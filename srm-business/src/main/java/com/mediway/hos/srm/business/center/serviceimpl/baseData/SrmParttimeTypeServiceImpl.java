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

import com.mediway.hos.srm.business.center.model.dto.baseData.ParttimeTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ParttimeTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmParttimeType;
import com.mediway.hos.srm.business.center.service.baseData.SrmParttimeTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmParttimeTypeMapper;


/**
 * <p>
 * 兼职类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmParttimeTypeServiceImpl extends BaseServiceImpl<SrmParttimeTypeMapper, SrmParttimeType> implements SrmParttimeTypeService {

    @Autowired
    private SrmParttimeTypeMapper srmParttimeTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateParttimeType(BaseDataLearningDto baseDataLearningDto) {
        List<ParttimeTypeDto> parttimeTypeDtos =baseDataLearningDto.getParttimeTypes();

        List<SrmParttimeType> parttimeTypeList=new ArrayList<>();
        for (ParttimeTypeDto parttimeTypeDto :parttimeTypeDtos) {
            SrmParttimeType srmParttimeType = new SrmParttimeType();
            srmParttimeType.setId(parttimeTypeDto.getRowId());
            srmParttimeType.setCode(parttimeTypeDto.getCode());
            srmParttimeType.setName(parttimeTypeDto.getName());
            srmParttimeType.setIsValid(parttimeTypeDto.getIsValid());

            parttimeTypeList.add(srmParttimeType);
            Long RowId = srmParttimeType.getId();
        }
        super.saveOrUpdateBatch(parttimeTypeList);
        return RowId;
    }
    @Override
    public ParttimeTypeVo getDetailParttimeType(Long RowId) {
        return null;
    }

    @Override
    public IPage<ParttimeTypeVo> listParttimeType(ParttimeTypeDto parttimeTypeDto) {
        Page<ParttimeTypeVo> page = new Page<>(parttimeTypeDto.getPage(),parttimeTypeDto.getRows());
        IPage<ParttimeTypeVo> res= srmParttimeTypeMapper.listParttimeType(page,parttimeTypeDto);
        return res;
    }

    @Override
    public void deleteParttimeType(BaseDto baseDto) {
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

    @Override
    public List<CombVo> getParttimeType() {
        return srmParttimeTypeMapper.getParttimeType();
    }
}
