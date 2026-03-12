package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjLevelVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjLevel;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjLevelService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProjLevelMapper;

import javax.annotation.Resource;


/**
 * <p>
 * 项目级别代码 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjLevelServiceImpl extends BaseServiceImpl<SrmProjLevelMapper, SrmProjLevel> implements SrmProjLevelService {

    @Autowired
    private SrmProjLevelService  srmProjLevelService;
    @Autowired
    private SrmProjLevelMapper srmProjLevelMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;

    @Override
    @Transactional
    public Long saveOrUpdateProjLevel(BaseDataProjDto baseDataProjDto) {
        List<ProjLevelDto> projLevelDtos =baseDataProjDto.getProjLevels();
        List<SrmProjLevel> projLevelList=new ArrayList<>();
        for (ProjLevelDto projLevelDto :projLevelDtos) {
            SrmProjLevel srmProjLevel = new SrmProjLevel();
            srmProjLevel.setId(projLevelDto.getRowId());
            if(ObjectUtil.isEmpty(projLevelDto.getCode())){
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PRJ_LEVEL, 1, "");
                srmProjLevel.setCode(code);
            }else {
                srmProjLevel.setCode(projLevelDto.getCode());
            }
            srmProjLevel.setName(projLevelDto.getName());
            srmProjLevel.setIsValid(Integer.valueOf(projLevelDto.getIsValid()));

            projLevelList.add(srmProjLevel);
            Long RowId = srmProjLevel.getId();
        }
        super.saveOrUpdateBatch(projLevelList);
        return RowId;
    }
    @Override
    public ProjLevelVo getDetailProjLevel(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProjLevelVo> listProjLevel(ProjLevelDto projLevelDto) {
        Page<ProjLevelVo> page = new Page<>(projLevelDto.getPage(), projLevelDto.getRows());
        IPage<ProjLevelVo> res= srmProjLevelMapper.listProjLevel(page, projLevelDto);
        //List<ProjLevelVo> records=res.getRecords();
        //List<ProjLevelVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteProjLevel(BaseDto baseDto) {
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
    public List<CombVo> getProjLevel() {
        return srmProjLevelMapper.getProjLevel();
    }
}
