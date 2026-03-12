package com.mediway.hos.srm.business.center.serviceimpl.project;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectMidcheckListInfoDto;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectMidcheckListInfo;
import com.mediway.hos.srm.business.center.mapper.project.SrmProjectMidcheckListInfoMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectMidcheckListInfoVo;
import com.mediway.hos.srm.business.center.service.project.SrmProjectMidcheckListInfoService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.utils.DateTransform;

import java.util.List;

/**
 * <p>
 * 中检批次信息表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectMidcheckListInfoServiceImpl extends BaseServiceImpl<SrmProjectMidcheckListInfoMapper, SrmProjectMidcheckListInfo> implements SrmProjectMidcheckListInfoService {
    @Autowired
    private SrmProjectMidcheckListInfoMapper srmProjectMidcheckListInfoMapper;
    @Override
    public ProjectMidcheckListInfoVo getDetail(String rowId) {
        return srmProjectMidcheckListInfoMapper.getDetail(rowId);
    }

    @Override
    public IPage<ProjectMidcheckListInfoVo> listProjectMidCheckListInfo(ProjectMidcheckListInfoDto projectMidcheckListInfoDto) {

        Page<ProjectMidcheckListInfoVo> page = new Page<>(projectMidcheckListInfoDto.getPage(), projectMidcheckListInfoDto.getRows());
        IPage<ProjectMidcheckListInfoVo> res= srmProjectMidcheckListInfoMapper.listProjectMidCheckListInfo(page, projectMidcheckListInfoDto);
        return res;
    }

    @Override
    @Transactional
    public Long saveProjectMidCheckListInfo(ProjectMidcheckListInfoDto projectMidcheckListInfoDto) {
        Long RowId=null;
        try{
            SrmProjectMidcheckListInfo srmProjectMidcheckListInfo=new SrmProjectMidcheckListInfo();
            srmProjectMidcheckListInfo.setId(projectMidcheckListInfoDto.getRowId());
            srmProjectMidcheckListInfo.setMidcheckInfo(projectMidcheckListInfoDto.getMidCheckInfo());
            srmProjectMidcheckListInfo.setMidcheckState(projectMidcheckListInfoDto.getMidCheckState());
            srmProjectMidcheckListInfo.setNote(projectMidcheckListInfoDto.getNote());
            srmProjectMidcheckListInfo.setNotifyPlan(projectMidcheckListInfoDto.getNotifyPlan());
            srmProjectMidcheckListInfo.setProjTypeCode(projectMidcheckListInfoDto.getProjTypeCode());
            srmProjectMidcheckListInfo.setBeginDate(DateTransform.getLocalDateTime(projectMidcheckListInfoDto.getBeginDate()));
            srmProjectMidcheckListInfo.setEndDate(DateTransform.getLocalDateTime(projectMidcheckListInfoDto.getEndDate()));
            super.saveOrUpdate(srmProjectMidcheckListInfo);
            RowId=srmProjectMidcheckListInfo.getId();
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
        return RowId;
    }

    @Override
    public List<CombVo> getprojectMidcheckListInfo(String name) {
        return srmProjectMidcheckListInfoMapper.getprojectMidcheckListInfo(name);
    }
}
