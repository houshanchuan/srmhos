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

import com.mediway.hos.srm.business.center.model.dto.baseData.LectureLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.LectureLevelVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmLectureLevel;
import com.mediway.hos.srm.business.center.service.baseData.SrmLectureLevelService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmLectureLevelMapper;


/**
 * <p>
 * 讲座级别 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmLectureLevelServiceImpl extends BaseServiceImpl<SrmLectureLevelMapper, SrmLectureLevel> implements SrmLectureLevelService {

    @Autowired
    private SrmLectureLevelMapper srmLectureLevelMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateLectureLevel(BaseDataLearningDto baseDataLearningDto) {
        List<LectureLevelDto> lectureLevelDtos =baseDataLearningDto.getLectureLevels();

        List<SrmLectureLevel> lectureLevelList=new ArrayList<>();
        for (LectureLevelDto lectureLevelDto :lectureLevelDtos) {
            SrmLectureLevel srmLectureLevel = new SrmLectureLevel();
            srmLectureLevel.setId(lectureLevelDto.getRowId());
            srmLectureLevel.setCode(lectureLevelDto.getCode());
            srmLectureLevel.setName(lectureLevelDto.getName());
            srmLectureLevel.setIsValid(lectureLevelDto.getIsValid());

            lectureLevelList.add(srmLectureLevel);
            Long RowId = srmLectureLevel.getId();
        }
        super.saveOrUpdateBatch(lectureLevelList);
        return RowId;
    }
    @Override
    public LectureLevelVo getDetailLectureLevel(Long RowId) {
        return null;
    }

    @Override
    public IPage<LectureLevelVo> listLectureLevel(LectureLevelDto lectureLevelDto) {
        Page<LectureLevelVo> page = new Page<>(lectureLevelDto.getPage(),lectureLevelDto.getRows());
        IPage<LectureLevelVo> res= srmLectureLevelMapper.listLectureLevel(page,lectureLevelDto);
        return res;
    }

    @Override
    public void deleteLectureLevel(BaseDto baseDto) {
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
    public List<CombVo> getLectureLevel() {
        return srmLectureLevelMapper.getLectureLevel();
    }

}
