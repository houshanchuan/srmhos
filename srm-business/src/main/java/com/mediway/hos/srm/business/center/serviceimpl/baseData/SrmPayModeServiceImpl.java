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

import com.mediway.hos.srm.business.center.model.dto.baseData.PayModeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PayModeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPayMode;
import com.mediway.hos.srm.business.center.service.baseData.SrmPayModeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmPayModeMapper;
/**
 * <p>
 * 支付方式 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPayModeServiceImpl extends BaseServiceImpl<SrmPayModeMapper, SrmPayMode> implements SrmPayModeService {

    @Autowired
    private SrmPayModeService  srmPayModeService;
    @Autowired
    private SrmPayModeMapper srmPayModeMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdatePayMode(BaseDataProjDto baseDataProjDto) {
        List<PayModeDto> payModeDtos =baseDataProjDto.getPayModes();

        List<SrmPayMode> payModeList=new ArrayList<>();
        for (PayModeDto payModeDto :payModeDtos) {
            SrmPayMode srmPayMode = new SrmPayMode();
            srmPayMode.setId(payModeDto.getRowId());
            if(ObjectUtil.isEmpty(payModeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PAY_MODEL, 1, "");
                srmPayMode.setCode(code);
            }else{
                srmPayMode.setCode(payModeDto.getCode());
            }
            srmPayMode.setName(payModeDto.getName());
            srmPayMode.setIsValid(Integer.valueOf(payModeDto.getIsValid()));

            payModeList.add(srmPayMode);
            Long RowId = srmPayMode.getId();
        }
        super.saveOrUpdateBatch(payModeList);
        return RowId;
    }
    @Override
    public PayModeVo getDetailPayMode(Long RowId) {
        return null;
    }

    @Override
    public IPage<PayModeVo> listPayMode(PayModeDto payModeDto) {
        Page<PayModeVo> page = new Page<>(payModeDto.getPage(), payModeDto.getRows());
        IPage<PayModeVo> res= srmPayModeMapper.listPayMode(page, payModeDto);
        //List<PayModeVo> records=res.getRecords();
        //List<PayModeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePayMode(BaseDto baseDto) {
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
