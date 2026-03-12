package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;


import com.mediway.hos.srm.business.center.model.dto.baseData.AchvTransAgreementTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAchvTransAgreementType;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvTransAgreementTypeVo;
/**
 * <p>
 * 转化协议类型表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-01
 */
public interface SrmAchvTransAgreementTypeMapper extends BaseMapper<SrmAchvTransAgreementType> {
    IPage<AchvTransAgreementTypeVo> listAchvTransAgreementType(@Param("page") Page<AchvTransAgreementTypeVo> page, @Param("achvTransAgreementTypeDto") AchvTransAgreementTypeDto achvTransAgreementTypeDto);
    List<CombVo> getAchvTransAgreementType();
}
