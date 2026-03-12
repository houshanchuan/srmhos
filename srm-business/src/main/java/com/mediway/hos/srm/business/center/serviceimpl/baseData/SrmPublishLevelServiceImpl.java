package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import com.mediway.hos.srm.business.center.constants.BusinessConstants;
import com.mediway.hos.srm.business.center.service.baseData.SrmBusinessnoService;
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

import com.mediway.hos.srm.business.center.model.dto.baseData.PublishLevelDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPublishLevel;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmPublishLevelMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.PublishLevelVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPublishLevelService;

import javax.annotation.Resource;


/**
 * <p>
 * 出版级别 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPublishLevelServiceImpl extends BaseServiceImpl<SrmPublishLevelMapper, SrmPublishLevel> implements SrmPublishLevelService {
    @Autowired
    private SrmPublishLevelService  srmPublishLevelService;
    @Autowired
    private SrmPublishLevelMapper srmPublishLevelMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdatePublishLevel(BaseDataLearningDto baseDataLearningDto) {
        List<PublishLevelDto> publishLevelDtos =baseDataLearningDto.getPublishLevels();

        List<SrmPublishLevel> publishLevelList=new ArrayList<>();
        for (PublishLevelDto publishLevelDto :publishLevelDtos) {
            SrmPublishLevel srmPublishLevel = new SrmPublishLevel();
            srmPublishLevel.setId(publishLevelDto.getRowId());
            if(ObjectUtil.isEmpty(publishLevelDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PT_PUBLISH_LEVEL, 1, "");
                srmPublishLevel.setCode(code);
            }else{
                srmPublishLevel.setCode(publishLevelDto.getCode());
            }
            srmPublishLevel.setName(publishLevelDto.getName());
            srmPublishLevel.setIsValid(publishLevelDto.getIsValid());

            publishLevelList.add(srmPublishLevel);
            Long RowId = srmPublishLevel.getId();
        }
        super.saveOrUpdateBatch(publishLevelList);
        return RowId;
    }
    @Override
    public PublishLevelVo getDetailPublishLevel(Long RowId) {
        return null;
    }

    @Override
    public IPage<PublishLevelVo> listPublishLevel(PublishLevelDto publishLevelDto) {
        Page<PublishLevelVo> page = new Page<>(publishLevelDto.getPage(), publishLevelDto.getRows());
        IPage<PublishLevelVo> res= srmPublishLevelMapper.listPublishLevel(page, publishLevelDto);
        //List<PublishLevelVo> records=res.getRecords();
        //List<PublishLevelVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePublishLevel(BaseDto baseDto) {
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
    public List<CombVo> getPublishLevel(){return srmPublishLevelMapper.getPublishLevel();}
}
