package com.mediway.hos.srm.business.center.model.dto.baseData;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class BaseListDto {
    @TableField(exist = false)
    private String q;
    @TableField(exist = false)
    private Integer current;
    @TableField(exist = false)
    private Integer size;
}
