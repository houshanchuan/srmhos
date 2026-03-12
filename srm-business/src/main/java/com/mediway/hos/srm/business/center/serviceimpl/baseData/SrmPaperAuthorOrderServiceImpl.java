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
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.dto.baseData.PaperAuthorOrderDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPaperAuthorOrder;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmPaperAuthorOrderMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperAuthorOrderVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPaperAuthorOrderService;

import javax.annotation.Resource;


/**
 * <p>
 * 论文作者排序 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
@Service
public class SrmPaperAuthorOrderServiceImpl extends BaseServiceImpl<SrmPaperAuthorOrderMapper, SrmPaperAuthorOrder> implements SrmPaperAuthorOrderService {
    @Autowired
    private SrmPaperAuthorOrderMapper srmPaperAuthorOrderMapper;
    @Override
    public List<CombVo> getPaperAuthorOrder() {
        return srmPaperAuthorOrderMapper.getPaperAuthorOrder();
    }

    @Autowired
    private SrmPaperAuthorOrderService  srmPaperAuthorOrderService;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;

    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdatePaperAuthorOrder(BaseDataLearningDto baseDataLearningDto) {
        List<PaperAuthorOrderDto> paperAuthorOrderDtos =baseDataLearningDto.getPaperAuthorOrders();

        List<SrmPaperAuthorOrder> paperAuthorOrderList=new ArrayList<>();
        for (PaperAuthorOrderDto paperAuthorOrderDto :paperAuthorOrderDtos) {
            SrmPaperAuthorOrder srmPaperAuthorOrder = new SrmPaperAuthorOrder();
            srmPaperAuthorOrder.setId(paperAuthorOrderDto.getRowId());
            if(ObjectUtil.isEmpty(paperAuthorOrderDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PT_AUTHOR_ORDER, 2, "");
                srmPaperAuthorOrder.setCode(code);
            }else{
                srmPaperAuthorOrder.setCode(paperAuthorOrderDto.getCode());
            }
            srmPaperAuthorOrder.setName(paperAuthorOrderDto.getName());
            srmPaperAuthorOrder.setIsValid(Integer.valueOf(paperAuthorOrderDto.getIsValid()));

            paperAuthorOrderList.add(srmPaperAuthorOrder);
            Long RowId = srmPaperAuthorOrder.getId();
        }
        super.saveOrUpdateBatch(paperAuthorOrderList);
        return RowId;
    }
    @Override
    public PaperAuthorOrderVo getDetailPaperAuthorOrder(Long RowId) {
        return null;
    }

    @Override
    public IPage<PaperAuthorOrderVo> listPaperAuthorOrder(PaperAuthorOrderDto paperAuthorOrderDto) {
        Page<PaperAuthorOrderVo> page = new Page<>(paperAuthorOrderDto.getPage(), paperAuthorOrderDto.getRows());
        IPage<PaperAuthorOrderVo> res= srmPaperAuthorOrderMapper.listPaperAuthorOrder(page, paperAuthorOrderDto);
        //List<PaperAuthorOrderVo> records=res.getRecords();
        //List<PaperAuthorOrderVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePaperAuthorOrder(BaseDto baseDto) {
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
