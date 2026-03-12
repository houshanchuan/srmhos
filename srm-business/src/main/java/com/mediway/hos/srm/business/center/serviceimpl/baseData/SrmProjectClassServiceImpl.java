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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectClassDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectClassVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectClass;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectClassService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProjectClassMapper;

/**
 * <p>
 * 项目性质 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectClassServiceImpl extends BaseServiceImpl<SrmProjectClassMapper, SrmProjectClass> implements SrmProjectClassService {

    @Autowired
    private SrmProjectClassMapper srmProjectClassMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateProjectClass(BaseDataProjDto baseDataProjDto) {
        List<ProjectClassDto> projectClassDtos =baseDataProjDto.getProjectClasss();

        List<SrmProjectClass> projectClassList=new ArrayList<>();
        for (ProjectClassDto projectClassDto :projectClassDtos) {
            SrmProjectClass srmProjectClass = new SrmProjectClass();
            srmProjectClass.setId(projectClassDto.getRowId());

            if(ObjectUtil.isEmpty(projectClassDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PRJ_CLASS, 1, "");
                srmProjectClass.setCode(code);
            }else{
                srmProjectClass.setCode(projectClassDto.getCode());
            }
            srmProjectClass.setName(projectClassDto.getName());
            srmProjectClass.setIsValid(Integer.valueOf(projectClassDto.getIsValid()));

            projectClassList.add(srmProjectClass);
            Long RowId = srmProjectClass.getId();
        }
        super.saveOrUpdateBatch(projectClassList);
        return RowId;
    }
    @Override
    public ProjectClassVo getDetailProjectClass(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProjectClassVo> listProjectClass(ProjectClassDto projectClassDto) {
        Page<ProjectClassVo> page = new Page<>(projectClassDto.getPage(), projectClassDto.getRows());
        IPage<ProjectClassVo> res= srmProjectClassMapper.listProjectClass(page, projectClassDto);
        //List<ProjectClassVo> records=res.getRecords();
        //List<ProjectClassVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteProjectClass(BaseDto baseDto) {
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
    public List<CombVo> getProjClass(){
        return srmProjectClassMapper.getProjClass();
    }
}
