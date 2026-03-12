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

import com.mediway.hos.srm.business.center.model.dto.baseData.ParttimeJobDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ParttimeJobVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmParttimeJobService;

/**
 * <p>
 * 兼职职位表(职务类型)
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/parttimeJob")
@Api(tags = "兼职职位表(职务类型)")
public class SrmParttimeJobController {

    @Autowired
    private SrmParttimeJobService srmParttimeJobService;

    @PostMapping({"/saveOrUpdateParttimeJob"})
    public BaseResponse saveOrUpdateParttimeJob(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmParttimeJobService.saveOrUpdateParttimeJob(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailParttimeJob(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ParttimeJobVo parttimeJobVo = srmParttimeJobService.getDetailParttimeJob(RowId);
        return BaseResponse.success(parttimeJobVo);
    }

    @PostMapping({"/listParttimeJob"})
    public BaseResponse listParttimeJob(@RequestBody ParttimeJobDto parttimeJobDto) {
        IPage<ParttimeJobVo> list = srmParttimeJobService.listParttimeJob(parttimeJobDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteParttimeJob"})
    public BaseResponse deleteParttimeJob(@RequestBody BaseDto baseDto) {
        srmParttimeJobService.deleteParttimeJob(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
