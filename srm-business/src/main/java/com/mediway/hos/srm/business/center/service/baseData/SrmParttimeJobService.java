package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.dto.baseData.ParttimeJobDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmParttimeJob;
import com.mediway.hos.srm.business.center.model.vo.baseData.ParttimeJobVo;

/**
 * <p>
 * 兼职职位表(职务类型) 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmParttimeJobService extends BaseService<SrmParttimeJob> {

    @Transactional
    Long saveOrUpdateParttimeJob(BaseDataUserDto baseDataUserDto);

    ParttimeJobVo getDetailParttimeJob(Long RowId);
    IPage<ParttimeJobVo> listParttimeJob(ParttimeJobDto parttimeJobDto);

    void deleteParttimeJob(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getPartTimeJob(ParttimeJobDto parttimeJobDto);
}
