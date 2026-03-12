package com.mediway.hos.srm.business.center.service.common;

import com.mediway.hos.srm.business.center.model.dto.common.GridColSetDto;
import com.mediway.hos.srm.business.center.model.dto.common.GridColSetMainDto;
import com.mediway.hos.srm.business.center.model.entity.common.SrmGridcolset;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.common.GridColSetRowVo;

import java.util.List;

/**
 * <p>
 * 列设置 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-11
 */
public interface SrmGridcolsetService extends BaseService<SrmGridcolset> {
    List<GridColSetRowVo> initGridColSet(GridColSetDto gridColSetDto);
    String ifGridColSetExist(GridColSetMainDto gridColSetMainDto);

    void  saveGridColSet(GridColSetDto gridColSetDto);

    List<GridColSetRowVo> getGridColSet(GridColSetMainDto gridColSetMainDto);

    void retSetGridCol(GridColSetMainDto gridColSetMainDto);
}
