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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjSecretLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjSecretLevelVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjSecretLevel;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjSecretLevelService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProjSecretLevelMapper;
/**
 * <p>
 * 项目密级代码表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjSecretLevelServiceImpl extends BaseServiceImpl<SrmProjSecretLevelMapper, SrmProjSecretLevel> implements SrmProjSecretLevelService {

    @Autowired
    private SrmProjSecretLevelService  srmProjSecretLevelService;
    @Autowired
    private SrmProjSecretLevelMapper srmProjSecretLevelMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateProjSecretLevel(BaseDataProjDto baseDataProjDto) {
        List<ProjSecretLevelDto> projSecretLevelDtos =baseDataProjDto.getProjSecretLevels();

        List<SrmProjSecretLevel> projSecretLevelList=new ArrayList<>();
        for (ProjSecretLevelDto projSecretLevelDto :projSecretLevelDtos) {
            SrmProjSecretLevel srmProjSecretLevel = new SrmProjSecretLevel();
            srmProjSecretLevel.setId(projSecretLevelDto.getRowId());
            if(ObjectUtil.isEmpty(projSecretLevelDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PRJ_SECRET_LEVEL, 1, "");
                srmProjSecretLevel.setCode(code);
            }else{
                srmProjSecretLevel.setCode(projSecretLevelDto.getCode());
            }
            srmProjSecretLevel.setName(projSecretLevelDto.getName());
            srmProjSecretLevel.setIsValid(Integer.valueOf(projSecretLevelDto.getIsValid()));

            projSecretLevelList.add(srmProjSecretLevel);
            Long RowId = srmProjSecretLevel.getId();
        }
        super.saveOrUpdateBatch(projSecretLevelList);
        return RowId;
    }
    @Override
    public ProjSecretLevelVo getDetailProjSecretLevel(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProjSecretLevelVo> listProjSecretLevel(ProjSecretLevelDto projSecretLevelDto) {
        Page<ProjSecretLevelVo> page = new Page<>(projSecretLevelDto.getPage(), projSecretLevelDto.getRows());
        IPage<ProjSecretLevelVo> res= srmProjSecretLevelMapper.listProjSecretLevel(page, projSecretLevelDto);
        //List<ProjSecretLevelVo> records=res.getRecords();
        //List<ProjSecretLevelVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteProjSecretLevel(BaseDto baseDto) {
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
