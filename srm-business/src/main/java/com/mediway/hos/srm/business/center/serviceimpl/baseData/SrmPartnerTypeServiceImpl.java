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
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.PartnerTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PartnerTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPartnerType;
import com.mediway.hos.srm.business.center.service.baseData.SrmPartnerTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmPartnerTypeMapper;

/**
 * <p>
 * 对方类型表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPartnerTypeServiceImpl extends BaseServiceImpl<SrmPartnerTypeMapper, SrmPartnerType> implements SrmPartnerTypeService {

    @Autowired
    private SrmPartnerTypeService  srmPartnerTypeService;
    @Autowired
    private SrmPartnerTypeMapper srmPartnerTypeMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdatePartnerType(BaseDataProjDto baseDataProjDto) {
        List<PartnerTypeDto> partnerTypeDtos =baseDataProjDto.getPartnerTypes();

        List<SrmPartnerType> partnerTypeList=new ArrayList<>();
        for (PartnerTypeDto partnerTypeDto :partnerTypeDtos) {
            SrmPartnerType srmPartnerType = new SrmPartnerType();
            srmPartnerType.setId(partnerTypeDto.getRowId());
            if(ObjectUtil.isEmpty(partnerTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PRJ_PARTNER_TYPE, 2, "");
                srmPartnerType.setCode(code);
            }else{
                srmPartnerType.setCode(partnerTypeDto.getCode());
            }
            srmPartnerType.setName(partnerTypeDto.getName());
            srmPartnerType.setIsValid(Integer.valueOf(partnerTypeDto.getIsValid()));

            partnerTypeList.add(srmPartnerType);
            Long RowId = srmPartnerType.getId();
        }
        super.saveOrUpdateBatch(partnerTypeList);
        return RowId;
    }
    @Override
    public PartnerTypeVo getDetailPartnerType(Long RowId) {
        return null;
    }

    @Override
    public IPage<PartnerTypeVo> listPartnerType(PartnerTypeDto partnerTypeDto) {
        Page<PartnerTypeVo> page = new Page<>(partnerTypeDto.getPage(), partnerTypeDto.getRows());
        IPage<PartnerTypeVo> res= srmPartnerTypeMapper.listPartnerType(page, partnerTypeDto);
        //List<PartnerTypeVo> records=res.getRecords();
        //List<PartnerTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePartnerType(BaseDto baseDto) {
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

    @Override
    public List<CombVo> getPartnerType() {
        return srmPartnerTypeMapper.getPartnerType();
    }
}
