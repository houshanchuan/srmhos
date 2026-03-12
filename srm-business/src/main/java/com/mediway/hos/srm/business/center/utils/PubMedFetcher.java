package com.mediway.hos.srm.business.center.utils;
import com.mediway.hos.srm.business.center.model.entity.pubmed.SrmPubmedPaper;
import com.mediway.hos.srm.business.center.serviceimpl.pubmed.PubmedSaxHandler;
import org.apache.commons.io.IOUtils;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PubMedFetcher {

    private static final String USER_AGENT = "Mozilla/5.0 (compatible; PubMedBot/1.0)";
    private static final int DEFAULT_MAX_RESULTS = 500;

    private static final String API_KEY="9f12250b75f5f9bb7c683b933d983ce5c508";

    /**
     * 获取最近 N 天的免费全文论文（带摘要）
     *
     * @param days 最近多少天（如 30）
     * @return 文章列表
     */
    public List<SrmPubmedPaper> fetchArticlesFromLastDays(int days) throws Exception {
        // 构造日期范围：例如 "2025/11/09:2025/12/09[PDAT]"
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(days);
        String dateRange = String.format("%s:%s[PDAT]",
                startDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")),
                endDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));

        String query = dateRange + " AND free full text[filter]";
        System.setProperty("https.protocols", "TLSv1.2");
        System.setProperty("jdk.tls.client.protocols", "TLSv1.2");

        return searchPubMed(query);
    }

    /**
     * 通用搜索方法（支持任意查询）
     */

    public List<SrmPubmedPaper> searchPubMed(String query) throws Exception {

        // ===== Step 1: 调用 esearch 获取 WebEnv 和 QueryKey（不返回 ID 列表）=====
        String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8.name());
        // 注意：这里 retmax=0 表示我们只关心 WebEnv，不关心初始 ID 列表（由 efetch 分页拉取）
        String esearchUrl = "https://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi?" +
                "db=pubmed&term=" + encodedQuery +
                "&retmax=0" +                    // 👈 关键：不返回 ID，只获取 WebEnv
                "&usehistory=y" +
                "&email=ntafman@hotmail.com"; // 👈 建议提供 tool/email，避免被限

        HttpURLConnection conn = (HttpURLConnection) new URL(esearchUrl).openConnection();
        conn.setRequestProperty("User-Agent", USER_AGENT);
        conn.setConnectTimeout(10_000);
        conn.setReadTimeout(60_000);

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("ESearch failed with code: " + conn.getResponseCode());
        }

        String webEnv = null, queryKey = null;
        int totalCount = 0;

        try (InputStream in = conn.getInputStream()) {
            XMLStreamReader reader = XMLInputFactory.newInstance()
                    .createXMLStreamReader(in, StandardCharsets.UTF_8.name());
            while (reader.hasNext()) {
                if (reader.next() == XMLStreamConstants.START_ELEMENT) {
                    switch (reader.getLocalName()) {
                        case "WebEnv":
                            reader.next();
                            webEnv = reader.getText().trim();
                            break;
                        case "QueryKey":
                            reader.next();
                            queryKey = reader.getText().trim();
                            break;
                        case "Count":
                            reader.next();
                            totalCount = Integer.parseInt(reader.getText().trim());
                            break;
                    }
                }
            }
            reader.close();
        }
        System.out.println("论文总数："+totalCount);
        // 如果 WebEnv 或 QueryKey 缺失，说明查询无结果或出错
        if (webEnv == null || queryKey == null) {
            return Collections.emptyList();
        }

        // 实际要获取的数量：不超过 totalCount，也不超过 maxResults
        //int actualMax = Math.min(totalCount, maxResults);
        if (totalCount == 0) {
            return Collections.emptyList();
        }

        // ===== Step 2: 分页调用 efetch 拉取详细数据 =====
        List<SrmPubmedPaper> allPapers = new ArrayList<>();
        final int BATCH_SIZE = 20; // 每次拉取 100 条（NCBI 推荐 100~500）
      //  totalCount=10;
        for (int start = 0; start < totalCount; start += BATCH_SIZE) {
           // int thisBatchSize = Math.min(BATCH_SIZE, actualMax - start);
            System.out.println("开始获取第"+start+"的"+BATCH_SIZE);
            // 构建分页 efetch URL
            String efetchUrl = "https://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?" +
                    "db=pubmed" +
                    "&WebEnv=" + URLEncoder.encode(webEnv, StandardCharsets.UTF_8.name()) +
                    "&query_key=" + queryKey +
                    "&retstart=" + start +          // 👈 分页起始位置
                    "&retmax=" + BATCH_SIZE +    // 👈 本次拉取数量
                    "&retmode=xml" +
                    "&tool=myapp&email=ntafman@hotmail.com"+
                    "&api_key=" + API_KEY;

            HttpURLConnection efetchConn = (HttpURLConnection) new URL(efetchUrl).openConnection();
            efetchConn.setRequestProperty("User-Agent", USER_AGENT);
            efetchConn.setConnectTimeout(15_000);
            efetchConn.setReadTimeout(120_000); // 拉取大批次需更长读超时
            efetchConn.setRequestProperty("Connection", "close");

            if (efetchConn.getResponseCode() != 200) {
                // 可选：记录警告并跳过本批次，或抛异常
                System.err.println("⚠️ EFetch failed at start=" + start + ", code=" + efetchConn.getResponseCode());
                continue;
            }

            // 先完整下载 XML 到内存（避免 SAX 解析时网络中断）
            byte[] xmlBytes;
            try (InputStream in = efetchConn.getInputStream();
                 ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
                byte[] temp = new byte[8192];
                int n;
                while ((n = in.read(temp)) != -1) {
                    buffer.write(temp, 0, n);
                }
                xmlBytes = buffer.toByteArray();
            }

            // 用 ByteArrayInputStream 安全解析（无网络依赖）
            try (InputStream bis = new ByteArrayInputStream(xmlBytes)) {
                List<SrmPubmedPaper> batchPapers = parseEfetchXml(bis);
                allPapers.addAll(batchPapers);
            }
            System.out.println("已解析完"+start+"的"+BATCH_SIZE);
            // ===== 遵守 NCBI 速率限制：每秒最多 3 次请求 =====
            // https://ncbi.nlm.nih.gov/home/about/policies/
            if (start + BATCH_SIZE < totalCount) { // 最后一批不用 sleep
                Thread.sleep(350); // ≈ 2.85 次/秒，安全
            }
        }

        return allPapers;
    }

    public static void main(String[] args){
        // 读取你之前保存的 XML 文件
        try{
            byte[] xmlBytes = Files.readAllBytes(Paths.get("D:\\pubmed_debug.xml"));

    // 转为 InputStream（供 parseEfetchXml 使用）
            InputStream xmlStream = new ByteArrayInputStream(xmlBytes);
            List<SrmPubmedPaper> papers = new PubMedFetcher().parseEfetchXml(xmlStream);
            System.out.println("成功解析: " + papers.size() + " 篇论文");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 使用 SAX 快速解析 PubMed efetch XML 流（高性能、低内存）
     */
    private List<SrmPubmedPaper> parseEfetchXml(InputStream xmlInputStream) throws Exception {
        // 创建安全且高效的 SAX 解析器
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // 🔒 安全加固：禁用 DTD 和外部实体（防 XXE 攻击）
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        // ⚡ 性能提示：可选（某些 JDK 默认开启）


        SAXParser saxParser = factory.newSAXParser();
        PubmedSaxHandler handler = new PubmedSaxHandler();

        // 直接解析 InputStream（无需加载到内存）
        saxParser.parse(xmlInputStream, handler);

        return handler.getPapers();
    }
    /**
     * 从 PubMed efetch 的 XML 流中解析出论文列表（流式解析，低内存）
     */
    private List<SrmPubmedPaper> parseEfetchXml1(InputStream xmlInputStream) throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        factory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);

        List<SrmPubmedPaper> papers = new ArrayList<>();
        XMLStreamReader reader = factory.createXMLStreamReader(xmlInputStream, StandardCharsets.UTF_8.name());

        SrmPubmedPaper current = null;
        String currentElement = "";
        StringBuilder abstractBuilder = null;
        boolean inAbstractText = false;

        try {
            while (reader.hasNext()) {
                int event = reader.next();

                if (event == XMLStreamConstants.START_ELEMENT) {
                    String name = reader.getLocalName();
                    currentElement = name;

                    if ("PubmedArticle".equals(name)) {
                        current = new SrmPubmedPaper();
                        abstractBuilder = new StringBuilder();
                    } else if ("PMID".equals(name) && current != null) {
                        reader.next();
                        current.setPmid(reader.getText().trim());
                    } else if ("AbstractText".equals(name)) {
                        inAbstractText = true;
                    } else if ("ArticleId".equals(name) && current != null) {
                        String idType = reader.getAttributeValue(null, "IdType");
                        reader.next();
                        if (reader.hasText()) {
                            String idVal = reader.getText().trim();
                            if ("pmc".equalsIgnoreCase(idType)) {
                                current.setPmcid(idVal);
                            } else if ("doi".equalsIgnoreCase(idType)) {
                                current.setDoi(idVal);
                            }
                        }
                    }

                } else if (event == XMLStreamConstants.CHARACTERS) {
                    String text = reader.getText().trim();
                    if (!text.isEmpty()) {
                        if (inAbstractText) {
                            abstractBuilder.append(text).append(' ');
                        } else {
                            switch (currentElement) {
                                case "ArticleTitle":
                                    current.setTitle(text);
                                    break;
                                case "ISOAbbreviation":
                                case "MedlineTA":
                                    current.setJournal(text);
                                    break;
                                case "Year":
                                    if (current.getPubDate() == null || current.getPubDate().isEmpty()) {
                                        current.setPubDate(text);
                                    }
                                    break;
                            }
                        }
                    }

                } else if (event == XMLStreamConstants.END_ELEMENT) {
                    if ("AbstractText".equals(reader.getLocalName())) {
                        inAbstractText = false;
                    } else if ("PubmedArticle".equals(reader.getLocalName())) {
                        if (current != null) {
                            current.setIntro(abstractBuilder.toString().trim());
                            if (current.getPmid() != null && !current.getPmid().isEmpty()) {
                                papers.add(current);
                            }
                            current = null;
                            abstractBuilder = null;
                        }
                    }
                }
            }
        } finally {
            reader.close(); // 确保关闭
        }

        return papers;
    }
    public String getPaperUrl(String pmcId){
        String fileUrl=null;
        try {
            // 先查 OA 接口
            String oaUrl = "https://www.ncbi.nlm.nih.gov/pmc/utils/oa/oa.fcgi?id=" + pmcId;
            HttpURLConnection conn = (HttpURLConnection) new URL(oaUrl).openConnection();
            conn.setRequestProperty("User-Agent", USER_AGENT);

            try (InputStream in = conn.getInputStream()) {
                XMLStreamReader reader = XMLInputFactory.newInstance()
                        .createXMLStreamReader(in, StandardCharsets.UTF_8.name());
                while (reader.hasNext()) {
                    if (reader.next() == XMLStreamConstants.START_ELEMENT && "link".equals(reader.getLocalName())) {
                        String href = reader.getAttributeValue(null, "href");
                        String format = reader.getAttributeValue(null, "format");
                        if ("pdf".equalsIgnoreCase(format) || "tgz".equalsIgnoreCase(format)) {
                            fileUrl = href;
                            break;
                        }
                    }
                }
                reader.close();
            }

            if (fileUrl == null) {
                System.out.println("没有下载地址:pmcid=" + pmcId);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return fileUrl;
    }
    /**
     * 下载 PDF（通过 PMC ID）
     */
    public boolean downloadPdfByPmc(String fileUrl, String outputPath) throws Exception {

        boolean success=false;
        // 下载（支持 HTTP/FTP）
        URL url = new URL(fileUrl);
        URLConnection urlConn = url.openConnection();
        if (urlConn instanceof HttpURLConnection) {
            ((HttpURLConnection) urlConn).setRequestProperty("User-Agent", USER_AGENT);
        }

        try {
            InputStream in = urlConn.getInputStream();
            FileOutputStream out = new FileOutputStream(outputPath);
            byte[] buf = new byte[8192];
            int len;
            while((len =in.read(buf))!=-1){
                out.write(buf, 0, len);
            }
            success=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return success;
    }
}