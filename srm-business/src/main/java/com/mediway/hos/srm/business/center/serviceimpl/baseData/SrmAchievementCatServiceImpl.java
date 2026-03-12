package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.AchvCatDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAchievementCat;
import com.mediway.hos.srm.business.center.mapper.award.SrmAchievementCatMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvCatVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmAchievementCatService;


/**
 * <p>
 * 成果分类 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmAchievementCatServiceImpl extends BaseServiceImpl<SrmAchievementCatMapper, SrmAchievementCat> implements SrmAchievementCatService {

    @Autowired
    private SrmAchievementCatMapper srmAchievementCatMapper;
    private Long RowId;
    @Override
    public List<CombVo> getAchievementCat() {
        return srmAchievementCatMapper.getAchievementCat();
    }
    @Override
    @Transactional
    public Long saveOrUpdateAchvCat(BaseDataLearningDto baseDataLearningDto) {
        List<AchvCatDto> achvCatDtos =baseDataLearningDto.getAchvCats();

        List<SrmAchievementCat> achvCatList=new ArrayList<>();
        for (AchvCatDto achvCatDto :achvCatDtos) {
            SrmAchievementCat srmAchvCat = new SrmAchievementCat();
            srmAchvCat.setId(achvCatDto.getRowId());
            srmAchvCat.setCode(achvCatDto.getCode());
            srmAchvCat.setName(achvCatDto.getName());
            srmAchvCat.setIsValid(Integer.valueOf(achvCatDto.getIsValid()));

            achvCatList.add(srmAchvCat);
            Long RowId = srmAchvCat.getId();
        }
        super.saveOrUpdateBatch(achvCatList);
        return RowId;
    }
    @Override
    public AchvCatVo getDetailAchvCat(Long RowId) {
        return null;
    }

    @Override
    public IPage<AchvCatVo> listAchvCat(AchvCatDto achvCatDto) {
        Page<AchvCatVo> page = new Page<>(achvCatDto.getPage(), achvCatDto.getRows());
        IPage<AchvCatVo> res= srmAchievementCatMapper.listAchvCat(page, achvCatDto);
        //List<AchvCatVo> records=res.getRecords();
        //List<AchvCatVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteAchvCat(BaseDto baseDto) {
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
