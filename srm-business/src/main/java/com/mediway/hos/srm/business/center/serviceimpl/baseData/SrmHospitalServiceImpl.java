package com.mediway.hos.srm.business.center.serviceimpl.baseData;

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

import com.mediway.hos.srm.business.center.model.dto.baseData.HospitalDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.baseData.HospitalVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmHospital;
import com.mediway.hos.srm.business.center.service.baseData.SrmHospitalService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmHospitalMapper;

/**
 * <p>
 * 医疗机构(医院)表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-25
 */
@Service
public class SrmHospitalServiceImpl extends BaseServiceImpl<SrmHospitalMapper, SrmHospital> implements SrmHospitalService {
    @Autowired
    private SrmHospitalMapper srmHospitalMapper;

    private Long RowId;

    @Override
    @Transactional
    public Long saveOrUpdateSrmHospital(BaseDataCommonDto baseDataCommonDto) {
        List<HospitalDto> hospitalDtos =baseDataCommonDto.getSrmHospitals();
        List<SrmHospital> srmHospitalList=new ArrayList<>();
        for (HospitalDto hospitalDto :hospitalDtos) {
            SrmHospital srmHospital = new SrmHospital();
            srmHospital.setId(hospitalDto.getRowId());
            srmHospital.setCode(hospitalDto.getCode());
            srmHospital.setName(hospitalDto.getName());
            srmHospital.setIsValid(hospitalDto.getIsValid());

            srmHospitalList.add(srmHospital);
            Long RowId = srmHospital.getId();
        }
        super.saveOrUpdateBatch(srmHospitalList);
        return RowId;
    }
    @Override
    public HospitalVo getDetailSrmHospital(Long RowId) {
        return null;
    }

    @Override
    public IPage<HospitalVo> listSrmHospital(HospitalDto srmHospitalDto) {
        Page<HospitalVo> page = new Page<>(srmHospitalDto.getPage(),srmHospitalDto.getRows());
        IPage<HospitalVo> res= srmHospitalMapper.listSrmHospital(page,srmHospitalDto);
        return res;
    }

    @Override
    public void deleteSrmHospital(BaseDto baseDto) {
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

    @Override
    public List<CombVo> getHospital() {
        return srmHospitalMapper.getHospital();
    }

}
