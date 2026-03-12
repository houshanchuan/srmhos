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

import com.mediway.hos.srm.business.center.model.dto.baseData.PubRangeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPubRange;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmPubRangeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.PubRangeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPubRangeService;

import javax.annotation.Resource;

/**
 * <p>
 * 发表范围 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPubRangeServiceImpl extends BaseServiceImpl<SrmPubRangeMapper, SrmPubRange> implements SrmPubRangeService {
    @Autowired
    private SrmPubRangeService  srmPubRangeService;
    @Autowired
    private SrmPubRangeMapper srmPubRangeMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdatePubRange(BaseDataLearningDto baseDataLearningDto) {
        List<PubRangeDto> pubRangeDtos =baseDataLearningDto.getPubRanges();

        List<SrmPubRange> pubRangeList=new ArrayList<>();
        for (PubRangeDto pubRangeDto :pubRangeDtos) {
            SrmPubRange srmPubRange = new SrmPubRange();
            srmPubRange.setId(pubRangeDto.getRowId());
            if(ObjectUtil.isEmpty(pubRangeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PT_PUB_RANGE, 1, "");
                srmPubRange.setCode(code);
            }else{
                srmPubRange.setCode(pubRangeDto.getCode());
            }
            srmPubRange.setName(pubRangeDto.getName());
            srmPubRange.setIsValid(Integer.valueOf(pubRangeDto.getIsValid()));

            pubRangeList.add(srmPubRange);
            Long RowId = srmPubRange.getId();
        }
        super.saveOrUpdateBatch(pubRangeList);
        return RowId;
    }
    @Override
    public PubRangeVo getDetailPubRange(Long RowId) {
        return null;
    }

    @Override
    public IPage<PubRangeVo> listPubRange(PubRangeDto pubRangeDto) {
        Page<PubRangeVo> page = new Page<>(pubRangeDto.getPage(), pubRangeDto.getRows());
        IPage<PubRangeVo> res= srmPubRangeMapper.listPubRange(page, pubRangeDto);
        //List<PubRangeVo> records=res.getRecords();
        //List<PubRangeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePubRange(BaseDto baseDto) {
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
