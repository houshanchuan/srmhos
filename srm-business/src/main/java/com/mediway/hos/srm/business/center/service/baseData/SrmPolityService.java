package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;



import com.mediway.hos.srm.business.center.model.dto.baseData.PolityDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPolity;
import com.mediway.hos.srm.business.center.model.vo.baseData.PolityVo;

/**
 * <p>
 * 政治面貌 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPolityService extends BaseService<SrmPolity> {
    @Transactional
    Long saveOrUpdatePolity(BaseDataUserDto baseDataUserDto);

    PolityVo getDetailPolity(Long RowId);
    IPage<PolityVo> listPolity(PolityDto polityDto);

    void deletePolity(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getPolity();
}
