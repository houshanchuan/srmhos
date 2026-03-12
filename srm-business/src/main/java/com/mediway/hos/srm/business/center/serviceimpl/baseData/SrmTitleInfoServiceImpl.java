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

import com.mediway.hos.srm.business.center.model.dto.baseData.TitleInfoDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmTitleInfo;
import com.mediway.hos.srm.business.center.model.vo.baseData.TitleInfoVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmTitleInfoService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmTitleInfoMapper;

/**
 * <p>
 * 职称表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmTitleInfoServiceImpl extends BaseServiceImpl<SrmTitleInfoMapper, SrmTitleInfo> implements SrmTitleInfoService {
    @Autowired
    private SrmTitleInfoMapper srmTitleInfoMapper;
    @Override
    public List<CombVo> getUserTitle(TitleInfoDto titleInfoDto) {
        return srmTitleInfoMapper.getUserTitle(titleInfoDto);
    }


    @Autowired
    private SrmTitleInfoService  srmTitleInfoService;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateTitleInfo(BaseDataUserDto baseDataUserDto) {
        List<TitleInfoDto> titleInfoDtos =baseDataUserDto.getTitleInfos();

        List<SrmTitleInfo> titleInfoList=new ArrayList<>();
        for (TitleInfoDto titleInfoDto :titleInfoDtos) {
            SrmTitleInfo srmTitleInfo = new SrmTitleInfo();
            srmTitleInfo.setId(titleInfoDto.getRowId());
            if(ObjectUtil.isEmpty(titleInfoDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_TITLE_INFO, 3, "");
                srmTitleInfo.setCode(code);
            }else{
                srmTitleInfo.setCode(titleInfoDto.getCode());
            }
            srmTitleInfo.setName(titleInfoDto.getName());
            srmTitleInfo.setIsValid(Integer.valueOf(titleInfoDto.getIsValid()));

            titleInfoList.add(srmTitleInfo);
            Long RowId = srmTitleInfo.getId();
        }
        super.saveOrUpdateBatch(titleInfoList);
        return RowId;
    }
    @Override
    public TitleInfoVo getDetailTitleInfo(Long RowId) {
        return null;
    }

    @Override
    public IPage<TitleInfoVo> listTitleInfo(TitleInfoDto titleInfoDto) {
        Page<TitleInfoVo> page = new Page<>(titleInfoDto.getPage(), titleInfoDto.getRows());
        IPage<TitleInfoVo> res= srmTitleInfoMapper.listTitleInfo(page, titleInfoDto);
        //List<TitleInfoVo> records=res.getRecords();
        //List<TitleInfoVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteTitleInfo(BaseDto baseDto) {
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
