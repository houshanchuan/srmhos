package com.mediway.hos.srm.business.center.serviceimpl.patent;

import com.mediway.hos.srm.business.center.model.dto.patent.PatentApplyAuthorDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.patent.SrmPatentApplyAuthor;
import com.mediway.hos.srm.business.center.mapper.patent.SrmPatentApplyAuthorMapper;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentApplyAuthorVo;
import com.mediway.hos.srm.business.center.service.patent.SrmPatentApplyAuthorService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 专利申报作者表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPatentApplyAuthorServiceImpl extends BaseServiceImpl<SrmPatentApplyAuthorMapper, SrmPatentApplyAuthor> implements SrmPatentApplyAuthorService {
    @Autowired
    private SrmPatentApplyAuthorMapper srmPatentApplyAuthorMapper;
    @Override
    public void deleteAuthorByApplyId(Long patentApplyId) {
        srmPatentApplyAuthorMapper.deleteAuthorByApplyId(patentApplyId);
    }

    @Override
    public List<PatentApplyAuthorVo> listPatentApplyAuthor(BaseDto baseDto) {
        Long paperId=baseDto.getId();
        return srmPatentApplyAuthorMapper.listPatentApplyAuthor(paperId);
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
    public Long saveAuthor(PatentApplyAuthorDto patentApplyAuthorDto) {
        SrmPatentApplyAuthor srmPatentApplyAuthor=new SrmPatentApplyAuthor();
        srmPatentApplyAuthor.setId(patentApplyAuthorDto.getRowId());
        srmPatentApplyAuthor.setApplyPatentId(patentApplyAuthorDto.getApplyPatentId());
        srmPatentApplyAuthor.setAuthorId(patentApplyAuthorDto.getAuthorId());
        srmPatentApplyAuthor.setAuthorCode(patentApplyAuthorDto.getAuthorCode());
        srmPatentApplyAuthor.setAuthorName(patentApplyAuthorDto.getAuthorName());
        srmPatentApplyAuthor.setAuthorType(patentApplyAuthorDto.getAuthorType());
        srmPatentApplyAuthor.setRanking(patentApplyAuthorDto.getRanking());
        srmPatentApplyAuthor.setNote(patentApplyAuthorDto.getNote());
        srmPatentApplyAuthor.setTitle(patentApplyAuthorDto.getTitle());
        srmPatentApplyAuthor.setEduLevel(patentApplyAuthorDto.getEduLevel());
        srmPatentApplyAuthor.setDegree(patentApplyAuthorDto.getDegree());
        srmPatentApplyAuthor.setWorkRatio(patentApplyAuthorDto.getWorkRatio());
        this.saveOrUpdate(srmPatentApplyAuthor);
        return srmPatentApplyAuthor.getId();
    }
}
