package com.mediway.hos.srm.business.center.controller.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.dto.baseData.LanguageDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.LanguageVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmLanguageService;

/**
 * <p>
 * 语言代码表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
@RestController
@RequestMapping("srm/language")
@Api(tags = "语言代码表")
public class SrmLanguageController {
    @Autowired
    private SrmLanguageService srmLanguageService;
    @PostMapping({"/getLanguage"})
    public List<CombVo> getLanguage(@RequestBody(required = false) LanguageDto languageDto) {
         return srmLanguageService.getLanguage(languageDto);

    }

    @PostMapping({"/saveOrUpdateLanguage"})
    public BaseResponse saveOrUpdateLanguage(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmLanguageService.saveOrUpdateLanguage(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailLanguage(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        LanguageVo languageVo = srmLanguageService.getDetailLanguage(RowId);
        return BaseResponse.success(languageVo);
    }

    @PostMapping({"/listLanguage"})
    public BaseResponse listLanguage(@RequestBody(required = false) LanguageDto languageDto) {
        IPage<LanguageVo> list = srmLanguageService.listLanguage(languageDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteLanguage"})
    public BaseResponse deleteLanguage(@RequestBody BaseDto baseDto) {
        srmLanguageService.deleteLanguage(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
