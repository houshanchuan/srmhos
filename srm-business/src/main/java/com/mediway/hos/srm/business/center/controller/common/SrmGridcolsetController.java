package com.mediway.hos.srm.business.center.controller.common;


import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.common.GridColSetDto;
import com.mediway.hos.srm.business.center.model.dto.common.GridColSetMainDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.common.GridColSetRowVo;
import com.mediway.hos.srm.business.center.service.common.SrmGridcolsetService;

import java.util.List;

/**
 * <p>
 * 列设置
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-11
 */
@RestController
@RequestMapping("srm/gridcolset")
@Api(tags = "列设置")
public class SrmGridcolsetController {
    @Autowired
    private SrmGridcolsetService srmGridcolsetService;
    @PostMapping({"/ifGridColSetExist"})
    public BaseResponse ifGridColSetExist(@RequestBody GridColSetMainDto gridColSetMainDto) {
        String res= srmGridcolsetService.ifGridColSetExist(gridColSetMainDto);
        return BaseResponse.success(res);
    }
    @PostMapping({"/initGridColSet"})
    public BaseResponse initGridColSet(@RequestBody GridColSetDto gridColSetDto) {
        System.out.println(gridColSetDto.toString());
        srmGridcolsetService.initGridColSet(gridColSetDto);
        return BaseResponse.success("成功");
    }
    @PostMapping({"/saveGridColSet"})
    public BaseResponse saveGridColSet(@RequestBody GridColSetDto gridColSetDto) {
        srmGridcolsetService.saveGridColSet(gridColSetDto);
        return BaseResponse.success("成功");
    }
    @PostMapping({"/getGridColSet"})
    public List<GridColSetRowVo> getGridColSet(@RequestBody GridColSetMainDto gridColSetMainDto) {
        return srmGridcolsetService.getGridColSet(gridColSetMainDto);
    }
    @PostMapping({"/retSetGridCol"})
    public BaseResponse retSetGridCol(@RequestBody GridColSetMainDto gridColSetMainDto) {
        System.out.println(gridColSetMainDto.toString());
        srmGridcolsetService.retSetGridCol(gridColSetMainDto);
        return BaseResponse.success("成功");
    }

}
