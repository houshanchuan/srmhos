package com.mediway.hos.srm.business.center.serviceimpl.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.YearWorkMonthDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.YearWorkMonthVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmYearWorkmonth;
import com.mediway.hos.srm.business.center.service.baseData.SrmYearWorkmonthService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmYearWorkmonthMapper;

/**
 * <p>
 * 年工作量 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmYearWorkmonthServiceImpl extends BaseServiceImpl<SrmYearWorkmonthMapper, SrmYearWorkmonth> implements SrmYearWorkmonthService {

    @Autowired
    private SrmYearWorkmonthService  srmYearWorkMonthService;
    @Autowired
    private SrmYearWorkmonthMapper srmYearWorkMonthMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateYearWorkMonth(BaseDataCommonDto baseDataProjDto) {
        List<YearWorkMonthDto> yearWorkMonthDtos =baseDataProjDto.getYearWorkMonths();

        List<SrmYearWorkmonth> yearWorkMonthList=new ArrayList<>();
        for (YearWorkMonthDto yearWorkMonthDto :yearWorkMonthDtos) {
            SrmYearWorkmonth srmYearWorkMonth = new SrmYearWorkmonth();
            srmYearWorkMonth.setId(yearWorkMonthDto.getRowId());
            srmYearWorkMonth.setCode(yearWorkMonthDto.getCode());
            srmYearWorkMonth.setName(yearWorkMonthDto.getName());
            srmYearWorkMonth.setIsValid(Integer.valueOf(yearWorkMonthDto.getIsValid()));

            yearWorkMonthList.add(srmYearWorkMonth);
            Long RowId = srmYearWorkMonth.getId();
        }
        super.saveOrUpdateBatch(yearWorkMonthList);
        return RowId;
    }
    @Override
    public YearWorkMonthVo getDetailYearWorkMonth(Long RowId) {
        return null;
    }

    @Override
    public IPage<YearWorkMonthVo> listYearWorkMonth(YearWorkMonthDto yearWorkMonthDto) {
        Page<YearWorkMonthVo> page = new Page<>(yearWorkMonthDto.getPage(), yearWorkMonthDto.getRows());
        IPage<YearWorkMonthVo> res= srmYearWorkMonthMapper.listYearWorkMonth(page, yearWorkMonthDto);
        //List<YearWorkMonthVo> records=res.getRecords();
        //List<YearWorkMonthVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteYearWorkMonth(BaseDto baseDto) {
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
