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
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.RelyUnitDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmRelyUnit;
import com.mediway.hos.srm.business.center.model.vo.baseData.RelyUnitVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmRelyUnitService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmRelyUnitMapper;

/**
 * <p>
 * 单位表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmRelyUnitServiceImpl extends BaseServiceImpl<SrmRelyUnitMapper, SrmRelyUnit> implements SrmRelyUnitService {

    @Autowired
    private SrmRelyUnitService  srmRelyUnitService;
    @Autowired
    private SrmRelyUnitMapper srmRelyUnitMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
	public List<CombVo> getRelyUnit(RelyUnitDto relyUnitDto) {
        return srmRelyUnitMapper.getRelyUnit(relyUnitDto);
	}
    @Override
    @Transactional
    public Long saveOrUpdateRelyUnit(BaseDataUserDto baseDataUserDto) {
        List<RelyUnitDto> relyUnitDtos =baseDataUserDto.getRelyUnits();

        List<SrmRelyUnit> relyUnitList=new ArrayList<>();
        for (RelyUnitDto relyUnitDto :relyUnitDtos) {
            SrmRelyUnit srmRelyUnit = new SrmRelyUnit();
            srmRelyUnit.setId(relyUnitDto.getRowId());
            if(ObjectUtil.isEmpty(relyUnitDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_RELY_UNIT, 1, "");
                srmRelyUnit.setCode(code);
            }else{
                srmRelyUnit.setCode(relyUnitDto.getCode());
            }
            srmRelyUnit.setName(relyUnitDto.getName());
            srmRelyUnit.setIsValid(relyUnitDto.getIsValid());
            srmRelyUnit.setUnitType(relyUnitDto.getUnitType());
            srmRelyUnit.setAlias(relyUnitDto.getAlias());
            srmRelyUnit.setAbbreviation(relyUnitDto.getAbbreviation());
            srmRelyUnit.setIsDefault(relyUnitDto.getIsDefault());
            srmRelyUnit.setIsPatentAgency(relyUnitDto.getIsPatentAgency());
            relyUnitList.add(srmRelyUnit);
            Long RowId = srmRelyUnit.getId();
        }
        super.saveOrUpdateBatch(relyUnitList);
        return RowId;
    }
    @Override
    public RelyUnitVo getDetailRelyUnit(Long RowId) {
        return null;
    }

    @Override
    public IPage<RelyUnitVo> listRelyUnit(RelyUnitDto relyUnitDto) {
        Page<RelyUnitVo> page = new Page<>(relyUnitDto.getPage(), relyUnitDto.getRows());
        IPage<RelyUnitVo> res= srmRelyUnitMapper.listRelyUnit(page, relyUnitDto);
        //List<RelyUnitVo> records=res.getRecords();
        //List<RelyUnitVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteRelyUnit(BaseDto baseDto) {
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
