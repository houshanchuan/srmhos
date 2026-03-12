package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
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

import com.mediway.hos.srm.business.center.model.dto.baseData.LectureTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.LectureTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmLectureType;
import com.mediway.hos.srm.business.center.service.baseData.SrmLectureTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmLectureTypeMapper;

/**
 * <p>
 * 讲座类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmLectureTypeServiceImpl extends BaseServiceImpl<SrmLectureTypeMapper, SrmLectureType> implements SrmLectureTypeService {

    @Autowired
    private SrmLectureTypeMapper srmLectureTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateLectureType(BaseDataLearningDto baseDataLearningDto) {
        List<LectureTypeDto> lectureTypeDtos =baseDataLearningDto.getLectureTypes();

        List<SrmLectureType> lectureTypeList=new ArrayList<>();
        for (LectureTypeDto lectureTypeDto :lectureTypeDtos) {
            SrmLectureType srmLectureType = new SrmLectureType();
            srmLectureType.setId(lectureTypeDto.getRowId());
            srmLectureType.setCode(lectureTypeDto.getCode());
            srmLectureType.setName(lectureTypeDto.getName());
            srmLectureType.setIsValid(lectureTypeDto.getIsValid());

            lectureTypeList.add(srmLectureType);
            Long RowId = srmLectureType.getId();
        }
        super.saveOrUpdateBatch(lectureTypeList);
        return RowId;
    }
    @Override
    public LectureTypeVo getDetailLectureType(Long RowId) {
        return null;
    }

    @Override
    public IPage<LectureTypeVo> listLectureType(LectureTypeDto lectureTypeDto) {
        Page<LectureTypeVo> page = new Page<>(lectureTypeDto.getPage(),lectureTypeDto.getRows());
        IPage<LectureTypeVo> res= srmLectureTypeMapper.listLectureType(page,lectureTypeDto);
        return res;
    }

    @Override
    public void deleteLectureType(BaseDto baseDto) {
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

    @Override
    public List<CombVo> getLectureType() {
        return srmLectureTypeMapper.getLectureType();
    }
}
