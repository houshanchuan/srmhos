package com.mediway.hos.srm.business.center.service.achvTransformation;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.achvTransformation.AchvTransformationDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import com.mediway.hos.srm.business.center.model.entity.achvTransformation.SrmAchvTransformation;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.achvTransformation.AchvTransformationVo;


/**
 * <p>
 * 成果转化申请表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAchvTransformationService extends BaseService<SrmAchvTransformation> {
    AchvTransformationVo getDetail(String rowId);
    Long saveAchvTransformation(AchvTransformationDto achvTransformationDto);

    IPage<AchvTransformationVo> listAchvTransformation(AchvTransformationDto achvTransformationDto);

    void deleteAchvTransformation(BaseDto baseDto);
    void subMit(BaseDto baseDto);

    void audit(BaseDto baseDto);
    IPage<AchvTransformationVo> listAuditAchvTransformation(AchvTransformationDto achvTransformationDto);
}
