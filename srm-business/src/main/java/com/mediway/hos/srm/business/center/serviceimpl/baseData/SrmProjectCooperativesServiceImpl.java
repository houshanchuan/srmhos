package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectCooperatives;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProjectCooperativesMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectCooperativesVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectCooperativesService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 项目合作单位表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectCooperativesServiceImpl extends BaseServiceImpl<SrmProjectCooperativesMapper, SrmProjectCooperatives> implements SrmProjectCooperativesService {
    @Autowired
    private SrmProjectCooperativesMapper srmProjectCooperativesMapper;
    @Override
    public List<ProjectCooperativesVo> listProjectCooperatives(BaseDto baseDto) {
        return srmProjectCooperativesMapper.listProjectCooperatives(baseDto.getId());
    }

    @Override
    @Transactional
    public void deleteProjectCooperativesById(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
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

}
