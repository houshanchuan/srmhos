package com.mediway.hos.srm.business.center.controller.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProductProjectSourceDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProductProjectSourceVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProductProjectsourceService;


/**
 * <p>
 * 成果的项目来源表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
@RestController
@RequestMapping("srm/productProjectsource")
@Api(tags = "成果的项目来源表")
public class SrmProductProjectsourceController {
    @Autowired
    private SrmProductProjectsourceService srmProductProjectsourceService;
    @PostMapping({"/getProjectsource"})
    public List<CombVo> getProjectsource() {
        List<CombVo> list = srmProductProjectsourceService.getProjectsource();
        return list;
    }

    @PostMapping({"/saveOrUpdateProductProjectSource"})
    public BaseResponse saveOrUpdateProductProjectSource(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmProductProjectsourceService.saveOrUpdateProductProjectSource(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProductProjectSource(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProductProjectSourceVo productProjectSourceVo = srmProductProjectsourceService.getDetailProductProjectSource(RowId);
        return BaseResponse.success(productProjectSourceVo);
    }

    @PostMapping({"/listProductProjectSource"})
    public BaseResponse listProductProjectSource(@RequestBody ProductProjectSourceDto productProjectSourceDto) {
        IPage<ProductProjectSourceVo> list = srmProductProjectsourceService.listProductProjectSource(productProjectSourceDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProductProjectSource"})
    public BaseResponse deleteProductProjectSource(@RequestBody BaseDto baseDto) {
        srmProductProjectsourceService.deleteProductProjectSource(baseDto);
        return BaseResponse.success("删除成功!");

    }

}
