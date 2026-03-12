package com.mediway.hos.srm.business.center.controller.academic;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.baseData.AchvTransformantsTypeDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvTransformantsTypeVo;
import com.mediway.hos.srm.business.center.service.academic.SrmAcPersonAcademicTitleService;
import com.mediway.hos.srm.business.center.service.baseData.SrmAchvTransformantsTypeService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 学术称号表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srmAcPersonAcademicTitle")
@Api(tags = "学术称号表")
public class SrmAcPersonAcademicTitleController {

    @Resource
    private SrmAcPersonAcademicTitleService srmAcPersonAcademicTitleService;



}
