package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataPlatformDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.SciUnitFormDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.SciUnitFormVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmSciUnitForm;
import com.mediway.hos.srm.business.center.service.baseData.SrmSciUnitFormService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmSciUnitFormMapper;

/**
 * <p>
 * 组织形式(科技统计用) 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmSciUnitFormServiceImpl extends BaseServiceImpl<SrmSciUnitFormMapper, SrmSciUnitForm> implements SrmSciUnitFormService {

    @Autowired
    private SrmSciUnitFormMapper srmSciUnitFormMapper;
    private Long RowId;

    @Override
    @Transactional
    public Long saveOrUpdateSciUnitForm(BaseDataPlatformDto baseDataPlatformDto) {
        List<SciUnitFormDto> sciUnitFormDtos = baseDataPlatformDto.getSciUnitForms();

        List<SrmSciUnitForm> sciUnitFormList = new ArrayList<>();
        for (SciUnitFormDto sciUnitFormDto : sciUnitFormDtos) {
            SrmSciUnitForm srmSciUnitForm = new SrmSciUnitForm();
            srmSciUnitForm.setId(sciUnitFormDto.getRowId());
            srmSciUnitForm.setCode(sciUnitFormDto.getCode());
            srmSciUnitForm.setName(sciUnitFormDto.getName());
            srmSciUnitForm.setIsValid(sciUnitFormDto.getIsValid());

            sciUnitFormList.add(srmSciUnitForm);
            Long RowId = srmSciUnitForm.getId();
        }
        super.saveOrUpdateBatch(sciUnitFormList);
        return RowId;
    }

    @Override
    public SciUnitFormVo getDetailSciUnitForm(Long RowId) {
        return null;
    }

    @Override
    public IPage<SciUnitFormVo> listSciUnitForm(SciUnitFormDto sciUnitFormDto) {
        Page<SciUnitFormVo> page = new Page<>(sciUnitFormDto.getPage(), sciUnitFormDto.getRows());
        IPage<SciUnitFormVo> res = srmSciUnitFormMapper.listSciUnitForm(page, sciUnitFormDto);
        return res;
    }

    @Override
    public void deleteSciUnitForm(BaseDto baseDto) {
        List<Long> idList = baseDto.getIdList();
        String idStr = "";
        try {
            for (Long RowId : idList) {
                //System.out.println(RowId);
                if (StringUtils.isEmpty(idStr)) {
                    idStr = String.valueOf(RowId);
                } else {
                    idStr = idStr + "" + String.valueOf(RowId);
                }
            }
            super.deleteByIds(idStr);
        } catch (Exception exception) {
            throw new ErrorException("-200", exception.getMessage());
        }
    }

    @Override
    public Long getIdByName(String name) {
        return null;
    }
}