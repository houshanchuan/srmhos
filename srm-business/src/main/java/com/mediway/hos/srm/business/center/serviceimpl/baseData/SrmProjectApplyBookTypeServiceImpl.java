package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import com.mediway.hos.srm.business.center.constants.BusinessConstants;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjLevel;
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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApplyBookTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApplyBookTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectApplyBookType;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectApplyBookTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProjectApplyBookTypeMapper;

import javax.annotation.Resource;

/**
 * <p>
 * 项目申报类别 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectApplyBookTypeServiceImpl extends BaseServiceImpl<SrmProjectApplyBookTypeMapper, SrmProjectApplyBookType> implements SrmProjectApplyBookTypeService {

    @Autowired
    private SrmProjectApplyBookTypeService  srmProjectApplyBookTypeService;
    @Autowired
    private SrmProjectApplyBookTypeMapper srmProjectApplyBookTypeMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateProjectApplyBookType(BaseDataProjDto baseDataProjDto) {
        List<ProjectApplyBookTypeDto> projectApplyBookTypeDtos =baseDataProjDto.getProjectApplyBookTypes();
        List<SrmProjectApplyBookType> projectApplyBookTypeList=new ArrayList<>();
        for (ProjectApplyBookTypeDto projectApplyBookTypeDto :projectApplyBookTypeDtos) {
            SrmProjectApplyBookType srmProjectApplyBookType = new SrmProjectApplyBookType();
            srmProjectApplyBookType.setId(projectApplyBookTypeDto.getRowId());
            if(ObjectUtil.isEmpty(projectApplyBookTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PRJ_APPLY_BOOK_TYPE, 1, "");
                srmProjectApplyBookType.setCode(code);
            }else{
                srmProjectApplyBookType.setCode(projectApplyBookTypeDto.getCode());
            }
            srmProjectApplyBookType.setName(projectApplyBookTypeDto.getName());
            srmProjectApplyBookType.setIsValid(Integer.valueOf(projectApplyBookTypeDto.getIsValid()));

            projectApplyBookTypeList.add(srmProjectApplyBookType);
            Long RowId = srmProjectApplyBookType.getId();
        }
        super.saveOrUpdateBatch(projectApplyBookTypeList);
        return RowId;
    }
    @Override
    public ProjectApplyBookTypeVo getDetailProjectApplyBookType(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProjectApplyBookTypeVo> listProjectApplyBookType(ProjectApplyBookTypeDto projectApplyBookTypeDto) {
        Page<ProjectApplyBookTypeVo> page = new Page<>(projectApplyBookTypeDto.getPage(), projectApplyBookTypeDto.getRows());
        IPage<ProjectApplyBookTypeVo> res= srmProjectApplyBookTypeMapper.listProjectApplyBookType(page, projectApplyBookTypeDto);
        //List<ProjectApplyBookTypeVo> records=res.getRecords();
        //List<ProjectApplyBookTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteProjectApplyBookType(BaseDto baseDto) {
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
    public List<CombVo> getProjectApplyBookType() {
        return srmProjectApplyBookTypeMapper.getProjectApplyBookType();
    }
}
