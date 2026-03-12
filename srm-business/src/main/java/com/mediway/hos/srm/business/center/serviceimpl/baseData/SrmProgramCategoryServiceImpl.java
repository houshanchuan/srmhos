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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProgramCategoryDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProgramCategoryVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProgramCategory;
import com.mediway.hos.srm.business.center.service.baseData.SrmProgramCategoryService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProgramCategoryMapper;

/**
 * <p>
 * 计划类别 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProgramCategoryServiceImpl extends BaseServiceImpl<SrmProgramCategoryMapper, SrmProgramCategory> implements SrmProgramCategoryService {

    @Autowired
    private SrmProgramCategoryService  srmProgramCategoryService;
    @Autowired
    private SrmProgramCategoryMapper srmProgramCategoryMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateProgramCategory(BaseDataProjDto baseDataProjDto) {
        List<ProgramCategoryDto> programCategoryDtos =baseDataProjDto.getProgramCategorys();

        List<SrmProgramCategory> programCategoryList=new ArrayList<>();
        for (ProgramCategoryDto programCategoryDto :programCategoryDtos) {
            SrmProgramCategory srmProgramCategory = new SrmProgramCategory();
            srmProgramCategory.setId(programCategoryDto.getRowId());
            if(ObjectUtil.isEmpty(programCategoryDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PROGRAM_CATEGORY, 1, "");
                srmProgramCategory.setCode(code);
            }else{
                srmProgramCategory.setCode(programCategoryDto.getCode());
            }
            srmProgramCategory.setName(programCategoryDto.getName());
            srmProgramCategory.setIsValid(Integer.valueOf(programCategoryDto.getIsValid()));

            programCategoryList.add(srmProgramCategory);
            Long RowId = srmProgramCategory.getId();
        }
        super.saveOrUpdateBatch(programCategoryList);
        return RowId;
    }
    @Override
    public ProgramCategoryVo getDetailProgramCategory(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProgramCategoryVo> listProgramCategory(ProgramCategoryDto programCategoryDto) {
        Page<ProgramCategoryVo> page = new Page<>(programCategoryDto.getPage(), programCategoryDto.getRows());
        IPage<ProgramCategoryVo> res= srmProgramCategoryMapper.listProgramCategory(page, programCategoryDto);
        //List<ProgramCategoryVo> records=res.getRecords();
        //List<ProgramCategoryVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteProgramCategory(BaseDto baseDto) {
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
