package com.mediway.hos.srm.business.center.serviceimpl.pubmed;

import com.mediway.hos.srm.business.center.model.entity.pubmed.SrmPubmedPaper;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class PubmedSaxParser {

    public static List<SrmPubmedPaper> parseEfetchXml(InputStream xmlInputStream) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
       // factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", false);
        // 🔒 关键：禁用 DTD 和外部实体
       // factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true); // 禁止 DOCTYPE
        // 或者，如果你仍想允许 DOCTYPE 但不加载外部资源（更兼容）：

    factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
    factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
    factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

        SAXParser saxParser = factory.newSAXParser();
        PubmedSaxHandler handler = new PubmedSaxHandler();
        saxParser.parse(xmlInputStream, handler);
        return handler.getPapers();
    }

    // 测试主函数
    public static void main(String[] args) {
        try {
            List<SrmPubmedPaper> papers = parseEfetchXml(new FileInputStream("d:\\pubmed_debug.xml"));
            System.out.println("\n🎉 总共解析出 " + papers.size() + " 篇论文");
            for (SrmPubmedPaper p : papers) {
                System.out.println("PMID: " + p.getPmid());
                System.out.println("Title: " + p.getTitle());
                System.out.println("PubDate: " + p.getPubDate());
                System.out.println("Abstract preview: " +
                        (p.getIntro().length() > 100 ? p.getIntro().substring(0, 100) + "..." : p.getIntro()));
                System.out.println("---");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}