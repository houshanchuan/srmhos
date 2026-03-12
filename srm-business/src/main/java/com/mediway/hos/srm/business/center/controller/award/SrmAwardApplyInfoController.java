package com.mediway.hos.srm.business.center.controller.award;


import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.award.AwardApplyInfoDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.award.AwardApplyInfoVo;
import com.mediway.hos.srm.business.center.service.award.SrmAwardApplyInfoService;

import java.util.List;

/**
 * <p>
 * 获奖申报计划
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmAwardApplyInfo")
@Api(tags = "获奖申报计划")
public class SrmAwardApplyInfoController {
    @Autowired
    private SrmAwardApplyInfoService srmAwardApplyInfoService;
    @PostMapping({"/saveAwardApplyInfo"})
    public BaseResponse saveAwardApplyInfo(@RequestBody AwardApplyInfoDto awardApplyInfoDto) {
        Long RowId= srmAwardApplyInfoService.saveAwardApplyInfo(awardApplyInfoDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        AwardApplyInfoVo awardApplyInfoVo = srmAwardApplyInfoService.getDetail(RowId);
        return BaseResponse.success(awardApplyInfoVo);
    }

    @PostMapping({"/listAwardApplyInfo"})
    public BaseResponse listAwardApplyInfo(@RequestBody AwardApplyInfoDto awardApplyInfoDto) {
        List<AwardApplyInfoVo> list = srmAwardApplyInfoService.listAwardApplyInfo(awardApplyInfoDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAwardApplyInfo"})
    public BaseResponse deleteAwardApplyInfo(@RequestBody BaseDto baseDto) {
        srmAwardApplyInfoService.deleteAwardApplyInfo(baseDto);
        return BaseResponse.success("删除成功");

    }
}
