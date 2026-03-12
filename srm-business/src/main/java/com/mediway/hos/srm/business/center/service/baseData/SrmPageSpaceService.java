package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.PageSpaceDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPageSpace;
import com.mediway.hos.srm.business.center.model.vo.baseData.PageSpaceVo;
/**
 * <p>
 * 版面 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPageSpaceService extends BaseService<SrmPageSpace> {
    @Transactional
    Long saveOrUpdatePageSpace(BaseDataLearningDto baseDataLearningDto);

    PageSpaceVo getDetailPageSpace(Long RowId);
    IPage<PageSpaceVo> listPageSpace(PageSpaceDto pageSpaceDto);

    void deletePageSpace(BaseDto baseDto);

    Long getIdByName(String name);
    public List<CombVo> getPageSpace(PageSpaceDto pageSpaceDto);
}
