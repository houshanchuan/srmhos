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

import com.mediway.hos.srm.business.center.model.dto.baseData.HonorTitleDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.HonorTitleVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmHonorTitle;
import com.mediway.hos.srm.business.center.service.baseData.SrmHonorTitleService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmHonorTitleMapper;

import javax.annotation.Resource;

/**
 * <p>
 * 荣誉称号表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */

@Service
public class SrmHonorTitleServiceImpl extends BaseServiceImpl<SrmHonorTitleMapper, SrmHonorTitle> implements SrmHonorTitleService {
    @Autowired
    private  SrmHonorTitleMapper srmHonorTitleMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    @Override
    public List<CombVo> getHonorTitle() {
        return srmHonorTitleMapper.getHonorTitle();
    }
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateHonorTitle(BaseDataUserDto baseDataUserDto) {
        List<HonorTitleDto> honorTitleDtos =baseDataUserDto.getHonorTitles();

        List<SrmHonorTitle> honorTitleList=new ArrayList<>();
        for (HonorTitleDto honorTitleDto :honorTitleDtos) {
            SrmHonorTitle srmHonorTitle = new SrmHonorTitle();
            srmHonorTitle.setId(honorTitleDto.getRowId());
            if(ObjectUtil.isEmpty(honorTitleDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_HONOR_TITLE, 1, "");
                srmHonorTitle.setCode(code);
            }else{
                srmHonorTitle.setCode(honorTitleDto.getCode());
            }
            srmHonorTitle.setName(honorTitleDto.getName());
            srmHonorTitle.setIsValid(honorTitleDto.getIsValid());

            honorTitleList.add(srmHonorTitle);
            Long RowId = srmHonorTitle.getId();
        }
        super.saveOrUpdateBatch(honorTitleList);
        return RowId;
    }
    @Override
    public HonorTitleVo getDetailHonorTitle(Long RowId) {
        return null;
    }

    @Override
    public IPage<HonorTitleVo> listHonorTitle(HonorTitleDto honorTitleDto) {
        Page<HonorTitleVo> page = new Page<>(honorTitleDto.getPage(),honorTitleDto.getRows());
        IPage<HonorTitleVo> res= srmHonorTitleMapper.listHonorTitle(page,honorTitleDto);
        return res;
    }

    @Override
    public void deleteHonorTitle(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                if(StringUtils.isEmpty(idStr)){
                    idStr=String.valueOf(RowId);
                }else{
                    idStr=idStr+""+String.valueOf(RowId);
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
