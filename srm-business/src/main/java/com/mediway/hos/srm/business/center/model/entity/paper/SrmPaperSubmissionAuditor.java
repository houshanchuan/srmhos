package com.mediway.hos.srm.business.center.model.entity.paper;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * 论文投稿评审专家表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmPaperSubmissionAuditor对象", description="成果评审专家表")
@TableName("srm_paper_submission_auditor")
public class SrmPaperSubmissionAuditor extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId  ")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "系统号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "业务ID")
    @TableField("app_rowId")
    private Long appRowId;

    @ApiModelProperty(value = "专业审批专家")
    @TableField("expert_list")
    private String expertList;

    @ApiModelProperty(value = "伦理审批专家")
    @TableField("ethic_expert_list")
    private String ethicExpertList;

    @ApiModelProperty(value = "期刊类型")
    @TableField("journal_type")
    private String journalType;


}
