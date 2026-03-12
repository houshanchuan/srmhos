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

import com.mediway.hos.srm.business.center.service.baseData.SrmJournalLevelService;
import com.mediway.hos.srm.business.center.model.dto.baseData.JournalLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.JournalLevelVo;
/**
 * <p>
 * 期刊级别
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/journalLevel")
@Api(tags = "期刊级别")
public class SrmJournalLevelController {
    @Autowired
    private SrmJournalLevelService srmJournalLevelService;

    @PostMapping({"/saveOrUpdateJournalLevel"})
    public BaseResponse saveOrUpdateJournalLevel(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmJournalLevelService.saveOrUpdateJournalLevel(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailJournalLevel(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        JournalLevelVo journalLevelVo = srmJournalLevelService.getDetailJournalLevel(RowId);
        return BaseResponse.success(journalLevelVo);
    }

    @PostMapping({"/listJournalLevel"})
    public BaseResponse listJournalLevel(@RequestBody JournalLevelDto journalLevelDto) {
        IPage<JournalLevelVo> list = srmJournalLevelService.listJournalLevel(journalLevelDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteJournalLevel"})
    public BaseResponse deleteJournalLevel(@RequestBody BaseDto baseDto) {
        srmJournalLevelService.deleteJournalLevel(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
