package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.TeacherTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.TeacherTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmTeacherType;

/**
 * <p>
 * 教师类型代码 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmTeacherTypeService extends BaseService<SrmTeacherType> {

    @Transactional
    Long saveOrUpdateTeacherType(BaseDataUserDto baseDataUserDto);

    TeacherTypeVo getDetailTeacherType(Long RowId);
    IPage<TeacherTypeVo> listTeacherType(TeacherTypeDto teacherTypeDto);

    void deleteTeacherType(BaseDto baseDto);

    Long getIdByName(String name);
}
