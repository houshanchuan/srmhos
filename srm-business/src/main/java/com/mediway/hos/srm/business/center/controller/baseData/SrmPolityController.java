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

import com.mediway.hos.srm.business.center.model.dto.baseData.PolityDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PolityVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPolityService;

/**
 * <p>
 * 政治面貌
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/polity")
@Api(tags = "政治面貌")
public class SrmPolityController {

    @Autowired
    private SrmPolityService srmPolityService;

    @PostMapping({"/saveOrUpdatePolity"})
    public BaseResponse saveOrUpdatePolity(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmPolityService.saveOrUpdatePolity(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPolity(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PolityVo polityVo = srmPolityService.getDetailPolity(RowId);
        return BaseResponse.success(polityVo);
    }

    @PostMapping({"/listPolity"})
    public BaseResponse listPolity(@RequestBody PolityDto polityDto) {
        IPage<PolityVo> list = srmPolityService.listPolity(polityDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePolity"})
    public BaseResponse deletePolity(@RequestBody BaseDto baseDto) {
        srmPolityService.deletePolity(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/getPolity"})
    public List<CombVo> getPolity() {
        return srmPolityService.getPolity();

    }
}
