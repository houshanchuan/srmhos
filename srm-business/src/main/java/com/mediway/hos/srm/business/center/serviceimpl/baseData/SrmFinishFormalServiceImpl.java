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

import com.mediway.hos.srm.business.center.model.dto.baseData.FinishFormalDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.FinishFormalVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmFinishFormal;
import com.mediway.hos.srm.business.center.service.baseData.SrmFinishFormalService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmFinishFormalMapper;

/**
 * <p>
 * 完成形式代码 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmFinishFormalServiceImpl extends BaseServiceImpl<SrmFinishFormalMapper, SrmFinishFormal> implements SrmFinishFormalService {

    @Autowired
    private SrmFinishFormalService  srmFinishFormalService;
    @Autowired
    private SrmFinishFormalMapper srmFinishFormalMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFinishFormal(BaseDataProjDto baseDataProjDto) {
        List<FinishFormalDto> finishFormalDtos =baseDataProjDto.getFinishFormals();

        List<SrmFinishFormal> finishFormalList=new ArrayList<>();
        for (FinishFormalDto finishFormalDto :finishFormalDtos) {
            SrmFinishFormal srmFinishFormal = new SrmFinishFormal();
            srmFinishFormal.setId(finishFormalDto.getRowId());
            if(ObjectUtil.isEmpty(finishFormalDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.FINISH_TYPE, 1, "");
                srmFinishFormal.setCode(code);
            }else{
                srmFinishFormal.setCode(finishFormalDto.getCode());
            }
            srmFinishFormal.setName(finishFormalDto.getName());
            srmFinishFormal.setIsValid(Integer.valueOf(finishFormalDto.getIsValid()));

            finishFormalList.add(srmFinishFormal);
            Long RowId = srmFinishFormal.getId();
        }
        super.saveOrUpdateBatch(finishFormalList);
        return RowId;
    }
    @Override
    public FinishFormalVo getDetailFinishFormal(Long RowId) {
        return null;
    }

    @Override
    public IPage<FinishFormalVo> listFinishFormal(FinishFormalDto finishFormalDto) {
        Page<FinishFormalVo> page = new Page<>(finishFormalDto.getPage(), finishFormalDto.getRows());
        IPage<FinishFormalVo> res= srmFinishFormalMapper.listFinishFormal(page, finishFormalDto);
        //List<FinishFormalVo> records=res.getRecords();
        //List<FinishFormalVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFinishFormal(BaseDto baseDto) {
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
