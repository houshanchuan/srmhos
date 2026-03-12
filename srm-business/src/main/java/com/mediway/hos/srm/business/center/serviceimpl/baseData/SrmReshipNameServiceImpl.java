package com.mediway.hos.srm.business.center.serviceimpl.baseData;


import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import com.mediway.hos.srm.business.center.constants.BusinessConstants;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmBusinessnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.PaperReshipNameDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmReshipName;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmReshipNameMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperReshipNameVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmReshipNameService;

import javax.annotation.Resource;

/**
 * <p>
 * 转载名称 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmReshipNameServiceImpl extends BaseServiceImpl<SrmReshipNameMapper, SrmReshipName> implements SrmReshipNameService {
    @Autowired
    private SrmReshipNameService  srmReshipNameService;
    @Autowired
    private SrmReshipNameMapper srmReshipNameMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdatePaperReshipName(BaseDataLearningDto baseDataLearningDto) {
        List<PaperReshipNameDto> paperReshipNameDtos =baseDataLearningDto.getPaperReshipNames();

        List<SrmReshipName> paperReshipNameList=new ArrayList<>();
        for (PaperReshipNameDto paperReshipNameDto :paperReshipNameDtos) {
            SrmReshipName srmPaperReshipName = new SrmReshipName();
            srmPaperReshipName.setId(paperReshipNameDto.getRowId());
            if(ObjectUtil.isEmpty(paperReshipNameDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PT_RESHIP_NAME, 1, "");
                srmPaperReshipName.setCode(code);
            }else{
                srmPaperReshipName.setCode(paperReshipNameDto.getCode());
            }
            srmPaperReshipName.setName(paperReshipNameDto.getName());
            srmPaperReshipName.setIsValid(Integer.valueOf(paperReshipNameDto.getIsValid()));

            paperReshipNameList.add(srmPaperReshipName);
            Long RowId = srmPaperReshipName.getId();
        }
        super.saveOrUpdateBatch(paperReshipNameList);
        return RowId;
    }
    @Override
    public PaperReshipNameVo getDetailPaperReshipName(Long RowId) {
        return null;
    }

    @Override
    public IPage<PaperReshipNameVo> listPaperReshipName(PaperReshipNameDto paperReshipNameDto) {
        Page<PaperReshipNameVo> page = new Page<>(paperReshipNameDto.getPage(), paperReshipNameDto.getRows());
        IPage<PaperReshipNameVo> res= srmReshipNameMapper.listPaperReshipName(page, paperReshipNameDto);
        //List<PaperReshipNameVo> records=res.getRecords();
        //List<PaperReshipNameVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePaperReshipName(BaseDto baseDto) {
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
    public List<CombVo> getPaperReshipName(PaperReshipNameDto paperReshipNameDto) {
        return srmReshipNameMapper.getPaperReshipName(paperReshipNameDto);
    }
}
