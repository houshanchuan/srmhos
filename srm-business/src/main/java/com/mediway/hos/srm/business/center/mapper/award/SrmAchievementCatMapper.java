package com.mediway.hos.srm.business.center.mapper.award;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;
import com.mediway.hos.srm.business.center.model.dto.baseData.AchvCatDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAchievementCat;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvCatVo;

/**
 * <p>
 * 成果分类 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAchievementCatMapper extends BaseMapper<SrmAchievementCat> {  
	List<CombVo> getAchievementCat();

    IPage<AchvCatVo> listAchvCat(@Param("page") Page<AchvCatVo> page, @Param("achvCatDto") AchvCatDto achvCatDto);
}
