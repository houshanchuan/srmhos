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
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.EduLevelDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEduLevel;
import com.mediway.hos.srm.business.center.model.vo.baseData.EduLevelVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmEduLevelService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmEduLevelMapper;

/**
 * <p>
 * 学历表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmEduLevelServiceImpl extends BaseServiceImpl<SrmEduLevelMapper, SrmEduLevel> implements SrmEduLevelService {
    @Autowired
    private SrmEduLevelService  srmEduLevelService;
    @Autowired
    private SrmEduLevelMapper srmEduLevelMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateEduLevel(BaseDataUserDto baseDataUserDto) {
        List<EduLevelDto> eduLevelDtos =baseDataUserDto.getEduLevels();

        List<SrmEduLevel> eduLevelList=new ArrayList<>();
        for (EduLevelDto eduLevelDto :eduLevelDtos) {
            SrmEduLevel srmEduLevel = new SrmEduLevel();
            srmEduLevel.setId(eduLevelDto.getRowId());
            if(ObjectUtil.isEmpty(eduLevelDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_EDU_LEVEL, 2, "");
                srmEduLevel.setCode(code);
            }else{
                srmEduLevel.setCode(eduLevelDto.getCode());
            }
            srmEduLevel.setName(eduLevelDto.getName());
            srmEduLevel.setIsValid(Integer.valueOf(eduLevelDto.getIsValid()));

            eduLevelList.add(srmEduLevel);
            Long RowId = srmEduLevel.getId();
        }
        super.saveOrUpdateBatch(eduLevelList);
        return RowId;
    }
    @Override
    public EduLevelVo getDetailEduLevel(Long RowId) {
        return null;
    }

    @Override
    public IPage<EduLevelVo> listEduLevel(EduLevelDto eduLevelDto) {
        Page<EduLevelVo> page = new Page<>(eduLevelDto.getPage(), eduLevelDto.getRows());
        IPage<EduLevelVo> res= srmEduLevelMapper.listEduLevel(page, eduLevelDto);
        //List<EduLevelVo> records=res.getRecords();
        //List<EduLevelVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteEduLevel(BaseDto baseDto) {
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
    public List<CombVo> getEduLevel(EduLevelDto eduLevelDto) {
        return srmEduLevelMapper.getEduLevel(eduLevelDto);
    }
}
