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

import com.mediway.hos.srm.business.center.model.dto.baseData.UnitOrderDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.UnitOrderVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmUnitOrder;
import com.mediway.hos.srm.business.center.service.baseData.SrmUnitOrderService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmUnitOrderMapper;

/**
 * <p>
 * 单位排序 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmUnitOrderServiceImpl extends BaseServiceImpl<SrmUnitOrderMapper, SrmUnitOrder> implements SrmUnitOrderService {
    @Autowired
    private SrmUnitOrderMapper srmUnitOrderMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    @Override
    public List<CombVo> getUnitOrder() {
        return srmUnitOrderMapper.getUnitOrder();
    }

    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateUnitOrder(BaseDataProjDto baseDataProjDto) {
        List<UnitOrderDto> unitOrderDtos =baseDataProjDto.getUnitOrders();

        List<SrmUnitOrder> unitOrderList=new ArrayList<>();
        for (UnitOrderDto unitOrderDto :unitOrderDtos) {
            SrmUnitOrder srmUnitOrder = new SrmUnitOrder();
            srmUnitOrder.setId(unitOrderDto.getRowId());
            if(ObjectUtil.isEmpty(unitOrderDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.UNIT_ORDER, 1, "");
                srmUnitOrder.setCode(code);
            }else{
                srmUnitOrder.setCode(unitOrderDto.getCode());
            }
            srmUnitOrder.setName(unitOrderDto.getName());
            srmUnitOrder.setIsValid(Integer.valueOf(unitOrderDto.getIsValid()));

            unitOrderList.add(srmUnitOrder);
            Long RowId = srmUnitOrder.getId();
        }
        super.saveOrUpdateBatch(unitOrderList);
        return RowId;
    }
    @Override
    public UnitOrderVo getDetailUnitOrder(Long RowId) {
        return null;
    }

    @Override
    public IPage<UnitOrderVo> listUnitOrder(UnitOrderDto unitOrderDto) {
        Page<UnitOrderVo> page = new Page<>(unitOrderDto.getPage(), unitOrderDto.getRows());
        IPage<UnitOrderVo> res= srmUnitOrderMapper.listUnitOrder(page, unitOrderDto);
        //List<UnitOrderVo> records=res.getRecords();
        //List<UnitOrderVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteUnitOrder(BaseDto baseDto) {
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
