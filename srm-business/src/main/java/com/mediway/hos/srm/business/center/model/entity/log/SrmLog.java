package com.mediway.hos.srm.business.center.model.entity.log;

import cn.hutool.json.JSONArray;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.mediway.hos.i18n.annotation.HosI18nAutoTrans;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@ApiModel(
        value = "科研系统日志对象",
        description = ""
)
@TableName(
        value = "ct_srm_log",
        autoResultMap = true
)
@Data
public class SrmLog extends BasePO {

    @TableId(value = "ID", type = IdType.AUTO)
    private long id;
    @ApiModelProperty("业务的名称")
    @TableField("title")
    private String title;
    @ApiModelProperty("实体名称")
    @TableField("method_name")
    private String methodName;
    @ApiModelProperty("实体类名")
    @TableField("entity_code")
    private String entityCode;
    @ApiModelProperty("实体表名")
    @TableField("table_name")
    private String tableName;
    @ApiModelProperty("操作类型")
    @TableField("type")
    private String type;
    @ApiModelProperty("业务id")
    @TableField("bussiness_id")
    private String bussinessId;

    @ApiModelProperty("IP")
    @TableField("ip")
    private String ip;
    @ApiModelProperty("服务IP")
    @TableField("device_type")
    private String deviceType;

    @ApiModelProperty("差异数据")
    private String difData;
    @ApiModelProperty("创建人主键")
    @TableField("create_by")
    private String createBy;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;


}
