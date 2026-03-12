package com.mediway.hos.srm.business.center.model.entity.achvTransformation;

import com.baomidou.mybatisplus.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 成果转化申请表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmAchvTransformation对象", description="成果转化申请表")
@TableName("srm_achv_transformation")
public class SrmAchvTransformation extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "转化编号")
    @TableField("transform_no")
    private String transformNo;

    @ApiModelProperty(value = "转化描述")
    @TableField("transform_desc")
    private String transformDesc;

    @ApiModelProperty(value = "系统业务号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "科室")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty(value = "年度")
    @TableField("year")
    private String year;

    @ApiModelProperty(value = "成果DR")
    @TableField("achievement")
    private String achievement;

    @ApiModelProperty(value = "来源项目")
    @TableField("source_proj")
    private String sourceProj;

    @ApiModelProperty(value = "来源项目名称")
    @TableField("source_proj_name")
    private String sourceProjName;

    @ApiModelProperty(value = "来源专利")
    @TableField("source_patent")
    private String sourcePatent;

    @ApiModelProperty(value = "来源专利名称")
    @TableField("source_patent_name")
    private String sourcePatentName;

    @ApiModelProperty(value = "转化类型")
    @TableField("transform_type")
    private String transformType;

    @ApiModelProperty(value = "协议（合同）类型")
    @TableField("agr_type")
    private String agrType;

    @ApiModelProperty(value = "协议（合同）号")
    @TableField("agr_no")
    private String agrNo;

    @ApiModelProperty(value = "协议（合同）日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="agr_date")
    private LocalDateTime agrDate;

    @ApiModelProperty(value = "协议生效日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="agr_start_date")
    private LocalDateTime agrStartDate;

    @ApiModelProperty(value = "协议终止日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="agr_end_date")
    private LocalDateTime agrEndDate;

    @ApiModelProperty(value = "转让（许可）费用")
    @TableField("fee_amt")
    private BigDecimal feeAmt;

    @ApiModelProperty(value = "费用支付方式")
    @TableField("pay_mode")
    private String payMode;

    @ApiModelProperty(value = "成果方出资占比")
    @TableField("achv_unit_prop")
    private BigDecimal achvUnitProp;

    @ApiModelProperty(value = "合作方出资占比")
    @TableField("partner_unit_prop")
    private BigDecimal partnerUnitProp;

    @ApiModelProperty(value = "转化物")
    @TableField("transformants")
    private String transformants;

    @ApiModelProperty(value = "成果单位")
    @TableField("achv_unit")
    private String achvUnit;

    @ApiModelProperty(value = "成果单位地址")
    @TableField("achv_addr")
    private String achvAddr;

    @ApiModelProperty(value = "成果单位邮编")
    @TableField("achv_post_code")
    private String achvPostCode;

    @ApiModelProperty(value = "成果负责人")
    @TableField("achv_head")
    private String achvHead;

    @ApiModelProperty(value = "成果负责人电话")
    @TableField("achv_headtel")
    private String achvHeadtel;

    @ApiModelProperty(value = "合作单位（公司，单位，）")
    @TableField("partner_unit")
    private String partnerUnit;

    @ApiModelProperty(value = "合作单位地址")
    @TableField("partner_unit_addr")
    private String partnerUnitAddr;

    @ApiModelProperty(value = "合作单位邮编")
    @TableField("partner_unit_postcode")
    private String partnerUnitPostcode;

    @ApiModelProperty(value = "合作单位电话")
    @TableField("partner_unit_tel")
    private String partnerUnitTel;

    @ApiModelProperty(value = "代理人姓名")
    @TableField("agent_name")
    private String agentName;

    @ApiModelProperty(value = "代理机构")
    @TableField("agent_unit")
    private String agentUnit;

    @ApiModelProperty(value = "代理机构电话")
    @TableField("agent_unit_tel")
    private String agentUnitTel;

    @ApiModelProperty(value = "代理机构地址")
    @TableField("agent_unit_addr")
    private String agentUnitAddr;

    @ApiModelProperty(value = "代理人邮编")
    @TableField("agent_unit_postcode")
    private String agentUnitPostcode;

    @ApiModelProperty(value = "创建日期")
    @TableField("create_date")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "?创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "?创建人")
    @TableField("create_user_id")
    private String createUserId;

    @ApiModelProperty(value = "提交人")
    @TableField("sub_user_id")
    private String subUserId;

    @ApiModelProperty(value = "提交日期")
    @TableField("sub_date")
    private LocalDateTime subDate;

    @ApiModelProperty(value = "提交时间")
    @TableField("sub_time")
    private LocalDateTime subTime;

    @ApiModelProperty(value = "提交状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "审核状态")
    @TableField("chk_status")
    private String chkStatus;

    @ApiModelProperty(value = "最后审批人")
    @TableField("chk_user_id")
    private String chkUserId;

    @ApiModelProperty(value = "最后审批日期")
    @TableField("chk_date")
    private LocalDateTime chkDate;

    @ApiModelProperty(value = "最后审批时间")
    @TableField("chk_time")
    private LocalDateTime chkTime;

    @ApiModelProperty(value = "最后审核描述")
    @TableField("chk_desc")
    private String chkDesc;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;


}
