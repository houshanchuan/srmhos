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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApprovalStatusDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApprovalStatusVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectApprovalStatus;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectApprovalStatusService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProjectApprovalStatusMapper;

/**
 * <p>
 * 项目申报立项状态 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectApprovalStatusServiceImpl extends BaseServiceImpl<SrmProjectApprovalStatusMapper, SrmProjectApprovalStatus> implements SrmProjectApprovalStatusService {

    @Autowired
    private SrmProjectApprovalStatusService  srmProjectApprovalStatusService;
    @Autowired
    private SrmProjectApprovalStatusMapper srmProjectApprovalStatusMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateProjectApprovalStatus(BaseDataCommonDto baseDataProjDto) {
        List<ProjectApprovalStatusDto> projectApprovalStatusDtos =baseDataProjDto.getProjectApprovalStatuss();

        List<SrmProjectApprovalStatus> projectApprovalStatusList=new ArrayList<>();
        for (ProjectApprovalStatusDto projectApprovalStatusDto :projectApprovalStatusDtos) {
            SrmProjectApprovalStatus srmProjectApprovalStatus = new SrmProjectApprovalStatus();
            srmProjectApprovalStatus.setId(projectApprovalStatusDto.getRowId());
            srmProjectApprovalStatus.setCode(projectApprovalStatusDto.getCode());
            srmProjectApprovalStatus.setName(projectApprovalStatusDto.getName());
            srmProjectApprovalStatus.setIsValid(Integer.valueOf(projectApprovalStatusDto.getIsValid()));

            projectApprovalStatusList.add(srmProjectApprovalStatus);
            Long RowId = srmProjectApprovalStatus.getId();
        }
        super.saveOrUpdateBatch(projectApprovalStatusList);
        return RowId;
    }
    @Override
    public ProjectApprovalStatusVo getDetailProjectApprovalStatus(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProjectApprovalStatusVo> listProjectApprovalStatus(ProjectApprovalStatusDto projectApprovalStatusDto) {
        Page<ProjectApprovalStatusVo> page = new Page<>(projectApprovalStatusDto.getPage(), projectApprovalStatusDto.getRows());
        IPage<ProjectApprovalStatusVo> res= srmProjectApprovalStatusMapper.listProjectApprovalStatus(page, projectApprovalStatusDto);
        //List<ProjectApprovalStatusVo> records=res.getRecords();
        //List<ProjectApprovalStatusVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteProjectApprovalStatus(BaseDto baseDto) {
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
