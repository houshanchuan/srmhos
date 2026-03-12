package com.mediway.hos.srm.business.center.serviceimpl.award;

import com.mediway.hos.srm.business.center.model.dto.award.AchievementAuthorDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.award.SrmAchievementAuthor;
import com.mediway.hos.srm.business.center.mapper.award.SrmAchievementAuthorMapper;
import com.mediway.hos.srm.business.center.model.vo.award.AchievementAuthorVo;
import com.mediway.hos.srm.business.center.service.award.SrmAchievementAuthorService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 获奖成果作者表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmAchievementAuthorServiceImpl extends BaseServiceImpl<SrmAchievementAuthorMapper, SrmAchievementAuthor> implements SrmAchievementAuthorService {
    @Autowired
    private SrmAchievementAuthorMapper srmAchievementAuthorMapper;
    @Override
    public List<AchievementAuthorVo> listAchievementAuthor(BaseDto baseDto) {
        return srmAchievementAuthorMapper.listAchievementAuthor(baseDto.getId());
    }

    @Override
    public void deleteAuthorByParentId(Long parentId) {
        srmAchievementAuthorMapper.deleteAuthorByParentId(parentId);
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
    public Long saveAuthor(AchievementAuthorDto achievementAuthorDto) {
        SrmAchievementAuthor srmAchievementAuthor=new SrmAchievementAuthor();
        srmAchievementAuthor.setId(achievementAuthorDto.getRowId());
        srmAchievementAuthor.setAchievementId(achievementAuthorDto.getAchievementId());
        srmAchievementAuthor.setAuthorId(achievementAuthorDto.getAuthorId());
        srmAchievementAuthor.setAuthorType(achievementAuthorDto.getAuthorType());
        srmAchievementAuthor.setAuthorRanking(achievementAuthorDto.getAuthorRanking());
        srmAchievementAuthor.setNote(achievementAuthorDto.getNote());
        srmAchievementAuthor.setTitle(achievementAuthorDto.getTitle());
        srmAchievementAuthor.setEduDegree(achievementAuthorDto.getEduDegree());
        srmAchievementAuthor.setEduLevel(achievementAuthorDto.getEduLevel());
        srmAchievementAuthor.setWorkRatio(achievementAuthorDto.getWorkRatio());
        this.saveOrUpdate(srmAchievementAuthor);
        return  srmAchievementAuthor.getId();
    }
}
