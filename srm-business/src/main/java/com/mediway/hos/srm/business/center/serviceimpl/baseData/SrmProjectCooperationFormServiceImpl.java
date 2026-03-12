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


import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectCooprateFormDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectCooprateFormVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectCooperationForm;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectCooperationFormService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProjectCooperationFormMapper;
/**
 * <p>
 * 项目合作形式 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectCooperationFormServiceImpl extends BaseServiceImpl<SrmProjectCooperationFormMapper, SrmProjectCooperationForm> implements SrmProjectCooperationFormService {

    @Autowired
    private SrmProjectCooperationFormService  srmProjectCooperationFormService;
    @Autowired
    private SrmProjectCooperationFormMapper srmProjectCooprateFormMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateProjectCooprateForm(BaseDataProjDto baseDataProjDto) {
        List<ProjectCooprateFormDto> projectCooprateFormDtos =baseDataProjDto.getProjectCooprateForms();

        List<SrmProjectCooperationForm> projectCooprateFormList=new ArrayList<>();
        for (ProjectCooprateFormDto projectCooprateFormDto :projectCooprateFormDtos) {
            SrmProjectCooperationForm srmProjectCooprateForm = new SrmProjectCooperationForm();
            srmProjectCooprateForm.setId(projectCooprateFormDto.getRowId());

            if(ObjectUtil.isEmpty(projectCooprateFormDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PRJ_COOP_FORM, 1, "");
                srmProjectCooprateForm.setCode(code);
            }else{
                srmProjectCooprateForm.setCode(projectCooprateFormDto.getCode());
            }
            srmProjectCooprateForm.setName(projectCooprateFormDto.getName());
            srmProjectCooprateForm.setIsValid(Integer.valueOf(projectCooprateFormDto.getIsValid()));

            projectCooprateFormList.add(srmProjectCooprateForm);
            Long RowId = srmProjectCooprateForm.getId();
        }
        super.saveOrUpdateBatch(projectCooprateFormList);
        return RowId;
    }
    @Override
    public ProjectCooprateFormVo getDetailProjectCooprateForm(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProjectCooprateFormVo> listProjectCooprateForm(ProjectCooprateFormDto projectCooprateFormDto) {
        Page<ProjectCooprateFormVo> page = new Page<>(projectCooprateFormDto.getPage(), projectCooprateFormDto.getRows());
        IPage<ProjectCooprateFormVo> res= srmProjectCooprateFormMapper.listProjectCooprateForm(page, projectCooprateFormDto);
        //List<ProjectCooprateFormVo> records=res.getRecords();
        //List<ProjectCooprateFormVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteProjectCooprateForm(BaseDto baseDto) {
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
    public List<CombVo> getProjectCooprateForm(ProjectCooprateFormDto projectCooprateFormDto) {
        return srmProjectCooprateFormMapper.getProjectCooprateForm(projectCooprateFormDto);
    }
}
