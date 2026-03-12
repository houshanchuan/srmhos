package com.mediway.hos.srm.business.center.serviceimpl.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
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

import com.mediway.hos.srm.business.center.model.dto.baseData.PressInfoDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPressInfo;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmPressInfoMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.PressInfoVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPressInfoService;

/**
 * <p>
 * 出版社信息 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
@Service
public class SrmPressInfoServiceImpl extends BaseServiceImpl<SrmPressInfoMapper, SrmPressInfo> implements SrmPressInfoService {
    @Autowired
    private SrmPressInfoService  srmPressInfoService;
    @Autowired
    private SrmPressInfoMapper srmPressInfoMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdatePressInfo(BaseDataLearningDto baseDataLearningDto) {
        List<PressInfoDto> pressInfoDtos =baseDataLearningDto.getPressInfos();

        List<SrmPressInfo> pressInfoList=new ArrayList<>();
        for (PressInfoDto pressInfoDto :pressInfoDtos) {
            SrmPressInfo srmPressInfo = new SrmPressInfo();
            srmPressInfo.setId(pressInfoDto.getRowId());
            srmPressInfo.setCode(pressInfoDto.getCode());
            srmPressInfo.setName(pressInfoDto.getName());
            srmPressInfo.setIsValid(pressInfoDto.getIsValid());
            srmPressInfo.setAddress(pressInfoDto.getAddress());
            srmPressInfo.setLevel(pressInfoDto.getLevel());


            pressInfoList.add(srmPressInfo);
            Long RowId = srmPressInfo.getId();
        }
        super.saveOrUpdateBatch(pressInfoList);
        return RowId;
    }
    @Override
    public PressInfoVo getDetailPressInfo(Long RowId) {
        return null;
    }

    @Override
    public IPage<PressInfoVo> listPressInfo(PressInfoDto pressInfoDto) {
        Page<PressInfoVo> page = new Page<>(pressInfoDto.getPage(), pressInfoDto.getRows());
        IPage<PressInfoVo> res= srmPressInfoMapper.listPressInfo(page, pressInfoDto);
        //List<PressInfoVo> records=res.getRecords();
        //List<PressInfoVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePressInfo(BaseDto baseDto) {
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
    public List<CombVo> getPressInfo() {
        return srmPressInfoMapper.getPressInfo();
    }
}
