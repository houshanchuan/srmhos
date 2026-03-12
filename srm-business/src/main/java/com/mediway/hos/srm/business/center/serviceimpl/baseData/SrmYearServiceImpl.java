package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmYear;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmYearMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmYearService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import java.util.ArrayList;
import com.mediway.hos.srm.business.center.model.dto.baseData.YearDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.YearVo;


/**
 * <p>
 * 年度 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-19
 */
@Service
public class SrmYearServiceImpl extends BaseServiceImpl<SrmYearMapper, SrmYear> implements SrmYearService {
    @Resource
    private SrmYearMapper srmYearMapper;

    @Override
    public Long saveYear(SrmYear year) {
        srmYearMapper.saveYear(year);
        return  year.getId();
    }

    @Override
    public List<CombVo> getYear(YearDto yearDto) {
        System.out.println(1233333333);
        return srmYearMapper.getYear(yearDto);
    }

    public void test2(){
        //这种不会回滚了
        test();
    }
    //@Transactional (rollbackFor = {java.lang.Exception.class})
    @Transactional
    public void test(){
        SrmYear year=new SrmYear();
        year.setCode("1997");
        year.setName("1997");
        year.setIsValid(1);
        SrmYear year2=new SrmYear();
        year2.setCode("2032");
        year2.setName("2032");

        year.setIsValid(0);
        try{
            super.saveOrUpdate(year);
            super.saveOrUpdate(year2);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            //不加的话不会滚
            throw new ErrorException("-200","错误","error1");
        }


        //long result2=this.saveOrupdate(year);

    }

    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateYear(BaseDataProjDto baseDataProjDto) {
        List<YearDto> yearDtos =baseDataProjDto.getYears();

        List<SrmYear> yearList=new ArrayList<>();
        for (YearDto yearDto :yearDtos) {
            SrmYear srmYear = new SrmYear();
            srmYear.setId(yearDto.getRowId());
            srmYear.setCode(yearDto.getCode());
            srmYear.setName(yearDto.getName());
            srmYear.setIsValid(Integer.valueOf(yearDto.getIsValid()));

            yearList.add(srmYear);
            Long RowId = srmYear.getId();
        }
        super.saveOrUpdateBatch(yearList);
        return RowId;
    }
    @Override
    public YearVo getDetailYear(Long RowId) {
        return null;
    }

    @Override
    public IPage<YearVo> listYear(YearDto yearDto) {
        Page<YearVo> page = new Page<>(yearDto.getPage(), yearDto.getRows());
        IPage<YearVo> res= srmYearMapper.listYear(page, yearDto);
        //List<YearVo> records=res.getRecords();
        //List<YearVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteYear(BaseDto baseDto) {
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
