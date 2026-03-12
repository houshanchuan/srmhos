package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.PersonStateDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPersonState;
import com.mediway.hos.srm.business.center.model.vo.baseData.PersonStateVo;

/**
 * <p>
 * 人员状态表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPersonStateMapper extends BaseMapper<SrmPersonState> {
    IPage<PersonStateVo> listPersonState(@Param("page") Page<PersonStateVo> page, @Param("personStateDto") PersonStateDto personStateDto);

    List<CombVo> getPersonState();
}
