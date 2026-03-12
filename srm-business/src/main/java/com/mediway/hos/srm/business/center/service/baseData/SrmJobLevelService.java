package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.JobLevelDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmJobLevel;
import com.mediway.hos.srm.business.center.model.vo.baseData.JobLevelVo;

/**
 * <p>
 * 科研人员岗位层级 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmJobLevelService extends BaseService<SrmJobLevel> {
    @Transactional
    Long saveOrUpdateJobLevel(BaseDataUserDto baseDataUserDto);

    JobLevelVo getDetailJobLevel(Long RowId);
    IPage<JobLevelVo> listJobLevel(JobLevelDto jobLevelDto);

    void deleteJobLevel(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getJobLevel();


}
