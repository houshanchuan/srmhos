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

import com.mediway.hos.srm.business.center.model.dto.baseData.TeacherTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.TeacherTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmTeacherType;
import com.mediway.hos.srm.business.center.service.baseData.SrmTeacherTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmTeacherTypeMapper;

/**
 * <p>
 * 教师类型代码 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmTeacherTypeServiceImpl extends BaseServiceImpl<SrmTeacherTypeMapper, SrmTeacherType> implements SrmTeacherTypeService {

    @Autowired
    private SrmTeacherTypeMapper srmTeacherTypeMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateTeacherType(BaseDataUserDto baseDataUserDto) {
        List<TeacherTypeDto> teacherTypeDtos =baseDataUserDto.getTeacherTypes();

        List<SrmTeacherType> teacherTypeList=new ArrayList<>();
        for (TeacherTypeDto teacherTypeDto :teacherTypeDtos) {
            SrmTeacherType teacherType = new SrmTeacherType();
            teacherType.setId(teacherTypeDto.getRowId());
            if(ObjectUtil.isEmpty(teacherTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_TEACHER_TYPE, 1, "");
                teacherType.setCode(code);
            }else{
                teacherType.setCode(teacherTypeDto.getCode());
            }
            teacherType.setName(teacherTypeDto.getName());
            teacherType.setIsValid(teacherTypeDto.getIsValid());

            teacherTypeList.add(teacherType);
            Long RowId = teacherType.getId();
        }
        super.saveOrUpdateBatch(teacherTypeList);
        return RowId;
    }
    @Override
    public TeacherTypeVo getDetailTeacherType(Long RowId) {
        return null;
    }

    @Override
    public IPage<TeacherTypeVo> listTeacherType(TeacherTypeDto teacherTypeDto) {
        Page<TeacherTypeVo> page = new Page<>(teacherTypeDto.getPage(),teacherTypeDto.getRows());
        IPage<TeacherTypeVo> res= srmTeacherTypeMapper.listTeacherType(page,teacherTypeDto);
        //List<TeacherTypeVo> records=res.getRecords();
        //List<TeacherTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteTeacherType(BaseDto baseDto) {
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
