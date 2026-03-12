package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.AchvCatDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAchievementCat;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvCatVo;

/**
 * <p>
 * 成果分类 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAchievementCatService extends BaseService<SrmAchievementCat> {
	public List<CombVo> getAchievementCat();
    @Transactional
    Long saveOrUpdateAchvCat(BaseDataLearningDto baseDataLearningDto);

    AchvCatVo getDetailAchvCat(Long RowId);
    IPage<AchvCatVo> listAchvCat(AchvCatDto achvCatDto);

    void deleteAchvCat(BaseDto baseDto);

    Long getIdByName(String name);


}
