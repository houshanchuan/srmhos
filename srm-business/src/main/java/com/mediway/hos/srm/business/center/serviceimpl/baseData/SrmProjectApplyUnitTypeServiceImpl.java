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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApplyUnitTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApplyUnitTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectApplyUnitType;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectApplyUnitTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProjectApplyUnitTypeMapper;
/**
 * <p>
 * 项目申报部门类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectApplyUnitTypeServiceImpl extends BaseServiceImpl<SrmProjectApplyUnitTypeMapper, SrmProjectApplyUnitType> implements SrmProjectApplyUnitTypeService {

    @Autowired
    private SrmProjectApplyUnitTypeService  srmProjectApplyUnitTypeService;
    @Autowired
    private SrmProjectApplyUnitTypeMapper srmProjectApplyUnitTypeMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateProjectApplyUnitType(BaseDataProjDto baseDataProjDto) {
        List<ProjectApplyUnitTypeDto> projectApplyUnitTypeDtos =baseDataProjDto.getProjectApplyUnitTypes();

        List<SrmProjectApplyUnitType> projectApplyUnitTypeList=new ArrayList<>();
        for (ProjectApplyUnitTypeDto projectApplyUnitTypeDto :projectApplyUnitTypeDtos) {
            SrmProjectApplyUnitType srmProjectApplyUnitType = new SrmProjectApplyUnitType();
            srmProjectApplyUnitType.setId(projectApplyUnitTypeDto.getRowId());

            if(ObjectUtil.isEmpty(projectApplyUnitTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PRJ_APPLY_UNIT_TYPE, 1, "");
                srmProjectApplyUnitType.setCode(code);
            }else{
                srmProjectApplyUnitType.setCode(projectApplyUnitTypeDto.getCode());
            }
            srmProjectApplyUnitType.setName(projectApplyUnitTypeDto.getName());
            srmProjectApplyUnitType.setIsValid(Integer.valueOf(projectApplyUnitTypeDto.getIsValid()));

            projectApplyUnitTypeList.add(srmProjectApplyUnitType);
            Long RowId = srmProjectApplyUnitType.getId();
        }
        super.saveOrUpdateBatch(projectApplyUnitTypeList);
        return RowId;
    }
    @Override
    public ProjectApplyUnitTypeVo getDetailProjectApplyUnitType(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProjectApplyUnitTypeVo> listProjectApplyUnitType(ProjectApplyUnitTypeDto projectApplyUnitTypeDto) {
        Page<ProjectApplyUnitTypeVo> page = new Page<>(projectApplyUnitTypeDto.getPage(), projectApplyUnitTypeDto.getRows());
        IPage<ProjectApplyUnitTypeVo> res= srmProjectApplyUnitTypeMapper.listProjectApplyUnitType(page, projectApplyUnitTypeDto);
        //List<ProjectApplyUnitTypeVo> records=res.getRecords();
        //List<ProjectApplyUnitTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteProjectApplyUnitType(BaseDto baseDto) {
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
