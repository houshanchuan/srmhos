package com.mediway.hos.srm.business.center.serviceimpl.patent;

import com.mediway.hos.srm.business.center.model.dto.patent.PatentInfoAuthorDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.patent.SrmPatentInfoAuthor;
import com.mediway.hos.srm.business.center.mapper.patent.SrmPatentInfoAuthorMapper;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentInfoAuthorVo;
import com.mediway.hos.srm.business.center.service.patent.SrmPatentInfoAuthorService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 专利作者表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPatentInfoAuthorServiceImpl extends BaseServiceImpl<SrmPatentInfoAuthorMapper, SrmPatentInfoAuthor> implements SrmPatentInfoAuthorService {
    @Autowired
    private SrmPatentInfoAuthorMapper srmPatentInfoAuthorMapper;
    @Override
    public List<PatentInfoAuthorVo> listPatentInfoAuthor(BaseDto baseDto) {
        Long paperId=baseDto.getId();
        return srmPatentInfoAuthorMapper.listPatentInfoAuthor(paperId);
    }

    @Override
    public void deleteAuthorByParent(Long parentId) {
        srmPatentInfoAuthorMapper.deleteAuthorByParent(parentId);
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
    public Long saveAuthor(PatentInfoAuthorDto patentInfoAuthorDto) {
        SrmPatentInfoAuthor srmPatentInfoAuthor=new SrmPatentInfoAuthor();
        srmPatentInfoAuthor.setId(patentInfoAuthorDto.getRowId());
        srmPatentInfoAuthor.setPatentId(patentInfoAuthorDto.getPatentId());
        srmPatentInfoAuthor.setAuthor(patentInfoAuthorDto.getAuthor());
        srmPatentInfoAuthor.setAuthorName(patentInfoAuthorDto.getAuthorName());
        srmPatentInfoAuthor.setAuthorDeptId(patentInfoAuthorDto.getAuthorDeptId());
        srmPatentInfoAuthor.setAuthorType(patentInfoAuthorDto.getAuthorType());
        srmPatentInfoAuthor.setAuthorRanking(patentInfoAuthorDto.getAuthorRanking());
        srmPatentInfoAuthor.setTitle(patentInfoAuthorDto.getTitle());
        srmPatentInfoAuthor.setSex(patentInfoAuthorDto.getSex());
        srmPatentInfoAuthor.setAuthorRanking(patentInfoAuthorDto.getAuthorRanking());
        srmPatentInfoAuthor.setNote(patentInfoAuthorDto.getNote());
        srmPatentInfoAuthor.setEduDegree(patentInfoAuthorDto.getEduDegree());
        this.saveOrUpdate(srmPatentInfoAuthor);
        return srmPatentInfoAuthor.getId();

    }
}
