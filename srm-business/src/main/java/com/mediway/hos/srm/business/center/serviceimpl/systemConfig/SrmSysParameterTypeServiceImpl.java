package com.mediway.hos.srm.business.center.serviceimpl.systemConfig;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.systemConfig.SysParameterTypeDto;
import com.mediway.hos.srm.business.center.model.vo.systemConfig.SysParameterTypeVo;
import com.mediway.hos.srm.business.center.model.entity.systemConfig.SrmSysParameterType;
import com.mediway.hos.srm.business.center.service.systemConfig.SrmSysParameterTypeService;
import com.mediway.hos.srm.business.center.mapper.systemConfig.SrmSysParameterTypeMapper;

/**
 * <p>
 * 系统参数 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-13
 */
@Service
public class SrmSysParameterTypeServiceImpl extends BaseServiceImpl<SrmSysParameterTypeMapper, SrmSysParameterType> implements SrmSysParameterTypeService {

    @Autowired
    private SrmSysParameterTypeMapper srmSysParameterTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateSysParameterType(BaseDataCommonDto baseDataCommonDto) {
        List<SysParameterTypeDto> sysParameterTypeDtos =baseDataCommonDto.getSysParameterTypes();

        List<SrmSysParameterType> sysParameterTypeList=new ArrayList<>();
        for (SysParameterTypeDto sysParameterTypeDto :sysParameterTypeDtos) {
            SrmSysParameterType srmSysParameterType = new SrmSysParameterType();
            srmSysParameterType.setId(sysParameterTypeDto.getRowId());
            srmSysParameterType.setCode(sysParameterTypeDto.getCode());
            srmSysParameterType.setName(sysParameterTypeDto.getName());
            srmSysParameterType.setRemark(sysParameterTypeDto.getRemark());

            sysParameterTypeList.add(srmSysParameterType);
            Long RowId = srmSysParameterType.getId();
        }
        super.saveOrUpdateBatch(sysParameterTypeList);
        return RowId;
    }
    @Override
    public SysParameterTypeVo getDetailSysParameterType(Long RowId) {
        return null;
    }

    @Override
    public IPage<SysParameterTypeVo> listSysParameterType(SysParameterTypeDto sysParameterTypeDto) {
        Page<SysParameterTypeVo> page = new Page<>(sysParameterTypeDto.getPage(), sysParameterTypeDto.getRows());
        IPage<SysParameterTypeVo> res= srmSysParameterTypeMapper.listSysParameterType(page, sysParameterTypeDto);
        //List<SysParameterTypeVo> records=res.getRecords();
        //List<SysParameterTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteSysParameterType(BaseDto baseDto) {
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
