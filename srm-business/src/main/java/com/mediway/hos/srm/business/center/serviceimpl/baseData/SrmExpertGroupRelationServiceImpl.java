package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.ExpertGroupRelationDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ExpertGroupRelationVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmExpertGroupRelation;
import com.mediway.hos.srm.business.center.service.baseData.SrmExpertGroupRelationService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmExpertGroupRelationMapper;

/**
 * <p>
 * 组织关系定义 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmExpertGroupRelationServiceImpl extends BaseServiceImpl<SrmExpertGroupRelationMapper, SrmExpertGroupRelation> implements SrmExpertGroupRelationService {

    @Autowired
    private SrmExpertGroupRelationMapper srmExpertGroupRelationMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateSrmExpertGroupRelation(BaseDataUserDto baseDataUserDto) {
        List<ExpertGroupRelationDto> expertGroupRelationDtos =baseDataUserDto.getExpertGroupRelations();
        String mainId=baseDataUserDto.getMainId();
        List<SrmExpertGroupRelation> srmExpertGroupRelationList=new ArrayList<>();
        for (ExpertGroupRelationDto expertGroupRelationDto :expertGroupRelationDtos) {
            SrmExpertGroupRelation srmExpertGroupRelation = new SrmExpertGroupRelation();
            srmExpertGroupRelation.setId(expertGroupRelationDto.getRowId());
            srmExpertGroupRelation.setGroupId(expertGroupRelationDto.getGroupId());
            if (srmExpertGroupRelation.getGroupId()==null || srmExpertGroupRelation.getGroupId()=="") {
                srmExpertGroupRelation.setGroupId(mainId);
            }
            srmExpertGroupRelation.setUserId(expertGroupRelationDto.getUserId());
            srmExpertGroupRelationList.add(srmExpertGroupRelation);
            Long RowId = srmExpertGroupRelation.getId();
        }
        super.saveOrUpdateBatch(srmExpertGroupRelationList);
        return RowId;
    }
    @Override
    public ExpertGroupRelationVo getDetailSrmExpertGroupRelation(Long RowId) {
        return null;
    }

    @Override
    public IPage<ExpertGroupRelationVo> listSrmExpertGroupRelation(ExpertGroupRelationDto expertGroupRelationDto) {
        Page<ExpertGroupRelationVo> page = new Page<>(expertGroupRelationDto.getPage(),expertGroupRelationDto.getRows());
        IPage<ExpertGroupRelationVo> res= srmExpertGroupRelationMapper.listSrmExpertGroupRelation(page,expertGroupRelationDto);
        //List<ExpertGroupRelationVo> records=res.getRecords();
        //List<ExpertGroupRelationVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteSrmExpertGroupRelation(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                if(StringUtils.isEmpty(idStr)){
                    idStr=String.valueOf(RowId);
                }else{
                    idStr=idStr+""+String.valueOf(RowId);
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
