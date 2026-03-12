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
import com.mediway.hos.srm.business.center.service.baseData.SrmJournalService;
import com.mediway.hos.srm.business.center.model.dto.baseData.JournalDictDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.JournalDictVo;

/**
 * <p>
 * 期刊表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/journalDict")
@Api(tags = "期刊表")
public class SrmJournalController {

    @Autowired
    private SrmJournalService srmJournalService;

    @PostMapping({"/saveOrUpdateJournalDict"})
    public BaseResponse saveOrUpdateJournalDict(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmJournalService.saveOrUpdateJournalDict(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailJournalDict(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        JournalDictVo journalDictVo = srmJournalService.getDetailJournalDict(RowId);
        return BaseResponse.success(journalDictVo);
    }

    @PostMapping({"/listJournalDict"})
    public BaseResponse listJournalDict(@RequestBody JournalDictDto journalDictDto) {
        IPage<JournalDictVo> list = srmJournalService.listJournalDict(journalDictDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteJournalDict"})
    public BaseResponse deleteJournalDict(@RequestBody BaseDto baseDto) {
        srmJournalService.deleteJournalDict(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
