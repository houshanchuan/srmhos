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


import com.mediway.hos.srm.business.center.model.dto.baseData.HonoraryTitleTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmHonoraryTitleType;
import com.mediway.hos.srm.business.center.model.vo.baseData.HonoraryTitleTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmHonoraryTitleTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmHonoraryTitleTypeMapper;

import javax.annotation.Resource;


/**
 * <p>
 * 荣誉称号 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmHonoraryTitleTypeServiceImpl extends BaseServiceImpl<SrmHonoraryTitleTypeMapper, SrmHonoraryTitleType> implements SrmHonoraryTitleTypeService {

    @Autowired
    private SrmHonoraryTitleTypeService  srmHonoraryTitleTypeService;
    @Autowired
    private SrmHonoraryTitleTypeMapper srmHonoraryTitleTypeMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateHonoraryTitleType(BaseDataUserDto baseDataUserDto) {
        List<HonoraryTitleTypeDto> honoraryTitleTypeDtos =baseDataUserDto.getHonoraryTitleTypes();

        List<SrmHonoraryTitleType> honoraryTitleTypeList=new ArrayList<>();
        for (HonoraryTitleTypeDto honoraryTitleTypeDto :honoraryTitleTypeDtos) {
            SrmHonoraryTitleType srmHonoraryTitleType = new SrmHonoraryTitleType();
            srmHonoraryTitleType.setId(honoraryTitleTypeDto.getRowId());
            if(ObjectUtil.isEmpty(honoraryTitleTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_HONOR_TITLE_TYPE, 1, "");
                srmHonoraryTitleType.setCode(code);
            }else{
                srmHonoraryTitleType.setCode(honoraryTitleTypeDto.getCode());
            }
            srmHonoraryTitleType.setName(honoraryTitleTypeDto.getName());
            srmHonoraryTitleType.setIsValid(Integer.valueOf(honoraryTitleTypeDto.getIsValid()));

            honoraryTitleTypeList.add(srmHonoraryTitleType);
            Long RowId = srmHonoraryTitleType.getId();
        }
        super.saveOrUpdateBatch(honoraryTitleTypeList);
        return RowId;
    }
    @Override
    public HonoraryTitleTypeVo getDetailHonoraryTitleType(Long RowId) {
        return null;
    }

    @Override
    public IPage<HonoraryTitleTypeVo> listHonoraryTitleType(HonoraryTitleTypeDto honoraryTitleTypeDto) {
        Page<HonoraryTitleTypeVo> page = new Page<>(honoraryTitleTypeDto.getPage(), honoraryTitleTypeDto.getRows());
        IPage<HonoraryTitleTypeVo> res= srmHonoraryTitleTypeMapper.listHonoraryTitleType(page, honoraryTitleTypeDto);
        //List<HonoraryTitleTypeVo> records=res.getRecords();
        //List<HonoraryTitleTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteHonoraryTitleType(BaseDto baseDto) {
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
