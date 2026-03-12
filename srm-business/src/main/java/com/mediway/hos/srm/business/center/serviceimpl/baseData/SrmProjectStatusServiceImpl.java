package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectStatusDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectStatusVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectStatus;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectStatusService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProjectStatusMapper;
/**
 * <p>
 * 项目状态代码 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectStatusServiceImpl extends BaseServiceImpl<SrmProjectStatusMapper, SrmProjectStatus> implements SrmProjectStatusService {

    @Autowired
    private SrmProjectStatusMapper srmProjectStatusMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateProjectStatus(BaseDataCommonDto baseDataProjDto) {
        List<ProjectStatusDto> projectStatusDtos =baseDataProjDto.getProjectStatuss();

        List<SrmProjectStatus> projectStatusList=new ArrayList<>();
        for (ProjectStatusDto projectStatusDto :projectStatusDtos) {
            SrmProjectStatus srmProjectStatus = new SrmProjectStatus();
            srmProjectStatus.setId(projectStatusDto.getRowId());
            srmProjectStatus.setCode(projectStatusDto.getCode());
            srmProjectStatus.setName(projectStatusDto.getName());
            srmProjectStatus.setIsValid(Integer.valueOf(projectStatusDto.getIsValid()));

            projectStatusList.add(srmProjectStatus);
            Long RowId = srmProjectStatus.getId();
        }
        super.saveOrUpdateBatch(projectStatusList);
        return RowId;
    }
    @Override
    public ProjectStatusVo getDetailProjectStatus(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProjectStatusVo> listProjectStatus(ProjectStatusDto projectStatusDto) {
        Page<ProjectStatusVo> page = new Page<>(projectStatusDto.getPage(), projectStatusDto.getRows());
        IPage<ProjectStatusVo> res= srmProjectStatusMapper.listProjectStatus(page, projectStatusDto);
        //List<ProjectStatusVo> records=res.getRecords();
        //List<ProjectStatusVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteProjectStatus(BaseDto baseDto) {
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
}
