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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApplyTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApplyTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectApplyType;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectApplyTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProjectApplyTypeMapper;

/**
 * <p>
 * 项目申报类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectApplyTypeServiceImpl extends BaseServiceImpl<SrmProjectApplyTypeMapper, SrmProjectApplyType> implements SrmProjectApplyTypeService {

    @Autowired
    private SrmProjectApplyTypeService  srmProjectApplyTypeService;
    @Autowired
    private SrmProjectApplyTypeMapper srmProjectApplyTypeMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateProjectApplyType(BaseDataProjDto baseDataProjDto) {
        List<ProjectApplyTypeDto> projectApplyTypeDtos =baseDataProjDto.getProjectApplyTypes();

        List<SrmProjectApplyType> projectApplyTypeList=new ArrayList<>();
        for (ProjectApplyTypeDto projectApplyTypeDto :projectApplyTypeDtos) {
            SrmProjectApplyType srmProjectApplyType = new SrmProjectApplyType();
            srmProjectApplyType.setId(projectApplyTypeDto.getRowId());
            if(ObjectUtil.isEmpty(projectApplyTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PRJ_APPLY_TYPE, 1, "");
                srmProjectApplyType.setCode(code);
            }else{
                srmProjectApplyType.setCode(projectApplyTypeDto.getCode());
            }
            srmProjectApplyType.setName(projectApplyTypeDto.getName());
            srmProjectApplyType.setIsValid(Integer.valueOf(projectApplyTypeDto.getIsValid()));

            projectApplyTypeList.add(srmProjectApplyType);
            Long RowId = srmProjectApplyType.getId();
        }
        super.saveOrUpdateBatch(projectApplyTypeList);
        return RowId;
    }
    @Override
    public ProjectApplyTypeVo getDetailProjectApplyType(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProjectApplyTypeVo> listProjectApplyType(ProjectApplyTypeDto projectApplyTypeDto) {
        Page<ProjectApplyTypeVo> page = new Page<>(projectApplyTypeDto.getPage(), projectApplyTypeDto.getRows());
        IPage<ProjectApplyTypeVo> res= srmProjectApplyTypeMapper.listProjectApplyType(page, projectApplyTypeDto);
        //List<ProjectApplyTypeVo> records=res.getRecords();
        //List<ProjectApplyTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteProjectApplyType(BaseDto baseDto) {
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
    public List<CombVo> getProjectApplyType() {
        return srmProjectApplyTypeMapper.getProjectApplyType();
    }
}
