package com.mediway.hos.srm.business.center.serviceimpl.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjectCategoryDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjectCategoryVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundProjectCategory;
import com.mediway.hos.srm.business.center.service.fund.FundProjectCategoryService;
import com.mediway.hos.srm.business.center.mapper.fund.FundProjectCategoryMapper;


/**
 * <p>
 * 项目属性 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@Service
public class FundProjectCategoryServiceImpl extends BaseServiceImpl<FundProjectCategoryMapper, FundProjectCategory> implements FundProjectCategoryService {

    @Autowired
    private FundProjectCategoryMapper fundProjectCategoryMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundProjectCategory(BaseDataFundDto baseDataFundDto) {
        List<FundProjectCategoryDto> fundProjectCategoryDtos =baseDataFundDto.getFundProjectCategorys();

        List<FundProjectCategory> fundProjectCategoryList=new ArrayList<>();
        for (FundProjectCategoryDto fundProjectCategoryDto :fundProjectCategoryDtos) {
            FundProjectCategory fundProjectCategory = new FundProjectCategory();
            fundProjectCategory.setId(fundProjectCategoryDto.getRowId());
            fundProjectCategory.setCode(fundProjectCategoryDto.getCode());
            fundProjectCategory.setName(fundProjectCategoryDto.getName());
            fundProjectCategory.setIsValid(fundProjectCategoryDto.getIsValid());

            fundProjectCategoryList.add(fundProjectCategory);
            Long RowId = fundProjectCategory.getId();
        }
        super.saveOrUpdateBatch(fundProjectCategoryList);
        return RowId;
    }
    @Override
    public FundProjectCategoryVo getDetailFundProjectCategory(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundProjectCategoryVo> listFundProjectCategory(FundProjectCategoryDto fundProjectCategoryDto) {
        Page<FundProjectCategoryVo> page = new Page<>(fundProjectCategoryDto.getPage(),fundProjectCategoryDto.getRows());
        IPage<FundProjectCategoryVo> res= fundProjectCategoryMapper.listFundProjectCategory(page,fundProjectCategoryDto);
        //List<FundProjectCategoryVo> records=res.getRecords();
        //List<FundProjectCategoryVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundProjectCategory(BaseDto baseDto) {
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
