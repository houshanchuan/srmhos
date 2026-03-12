package com.mediway.hos.srm.business.center.serviceimpl.award;

import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.award.AwardApplyAuthorDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.award.SrmAwardApplyAuthor;
import com.mediway.hos.srm.business.center.mapper.award.SrmAwardApplyAuthorMapper;
import com.mediway.hos.srm.business.center.model.vo.award.AwardApplyAuthorVo;
import com.mediway.hos.srm.business.center.service.award.SrmAwardApplyAuthorService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 成果获奖申报作者 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmAwardApplyAuthorServiceImpl extends BaseServiceImpl<SrmAwardApplyAuthorMapper, SrmAwardApplyAuthor> implements SrmAwardApplyAuthorService {
    @Autowired
    private SrmAwardApplyAuthorMapper srmAwardApplyAuthorMapper;
    @Override
    public void deleteAuthorByApplyId(Long awardApplyId) {
        srmAwardApplyAuthorMapper.deleteAuthorByApplyId(awardApplyId);
    }

    @Override
    public List<AwardApplyAuthorVo> listAwardApplyAuthor(BaseDto baseDto) {
        return srmAwardApplyAuthorMapper.listAwardApplyAuthor(baseDto.getId());
    }

    @Override
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
    public Long saveAuthor(AwardApplyAuthorDto awardApplyAuthorDto) {
        SrmAwardApplyAuthor srmAwardApplyAuthor=new SrmAwardApplyAuthor();
        srmAwardApplyAuthor.setId(awardApplyAuthorDto.getRowId());
        srmAwardApplyAuthor.setAwardApplyId(awardApplyAuthorDto.getAwardApplyId());
        srmAwardApplyAuthor.setAuthorId(awardApplyAuthorDto.getAuthorId());
        srmAwardApplyAuthor.setAuthorType(awardApplyAuthorDto.getAuthorType());
        srmAwardApplyAuthor.setAuthorRanking(awardApplyAuthorDto.getAuthorRanking());
        srmAwardApplyAuthor.setWorkRatio(awardApplyAuthorDto.getWorkRatio());
        srmAwardApplyAuthor.setSex(awardApplyAuthorDto.getSex());
        srmAwardApplyAuthor.setNote(awardApplyAuthorDto.getNote());
        srmAwardApplyAuthor.setTitle(awardApplyAuthorDto.getTitle());
        srmAwardApplyAuthor.setEduDegree(awardApplyAuthorDto.getEduDegree());
        srmAwardApplyAuthor.setEduLevel(awardApplyAuthorDto.getEduLevel());
        this.saveOrUpdate(srmAwardApplyAuthor);
        return srmAwardApplyAuthor.getId();
    }
}
