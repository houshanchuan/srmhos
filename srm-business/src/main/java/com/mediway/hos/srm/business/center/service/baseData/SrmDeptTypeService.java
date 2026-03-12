package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.DeptTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmDeptType;
import com.mediway.hos.srm.business.center.model.vo.baseData.DeptTypeVo;
/**
 * <p>
 * 部门类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmDeptTypeService extends BaseService<SrmDeptType> {

    @Transactional
    Long saveOrUpdateDeptType(BaseDataUserDto baseDataUserDto);

    DeptTypeVo getDetailDeptType(Long RowId);
    IPage<DeptTypeVo> listDeptType(DeptTypeDto deptTypeDto);

    void deleteDeptType(BaseDto baseDto);

    Long getIdByName(String name);
}
