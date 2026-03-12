package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.dto.baseData.PatentStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PatentStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPatentState;

/**
 * <p>
 * 专利状态 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPatentStateService extends BaseService<SrmPatentState> {
    public List<CombVo>  getPatentState();
    @Transactional
    Long saveOrUpdatePatentState(BaseDataCommonDto baseDataProjDto);

    PatentStateVo getDetailPatentState(Long RowId);
    IPage<PatentStateVo> listPatentState(PatentStateDto patentStateDto);

    void deletePatentState(BaseDto baseDto);

    Long getIdByName(String name);
}
