package com.mediway.hos.srm.business.center.model.dto.baseData;


import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

@Data
public class DisciplineDto extends BasePO {
    private Long rowId;
    private String code;
    private String name;
    private Integer isValid;
    private String classCode;
    private String upCode;
    private String queryName;
    //
    private int page;
    private int rows;
    private int limit;
}
