package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;


import com.mediway.hos.srm.business.center.model.dto.baseData.RelyUnitDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmRelyUnit;
import com.mediway.hos.srm.business.center.model.vo.baseData.RelyUnitVo;


/**
 * <p>
 * 单位表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmRelyUnitService extends BaseService<SrmRelyUnit> {
	public List<CombVo> getRelyUnit(RelyUnitDto relyUnitDto);

    @Transactional
    Long saveOrUpdateRelyUnit(BaseDataUserDto baseDataUserDto);

    RelyUnitVo getDetailRelyUnit(Long RowId);
    IPage<RelyUnitVo> listRelyUnit(RelyUnitDto relyUnitDto);

    void deleteRelyUnit(BaseDto baseDto);

    Long getIdByName(String name);
}
