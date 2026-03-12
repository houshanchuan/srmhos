package com.mediway.hos.srm.business.center.controller.pubmed;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.academic.AcConferenceHostDto;
import com.mediway.hos.srm.business.center.model.dto.pubmed.PubmedPaperDto;
import com.mediway.hos.srm.business.center.model.entity.pubmed.SrmPubmedPaper;
import com.mediway.hos.srm.business.center.service.pubmed.SrmPubmedPaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/srm/pubmed")
public class PubmedPaperController {

    @Autowired
    private SrmPubmedPaperService srmPubmedPaperService;
    @PostMapping({"/listPaper"})
    public BaseResponse listPaper(@RequestBody PubmedPaperDto pubmedPaperDto) {
        IPage<SrmPubmedPaper> list = srmPubmedPaperService.listPaper(pubmedPaperDto);
        return BaseResponse.success(list);
    }
}
