package com.mediway.hos.srm.business.center.service.patent;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentInfoDto;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentInfoMainDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentInfoVo;
import com.mediway.hos.srm.business.center.model.vo.baseData.UnitPeronVo;

import com.mediway.hos.srm.business.center.model.entity.patent.SrmPatentInfo;
import com.mediway.hos.srm.business.base.service.BaseService;


import java.util.List;

/**
 * <p>
 * 专利信息表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPatentInfoService extends BaseService<SrmPatentInfo> {
    Long savePatentInfo(PatentInfoMainDto patentInfoMainDto);
    PatentInfoVo getDetail(Long rowId);
    IPage<PatentInfoVo> listPatentInfo(PatentInfoDto patentInfoDto);

    void deletePatentInfo(BaseDto baseDto);
    void subMit(BaseDto baseDto);

    void audit(BaseDto baseDto);
    IPage<PatentInfoVo> listAuditPatentInfo(PatentInfoDto patentInfoDto);
    List<CombVo> getPatentApply(String userCode);
    List<UnitPeronVo> listPatentee(Long rowId);
    void deletePatentee(String rowIdStr);
    List<CombVo> getPatentInfo(String userCode);

}
