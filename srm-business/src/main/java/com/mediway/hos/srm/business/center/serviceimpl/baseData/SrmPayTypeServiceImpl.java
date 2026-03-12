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
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.PayTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PayTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPayType;
import com.mediway.hos.srm.business.center.service.baseData.SrmPayTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmPayTypeMapper;
/**
 * <p>
 * 付款类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPayTypeServiceImpl extends BaseServiceImpl<SrmPayTypeMapper, SrmPayType> implements SrmPayTypeService {

    @Autowired
    private SrmPayTypeService  srmPayTypeService;
    @Autowired
    private SrmPayTypeMapper srmPayTypeMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdatePayType(BaseDataProjDto baseDataProjDto) {
        List<PayTypeDto> payTypeDtos =baseDataProjDto.getPayTypes();

        List<SrmPayType> payTypeList=new ArrayList<>();
        for (PayTypeDto payTypeDto :payTypeDtos) {
            SrmPayType srmPayType = new SrmPayType();
            srmPayType.setId(payTypeDto.getRowId());
            if(ObjectUtil.isEmpty(payTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PAY_TYPE, 1, "");
                srmPayType.setCode(code);
            }else{
                srmPayType.setCode(payTypeDto.getCode());
            }
            srmPayType.setName(payTypeDto.getName());
            srmPayType.setIsValid(Integer.valueOf(payTypeDto.getIsValid()));

            payTypeList.add(srmPayType);
            Long RowId = srmPayType.getId();
        }
        super.saveOrUpdateBatch(payTypeList);
        return RowId;
    }
    @Override
    public PayTypeVo getDetailPayType(Long RowId) {
        return null;
    }

    @Override
    public IPage<PayTypeVo> listPayType(PayTypeDto payTypeDto) {
        Page<PayTypeVo> page = new Page<>(payTypeDto.getPage(), payTypeDto.getRows());
        IPage<PayTypeVo> res= srmPayTypeMapper.listPayType(page, payTypeDto);
        //List<PayTypeVo> records=res.getRecords();
        //List<PayTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePayType(BaseDto baseDto) {
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
    public List<CombVo> getPayType() {
        return srmPayTypeMapper.getPayType();
    }
}
