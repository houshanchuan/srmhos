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
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.AwardGradeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAwardGrade;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmAwardGradeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.AwardGradeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmAwardGradeService;

/**
 * <p>
 * 获奖等次 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmAwardGradeServiceImpl extends BaseServiceImpl<SrmAwardGradeMapper, SrmAwardGrade> implements SrmAwardGradeService {
    @Autowired
    private SrmAwardGradeService  srmAwardGradeService;
    @Autowired
    private SrmAwardGradeMapper srmAwardGradeMapper;
    private Long RowId;		 
    @Override
    public List<CombVo> getAwardGrade() {
        return srmAwardGradeMapper.getAwardGrade();
	}
    @Override
    @Transactional
    public Long saveOrUpdateAwardGrade(BaseDataLearningDto baseDataLearningDto) {
        List<AwardGradeDto> awardGradeDtos =baseDataLearningDto.getAwardGrades();

        List<SrmAwardGrade> awardGradeList=new ArrayList<>();
        for (AwardGradeDto awardGradeDto :awardGradeDtos) {
            SrmAwardGrade srmAwardGrade = new SrmAwardGrade();
            srmAwardGrade.setId(awardGradeDto.getRowId());
            srmAwardGrade.setCode(awardGradeDto.getCode());
            srmAwardGrade.setName(awardGradeDto.getName());
            srmAwardGrade.setIsValid(Integer.valueOf(awardGradeDto.getIsValid()));

            awardGradeList.add(srmAwardGrade);
            Long RowId = srmAwardGrade.getId();
        }
        super.saveOrUpdateBatch(awardGradeList);
        return RowId;
    }
    @Override
    public AwardGradeVo getDetailAwardGrade(Long RowId) {
        return null;
    }

    @Override
    public IPage<AwardGradeVo> listAwardGrade(AwardGradeDto awardGradeDto) {
        Page<AwardGradeVo> page = new Page<>(awardGradeDto.getPage(), awardGradeDto.getRows());
        IPage<AwardGradeVo> res= srmAwardGradeMapper.listAwardGrade(page, awardGradeDto);
        //List<AwardGradeVo> records=res.getRecords();
        //List<AwardGradeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteAwardGrade(BaseDto baseDto) {
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
