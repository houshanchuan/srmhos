package com.mediway.hos.srm.business.center.controller.baseData;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectChangeItemService;

import java.util.List;

/**
 * <p>
 * 项目变更内容表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmProjectChangeItem")
@Api(tags = "项目变更内容表")
public class SrmProjectChangeItemController {
    //getProjectChangeItem
    @Autowired
    private SrmProjectChangeItemService srmProjectChangeItemService;
    @PostMapping({"/getProjectChangeItem"})
    public List<CombVo> getProjectChangeItem() {
        return srmProjectChangeItemService.getProjectChangeItem();
    }
}
