package com.mediway.hos.srm.business.center.controller.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.service.baseData.SrmClassService;
import com.mediway.hos.srm.business.center.model.dto.baseData.SubjectClassDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.SubjectClassVo;

/**
 * <p>
 * 学科门类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-25
 */
@RestController
@RequestMapping("srm/class")
@Api(tags = "学科门类")
public class SrmClassController {
    @Autowired
    private SrmClassService srmClassService;

    @PostMapping({"/saveOrUpdateSubjectClass"})
    public BaseResponse saveOrUpdateSubjectClass(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmClassService.saveOrUpdateSubjectClass(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailSubjectClass(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        SubjectClassVo subjectClassVo = srmClassService.getDetailSubjectClass(RowId);
        return BaseResponse.success(subjectClassVo);
    }

    @PostMapping({"/listSubjectClass"})
    public BaseResponse listSubjectClass(@RequestBody SubjectClassDto subjectClassDto) {
        IPage<SubjectClassVo> list = srmClassService.listSubjectClass(subjectClassDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteSubjectClass"})
    public BaseResponse deleteSubjectClass(@RequestBody BaseDto baseDto) {
        srmClassService.deleteSubjectClass(baseDto);
        return BaseResponse.success("删除成功!");

    }

    @PostMapping({"/getSubjectClass"})
    public List<CombVo> getSubjectClass() {
        List<CombVo> list = srmClassService.getSubjectClass();
        return list;
    }
}
