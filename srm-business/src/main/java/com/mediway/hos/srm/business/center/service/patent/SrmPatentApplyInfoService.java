package com.mediway.hos.srm.business.center.service.patent;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentApplyInfoDto;
import com.mediway.hos.srm.business.center.model.entity.patent.SrmPatentApplyInfo;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentApplyInfoVo;

/**
 * <p>
 * 专利申报批次 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPatentApplyInfoService extends BaseService<SrmPatentApplyInfo> {
    Long savePatentApplyInfo(PatentApplyInfoDto patentApplyInfoDto);
    PatentApplyInfoVo getDetail(Long rowId);
    IPage<PatentApplyInfoVo> listPatentApplyInfo(PatentApplyInfoDto patentApplyInfoDto);
    void delete(Long rowId);
}
