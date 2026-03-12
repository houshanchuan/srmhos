package com.mediway.hos.srm.business.center.service.pubmed;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.pubmed.PubmedPaperDto;
import com.mediway.hos.srm.business.center.model.entity.pubmed.SrmPubmedPaper;

public interface SrmPubmedPaperService {

    public void syncRecentArticles();

    public IPage<SrmPubmedPaper> listPaper(PubmedPaperDto pubmedPaperDto);
}
