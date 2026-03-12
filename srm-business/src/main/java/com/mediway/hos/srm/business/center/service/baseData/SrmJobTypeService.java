package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.JobTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmJobType;
import com.mediway.hos.srm.business.center.model.vo.baseData.JobTypeVo;

/**
 * <p>
 * 科研人员岗位性质 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmJobTypeService extends BaseService<SrmJobType> {
    @Transactional
    Long saveOrUpdateJobType(BaseDataUserDto baseDataUserDto);

    JobTypeVo getDetailJobType(Long RowId);
    IPage<JobTypeVo> listJobType(JobTypeDto jobTypeDto);

    void deleteJobType(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getJobType(JobTypeDto jobTypeDto);
}
