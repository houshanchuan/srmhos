package com.mediway.hos.srm.business.center.controller.baseData;


import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.FieldInputSetupDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.FieldInputSetupListDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.baseData.FieldInputSetUpVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmFieldInputSetupService;

import java.util.List;

/**
 * <p>
 * 字段输入属性设置
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-13
 */
@RestController
@RequestMapping("srm/fieldInputSetup")
@Api(tags = "字段输入属性设置")
public class SrmFieldInputSetupController {
    @Autowired
    private SrmFieldInputSetupService srmFieldInputSetupService;
    @PostMapping({"/initFieldInputSetup"})
    public BaseResponse initFieldInputSetup(@RequestBody FieldInputSetupListDto fieldInputSetupDtoList) {
        srmFieldInputSetupService.initFieldInputSetup(fieldInputSetupDtoList);
        return BaseResponse.success("成功");
    }
    @PostMapping({"/saveFieldInputSetup"})
    public BaseResponse saveFieldInputSetup(@RequestBody FieldInputSetupListDto fieldInputSetupDtoList) {
        srmFieldInputSetupService.saveFieldInputSetup(fieldInputSetupDtoList);
        return BaseResponse.success("成功");
    }
    @PostMapping({"/getFieldInputSetup"})
    public List<FieldInputSetUpVo> getFieldInputSetup(@RequestBody FieldInputSetupDto fieldInputSetupDto) {
       return srmFieldInputSetupService.getFieldInputSetup(fieldInputSetupDto);

    }
    @PostMapping({"/deleteFieldInputSet"})
    public BaseResponse deleteFieldInputSet(@RequestBody FieldInputSetupDto fieldInputSetupDto) {
        srmFieldInputSetupService.deleteFieldInputSet(fieldInputSetupDto);
        return BaseResponse.success("成功");
    }
}
