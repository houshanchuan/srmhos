package com.mediway.hos.srm.business.center.serviceimpl.projectapply;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitGradeDto;
import com.mediway.hos.srm.business.center.model.entity.projectapply.SrmProjectSolicitGrade;
import com.mediway.hos.srm.business.center.mapper.projectapply.SrmProjectSolicitGradeMapper;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitAuditExpertVo;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitGradeVo;
import com.mediway.hos.srm.business.center.service.projectapply.SrmProjectSolicitGradeService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;

import java.util.List;

/**
 * <p>
 * 项目征集专业评分表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectSolicitGradeServiceImpl extends BaseServiceImpl<SrmProjectSolicitGradeMapper, SrmProjectSolicitGrade> implements SrmProjectSolicitGradeService {
    @Autowired
    private SrmProjectSolicitGradeMapper srmProjectSolicitGradeMapper;
    @Autowired
    private SrmUserService srmUserService;
    @Override
    // 初始化专家审核明细
    public void saveProjectSolictitGrade(ProjectSolicitGradeDto projectSolicitGradeDto) {
        SrmProjectSolicitGrade srmProjectSolicitGrade=new SrmProjectSolicitGrade();
        srmProjectSolicitGrade.setId(projectSolicitGradeDto.getRowId());
        srmProjectSolicitGrade.setSysNo(projectSolicitGradeDto.getSysNo());
        srmProjectSolicitGrade.setProjectId(projectSolicitGradeDto.getProjectId());
        srmProjectSolicitGrade.setDataStatus(0);
        srmProjectSolicitGrade.setIsCancel(0);
        //srmProjectSolicitGrade.setAuditStatus("");
        srmProjectSolicitGrade.setExpert(projectSolicitGradeDto.getExpert());
        srmProjectSolicitGrade.setAllotCount(projectSolicitGradeDto.getAllotCount());
        super.saveOrUpdate(srmProjectSolicitGrade);

    }

    @Override
    @Transactional
    // 上面的方法供初始分配专家用（没有事务，防止异常捕获，回滚失效），此方法保存专家填写的意见等（有事务）
    public Long saveDetail(ProjectSolicitGradeDto projectSolicitGradeDto) {
        Long RowId=projectSolicitGradeDto.getRowId();
        if(RowId==null){
            throw new ErrorException("-200","参数Id不存在！");
        }
        ProjectSolicitGradeVo projectSolicitGradeVo=srmProjectSolicitGradeMapper.getDetail(String.valueOf(RowId));
        if(projectSolicitGradeVo==null){
            throw new ErrorException("-200","专家明细不存在！");
        }
        if(projectSolicitGradeVo.getAuditStatus()!=null&&!projectSolicitGradeVo.getAuditStatus().isEmpty()){
            throw new ErrorException("-200","已审核不允许修改保存！");
        }
        // 取到原来的值
        SrmProjectSolicitGrade srmProjectSolicitGrade=new SrmProjectSolicitGrade();
        srmProjectSolicitGrade.setId(projectSolicitGradeDto.getRowId());
        srmProjectSolicitGrade.setSysNo(projectSolicitGradeVo.getSysNo());
        srmProjectSolicitGrade.setProjectId(projectSolicitGradeVo.getProjectId());
        srmProjectSolicitGrade.setPrjType(projectSolicitGradeVo.getPrjType());
        srmProjectSolicitGrade.setAllotCount(projectSolicitGradeVo.getAllotCount());
        srmProjectSolicitGrade.setDataStatus(projectSolicitGradeVo.getDataStatus());

        // 下面是界面获取的
        srmProjectSolicitGrade.setIndex1(projectSolicitGradeDto.getIndex1());
        srmProjectSolicitGrade.setIndex1score(projectSolicitGradeDto.getIndex1score());
        srmProjectSolicitGrade.setIndex2(projectSolicitGradeDto.getIndex2());
        srmProjectSolicitGrade.setIndex2score(projectSolicitGradeDto.getIndex2score());
        srmProjectSolicitGrade.setIndex3(projectSolicitGradeDto.getIndex3());
        srmProjectSolicitGrade.setIndex3score(projectSolicitGradeDto.getIndex3score());
        srmProjectSolicitGrade.setIndex4(projectSolicitGradeDto.getIndex4());
        srmProjectSolicitGrade.setIndex4score(projectSolicitGradeDto.getIndex4score());
        srmProjectSolicitGrade.setIndex5(projectSolicitGradeDto.getIndex5());
        srmProjectSolicitGrade.setIndex5score(projectSolicitGradeDto.getIndex5score());
        srmProjectSolicitGrade.setIndex6(projectSolicitGradeDto.getIndex6());
        srmProjectSolicitGrade.setIndex6score(projectSolicitGradeDto.getIndex6score());
        srmProjectSolicitGrade.setIndex7(projectSolicitGradeDto.getIndex7());
        srmProjectSolicitGrade.setIndex7score(projectSolicitGradeDto.getIndex7score());
        srmProjectSolicitGrade.setIndex8(projectSolicitGradeDto.getIndex8());
        srmProjectSolicitGrade.setIndex8score(projectSolicitGradeDto.getIndex8score());
        srmProjectSolicitGrade.setIndex9(projectSolicitGradeDto.getIndex9());
        srmProjectSolicitGrade.setIndex9score(projectSolicitGradeDto.getIndex9score());
        srmProjectSolicitGrade.setIndex10(projectSolicitGradeDto.getIndex10());
        srmProjectSolicitGrade.setIndex10score(projectSolicitGradeDto.getIndex10score());
        srmProjectSolicitGrade.setIndex11(projectSolicitGradeDto.getIndex11());
        srmProjectSolicitGrade.setIndex11score(projectSolicitGradeDto.getIndex11score());
        srmProjectSolicitGrade.setIndex12(projectSolicitGradeDto.getIndex12());
        srmProjectSolicitGrade.setIndex12score(projectSolicitGradeDto.getIndex12score());
        srmProjectSolicitGrade.setAuditStatus(projectSolicitGradeDto.getAuditStatus());
        srmProjectSolicitGrade.setNote(projectSolicitGradeDto.getNote());

        try{
            super.saveOrUpdate(srmProjectSolicitGrade);
            //RowId= srmProjectSolicitGrade.getId();
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
        return RowId;
    }

    @Override
    // 查询分配的专家
    public List<ProjectSolicitAuditExpertVo> listProjectSolicitGrade(ProjectSolicitGradeDto projectSolicitGradeDto) {
        return srmProjectSolicitGradeMapper.listProjectSolicitGrade(projectSolicitGradeDto);
    }

    @Override
    // 查询专家审批明细
    public IPage<ProjectSolicitGradeVo> listAuditProjectSolicit(ProjectSolicitDto projectSolicitDto) {
        String userCode=projectSolicitDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        projectSolicitDto.setUserId(srmUserRowId);
        Page<ProjectSolicitGradeVo> page = new Page<>(projectSolicitDto.getPage(), projectSolicitDto.getRows());
        IPage<ProjectSolicitGradeVo> res= srmProjectSolicitGradeMapper.listAuditProjectSolicit(page, projectSolicitDto);
        return res;
    }

    @Override
    @Transactional
    public void subMit(ProjectSolicitGradeDto projectSolicitGradeDto) {
        try{
            if(projectSolicitGradeDto.getRowId()==null){
                throw new ErrorException("-200","未传入ID");
            }
            projectSolicitGradeDto.setDataStatus(1);
            srmProjectSolicitGradeMapper.updateGradeState(projectSolicitGradeDto);
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    public ProjectSolicitGradeVo getDetail(String rowId) {
        return srmProjectSolicitGradeMapper.getDetail(rowId);
    }
}
