package com.mediway.hos.srm.business.center.model.entity.paper;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
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
 * 论文收录表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmPaperEmbody对象", description="论文收录表")
@TableName("srm_paper_embody")
public class SrmPaperEmbody extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "论文id")
    @TableField("paper_id")
    private Long paperId;

    @ApiModelProperty(value = "收录名称")
    @TableField("embody_id")
    private String embodyId;

    @ApiModelProperty(value = "收录时间")
    @TableField("embody_date")
    private String embodyDate;

    @ApiModelProperty(value = "附件材料证明")
    @TableField("file_id")
    private String fileId;

    @ApiModelProperty(value = "影响因子")
    @TableField("impact_factor")
    private BigDecimal impactFactor;

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
