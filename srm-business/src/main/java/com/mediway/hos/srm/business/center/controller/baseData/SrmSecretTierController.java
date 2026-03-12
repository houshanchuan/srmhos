package com.mediway.hos.srm.business.center.controller.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.SecretTierDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.SecretTierVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmSecretTierService;


/**
 * <p>
 * 涉密级别
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/secretTier")
@Api(tags = "涉密级别")
public class SrmSecretTierController {

    @Autowired
    private SrmSecretTierService srmSecretTierService;

    @PostMapping({"/saveOrUpdateSecretTier"})
    public BaseResponse saveOrUpdateSecretTier(@RequestBody BaseDataCommonDto baseDataProjDto) {
        Long RowId = srmSecretTierService.saveOrUpdateSecretTier(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailSecretTier(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        SecretTierVo secretTierVo = srmSecretTierService.getDetailSecretTier(RowId);
        return BaseResponse.success(secretTierVo);
    }

    @PostMapping({"/listSecretTier"})
    public BaseResponse listSecretTier(@RequestBody SecretTierDto secretTierDto) {
        IPage<SecretTierVo> list = srmSecretTierService.listSecretTier(secretTierDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteSecretTier"})
    public BaseResponse deleteSecretTier(@RequestBody BaseDto baseDto) {
        srmSecretTierService.deleteSecretTier(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
