package com.mediway.hos.srm.business.center.serviceimpl.projectapply;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectApplyInfoDto;
import com.mediway.hos.srm.business.center.model.entity.projectapply.SrmProjectApplyInfo;
import com.mediway.hos.srm.business.center.mapper.projectapply.SrmProjectApplyInfoMapper;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectApplyInfoVo;
import com.mediway.hos.srm.business.center.service.projectapply.SrmProjectApplyInfoService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import com.mediway.hos.srm.business.center.utils.DateTransform;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 项目申报批次 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-23
 */
@Service
public class SrmProjectApplyInfoServiceImpl extends BaseServiceImpl<SrmProjectApplyInfoMapper, SrmProjectApplyInfo> implements SrmProjectApplyInfoService {
    @Autowired
    private SrmProjectApplyInfoMapper srmProjectApplyInfoMapper;
    @Autowired
    private SrmUserService srmUserService;
    @Override
    public IPage<ProjectApplyInfoVo> listProjectApplyPlan(ProjectApplyInfoDto projectApplyInfoDto) {
        System.out.println(projectApplyInfoDto);
        Page<ProjectApplyInfoVo> page = new Page<>(projectApplyInfoDto.getPage(), projectApplyInfoDto.getRows());
        IPage<ProjectApplyInfoVo> res= srmProjectApplyInfoMapper.listProjectApplyPlan(page, projectApplyInfoDto);
        return res;
    }

    @Override
    @Transactional
    public void deleteProjectApplyPlan(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                SrmProjectApplyInfo srmProjectApplyInfo=this.selectById(RowId);
                String status=srmProjectApplyInfo.getState();
                if(!"1".equals(status)){
                    throw new ErrorException("-200","当前状态不允许删除！");
                }


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
    @Transactional
    public Long saveProjectApplyPlan(ProjectApplyInfoDto projectApplyInfoDto) {
        Long RowId=null;
        try {
            String userCode=projectApplyInfoDto.getCreatorCode();
            SrmProjectApplyInfo srmProjectApplyInfo=new SrmProjectApplyInfo();
            srmProjectApplyInfo.setId(projectApplyInfoDto.getRowId());
            srmProjectApplyInfo.setName(projectApplyInfoDto.getName());
            if(projectApplyInfoDto.getRowId()==null){
                srmProjectApplyInfo.setCreatorCode(userCode);
                srmProjectApplyInfo.setCreateTime(LocalDateTime.now());
            }

            srmProjectApplyInfo.setProjectClass(projectApplyInfoDto.getProjectClass());
            srmProjectApplyInfo.setNote(projectApplyInfoDto.getNote());
            srmProjectApplyInfo.setState(projectApplyInfoDto.getState());
            srmProjectApplyInfo.setStartDate(DateTransform.getLocalDateTime(projectApplyInfoDto.getStartDate()));
            srmProjectApplyInfo.setEndDate(DateTransform.getLocalDateTime(projectApplyInfoDto.getEndDate()));
            srmProjectApplyInfo.setSourceUnitName(projectApplyInfoDto.getSourceUnitName());
            srmProjectApplyInfo.setProjType(projectApplyInfoDto.getProjType());
            super.saveOrUpdate(srmProjectApplyInfo);
            RowId=srmProjectApplyInfo.getId();
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
        return RowId;
    }

    @Override
    public ProjectApplyInfoVo getDetail(Long rowId) {
        return srmProjectApplyInfoMapper.getDetail(rowId);
    }
}
