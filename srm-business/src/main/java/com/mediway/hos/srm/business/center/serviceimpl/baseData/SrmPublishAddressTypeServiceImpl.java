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

import com.mediway.hos.srm.business.center.model.dto.baseData.PublishAddressTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPublishAddressType;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmPublishAddressTypeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.PublishAddressTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPublishAddressTypeService;

import javax.annotation.Resource;

/**
 * <p>
 * 发表地点类型表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPublishAddressTypeServiceImpl extends BaseServiceImpl<SrmPublishAddressTypeMapper, SrmPublishAddressType> implements SrmPublishAddressTypeService {
    @Autowired
    private SrmPublishAddressTypeService  srmPublishAddressTypeService;
    @Autowired
    private SrmPublishAddressTypeMapper srmPublishAddressTypeMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdatePublishAddressType(BaseDataLearningDto baseDataLearningDto) {
        List<PublishAddressTypeDto> publishAddressTypeDtos =baseDataLearningDto.getPublishAddressTypes();

        List<SrmPublishAddressType> publishAddressTypeList=new ArrayList<>();
        for (PublishAddressTypeDto publishAddressTypeDto :publishAddressTypeDtos) {
            SrmPublishAddressType srmPublishAddressType = new SrmPublishAddressType();
            srmPublishAddressType.setId(publishAddressTypeDto.getRowId());
            if(ObjectUtil.isEmpty(publishAddressTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PT_PUBLISH_ADDRESS_TYPE, 1, "");
                srmPublishAddressType.setCode(code);
            }else{
                srmPublishAddressType.setCode(publishAddressTypeDto.getCode());
            }
            srmPublishAddressType.setName(publishAddressTypeDto.getName());
            srmPublishAddressType.setIsValid(Integer.valueOf(publishAddressTypeDto.getIsValid()));

            publishAddressTypeList.add(srmPublishAddressType);
            Long RowId = srmPublishAddressType.getId();
        }
        super.saveOrUpdateBatch(publishAddressTypeList);
        return RowId;
    }
    @Override
    public PublishAddressTypeVo getDetailPublishAddressType(Long RowId) {
        return null;
    }

    @Override
    public IPage<PublishAddressTypeVo> listPublishAddressType(PublishAddressTypeDto publishAddressTypeDto) {
        Page<PublishAddressTypeVo> page = new Page<>(publishAddressTypeDto.getPage(), publishAddressTypeDto.getRows());
        IPage<PublishAddressTypeVo> res= srmPublishAddressTypeMapper.listPublishAddressType(page, publishAddressTypeDto);
        //List<PublishAddressTypeVo> records=res.getRecords();
        //List<PublishAddressTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePublishAddressType(BaseDto baseDto) {
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
