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


import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApplyStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApplyStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectApplyState;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectApplyStateService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProjectApplyStateMapper;

/**
 * <p>
 * 项目申报状态 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectApplyStateServiceImpl extends BaseServiceImpl<SrmProjectApplyStateMapper, SrmProjectApplyState> implements SrmProjectApplyStateService {

    @Autowired
    private SrmProjectApplyStateService  srmProjectApplyStateService;
    @Autowired
    private SrmProjectApplyStateMapper srmProjectApplyStateMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateProjectApplyState(BaseDataCommonDto baseDataProjDto) {
        List<ProjectApplyStateDto> projectApplyStateDtos =baseDataProjDto.getProjectApplyStates();

        List<SrmProjectApplyState> projectApplyStateList=new ArrayList<>();
        for (ProjectApplyStateDto projectApplyStateDto :projectApplyStateDtos) {
            SrmProjectApplyState srmProjectApplyState = new SrmProjectApplyState();
            srmProjectApplyState.setId(projectApplyStateDto.getRowId());
            srmProjectApplyState.setCode(projectApplyStateDto.getCode());
            srmProjectApplyState.setName(projectApplyStateDto.getName());
            srmProjectApplyState.setIsValid(Integer.valueOf(projectApplyStateDto.getIsValid()));

            projectApplyStateList.add(srmProjectApplyState);
            Long RowId = srmProjectApplyState.getId();
        }
        super.saveOrUpdateBatch(projectApplyStateList);
        return RowId;
    }
    @Override
    public ProjectApplyStateVo getDetailProjectApplyState(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProjectApplyStateVo> listProjectApplyState(ProjectApplyStateDto projectApplyStateDto) {
        Page<ProjectApplyStateVo> page = new Page<>(projectApplyStateDto.getPage(), projectApplyStateDto.getRows());
        IPage<ProjectApplyStateVo> res= srmProjectApplyStateMapper.listProjectApplyState(page, projectApplyStateDto);
        //List<ProjectApplyStateVo> records=res.getRecords();
        //List<ProjectApplyStateVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteProjectApplyState(BaseDto baseDto) {
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
