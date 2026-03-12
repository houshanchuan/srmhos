package com.mediway.hos.srm.business.center.controller.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.service.baseData.SrmJournalSourceService;
import com.mediway.hos.srm.business.center.model.dto.baseData.JournalSourceDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.JournalSourceVo;

/**
 * <p>
 * 期刊源代码表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/journalSource")
@Api(tags = "期刊源代码表")
public class SrmJournalSourceController {
    @Autowired
    private SrmJournalSourceService srmJournalSourceService;

    @PostMapping({"/saveOrUpdateJournalSource"})
    public BaseResponse saveOrUpdateJournalSource(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmJournalSourceService.saveOrUpdateJournalSource(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailJournalSource(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        JournalSourceVo journalSourceVo = srmJournalSourceService.getDetailJournalSource(RowId);
        return BaseResponse.success(journalSourceVo);
    }

    @PostMapping({"/listJournalSource"})
    public BaseResponse listJournalSource(@RequestBody JournalSourceDto journalSourceDto) {
        IPage<JournalSourceVo> list = srmJournalSourceService.listJournalSource(journalSourceDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteJournalSource"})
    public BaseResponse deleteJournalSource(@RequestBody BaseDto baseDto) {
        srmJournalSourceService.deleteJournalSource(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
