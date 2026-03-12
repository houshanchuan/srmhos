package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.AppxfileTypeDetailDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.AppxfileTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.AppxfileTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAppxfileType;
import com.mediway.hos.srm.business.center.service.baseData.SrmAppxfileTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmAppxfileTypeMapper;
/**
 * <p>
 * 附件文件类型定义表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmAppxfileTypeServiceImpl extends BaseServiceImpl<SrmAppxfileTypeMapper, SrmAppxfileType> implements SrmAppxfileTypeService {
    @Autowired
    private SrmAppxfileTypeMapper srmAppxfileTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateAppxfileType(AppxfileTypeDto appxfileTypeDto) {

        List<AppxfileTypeDetailDto> appxfileTypeDetailDtos =appxfileTypeDto.getAppxfileTypeDetails();

        List<SrmAppxfileType> appxfileTypeList=new ArrayList<>();
        for (AppxfileTypeDetailDto appxfileTypeDetailDto :appxfileTypeDetailDtos) {
            SrmAppxfileType srmAppxfileType = new SrmAppxfileType();
            srmAppxfileType.setId(appxfileTypeDetailDto.getRowId());
            srmAppxfileType.setCode(appxfileTypeDetailDto.getCode());
            srmAppxfileType.setName(appxfileTypeDetailDto.getName());
            srmAppxfileType.setIsValid(appxfileTypeDetailDto.getIsValid());
            srmAppxfileType.setSysNo(appxfileTypeDetailDto.getSysNo());
            srmAppxfileType.setType(appxfileTypeDetailDto.getFileType());
            srmAppxfileType.setIsRequired(appxfileTypeDetailDto.getIsRequired());

            appxfileTypeList.add(srmAppxfileType);
            Long RowId = srmAppxfileType.getId();
        }
        super.saveOrUpdateBatch(appxfileTypeList);
        return RowId;
    }
    @Override
    public AppxfileTypeVo getDetailAppxfileType(Long RowId) {
        return null;
    }

    @Override
    public IPage<AppxfileTypeVo> listAppxfileType(AppxfileTypeDetailDto appxfileTypeDetailDto) {
        Page<AppxfileTypeVo> page = new Page<>(appxfileTypeDetailDto.getPage(), appxfileTypeDetailDto.getRows());
        String sysNo=appxfileTypeDetailDto.getSysNo();
        IPage<AppxfileTypeVo> res= srmAppxfileTypeMapper.listAppxfileType(page,sysNo);
        //List<AppxfileTypeVo> records=res.getRecords();
        //List<AppxfileTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteAppxfileType(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                if(StringUtils.isEmpty(idStr)){
                    idStr=String.valueOf(RowId);
                }else{
                    idStr=idStr+","+ RowId;
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
