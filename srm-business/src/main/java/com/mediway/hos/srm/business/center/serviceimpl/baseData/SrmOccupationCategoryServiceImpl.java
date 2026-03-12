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

import com.mediway.hos.srm.business.center.model.dto.baseData.OccupationCategoryDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmOccupationCategory;
import com.mediway.hos.srm.business.center.model.vo.baseData.OccupationCategoryVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmOccupationCategoryService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmOccupationCategoryMapper;

/**
 * <p>
 * 职业类别 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmOccupationCategoryServiceImpl extends BaseServiceImpl<SrmOccupationCategoryMapper, SrmOccupationCategory> implements SrmOccupationCategoryService {
    @Autowired
    private SrmOccupationCategoryService  srmOccupationCategoryService;
    @Autowired
    private SrmOccupationCategoryMapper srmOccupationCategoryMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateOccupationCategory(BaseDataUserDto baseDataUserDto) {
        List<OccupationCategoryDto> occupationCategoryDtos =baseDataUserDto.getOccupationCategorys();

        List<SrmOccupationCategory> occupationCategoryList=new ArrayList<>();
        for (OccupationCategoryDto occupationCategoryDto :occupationCategoryDtos) {
            SrmOccupationCategory srmOccupationCategory = new SrmOccupationCategory();
            srmOccupationCategory.setId(occupationCategoryDto.getRowId());
            if(ObjectUtil.isEmpty(occupationCategoryDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_OCCUPATION_CATEGORY, 2, "");
                srmOccupationCategory.setCode(code);
            }else{
                srmOccupationCategory.setCode(occupationCategoryDto.getCode());
            }
            srmOccupationCategory.setName(occupationCategoryDto.getName());
            srmOccupationCategory.setIsValid(Integer.valueOf(occupationCategoryDto.getIsValid()));

            occupationCategoryList.add(srmOccupationCategory);
            Long RowId = srmOccupationCategory.getId();
        }
        super.saveOrUpdateBatch(occupationCategoryList);
        return RowId;
    }
    @Override
    public OccupationCategoryVo getDetailOccupationCategory(Long RowId) {
        return null;
    }

    @Override
    public IPage<OccupationCategoryVo> listOccupationCategory(OccupationCategoryDto occupationCategoryDto) {
        Page<OccupationCategoryVo> page = new Page<>(occupationCategoryDto.getPage(), occupationCategoryDto.getRows());
        IPage<OccupationCategoryVo> res= srmOccupationCategoryMapper.listOccupationCategory(page, occupationCategoryDto);
        //List<OccupationCategoryVo> records=res.getRecords();
        //List<OccupationCategoryVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteOccupationCategory(BaseDto baseDto) {
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
    public List<CombVo> getOccupationCategory(OccupationCategoryDto occupationCategoryDto){
        return srmOccupationCategoryMapper.getOccupationCategory(occupationCategoryDto);
    }

}
