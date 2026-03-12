package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.DisciplineDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.entity.baseData.SrmDiscipline;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmDisciplineMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.DisciplineVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmDisciplineService;


/**
 * <p>
 * 学科表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-19
 */
@Service
public class SrmDisciplineServiceImpl extends BaseServiceImpl<SrmDisciplineMapper, SrmDiscipline> implements SrmDisciplineService {

    @Autowired
    private SrmDisciplineService  srmDisciplineService;
    @Autowired
    private SrmDisciplineMapper srmDisciplineMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateDiscipLine(BaseDataLearningDto baseDataLearningDto) {
        List<DisciplineDto> discipLineDtos =baseDataLearningDto.getDisciplines();

        List<SrmDiscipline> disciplineList=new ArrayList<>();
        for (DisciplineDto discipLineDto :discipLineDtos) {
            SrmDiscipline srmDiscipline = new SrmDiscipline();
            srmDiscipline.setId(discipLineDto.getRowId());
            srmDiscipline.setCode(discipLineDto.getCode());
            srmDiscipline.setName(discipLineDto.getName());
            srmDiscipline.setIsValid(Integer.valueOf(discipLineDto.getIsValid()));

            disciplineList.add(srmDiscipline);
            Long RowId = srmDiscipline.getId();
        }
        super.saveOrUpdateBatch(disciplineList);
        return RowId;
    }
    @Override
    public DisciplineVo getDetailDiscipLine(Long RowId) {
        return null;
    }

    @Override
    public IPage<DisciplineVo> listDiscipLine(DisciplineDto disciplineDto) {
        Page<DisciplineVo> page = new Page<>(disciplineDto.getPage(), disciplineDto.getRows());
        IPage<DisciplineVo> res= srmDisciplineMapper.listDiscipline(page, disciplineDto);
        //List<DiscipLineVo> records=res.getRecords();
        //List<DiscipLineVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteDiscipLine(BaseDto baseDto) {
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
    public List<CombVo> getDiscipline(String upCode,String classcode) {
        return srmDisciplineMapper.getDiscipline(upCode,classcode);
    }

    @Override
    public List<CombVo> getDisciplineNew(DisciplineDto disciplineDto) {
        return srmDisciplineMapper.getDisciplineNew(disciplineDto);
    }
}
