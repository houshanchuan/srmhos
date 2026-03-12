package com.mediway.hos.srm.business.center.mapper.award;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.award.AwardApplyInfoDto;
import com.mediway.hos.srm.business.center.model.entity.award.SrmAwardApplyInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.award.AwardApplyInfoVo;

import java.util.List;

/**
 * <p>
 * 获奖申报计划 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAwardApplyInfoMapper extends BaseMapper<SrmAwardApplyInfo> {
    List<AwardApplyInfoVo> listAwardApplyInfo(@Param("awardApplyInfoDto") AwardApplyInfoDto awardApplyInfoDto);
    AwardApplyInfoVo getDetail(@Param("rowId") Long rowId);
}
