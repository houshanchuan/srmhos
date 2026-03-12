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

import com.mediway.hos.srm.business.center.model.dto.baseData.GroupAuthConfigDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.GroupAuthConfigVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmGroupAuthConfigService;

/**
 * <p>
 * 
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/groupAuthConfig")
@Api(tags = "")
public class SrmGroupAuthConfigController {


    @Autowired
    private SrmGroupAuthConfigService srmGroupAuthConfigService;

    @PostMapping({"/saveOrUpdateGroupAuthConfig"})
    public BaseResponse saveOrUpdateGroupAuthConfig(@RequestBody BaseDataCommonDto baseDataCommonDto) {
        Long RowId = srmGroupAuthConfigService.saveOrUpdateGroupAuthConfig(baseDataCommonDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailGroupAuthConfig(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        GroupAuthConfigVo groupAuthConfigVo = srmGroupAuthConfigService.getDetailGroupAuthConfig(RowId);
        return BaseResponse.success(groupAuthConfigVo);
    }

    @PostMapping({"/listGroupAuthConfig"})
    public BaseResponse listGroupAuthConfig(@RequestBody GroupAuthConfigDto groupAuthConfigDto) {
        IPage<GroupAuthConfigVo> list = srmGroupAuthConfigService.listGroupAuthConfig(groupAuthConfigDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteGroupAuthConfig"})
    public BaseResponse deleteGroupAuthConfig(@RequestBody BaseDto baseDto) {
        srmGroupAuthConfigService.deleteGroupAuthConfig(baseDto);
        return BaseResponse.success("删除成功!");

    }

}
