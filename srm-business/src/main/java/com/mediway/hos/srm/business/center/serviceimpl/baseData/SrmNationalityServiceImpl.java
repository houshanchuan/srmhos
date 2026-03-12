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

import com.mediway.hos.srm.business.center.model.dto.baseData.NationalityDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmNationality;
import com.mediway.hos.srm.business.center.model.vo.baseData.NationalityVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmNationalityService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmNationalityMapper;

/**
 * <p>
 * 国籍代码表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmNationalityServiceImpl extends BaseServiceImpl<SrmNationalityMapper, SrmNationality> implements SrmNationalityService {
    @Autowired
    private SrmNationalityService  srmNationalityService;
    @Autowired
    private SrmNationalityMapper srmNationalityMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateNationality(BaseDataUserDto baseDataUserDto) {
        List<NationalityDto> nationalityDtos =baseDataUserDto.getNationalitys();

        List<SrmNationality> nationalityList=new ArrayList<>();
        for (NationalityDto nationalityDto :nationalityDtos) {
            SrmNationality srmNationality = new SrmNationality();
            srmNationality.setId(nationalityDto.getRowId());
            if(ObjectUtil.isEmpty(nationalityDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_NASTIONLITY, 1, "");
                srmNationality.setCode(code);
            }else{
                srmNationality.setCode(nationalityDto.getCode());
            }
            srmNationality.setName(nationalityDto.getName());
            srmNationality.setIsValid(Integer.valueOf(nationalityDto.getIsValid()));

            nationalityList.add(srmNationality);
            Long RowId = srmNationality.getId();
        }
        super.saveOrUpdateBatch(nationalityList);
        return RowId;
    }
    @Override
    public NationalityVo getDetailNationality(Long RowId) {
        return null;
    }

    @Override
    public IPage<NationalityVo> listNationality(NationalityDto nationalityDto) {
        Page<NationalityVo> page = new Page<>(nationalityDto.getPage(), nationalityDto.getRows());
        IPage<NationalityVo> res= srmNationalityMapper.listNationality(page, nationalityDto);
        //List<NationalityVo> records=res.getRecords();
        //List<NationalityVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteNationality(BaseDto baseDto) {
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

    public List<CombVo> getNationality(NationalityDto nationalityDto){
        return srmNationalityMapper.getNationality(nationalityDto);
    }

}
