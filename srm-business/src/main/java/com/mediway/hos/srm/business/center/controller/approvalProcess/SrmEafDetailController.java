package com.mediway.hos.srm.business.center.controller.approvalProcess;


import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.approvalProcess.EafDetailDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafDetailVo;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafDetailService;

import java.util.List;

/**
 * <p>
 * 审批流明细表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-21
 */
@RestController
@RequestMapping("srm/eafDetail")
@Api(tags = "审批流明细表")
public class SrmEafDetailController {
    @Autowired
    private SrmEafDetailService srmEafDetailService;
    @PostMapping({"/saveEafDetail"})
    public BaseResponse saveEafDetail(@RequestBody EafDetailDto eafDetailDto) {
        System.out.println(eafDetailDto);
        Long RowId= srmEafDetailService.saveEafDetail(eafDetailDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/listDetail"})
    public List<EafDetailVo> listDetail(@RequestBody EafDetailDto eafDetailDto) {
        List<EafDetailVo> list= srmEafDetailService.listDetail(eafDetailDto.getEafMain());
        return  list;
    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody EafDetailDto eafDetailDto) {
        EafDetailVo eafDetailVo= srmEafDetailService.getDetail(eafDetailDto.getId());
        return  BaseResponse.success(eafDetailVo);
    }
    @PostMapping({"/listChecker"})
    public List<EafDetailVo> listChecker(@RequestBody EafDetailDto eafDetailDto) {
        List<EafDetailVo> list= srmEafDetailService.listChecker(eafDetailDto.getId());
        return  list;
    }
    @PostMapping({"/delete"})
    public BaseResponse delete(@RequestBody BaseDto baseDto) {
        srmEafDetailService.deleteDetail(baseDto);
        return BaseResponse.success("删除成功!");
    }
}
