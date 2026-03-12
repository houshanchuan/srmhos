package com.mediway.hos.srm.business.center.model.entity.baseData;

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
 * 临床研究经费来源
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmClResearchFundsource对象", description="临床研究经费来源")
@TableName("srm_cl_research_fundsource")
public class SrmClResearchFundsource extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "项目DR")
    @TableField("proj_id")
    private String projId;

    @ApiModelProperty(value = "研究编号")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "研究名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "研究级别")
    @TableField("level")
    private String level;

    @ApiModelProperty(value = "涉及国际合作")
    @TableField("is_ic")
    private Integer isIc;

    @ApiModelProperty(value = "立项时间")
    @TableField("approval_date")
    private LocalDateTime approvalDate;

    @ApiModelProperty(value = "资金额度(万元)")
    @TableField("fund_amount")
    private BigDecimal fundAmount;

    @ApiModelProperty(value = "是否有效")
    @TableField("is_valid")
    private Integer isValid;


}
