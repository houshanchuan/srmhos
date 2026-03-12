package com.mediway.hos.srm.business.center.model.entity.baseData;

import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 项目合作单位表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmProjectCooperatives对象", description="项目合作单位表")
@TableName("srm_project_cooperatives")
public class SrmProjectCooperatives extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "项目ID")
    @TableField("proj_id")
    private Long projId;

    @ApiModelProperty(value = "项目依托单位或项目合作单位ID")
    @TableField("comp_id")
    private String compId;

    @ApiModelProperty(value = "项目分工")
    @TableField("divide_work")
    private String divideWork;

    @ApiModelProperty(value = "项目经费")
    @TableField("fund_total_amt")
    private BigDecimal fundTotalAmt;

    @ApiModelProperty(value = "上级资助经费")
    @TableField("fund_gov_amt")
    private BigDecimal fundGovAmt;

    @ApiModelProperty(value = "合作单位性质")
    @TableField("coop_unit_type")
    private String coopUnitType;

    @ApiModelProperty(value = "合作单位名称")
    @TableField("coop_unit_name")
    private String coopUnitName;

    @ApiModelProperty(value = "附件文件id")
    @TableField("file_id")
    private String fileId;

    @ApiModelProperty(value = "附件文件名称")
    @TableField("file_name")
    private String fileName;

    @ApiModelProperty(value = "联系人")
    @TableField("contact_name")
    private String contactName;

    @ApiModelProperty(value = "联系人电话")
    @TableField("contact_tel")
    private String contactTel;
}
