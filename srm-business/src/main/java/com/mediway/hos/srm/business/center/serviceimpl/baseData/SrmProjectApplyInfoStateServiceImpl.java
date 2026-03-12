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
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;


import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApplyInfoStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApplyInfoStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectApplyInfoState;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectApplyInfoStateService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProjectApplyInfoStateMapper;
/**
 * <p>
 * 项目申报批次状态 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectApplyInfoStateServiceImpl extends BaseServiceImpl<SrmProjectApplyInfoStateMapper, SrmProjectApplyInfoState> implements SrmProjectApplyInfoStateService {

    @Autowired
    private SrmProjectApplyInfoStateService  srmProjectApplyInfoStateService;
    @Autowired
    private SrmProjectApplyInfoStateMapper srmProjectApplyInfoStateMapper;
    private Long RowId;	  
     @Override
    public List<CombVo> getProjectApplyInfoState() {
        return srmProjectApplyInfoStateMapper.getProjectApplyInfoState();
	}
    @Override
    @Transactional
    public Long saveOrUpdateProjectApplyInfoState(BaseDataCommonDto baseDataProjDto) {
        List<ProjectApplyInfoStateDto> projectApplyInfoStateDtos =baseDataProjDto.getProjectApplyInfoStates();

        List<SrmProjectApplyInfoState> projectApplyInfoStateList=new ArrayList<>();
        for (ProjectApplyInfoStateDto projectApplyInfoStateDto :projectApplyInfoStateDtos) {
            SrmProjectApplyInfoState srmProjectApplyInfoState = new SrmProjectApplyInfoState();
            srmProjectApplyInfoState.setId(projectApplyInfoStateDto.getRowId());
            srmProjectApplyInfoState.setCode(projectApplyInfoStateDto.getCode());
            srmProjectApplyInfoState.setName(projectApplyInfoStateDto.getName());
            srmProjectApplyInfoState.setIsValid(Integer.valueOf(projectApplyInfoStateDto.getIsValid()));

            projectApplyInfoStateList.add(srmProjectApplyInfoState);
            Long RowId = srmProjectApplyInfoState.getId();
        }
        super.saveOrUpdateBatch(projectApplyInfoStateList);
        return RowId;
    }
    @Override
    public ProjectApplyInfoStateVo getDetailProjectApplyInfoState(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProjectApplyInfoStateVo> listProjectApplyInfoState(ProjectApplyInfoStateDto projectApplyInfoStateDto) {
        Page<ProjectApplyInfoStateVo> page = new Page<>(projectApplyInfoStateDto.getPage(), projectApplyInfoStateDto.getRows());
        IPage<ProjectApplyInfoStateVo> res= srmProjectApplyInfoStateMapper.listProjectApplyInfoState(page, projectApplyInfoStateDto);
        //List<ProjectApplyInfoStateVo> records=res.getRecords();
        //List<ProjectApplyInfoStateVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteProjectApplyInfoState(BaseDto baseDto) {
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
