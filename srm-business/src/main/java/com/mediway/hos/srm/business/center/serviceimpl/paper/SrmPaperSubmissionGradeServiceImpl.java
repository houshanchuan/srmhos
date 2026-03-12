package com.mediway.hos.srm.business.center.serviceimpl.paper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionGradeDto;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperSubmissionGrade;
import com.mediway.hos.srm.business.center.mapper.paper.SrmPaperSubmissionGradeMapper;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionAuditorVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionGradeVo;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperSubmissionGradeService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;

import java.util.List;

/**
 * <p>
 * 论文投稿同行评审表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPaperSubmissionGradeServiceImpl extends BaseServiceImpl<SrmPaperSubmissionGradeMapper, SrmPaperSubmissionGrade> implements SrmPaperSubmissionGradeService {
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmPaperSubmissionGradeMapper srmPaperSubmissionGradeMapper;
    @Override
    public void savePaperSubmissionGrade(PaperSubmissionGradeDto paperSubmissionGradeDto) {
        SrmPaperSubmissionGrade srmPaperSubmissionGrade=new SrmPaperSubmissionGrade();
        srmPaperSubmissionGrade.setId(paperSubmissionGradeDto.getRowId());
        srmPaperSubmissionGrade.setSysNo(paperSubmissionGradeDto.getSysNo());
        srmPaperSubmissionGrade.setAppRowId(Long.valueOf(paperSubmissionGradeDto.getAppRowId()));
        srmPaperSubmissionGrade.setDataStatus(0);
        //srmProjectSolicitGrade.setAuditStatus("");
        srmPaperSubmissionGrade.setExpert(paperSubmissionGradeDto.getExpert());
        super.saveOrUpdate(srmPaperSubmissionGrade);
    }

    @Override
    @Transactional
    public Long saveDetail(PaperSubmissionGradeDto paperSubmissionGradeDto) {
        Long RowId=paperSubmissionGradeDto.getRowId();
        if(RowId==null){
            throw new ErrorException("-200","参数Id不存在！");
        }
        PaperSubmissionGradeVo paperSubmissionGradeVo=srmPaperSubmissionGradeMapper.getDetail(String.valueOf(RowId));
        if(paperSubmissionGradeVo==null){
            throw new ErrorException("-200","专家明细不存在！");
        }
        if(paperSubmissionGradeVo.getAuditStatus()!=null&&!paperSubmissionGradeVo.getAuditStatus().isEmpty()){
            throw new ErrorException("-200","已审核不允许修改保存！");
        }
        // 取到原来的值
        SrmPaperSubmissionGrade srmPaperSubmissionGrade=new SrmPaperSubmissionGrade();
        srmPaperSubmissionGrade.setId(paperSubmissionGradeDto.getRowId());
        srmPaperSubmissionGrade.setSysNo(paperSubmissionGradeVo.getSysNo());
        srmPaperSubmissionGrade.setAppRowId(paperSubmissionGradeVo.getAppRowId());
        srmPaperSubmissionGrade.setDataStatus(paperSubmissionGradeVo.getDataStatus());

        // 下面是界面获取的
        srmPaperSubmissionGrade.setIndex1(paperSubmissionGradeDto.getIndex1());
        srmPaperSubmissionGrade.setIndex1score(paperSubmissionGradeDto.getIndex1score());
        srmPaperSubmissionGrade.setIndex2(paperSubmissionGradeDto.getIndex2());
        srmPaperSubmissionGrade.setIndex2score(paperSubmissionGradeDto.getIndex2score());
        srmPaperSubmissionGrade.setIndex3(paperSubmissionGradeDto.getIndex3());
        srmPaperSubmissionGrade.setIndex3score(paperSubmissionGradeDto.getIndex3score());
        srmPaperSubmissionGrade.setIndex4(paperSubmissionGradeDto.getIndex4());
        srmPaperSubmissionGrade.setIndex4score(paperSubmissionGradeDto.getIndex4score());
        srmPaperSubmissionGrade.setIndex5(paperSubmissionGradeDto.getIndex5());
        srmPaperSubmissionGrade.setIndex5score(paperSubmissionGradeDto.getIndex5score());
        srmPaperSubmissionGrade.setIndex6(paperSubmissionGradeDto.getIndex6());
        srmPaperSubmissionGrade.setIndex6score(paperSubmissionGradeDto.getIndex6score());
        srmPaperSubmissionGrade.setIndex7(paperSubmissionGradeDto.getIndex7());
        srmPaperSubmissionGrade.setIndex7score(paperSubmissionGradeDto.getIndex7score());
        srmPaperSubmissionGrade.setIndex8(paperSubmissionGradeDto.getIndex8());
        srmPaperSubmissionGrade.setIndex8score(paperSubmissionGradeDto.getIndex8score());
        srmPaperSubmissionGrade.setIndex9(paperSubmissionGradeDto.getIndex9());
        srmPaperSubmissionGrade.setIndex9score(paperSubmissionGradeDto.getIndex9score());
        srmPaperSubmissionGrade.setIndex10(paperSubmissionGradeDto.getIndex10());
        srmPaperSubmissionGrade.setIndex10score(paperSubmissionGradeDto.getIndex10score());
        srmPaperSubmissionGrade.setIndex11(paperSubmissionGradeDto.getIndex11());
        srmPaperSubmissionGrade.setIndex11score(paperSubmissionGradeDto.getIndex11score());
        srmPaperSubmissionGrade.setIndex12(paperSubmissionGradeDto.getIndex12());
        srmPaperSubmissionGrade.setIndex12score(paperSubmissionGradeDto.getIndex12score());
        srmPaperSubmissionGrade.setAuditStatus(paperSubmissionGradeDto.getAuditStatus());
        srmPaperSubmissionGrade.setNote(paperSubmissionGradeDto.getNote());

        try{
            super.saveOrUpdate(srmPaperSubmissionGrade);
            //RowId= srmProjectSolicitGrade.getId();
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
        return RowId;
    }

    @Override
    public List<PaperSubmissionAuditorVo> listPaperSubmissionGrade(PaperSubmissionGradeDto paperSubmissionGradeDto) {
        return srmPaperSubmissionGradeMapper.listPaperSubmissionGrade(paperSubmissionGradeDto);
    }

    @Override
    @Transactional
    public void subMit(PaperSubmissionGradeDto paperSubmissionGradeDto) {
        try{
            if(paperSubmissionGradeDto.getRowId()==null){
                throw new ErrorException("-200","未传入ID");
            }
            srmPaperSubmissionGradeMapper.updateGradeState(paperSubmissionGradeDto);
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    public PaperSubmissionGradeVo getDetail(String rowId) {
        return srmPaperSubmissionGradeMapper.getDetail(rowId);
    }
}
