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
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.TitleTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmTitleType;
import com.mediway.hos.srm.business.center.model.vo.baseData.TitleTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmTitleTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmTitleTypeMapper;

/**
 * <p>
 * 职称类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmTitleTypeServiceImpl extends BaseServiceImpl<SrmTitleTypeMapper, SrmTitleType> implements SrmTitleTypeService {
    @Autowired
    private SrmTitleTypeService  srmTitleTypeService;
    @Autowired
    private SrmTitleTypeMapper srmTitleTypeMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateTitleType(BaseDataUserDto baseDataUserDto) {
        List<TitleTypeDto> titleTypeDtos =baseDataUserDto.getTitleTypes();

        List<SrmTitleType> titleTypeList=new ArrayList<>();
        for (TitleTypeDto titleTypeDto :titleTypeDtos) {
            SrmTitleType srmTitleType = new SrmTitleType();
            srmTitleType.setId(titleTypeDto.getRowId());
            if(ObjectUtil.isEmpty(titleTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_TITLE_TYPE, 2, "");
                srmTitleType.setCode(code);
            }else{
                srmTitleType.setCode(titleTypeDto.getCode());
            }
            srmTitleType.setName(titleTypeDto.getName());
            srmTitleType.setIsValid(titleTypeDto.getIsValid());

            titleTypeList.add(srmTitleType);
            Long RowId = srmTitleType.getId();
        }
        super.saveOrUpdateBatch(titleTypeList);
        return RowId;
    }
    @Override
    public TitleTypeVo getDetailTitleType(Long RowId) {
        return null;
    }

    @Override
    public IPage<TitleTypeVo> listTitleType(TitleTypeDto titleTypeDto) {
        Page<TitleTypeVo> page = new Page<>(titleTypeDto.getPage(),titleTypeDto.getRows());
        IPage<TitleTypeVo> res= srmTitleTypeMapper.listTitleType(page,titleTypeDto);
        //List<TitleTypeVo> records=res.getRecords();
        //List<TitleTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteTitleType(BaseDto baseDto) {
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
