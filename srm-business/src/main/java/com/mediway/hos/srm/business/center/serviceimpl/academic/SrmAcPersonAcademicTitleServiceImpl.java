package com.mediway.hos.srm.business.center.serviceimpl.academic;

import cn.hutool.core.util.ObjectUtil;
import com.mediway.hos.srm.business.center.constants.BusinessConstants;
import com.mediway.hos.srm.business.center.model.dto.baseData.AcademicTitleDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.WorkTypeDto;
import com.mediway.hos.srm.business.center.model.entity.academic.SrmAcPersonAcademicTitle;
import com.mediway.hos.srm.business.center.mapper.academic.SrmAcPersonAcademicTitleMapper;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmWorkType;
import com.mediway.hos.srm.business.center.service.academic.SrmAcPersonAcademicTitleService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 学术称号表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmAcPersonAcademicTitleServiceImpl extends BaseServiceImpl<SrmAcPersonAcademicTitleMapper, SrmAcPersonAcademicTitle> implements SrmAcPersonAcademicTitleService {

    @Resource
    private SrmAcPersonAcademicTitleMapper srmAcPersonAcademicTitleMapper;
    @Override
    public Long saveOrUpdateAcPersonAcademicTitle(BaseDataUserDto baseDataUserDto) {
         List<AcademicTitleDto> academicTitleDto =baseDataUserDto.getAcademicTitles();

        List<SrmAcPersonAcademicTitle> titleList=new ArrayList<>();
        for (AcademicTitleDto titleDto :academicTitleDto) {
            SrmAcPersonAcademicTitle academicTitle = new SrmAcPersonAcademicTitle();
            academicTitle.setId(titleDto.getRowId());
            academicTitle.setName(titleDto.getName());
           // academicTitle.setPersonId(titleDto.ge);

            titleList.add(academicTitle);
            Long RowId = academicTitle.getId();
        }
        super.saveOrUpdateBatch(titleList);
        return null;
    }
}
