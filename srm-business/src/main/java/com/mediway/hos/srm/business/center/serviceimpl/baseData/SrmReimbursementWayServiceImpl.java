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

import com.mediway.hos.srm.business.center.model.dto.baseData.ReimbursementWayDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmReimbursementWay;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmReimbursementWayMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.ReimbursementWayVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmReimbursementWayService;

import javax.annotation.Resource;


/**
 * <p>
 * 报销途径 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmReimbursementWayServiceImpl extends BaseServiceImpl<SrmReimbursementWayMapper, SrmReimbursementWay> implements SrmReimbursementWayService {
    @Autowired
    private SrmReimbursementWayMapper srmReimbursementWayMapper;
    @Override
    public List<CombVo> getReimbursementWay() {
        return srmReimbursementWayMapper.getReimbursementWay();
    }

    @Autowired
    private SrmReimbursementWayService  srmReimbursementWayService;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateReimbursementWay(BaseDataLearningDto baseDataLearningDto) {
        List<ReimbursementWayDto> reimbursementWayDtos =baseDataLearningDto.getReimbursementWays();

        List<SrmReimbursementWay> reimbursementWayList=new ArrayList<>();
        for (ReimbursementWayDto reimbursementWayDto :reimbursementWayDtos) {
            SrmReimbursementWay srmReimbursementWay = new SrmReimbursementWay();
            srmReimbursementWay.setId(reimbursementWayDto.getRowId());
            if(ObjectUtil.isEmpty(reimbursementWayDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PT_REIMBURSEMENT_WAY, 1, "");
                srmReimbursementWay.setCode(code);
            }else{
                srmReimbursementWay.setCode(reimbursementWayDto.getCode());
            }
            srmReimbursementWay.setName(reimbursementWayDto.getName());
            srmReimbursementWay.setIsValid(Integer.valueOf(reimbursementWayDto.getIsValid()));

            reimbursementWayList.add(srmReimbursementWay);
            Long RowId = srmReimbursementWay.getId();
        }
        super.saveOrUpdateBatch(reimbursementWayList);
        return RowId;
    }
    @Override
    public ReimbursementWayVo getDetailReimbursementWay(Long RowId) {
        return null;
    }

    @Override
    public IPage<ReimbursementWayVo> listReimbursementWay(ReimbursementWayDto reimbursementWayDto) {
        Page<ReimbursementWayVo> page = new Page<>(reimbursementWayDto.getPage(), reimbursementWayDto.getRows());
        IPage<ReimbursementWayVo> res= srmReimbursementWayMapper.listReimbursementWay(page, reimbursementWayDto);
        //List<ReimbursementWayVo> records=res.getRecords();
        //List<ReimbursementWayVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteReimbursementWay(BaseDto baseDto) {
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
