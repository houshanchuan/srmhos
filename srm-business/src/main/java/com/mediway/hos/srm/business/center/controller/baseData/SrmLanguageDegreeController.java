package com.mediway.hos.srm.business.center.controller.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.dto.baseData.LanguageDegreeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.LanguageDegreeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmLanguageDegreeService;


/**
 * <p>
 * 语言等级代码表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/languageDegree")
@Api(tags = "语言等级代码表")
public class SrmLanguageDegreeController {

    @Autowired
    private SrmLanguageDegreeService srmLanguageDegreeService;

    @PostMapping({"/saveOrUpdateLanguageDegree"})
    public BaseResponse saveOrUpdateLanguageDegree(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmLanguageDegreeService.saveOrUpdateLanguageDegree(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailLanguageDegree(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        LanguageDegreeVo languageDegreeVo = srmLanguageDegreeService.getDetailLanguageDegree(RowId);
        return BaseResponse.success(languageDegreeVo);
    }

    @PostMapping({"/listLanguageDegree"})
    public BaseResponse listLanguageDegree(@RequestBody LanguageDegreeDto languageDegreeDto) {
        IPage<LanguageDegreeVo> list = srmLanguageDegreeService.listLanguageDegree(languageDegreeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteLanguageDegree"})
    public BaseResponse deleteLanguageDegree(@RequestBody BaseDto baseDto) {
        srmLanguageDegreeService.deleteLanguageDegree(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
