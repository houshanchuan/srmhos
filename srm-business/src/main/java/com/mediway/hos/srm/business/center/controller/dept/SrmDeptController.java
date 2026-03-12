package com.mediway.hos.srm.business.center.controller.dept;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.exception.BaseBusinessException;
import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseSrmDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.dept.DeptDto;
import io.swagger.annotations.Api;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.dept.DeptVo;
import com.mediway.hos.srm.business.center.service.dept.SrmDeptService;


import java.util.List;

/**
 * <p>
 * 科室信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-19
 */
@RestController
@Api(tags = "科室信息表")
@RequestMapping("srm/dept")
public class SrmDeptController {
    @Autowired
    private SrmDeptService srmDeptService;
    @PostMapping({"/getDept"})
    public List<CombVo> getDept(@RequestBody DeptDto deptDto) {
        List<CombVo> yearList = srmDeptService.getDept(deptDto);
        return yearList;
    }
    @PostMapping({"/listDept"})
    public BaseResponse listDept(@RequestBody(required=false) DeptDto deptDto) {
        if(deptDto==null){
            deptDto=new DeptDto();
        }
        IPage<DeptVo> list = srmDeptService.listDept(deptDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/saveDept"})
    public BaseResponse saveDept(@RequestBody DeptDto deptDto) {
        String RowId= null;
        try{
            RowId=srmDeptService.saveDept(deptDto);
        }catch (Exception e){
            throw new BaseBusinessException(e.getMessage());
        }
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseSrmDTO baseDto) {
        String RowId=baseDto.getId();
        DeptVo deptVo = srmDeptService.getDetail(RowId);
        return BaseResponse.success(deptVo);
    }
}
