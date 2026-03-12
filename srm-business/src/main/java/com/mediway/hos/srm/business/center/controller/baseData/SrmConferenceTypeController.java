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
import com.mediway.hos.srm.business.center.service.baseData.SrmConferenceTypeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.ConferenceTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ConferenceTypeVo;
/**
 * <p>
 * 会议类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/conferenceType")
@Api(tags = "会议类型")
public class SrmConferenceTypeController {
    @Autowired
    private SrmConferenceTypeService srmConferenceTypeService;

    @PostMapping({"/saveOrUpdateConferenceType"})
    public BaseResponse saveOrUpdateConferenceType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmConferenceTypeService.saveOrUpdateConferenceType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailConferenceType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ConferenceTypeVo conferenceTypeVo = srmConferenceTypeService.getDetailConferenceType(RowId);
        return BaseResponse.success(conferenceTypeVo);
    }

    @PostMapping({"/listConferenceType"})
    public BaseResponse listConferenceType(@RequestBody ConferenceTypeDto conferenceTypeDto) {
        IPage<ConferenceTypeVo> list = srmConferenceTypeService.listConferenceType(conferenceTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteConferenceType"})
    public BaseResponse deleteConferenceType(@RequestBody BaseDto baseDto) {
        srmConferenceTypeService.deleteConferenceType(baseDto);
        return BaseResponse.success("删除成功!");

    }

}
