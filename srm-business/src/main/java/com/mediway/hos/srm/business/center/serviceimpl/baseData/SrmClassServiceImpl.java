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

import com.mediway.hos.srm.business.center.model.dto.baseData.SubjectClassDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmClass;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmClassMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.SubjectClassVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmClassService;

/**
 * <p>
 * 学科门类 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-25
 */
@Service
public class SrmClassServiceImpl extends BaseServiceImpl<SrmClassMapper, SrmClass> implements SrmClassService {
    @Autowired
    private SrmClassService  srmClassService;
    @Autowired
    private SrmClassMapper srmClassMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateSubjectClass(BaseDataLearningDto baseDataLearningDto) {
        List<SubjectClassDto> subjectClassDtos =baseDataLearningDto.getSubjectClasss();
        List<SrmClass> subjectClassList=new ArrayList<>();
        for (SubjectClassDto subjectClassDto :subjectClassDtos) {
            SrmClass srmSubjectClass = new SrmClass();
            srmSubjectClass.setId(subjectClassDto.getRowId());
            srmSubjectClass.setCode(subjectClassDto.getCode());
            srmSubjectClass.setName(subjectClassDto.getName());
            srmSubjectClass.setIsValid(Integer.valueOf(subjectClassDto.getIsValid()));

            subjectClassList.add(srmSubjectClass);
            Long RowId = srmSubjectClass.getId();
        }
        super.saveOrUpdateBatch(subjectClassList);
        return RowId;
    }
    @Override
    public SubjectClassVo getDetailSubjectClass(Long RowId) {
        return null;
    }

    @Override
    public IPage<SubjectClassVo> listSubjectClass(SubjectClassDto subjectClassDto) {
        Page<SubjectClassVo> page = new Page<>(subjectClassDto.getPage(), subjectClassDto.getRows());
        IPage<SubjectClassVo> res= srmClassMapper.listSubjectClass(page, subjectClassDto);
        //List<SubjectClassVo> records=res.getRecords();
        //List<SubjectClassVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteSubjectClass(BaseDto baseDto) {
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
    public List<CombVo> getSubjectClass() {
        return srmClassMapper.getSubjectClass();
    }
}
