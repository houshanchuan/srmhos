package com.mediway.hos.srm.business.center.mapper.common;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.common.GridColSetMainDto;
import com.mediway.hos.srm.business.center.model.entity.common.SrmGridcolset;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.common.GridColSetRowVo;

import java.util.List;

/**
 * <p>
 * 列设置 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-11
 */
public interface SrmGridcolsetMapper extends BaseMapper<SrmGridcolset> {
   String ifGridColSetExist(@Param("gridColSetMainDto") GridColSetMainDto gridColSetMainDto);
   List<GridColSetRowVo> getGridColSet(@Param("gridColSetMainDto") GridColSetMainDto gridColSetMainDto);

   void retSetGridCol(@Param("gridColSetMainDto") GridColSetMainDto gridColSetMainDto);
}
