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

import com.mediway.hos.srm.business.center.model.dto.baseData.ImburseTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ImburseTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmImburseType;
import com.mediway.hos.srm.business.center.service.baseData.SrmImburseTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmImburseTypeMapper;
/**
 * <p>
 * 资助方式代码表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmImburseTypeServiceImpl extends BaseServiceImpl<SrmImburseTypeMapper, SrmImburseType> implements SrmImburseTypeService {

    @Autowired
    private SrmImburseTypeService  srmImburseTypeService;
    @Autowired
    private SrmImburseTypeMapper srmImburseTypeMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateImburseType(BaseDataProjDto baseDataProjDto) {
        List<ImburseTypeDto> imburseTypeDtos =baseDataProjDto.getImburseTypes();

        List<SrmImburseType> imburseTypeList=new ArrayList<>();
        for (ImburseTypeDto imburseTypeDto :imburseTypeDtos) {
            SrmImburseType srmImburseType = new SrmImburseType();
            srmImburseType.setId(imburseTypeDto.getRowId());
            if(ObjectUtil.isEmpty(imburseTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.IMBURE_TYPE, 1, "");
                srmImburseType.setCode(code);
            }else{
                srmImburseType.setCode(imburseTypeDto.getCode());
            }
            srmImburseType.setName(imburseTypeDto.getName());
            srmImburseType.setIsValid(Integer.valueOf(imburseTypeDto.getIsValid()));

            imburseTypeList.add(srmImburseType);
            Long RowId = srmImburseType.getId();
        }
        super.saveOrUpdateBatch(imburseTypeList);
        return RowId;
    }
    @Override
    public ImburseTypeVo getDetailImburseType(Long RowId) {
        return null;
    }

    @Override
    public IPage<ImburseTypeVo> listImburseType(ImburseTypeDto imburseTypeDto) {
        Page<ImburseTypeVo> page = new Page<>(imburseTypeDto.getPage(), imburseTypeDto.getRows());
        IPage<ImburseTypeVo> res= srmImburseTypeMapper.listImburseType(page, imburseTypeDto);
        //List<ImburseTypeVo> records=res.getRecords();
        //List<ImburseTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteImburseType(BaseDto baseDto) {
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
