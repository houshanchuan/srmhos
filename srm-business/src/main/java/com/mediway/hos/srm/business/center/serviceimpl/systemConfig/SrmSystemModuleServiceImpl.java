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
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.systemConfig.SystemModuleDto;
import com.mediway.hos.srm.business.center.model.vo.systemConfig.SystemModuleVo;
import com.mediway.hos.srm.business.center.model.entity.systemConfig.SrmSystemModule;
import com.mediway.hos.srm.business.center.service.systemConfig.SrmSystemModuleService;
import com.mediway.hos.srm.business.center.mapper.systemConfig.SrmSystemModuleMapper;


/**
 * <p>
 * 系统模块表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-22
 */
@Service
public class SrmSystemModuleServiceImpl extends BaseServiceImpl<SrmSystemModuleMapper, SrmSystemModule> implements SrmSystemModuleService {

    @Autowired
    private SrmSystemModuleMapper srmSystemModuleMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateSystemModule(BaseDataCommonDto baseDataCommonDto) {
        List<SystemModuleDto> systemModuleDtos =baseDataCommonDto.getSystemModules();

        List<SrmSystemModule> systemModuleList=new ArrayList<>();
        for (SystemModuleDto systemModuleDto :systemModuleDtos) {
            SrmSystemModule srmSystemModule = new SrmSystemModule();
            srmSystemModule.setId(systemModuleDto.getRowId());
            srmSystemModule.setCode(systemModuleDto.getCode());
            srmSystemModule.setName(systemModuleDto.getName());
            srmSystemModule.setIsValid(Integer.valueOf(systemModuleDto.getIsValid()));

            systemModuleList.add(srmSystemModule);
            Long RowId = srmSystemModule.getId();
        }
        super.saveOrUpdateBatch(systemModuleList);
        return RowId;
    }
    @Override
    public SystemModuleVo getDetailSystemModule(Long RowId) {
        return null;
    }

    @Override
    public IPage<SystemModuleVo> listSystemModule(SystemModuleDto systemModuleDto) {
        Page<SystemModuleVo> page = new Page<>(systemModuleDto.getPage(), systemModuleDto.getRows());
        IPage<SystemModuleVo> res= srmSystemModuleMapper.listSystemModule(page, systemModuleDto);
        //List<SystemModuleVo> records=res.getRecords();
        //List<SystemModuleVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteSystemModule(BaseDto baseDto) {
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
    public List<CombVo> getSystemModule(){
        return srmSystemModuleMapper.getSystemModule();

    }

}
