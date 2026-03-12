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

import com.mediway.hos.srm.business.center.model.dto.baseData.ClinicalStudyFileTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ClinicalStudyFileTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmClinicalStudyFileType;
import com.mediway.hos.srm.business.center.service.baseData.SrmClinicalStudyFileTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmClinicalStudyFileTypeMapper;

import javax.annotation.Resource;

/**
 * <p>
 * 临床试验研究项目附件类型表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmClinicalStudyFileTypeServiceImpl extends BaseServiceImpl<SrmClinicalStudyFileTypeMapper, SrmClinicalStudyFileType> implements SrmClinicalStudyFileTypeService {

    @Autowired
    private SrmClinicalStudyFileTypeService  srmClinicalStudyFileTypeService;
    @Autowired
    private SrmClinicalStudyFileTypeMapper srmClinicalStudyFileTypeMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateClinicalStudyFileType(BaseDataProjDto baseDataProjDto) {
        List<ClinicalStudyFileTypeDto> clinicalStudyFileTypeDtos =baseDataProjDto.getClinicalStudyFileTypes();

        List<SrmClinicalStudyFileType> clinicalStudyFileTypeList=new ArrayList<>();
        for (ClinicalStudyFileTypeDto clinicalStudyFileTypeDto :clinicalStudyFileTypeDtos) {
            SrmClinicalStudyFileType srmClinicalStudyFileType = new SrmClinicalStudyFileType();
            srmClinicalStudyFileType.setId(clinicalStudyFileTypeDto.getRowId());
            if(ObjectUtil.isEmpty(clinicalStudyFileTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PRJ_ClI_STUDY_FILETYPE, 1, "");
                srmClinicalStudyFileType.setCode(code);
            }else{
                srmClinicalStudyFileType.setCode(clinicalStudyFileTypeDto.getCode());
            }
            srmClinicalStudyFileType.setName(clinicalStudyFileTypeDto.getName());
            srmClinicalStudyFileType.setIsValid(clinicalStudyFileTypeDto.getIsValid());
            srmClinicalStudyFileType.setIsRequired(clinicalStudyFileTypeDto.getIsRequired());


            clinicalStudyFileTypeList.add(srmClinicalStudyFileType);
            Long RowId = srmClinicalStudyFileType.getId();
        }
        super.saveOrUpdateBatch(clinicalStudyFileTypeList);
        return RowId;
    }
    @Override
    public ClinicalStudyFileTypeVo getDetailClinicalStudyFileType(Long RowId) {
        return null;
    }

    @Override
    public IPage<ClinicalStudyFileTypeVo> listClinicalStudyFileType(ClinicalStudyFileTypeDto clinicalStudyFileTypeDto) {
        Page<ClinicalStudyFileTypeVo> page = new Page<>(clinicalStudyFileTypeDto.getPage(), clinicalStudyFileTypeDto.getRows());
        IPage<ClinicalStudyFileTypeVo> res= srmClinicalStudyFileTypeMapper.listClinicalStudyFileType(page, clinicalStudyFileTypeDto);
        //List<ClinicalStudyFileTypeVo> records=res.getRecords();
        //List<ClinicalStudyFileTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteClinicalStudyFileType(BaseDto baseDto) {
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
