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

import com.mediway.hos.srm.business.center.model.dto.baseData.WorkTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmWorkType;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmWorkTypeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.WorkTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmWorkTypeService;

import javax.annotation.Resource;

/**
 * <p>
 * 著作类别 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-19
 */
@Service
public class SrmWorkTypeServiceImpl extends BaseServiceImpl<SrmWorkTypeMapper, SrmWorkType> implements SrmWorkTypeService {

    @Autowired
    private SrmWorkTypeService  srmWorkTypeService;
    @Autowired
    private SrmWorkTypeMapper srmWorkTypeMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateWorkType(BaseDataLearningDto baseDataLearningDto) {
        List<WorkTypeDto> workTypeDtos =baseDataLearningDto.getWorkTypes();

        List<SrmWorkType> workTypeList=new ArrayList<>();
        for (WorkTypeDto workTypeDto :workTypeDtos) {
            SrmWorkType srmWorkType = new SrmWorkType();
            srmWorkType.setId(workTypeDto.getRowId());
            if(ObjectUtil.isEmpty(workTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PT_WORK_TYPE, 1, "");
                srmWorkType.setCode(code);
            }else{
                srmWorkType.setCode(workTypeDto.getCode());
            }
            srmWorkType.setName(workTypeDto.getName());
            srmWorkType.setIsValid(Integer.valueOf(workTypeDto.getIsValid()));

            workTypeList.add(srmWorkType);
            Long RowId = srmWorkType.getId();
        }
        super.saveOrUpdateBatch(workTypeList);
        return RowId;
    }
    @Override
    public WorkTypeVo getDetailWorkType(Long RowId) {
        return null;
    }

    @Override
    public IPage<WorkTypeVo> listWorkType(WorkTypeDto workTypeDto) {
        Page<WorkTypeVo> page = new Page<>(workTypeDto.getPage(), workTypeDto.getRows());
        IPage<WorkTypeVo> res= srmWorkTypeMapper.listWorkType(page, workTypeDto);
        //List<WorkTypeVo> records=res.getRecords();
        //List<WorkTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteWorkType(BaseDto baseDto) {
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
    public List<CombVo> getWorkType(WorkTypeDto workTypeDto) {
        return srmWorkTypeMapper.getWorkType(workTypeDto);
    }
}
