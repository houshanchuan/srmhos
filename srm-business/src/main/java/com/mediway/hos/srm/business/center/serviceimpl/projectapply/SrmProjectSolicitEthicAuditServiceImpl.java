package com.mediway.hos.srm.business.center.serviceimpl.projectapply;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitEthicAuditDto;
import com.mediway.hos.srm.business.center.model.entity.projectapply.SrmProjectSolicitEthicAudit;
import com.mediway.hos.srm.business.center.mapper.projectapply.SrmProjectSolicitEthicAuditMapper;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitAuditExpertVo;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitEthicAuditVo;
import com.mediway.hos.srm.business.center.service.projectapply.SrmProjectSolicitEthicAuditService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * <p>
 * 项目征集伦理审批表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectSolicitEthicAuditServiceImpl extends BaseServiceImpl<SrmProjectSolicitEthicAuditMapper, SrmProjectSolicitEthicAudit> implements SrmProjectSolicitEthicAuditService {
    @Autowired
    private  SrmProjectSolicitEthicAuditMapper srmProjectSolicitEthicAuditMapper;
    @Autowired
    private SrmUserService srmUserService;
    @Override
    public void saveProjectSolicitEthicAudit(ProjectSolicitEthicAuditDto projectSolicitEthicAuditDto) {
        SrmProjectSolicitEthicAudit srmProjectSolicitEthicAudit=new SrmProjectSolicitEthicAudit();
        srmProjectSolicitEthicAudit.setEthicExpert(projectSolicitEthicAuditDto.getEthicExpert());
        srmProjectSolicitEthicAudit.setSysNo(projectSolicitEthicAuditDto.getSysNo());
        srmProjectSolicitEthicAudit.setSoliProjectId(projectSolicitEthicAuditDto.getSoliProjectId());
        srmProjectSolicitEthicAudit.setDataStatus(0);
        srmProjectSolicitEthicAudit.setIsCancel(0);
        srmProjectSolicitEthicAudit.setEthicAllotCount(projectSolicitEthicAuditDto.getEthicAllotCount());
        super.saveOrUpdate(srmProjectSolicitEthicAudit);
    }

    @Override
    @Transactional
    // 上面的方法供初始分配专家用（没有事务，防止异常捕获，回滚失效），此方法保存专家填写的意见等（有事务）
    public Long saveDetail(ProjectSolicitEthicAuditDto projectSolicitEthicAuditDto) {
        Long RowId=null;
        SrmProjectSolicitEthicAudit srmProjectSolicitEthicAudit=new SrmProjectSolicitEthicAudit();
        srmProjectSolicitEthicAudit.setId(projectSolicitEthicAuditDto.getRowId());
        srmProjectSolicitEthicAudit.setEthicExpert(projectSolicitEthicAuditDto.getEthicExpert());
        srmProjectSolicitEthicAudit.setSysNo(projectSolicitEthicAuditDto.getSysNo());
        srmProjectSolicitEthicAudit.setSoliProjectId(projectSolicitEthicAuditDto.getSoliProjectId());
        srmProjectSolicitEthicAudit.setDataStatus(0);

        srmProjectSolicitEthicAudit.setEthicAuditDesc(projectSolicitEthicAuditDto.getEthicAuditDesc());
        srmProjectSolicitEthicAudit.setEthicChkResult(projectSolicitEthicAuditDto.getEthicChkResult());
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = currentDate.format(formatter);
        srmProjectSolicitEthicAudit.setEthicAuditDate(formattedDate);
        try{
            super.saveOrUpdate(srmProjectSolicitEthicAudit);
            RowId=srmProjectSolicitEthicAudit.getId();
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
        return RowId;
    }


    @Override
    public List<ProjectSolicitAuditExpertVo> listProjectSolicitEthicAudit(ProjectSolicitEthicAuditDto projectSolicitEthicAuditDto) {
        return srmProjectSolicitEthicAuditMapper.listProjectSolicitEthicAudit(projectSolicitEthicAuditDto);
    }

    @Override
    public IPage<ProjectSolicitEthicAuditVo> listEthicAuditProjectSolicit(ProjectSolicitDto projectSolicitDto) {
        String userCode=projectSolicitDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        projectSolicitDto.setUserId(srmUserRowId);
        Page<ProjectSolicitEthicAuditVo> page = new Page<>(projectSolicitDto.getPage(), projectSolicitDto.getRows());
        IPage<ProjectSolicitEthicAuditVo> res= srmProjectSolicitEthicAuditMapper.listEthicAuditProjectSolicit(page, projectSolicitDto);

        return res;
    }

    @Override
    public List<ProjectSolicitEthicAuditVo> listEthicAuditProjectSolicitDetail(ProjectSolicitEthicAuditDto projectSolicitEthicAuditDto) {
        String userCode=projectSolicitEthicAuditDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        projectSolicitEthicAuditDto.setUserId(String.valueOf(srmUserRowId));
        return srmProjectSolicitEthicAuditMapper.listEthicAuditProjectSolicitDetail(projectSolicitEthicAuditDto);
    }

    @Override
    @Transactional
    public void subMit(BaseDto baseDto) {
        System.out.println(baseDto);
        try{
            Long rowId=baseDto.getId();
            SrmProjectSolicitEthicAudit srmProjectSolicitEthicAudit=new SrmProjectSolicitEthicAudit();
            srmProjectSolicitEthicAudit.setId(rowId);
            srmProjectSolicitEthicAudit.setDataStatus(1);
            super.saveOrUpdate(srmProjectSolicitEthicAudit);

        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }
}
