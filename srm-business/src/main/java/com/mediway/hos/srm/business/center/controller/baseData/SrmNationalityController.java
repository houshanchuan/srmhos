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
import com.mediway.hos.srm.business.center.model.dto.baseData.NationalityDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.NationalityVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmNationalityService;
/**
 * <p>
 * 国籍代码表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/nationality")
@Api(tags = "国籍代码表")
public class SrmNationalityController {
    @Autowired
    private SrmNationalityService srmNationalityService;

    @PostMapping({"/saveOrUpdateNationality"})
    public BaseResponse saveOrUpdateNationality(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmNationalityService.saveOrUpdateNationality(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailNationality(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        NationalityVo nationalityVo = srmNationalityService.getDetailNationality(RowId);
        return BaseResponse.success(nationalityVo);
    }

    @PostMapping({"/listNationality"})
    public BaseResponse listNationality(@RequestBody NationalityDto nationalityDto) {
        IPage<NationalityVo> list = srmNationalityService.listNationality(nationalityDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteNationality"})
    public BaseResponse deleteNationality(@RequestBody BaseDto baseDto) {
        srmNationalityService.deleteNationality(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
