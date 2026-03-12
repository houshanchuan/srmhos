package com.mediway.hos.srm.business.center.model.entity.paper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 论文转载表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmPaperReship对象", description="论文转载表")
@TableName("srm_paper_reship")
public class SrmPaperReship extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "论文编号")
    @TableField("paper_id")
    private Long paperId;

    @ApiModelProperty(value = "转载名称")
    @TableField("reship_id")
    private String reshipId;

    @ApiModelProperty(value = "转载方式")
    @TableField("reship_type")
    private String reshipType;

    @ApiModelProperty(value = "转载时间")
    @TableField("reship_date")
    private String reshipDate;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "创建人编号")
    @TableField("creator_code")
    private String creatorCode;

    @ApiModelProperty(value = "创建人ID")
    @TableField("creator_id")
    private String creatorId;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;


}
