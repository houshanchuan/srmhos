package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import com.mediway.hos.srm.business.center.constants.BusinessConstants;
import com.mediway.hos.srm.business.center.service.baseData.SrmBusinessnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;


import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectOrgFormDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectOrgFormVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectOrgForm;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectOrgFormService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProjectOrgFormMapper;

/**
 * <p>
 * 项目组织形式 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectOrgFormServiceImpl extends BaseServiceImpl<SrmProjectOrgFormMapper, SrmProjectOrgForm> implements SrmProjectOrgFormService {
    @Autowired
    private SrmProjectOrgFormService  srmProjectOrgFormService;
    @Autowired
    private SrmProjectOrgFormMapper srmProjectOrgFormMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateProjectOrgForm(BaseDataProjDto baseDataProjDto) {
        List<ProjectOrgFormDto> projectOrgFormDtos =baseDataProjDto.getProjectOrgForms();

        List<SrmProjectOrgForm> projectOrgFormList=new ArrayList<>();
        for (ProjectOrgFormDto projectOrgFormDto :projectOrgFormDtos) {
            SrmProjectOrgForm srmProjectOrgForm = new SrmProjectOrgForm();
            srmProjectOrgForm.setId(projectOrgFormDto.getRowId());
            if(ObjectUtil.isEmpty(projectOrgFormDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PRJ_ORG_FORM, 1, "");
                srmProjectOrgForm.setCode(code);
            }else{
                srmProjectOrgForm.setCode(projectOrgFormDto.getCode());
            }
            srmProjectOrgForm.setName(projectOrgFormDto.getName());
            srmProjectOrgForm.setIsValid(Integer.valueOf(projectOrgFormDto.getIsValid()));

            projectOrgFormList.add(srmProjectOrgForm);
            Long RowId = srmProjectOrgForm.getId();
        }
        super.saveOrUpdateBatch(projectOrgFormList);
        return RowId;
    }
    @Override
    public ProjectOrgFormVo getDetailProjectOrgForm(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProjectOrgFormVo> listProjectOrgForm(ProjectOrgFormDto projectOrgFormDto) {
        Page<ProjectOrgFormVo> page = new Page<>(projectOrgFormDto.getPage(), projectOrgFormDto.getRows());
        IPage<ProjectOrgFormVo> res= srmProjectOrgFormMapper.listProjectOrgForm(page, projectOrgFormDto);
        //List<ProjectOrgFormVo> records=res.getRecords();
        //List<ProjectOrgFormVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteProjectOrgForm(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                if(StringUtils.isEmpty(idStr)){
                    idStr=String.valueOf(RowId);
                }else{
                    idStr=idStr+","+String.valueOf(RowId);
                }
            }
            super.deleteByIds(idStr);
        }catch (Exception exception){
            throw  new ErrorException("-200",exception.getMessage());
        }
    }

    @Override
    public Long getIdByName(String name) {
        return null;
    }

    @Override
    public List<CombVo> getProjectOrgForm(ProjectOrgFormDto projectOrgFormDto) {
        return srmProjectOrgFormMapper.getProjectOrgForm(projectOrgFormDto);
    }
}
