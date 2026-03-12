package com.mediway.hos.srm.business.center.serviceimpl.pubmed;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import com.mediway.hos.srm.business.center.mapper.pubmed.SrmPubmedPaperMapper;
import com.mediway.hos.srm.business.center.model.dto.academic.AcConferenceHostDto;
import com.mediway.hos.srm.business.center.model.dto.pubmed.PubmedPaperDto;
import com.mediway.hos.srm.business.center.model.entity.pubmed.SrmPubmedPaper;
import com.mediway.hos.srm.business.center.model.vo.academic.AcConferenceHostVo;
import com.mediway.hos.srm.business.center.service.pubmed.SrmPubmedPaperService;
import com.mediway.hos.srm.business.center.utils.PubMedFetcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class SrmPubmedPaperServiceImpl  extends BaseServiceImpl<SrmPubmedPaperMapper, SrmPubmedPaper> implements SrmPubmedPaperService {
    @Resource
    private SrmPubmedPaperMapper srmPubmedPaperMapper;

    private final PubMedFetcher fetcher = new PubMedFetcher();

    // 配置参数（可从 application.yml 注入）
    private final int DAYS_BACK =2 ;
    private final boolean DOWNLOAD_PDF_ENABLED = true;
    private final String PDF_STORAGE_PATH = "d:/pubmed/pdfs/";


    @Override
    public IPage<SrmPubmedPaper> listPaper(PubmedPaperDto pubmedPaperDto){
        HosUser hosUser = SecurityUtils.getLoginUser();
        if(hosUser==null) return null;
        String userCode=hosUser.getAccountCode();
        //String userCode=acConferenceHostDto.getUserCode();

        Page<SrmPubmedPaper> page = new Page<>(pubmedPaperDto.getPage(), pubmedPaperDto.getRows());
        IPage<SrmPubmedPaper> res= srmPubmedPaperMapper.selectPage(page, null);
        return res;
    }
    public void syncRecentArticles() {
        log.info("开始同步最近 {} 天的 PubMed 免费论文...", DAYS_BACK);

        try {
            List<SrmPubmedPaper> articles = fetcher.fetchArticlesFromLastDays(DAYS_BACK);
            log.info("共获取 {} 篇可下载论文", articles.size());

            int savedCount = 0, downloadedCount = 0;

            for (SrmPubmedPaper src : articles) {
                // 跳过已存在
                QueryWrapper wrapper = new QueryWrapper<SrmPubmedPaper>();
                wrapper.eq("pmid", src.getPmid());
                long count = srmPubmedPaperMapper.selectCount(wrapper);
                if (count > 0) continue;


                // 尝试下载 PDF
                if (false&&src.getPmcid() != null) {
                    try {
                        String fileUrl=fetcher.getPaperUrl(src.getPmcid());
                        src.setFileUrl(fileUrl);
                        if(fileUrl!=null) {
                            String pdfPath = PDF_STORAGE_PATH +"PMC"+ src.getPmcid() + ".tar.gz";
                            boolean isDown=fetcher.downloadPdfByPmc(fileUrl, pdfPath);
                            //entity.setHasPdfDownloaded(true);
                            src.setIsDown(isDown?1:0);
                            downloadedCount++;
                        }
                    } catch (Exception e) {
                        log.warn("PDF 下载失败 (PMC:{}): {}", src.getPmcid(), e.getMessage());
                    }
                }
                src.setSource("PM");
                src.setAddTime(new Date());
                src.setStatus("0");
                String author=src.getAuthor();
                if(author!=null&&author.length()>=1000){
                    src.setAuthor(author.substring(0,500)+"...");
                }
                srmPubmedPaperMapper.insert(src);
                savedCount++;
            }

            log.info("✅ 同步完成: 新增 {} 篇, 下载 PDF {} 篇", savedCount, downloadedCount);

        } catch (Exception e) {
            log.error("PubMed 同步失败", e);
        }
    }
}
