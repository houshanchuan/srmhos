package com.mediway.hos.srm.business.center.serviceimpl.systemConfig;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import com.mediway.hos.srm.business.center.mapper.systemConfig.SrmSysParameterTypeMapper;
import com.mediway.hos.srm.business.center.model.entity.systemConfig.SrmSysParameterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.systemConfig.SysParameterDto;
import com.mediway.hos.srm.business.center.model.vo.systemConfig.SysParameterVo;
import com.mediway.hos.srm.business.center.model.entity.systemConfig.SrmSysParameter;
import com.mediway.hos.srm.business.center.service.systemConfig.SrmSysParameterService;
import com.mediway.hos.srm.business.center.mapper.systemConfig.SrmSysParameterMapper;


/**
 * <p>
 * 系统参数明细 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-13
 */
@Service
public class SrmSysParameterServiceImpl extends BaseServiceImpl<SrmSysParameterMapper, SrmSysParameter> implements SrmSysParameterService {

    @Autowired
    private SrmSysParameterMapper srmSysParameterMapper;
    @Autowired
    private SrmSysParameterTypeMapper srmSysParameterTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateSysParameter(BaseDataCommonDto baseDataCommonDto) {
        List<SysParameterDto> sysParameterDtos =baseDataCommonDto.getSysParameters();

        List<SrmSysParameter> sysParameterList=new ArrayList<>();
        for (SysParameterDto sysParameterDto :sysParameterDtos) {
            SrmSysParameter srmSysParameter = new SrmSysParameter();
            srmSysParameter.setId(sysParameterDto.getRowId());
            srmSysParameter.setCode(sysParameterDto.getCode());
            srmSysParameter.setName(sysParameterDto.getName());
            srmSysParameter.setParaType(sysParameterDto.getParaType());
            srmSysParameter.setParaDesc(sysParameterDto.getParaDesc());
            srmSysParameter.setParaValue(sysParameterDto.getParaValue());
            srmSysParameter.setParaExplain(sysParameterDto.getParaExplain());

            sysParameterList.add(srmSysParameter);
            Long RowId = srmSysParameter.getId();
        }
        super.saveOrUpdateBatch(sysParameterList);
        return RowId;
    }
    @Override
    public SysParameterVo getDetailSysParameter(Long RowId) {
        return null;
    }

    @Override
    public IPage<SysParameterVo> listSysParameter(SysParameterDto sysParameterDto) {
        Page<SysParameterVo> page = new Page<>(sysParameterDto.getPage(), sysParameterDto.getRows());
        String paraType= sysParameterDto.getParaType();
        IPage<SysParameterVo> res= srmSysParameterMapper.listSysParameter(page, paraType);
        //List<SysParameterVo> records=res.getRecords();
        //List<SysParameterVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteSysParameter(BaseDto baseDto) {
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
    public String getParamVaule(String typeCode,String code){
        String value="N";
        QueryWrapper<SrmSysParameterType> srmSysParameterTypeQueryWrapper=new QueryWrapper<>();
        srmSysParameterTypeQueryWrapper.eq("code",typeCode);
        SrmSysParameterType srmSysParameterType=srmSysParameterTypeMapper.selectOne(srmSysParameterTypeQueryWrapper);
        if(srmSysParameterType!=null){
            Long typeId=srmSysParameterType.getId();
            QueryWrapper<SrmSysParameter> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("code",code).eq("para_type",typeId);
            System.out.println("111");
            SrmSysParameter srmSysParameter=srmSysParameterMapper.selectOne(queryWrapper);
            if(srmSysParameter!=null){
                value=srmSysParameter.getParaValue();
            }
        }
        return value;
    }
}
