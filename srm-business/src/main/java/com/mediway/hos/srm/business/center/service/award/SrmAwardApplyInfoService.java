package com.mediway.hos.srm.business.center.service.award;

import com.mediway.hos.srm.business.center.model.dto.award.AwardApplyInfoDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.award.SrmAwardApplyInfo;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.award.AwardApplyInfoVo;

import java.util.List;

/**
 * <p>
 * 获奖申报计划 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAwardApplyInfoService extends BaseService<SrmAwardApplyInfo> {
    public Long saveAwardApplyInfo(AwardApplyInfoDto awardApplyInfoDto);
    List<AwardApplyInfoVo> listAwardApplyInfo(AwardApplyInfoDto awardApplyInfoDto);
    AwardApplyInfoVo getDetail(Long rowId);
    void deleteAwardApplyInfo(BaseDto baseDto);
}
