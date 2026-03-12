package com.mediway.hos.srm.business.center.controller.patent;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentApplyInfoDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentApplyInfoVo;
import com.mediway.hos.srm.business.center.service.patent.SrmPatentApplyInfoService;

/**
 * <p>
 * 专利申报批次
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmPatentApplyInfo")
@Api(tags = "专利申报批次")
public class SrmPatentApplyInfoController {
    @Autowired
    private SrmPatentApplyInfoService srmPatentApplyInfoService;

    @PostMapping({"/savePatentApplyInfo"})
    public BaseResponse savePatentApplyInfo(@RequestBody PatentApplyInfoDto patentApplyInfoDto) {
        Long RowId= srmPatentApplyInfoService.savePatentApplyInfo(patentApplyInfoDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PatentApplyInfoVo monographVo = srmPatentApplyInfoService.getDetail(RowId);
        return BaseResponse.success(monographVo);
    }

    @PostMapping({"/listPatentApplyInfo"})
    public BaseResponse listPatentApplyInfo(@RequestBody PatentApplyInfoDto patentApplyInfoDto) {
        IPage<PatentApplyInfoVo> list = srmPatentApplyInfoService.listPatentApplyInfo(patentApplyInfoDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/delete"})
    public BaseResponse delete(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        srmPatentApplyInfoService.delete(RowId);
        return BaseResponse.success("删除成功");
    }
}
