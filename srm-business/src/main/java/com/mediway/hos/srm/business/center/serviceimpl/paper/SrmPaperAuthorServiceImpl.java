package com.mediway.hos.srm.business.center.serviceimpl.paper;

import com.mediway.hos.srm.business.center.model.dto.paper.PaperAuthorDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperAuthor;
import com.mediway.hos.srm.business.center.mapper.paper.SrmPaperAuthorMapper;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperAuthorVo;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperAuthorService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 论文作者表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPaperAuthorServiceImpl extends BaseServiceImpl<SrmPaperAuthorMapper, SrmPaperAuthor> implements SrmPaperAuthorService {
    @Autowired
    private SrmPaperAuthorMapper srmPaperAuthorMapper;
    @Override
    public PaperAuthorVo getPaperAuthor(String rankCode, String corrAuthorFlag, String authorType) {
        return srmPaperAuthorMapper.getPaperAuthor( rankCode,  corrAuthorFlag,  authorType);
    }

    @Override
    public int getAuthorCount(String paperId) {
        return srmPaperAuthorMapper.getAuthorCount(paperId);
    }

    @Override
    public List<PaperAuthorVo> listPaperAuthor(BaseDto baseDto) {
        Long paperId=baseDto.getId();
        return srmPaperAuthorMapper.listPaperAuthor(paperId);
    }

    @Override
    public void deleteAuthorByPaper(Long paperId) {
        srmPaperAuthorMapper.deleteAuthorByPaper(paperId);
    }

    @Override
    @Transactional
    public void deleteAuthorById(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
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
    public Long saveAuthor(PaperAuthorDto srmPaperAuthorDto){
        SrmPaperAuthor srmPaperAuthor=new SrmPaperAuthor();
        srmPaperAuthor.setId(srmPaperAuthorDto.getRowId());
        srmPaperAuthor.setPaperId(srmPaperAuthorDto.getPaperId());
        srmPaperAuthor.setAuthor(srmPaperAuthorDto.getAuthor());
        srmPaperAuthor.setAuthorType(srmPaperAuthorDto.getAuthorType());
        srmPaperAuthor.setAuthorName(srmPaperAuthorDto.getAuthorName());
        srmPaperAuthor.setRanking(srmPaperAuthorDto.getRanking());
        srmPaperAuthor.setSex(srmPaperAuthorDto.getSex());
        srmPaperAuthor.setNote(srmPaperAuthorDto.getNote());
        srmPaperAuthor.setAuthorDeptId(srmPaperAuthorDto.getAuthorDeptId());
        srmPaperAuthor.setWorkRatio(srmPaperAuthorDto.getWorkRatio());
        srmPaperAuthor.setIsCorrAuthor(srmPaperAuthorDto.getIsCorrAuthor());
        srmPaperAuthor.setIsTiedCorrAuthor(srmPaperAuthorDto.getIsTiedCorrAuthor());
        this.saveOrUpdate(srmPaperAuthor);
        return srmPaperAuthor.getId();
    }
}
