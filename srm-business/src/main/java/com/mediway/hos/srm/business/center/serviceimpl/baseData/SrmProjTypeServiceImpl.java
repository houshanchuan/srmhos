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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjType;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProjTypeMapper;

import javax.annotation.Resource;

/**
 * <p>
 * 项目分类表（父） 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjTypeServiceImpl extends BaseServiceImpl<SrmProjTypeMapper, SrmProjType> implements SrmProjTypeService {

    @Autowired
    private SrmProjTypeService  srmProjTypeService;
    @Autowired
    private SrmProjTypeMapper srmProjTypeMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateProjType(BaseDataProjDto baseDataProjDto) {
        List<ProjTypeDto> projTypeDtos =baseDataProjDto.getProjTypes();

        List<SrmProjType> projTypeList=new ArrayList<>();
        for (ProjTypeDto projTypeDto :projTypeDtos) {
            SrmProjType srmProjType = new SrmProjType();
            srmProjType.setId(projTypeDto.getRowId());
            if(ObjectUtil.isEmpty(projTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PRJ_TYPE, 2, "");
                srmProjType.setCode(code);
            }else{
                srmProjType.setCode(projTypeDto.getCode());
            }
            srmProjType.setName(projTypeDto.getName());
            srmProjType.setIsValid(projTypeDto.getIsValid());
            srmProjType.setProjClass(projTypeDto.getProjClass());
            srmProjType.setProjLevel(Long.valueOf(projTypeDto.getProjLevel()));
            srmProjType.setSocialSource(projTypeDto.getSocialSource());
            srmProjType.setAlias(projTypeDto.getAlias());
            srmProjType.setTechSource(projTypeDto.getTechSource());

            projTypeList.add(srmProjType);
            Long RowId = srmProjType.getId();
        }
        super.saveOrUpdateBatch(projTypeList);
        return RowId;
    }
    @Override
    public ProjTypeVo getDetailProjType(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProjTypeVo> listProjType(ProjTypeDto projTypeDto) {
        Page<ProjTypeVo> page = new Page<>(projTypeDto.getPage(), projTypeDto.getRows());
        IPage<ProjTypeVo> res= srmProjTypeMapper.listProjType(page, projTypeDto);
        //List<ProjTypeVo> records=res.getRecords();
        //List<ProjTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteProjType(BaseDto baseDto) {
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
    public List<CombVo> getProjectType(ProjTypeDto projTypeDto){
        return srmProjTypeMapper.getProjectType(projTypeDto);
    }
}
