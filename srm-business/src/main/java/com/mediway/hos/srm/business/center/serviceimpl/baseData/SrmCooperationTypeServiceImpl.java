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

import com.mediway.hos.srm.business.center.model.dto.baseData.CooperationTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CooperationTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmCooperationType;
import com.mediway.hos.srm.business.center.service.baseData.SrmCooperationTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmCooperationTypeMapper;

/**
 * <p>
 * 合作类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmCooperationTypeServiceImpl extends BaseServiceImpl<SrmCooperationTypeMapper, SrmCooperationType> implements SrmCooperationTypeService {

    @Autowired
    private SrmCooperationTypeMapper srmCooperationTypeMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateCooperationType(BaseDataProjDto baseDataProjDto) {
        List<CooperationTypeDto> cooperationTypeDtos =baseDataProjDto.getCooperationTypes();

        List<SrmCooperationType> cooperationTypeList=new ArrayList<>();
        for (CooperationTypeDto cooperationTypeDto :cooperationTypeDtos) {
            SrmCooperationType srmCooperationType = new SrmCooperationType();
            srmCooperationType.setId(cooperationTypeDto.getRowId());
            if(ObjectUtil.isEmpty(cooperationTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.COOP_TYPE, 1, "");
                srmCooperationType.setCode(code);
            }else{
                srmCooperationType.setCode(cooperationTypeDto.getCode());
            }
            srmCooperationType.setName(cooperationTypeDto.getName());
            srmCooperationType.setIsValid(cooperationTypeDto.getIsValid());

            cooperationTypeList.add(srmCooperationType);
            Long RowId = srmCooperationType.getId();
        }
        super.saveOrUpdateBatch(cooperationTypeList);
        return RowId;
    }
    @Override
    public CooperationTypeVo getDetailCooperationType(Long RowId) {
        return null;
    }

    @Override
    public IPage<CooperationTypeVo> listCooperationType(CooperationTypeDto cooperationTypeDto) {
        Page<CooperationTypeVo> page = new Page<>(cooperationTypeDto.getPage(),cooperationTypeDto.getRows());
        IPage<CooperationTypeVo> res= srmCooperationTypeMapper.listCooperationType(page,cooperationTypeDto);
        return res;
    }

    @Override
    public void deleteCooperationType(BaseDto baseDto) {
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
