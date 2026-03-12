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

import com.mediway.hos.srm.business.center.model.dto.baseData.JobLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.JobLevelVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmJobLevelService;
/**
 * <p>
 * 科研人员岗位层级
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/jobLevel")
@Api(tags = "科研人员岗位层级")
public class SrmJobLevelController {

    @Autowired
    private SrmJobLevelService srmJobLevelService;

    @PostMapping({"/saveOrUpdateJobLevel"})
    public BaseResponse saveOrUpdateJobLevel(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmJobLevelService.saveOrUpdateJobLevel(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailJobLevel(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        JobLevelVo jobLevelVo = srmJobLevelService.getDetailJobLevel(RowId);
        return BaseResponse.success(jobLevelVo);
    }

    @PostMapping({"/listJobLevel"})
    public BaseResponse listJobLevel(@RequestBody JobLevelDto jobLevelDto) {
        IPage<JobLevelVo> list = srmJobLevelService.listJobLevel(jobLevelDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteJobLevel"})
    public BaseResponse deleteJobLevel(@RequestBody BaseDto baseDto) {
        srmJobLevelService.deleteJobLevel(baseDto);
        return BaseResponse.success("删除成功!");

    }

    @PostMapping({"/getJobLevel"})
    public List<CombVo> getJobLevel() {
        return srmJobLevelService.getJobLevel();
    }
}
