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

import com.mediway.hos.srm.business.center.model.dto.baseData.TitleLevelDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmTitleLevel;
import com.mediway.hos.srm.business.center.model.vo.baseData.TitleLevelVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmTitleLevelService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmTitleLevelMapper;

/**
 * <p>
 * 职称级别 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmTitleLevelServiceImpl extends BaseServiceImpl<SrmTitleLevelMapper, SrmTitleLevel> implements SrmTitleLevelService {
    @Autowired
    private SrmTitleLevelService  srmTitleLevelService;
    @Autowired
    private SrmTitleLevelMapper srmTitleLevelMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateTitleLevel(BaseDataUserDto baseDataUserDto) {
        List<TitleLevelDto> titleLevelDtos =baseDataUserDto.getTitleLevels();

        List<SrmTitleLevel> titleLevelList=new ArrayList<>();
        for (TitleLevelDto titleLevelDto :titleLevelDtos) {
            SrmTitleLevel srmTitleLevel = new SrmTitleLevel();
            srmTitleLevel.setId(titleLevelDto.getRowId());
            if(ObjectUtil.isEmpty(titleLevelDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_TITLE_LEVEL, 1, "");
                srmTitleLevel.setCode(code);
            }else{
                srmTitleLevel.setCode(titleLevelDto.getCode());
            }
            srmTitleLevel.setName(titleLevelDto.getName());
            srmTitleLevel.setIsValid(Integer.valueOf(titleLevelDto.getIsValid()));

            titleLevelList.add(srmTitleLevel);
            Long RowId = srmTitleLevel.getId();
        }
        super.saveOrUpdateBatch(titleLevelList);
        return RowId;
    }
    @Override
    public TitleLevelVo getDetailTitleLevel(Long RowId) {
        return null;
    }

    @Override
    public IPage<TitleLevelVo> listTitleLevel(TitleLevelDto titleLevelDto) {
        Page<TitleLevelVo> page = new Page<>(titleLevelDto.getPage(), titleLevelDto.getRows());
        IPage<TitleLevelVo> res= srmTitleLevelMapper.listTitleLevel(page, titleLevelDto);
        //List<TitleLevelVo> records=res.getRecords();
        //List<TitleLevelVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteTitleLevel(BaseDto baseDto) {
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
