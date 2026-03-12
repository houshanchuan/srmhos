package com.mediway.hos.srm.business.center.model.entity.baseData;

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
 * 项目相关的人类遗传资源表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmProjHumanGeneRes对象", description="项目相关的人类遗传资源表")
@TableName("srm_proj_human_gene_res")
public class SrmProjHumanGeneRes extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "项目DR")
    @TableField("soli_proj_id")
    private String soliProjId;

    @ApiModelProperty(value = "是否涉及外方单位yn")
    @TableField("rela_frn_comp_flag")
    private String relaFrnCompFlag;

    @ApiModelProperty(value = "涉及外方单位名称")
    @TableField("rela_frn_comp_name")
    private String relaFrnCompName;

    @ApiModelProperty(value = "涉及外方单位国别")
    @TableField("rela_frn_comp_nation")
    private String relaFrnCompNation;

    @ApiModelProperty(value = "是否涉及外籍个人yn")
    @TableField("is_rela_frn_person")
    private Integer isRelaFrnPerson;

    @ApiModelProperty(value = "涉及外籍个人信息（姓名/国别/公司/职务）")
    @TableField("rela_frn_person_info")
    private String relaFrnPersonInfo;

    @ApiModelProperty(value = "申报原因")
    @TableField("apply_reason")
    private String applyReason;

    @ApiModelProperty(value = "申报账号选择方")
    @TableField("apply_acct_comp")
    private String applyAcctComp;

    @ApiModelProperty(value = "申报主体单位")
    @TableField("apply_main_comp")
    private String applyMainComp;

    @ApiModelProperty(value = "是否有涉及样本出境yn")
    @TableField("sample_exit_flag")
    private String sampleExitFlag;

    @ApiModelProperty(value = "出境样本类型")
    @TableField("sample_exit_type")
    private String sampleExitType;

    @ApiModelProperty(value = "样本出境地")
    @TableField("sample_exit_place")
    private String sampleExitPlace;

    @ApiModelProperty(value = "样本出境单位")
    @TableField("sample_exit_dept_name")
    private String sampleExitDeptName;

    @ApiModelProperty(value = "是否有涉及数据出境yn")
    @TableField("is_data_exit")
    private Integer isDataExit;

    @ApiModelProperty(value = "数据出境地")
    @TableField("data_exit_place")
    private String dataExitPlace;

    @ApiModelProperty(value = "数据出境单位")
    @TableField("data_exit_dept_name")
    private String dataExitDeptName;

    @ApiModelProperty(value = "未经审批或超出审批范围采集yn")
    @TableField("no_audit_flag")
    private String noAuditFlag;

    @ApiModelProperty(value = "申办方联系人")
    @TableField("contact_person")
    private String contactPerson;

    @ApiModelProperty(value = "联系人电话")
    @TableField("contact_tel")
    private String contactTel;


}
