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

import com.mediway.hos.srm.business.center.model.dto.baseData.SecretTierDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.SecretTierVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmSecretTier;
import com.mediway.hos.srm.business.center.service.baseData.SrmSecretTierService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmSecretTierMapper;

/**
 * <p>
 * 涉密级别 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmSecretTierServiceImpl extends BaseServiceImpl<SrmSecretTierMapper, SrmSecretTier> implements SrmSecretTierService {

    @Autowired
    private SrmSecretTierService  srmSecretTierService;
    @Autowired
    private SrmSecretTierMapper srmSecretTierMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateSecretTier(BaseDataCommonDto baseDataProjDto) {
        List<SecretTierDto> secretTierDtos =baseDataProjDto.getSecretTiers();

        List<SrmSecretTier> secretTierList=new ArrayList<>();
        for (SecretTierDto secretTierDto :secretTierDtos) {
            SrmSecretTier srmSecretTier = new SrmSecretTier();
            srmSecretTier.setId(secretTierDto.getRowId());
            srmSecretTier.setCode(secretTierDto.getCode());
            srmSecretTier.setName(secretTierDto.getName());
            srmSecretTier.setIsValid(Integer.valueOf(secretTierDto.getIsValid()));

            secretTierList.add(srmSecretTier);
            Long RowId = srmSecretTier.getId();
        }
        super.saveOrUpdateBatch(secretTierList);
        return RowId;
    }
    @Override
    public SecretTierVo getDetailSecretTier(Long RowId) {
        return null;
    }

    @Override
    public IPage<SecretTierVo> listSecretTier(SecretTierDto secretTierDto) {
        Page<SecretTierVo> page = new Page<>(secretTierDto.getPage(), secretTierDto.getRows());
        IPage<SecretTierVo> res= srmSecretTierMapper.listSecretTier(page, secretTierDto);
        //List<SecretTierVo> records=res.getRecords();
        //List<SecretTierVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteSecretTier(BaseDto baseDto) {
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
