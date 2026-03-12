package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
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

import com.mediway.hos.srm.business.center.model.dto.baseData.SocEconomicObjDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.SocEconomicObjVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmSocEconomicObj;
import com.mediway.hos.srm.business.center.service.baseData.SrmSocEconomicObjService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmSocEconomicObjMapper;


/**
 * <p>
 * 社会经济目标 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmSocEconomicObjServiceImpl extends BaseServiceImpl<SrmSocEconomicObjMapper, SrmSocEconomicObj> implements SrmSocEconomicObjService {

    @Autowired
    private SrmSocEconomicObjService  srmSocEconomicObjService;
    @Autowired
    private SrmSocEconomicObjMapper srmSocEconomicObjMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateSocEconomicObj(BaseDataProjDto baseDataProjDto) {
        List<SocEconomicObjDto> socEconomicObjDtos =baseDataProjDto.getSocEconomicObjs();

        List<SrmSocEconomicObj> socEconomicObjList=new ArrayList<>();
        for (SocEconomicObjDto socEconomicObjDto :socEconomicObjDtos) {
            SrmSocEconomicObj srmSocEconomicObj = new SrmSocEconomicObj();
            srmSocEconomicObj.setId(socEconomicObjDto.getRowId());
            srmSocEconomicObj.setCode(socEconomicObjDto.getCode());
            srmSocEconomicObj.setName(socEconomicObjDto.getName());
            srmSocEconomicObj.setIsValid(Integer.valueOf(socEconomicObjDto.getIsValid()));

            socEconomicObjList.add(srmSocEconomicObj);
            Long RowId = srmSocEconomicObj.getId();
        }
        super.saveOrUpdateBatch(socEconomicObjList);
        return RowId;
    }
    @Override
    public SocEconomicObjVo getDetailSocEconomicObj(Long RowId) {
        return null;
    }

    @Override
    public IPage<SocEconomicObjVo> listSocEconomicObj(SocEconomicObjDto socEconomicObjDto) {
        Page<SocEconomicObjVo> page = new Page<>(socEconomicObjDto.getPage(), socEconomicObjDto.getRows());
        IPage<SocEconomicObjVo> res= srmSocEconomicObjMapper.listSocEconomicObj(page, socEconomicObjDto);
        //List<SocEconomicObjVo> records=res.getRecords();
        //List<SocEconomicObjVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteSocEconomicObj(BaseDto baseDto) {
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
    public List<CombVo> getSocEconomicObj(SocEconomicObjDto socEconomicObjDto) {
        return srmSocEconomicObjMapper.getSocEconomicObj(socEconomicObjDto);
    }
}
