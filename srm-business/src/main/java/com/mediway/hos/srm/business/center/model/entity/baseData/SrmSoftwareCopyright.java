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
 * 软著信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmSoftwareCopyright对象", description="软著信息表")
@TableName("srm_software_copyright")
public class SrmSoftwareCopyright extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "软著名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "申请科室")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty(value = "著作权人")
    @TableField("copyright_owner")
    private String copyrightOwner;

    @ApiModelProperty(value = "首次发表日期")
    @TableField("first_pub_date")
    private LocalDateTime firstPubDate;

    @ApiModelProperty(value = "开发完成日期")
    @TableField("complete_date")
    private LocalDateTime completeDate;

    @ApiModelProperty(value = "登记号")
    @TableField("register_no")
    private String registerNo;

    @ApiModelProperty(value = "获颁时间")
    @TableField("issue_date")
    private LocalDateTime issueDate;

    @ApiModelProperty(value = "获得方式")
    @TableField("acqui_mode")
    private String acquiMode;

    @ApiModelProperty(value = "权利范围")
    @TableField("scope")
    private String scope;

    @ApiModelProperty(value = "证书号")
    @TableField("certificate_no")
    private String certificateNo;

    @ApiModelProperty(value = "申请人")
    @TableField("sub_user_id")
    private String subUserId;

    @ApiModelProperty(value = "申请时间")
    @TableField("sub_date")
    private LocalDateTime subDate;

    @ApiModelProperty(value = "数据状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "系统号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "年度")
    @TableField("year")
    private String year;

    @ApiModelProperty(value = "类型")
    @TableField("biz_type")
    private String bizType;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "奖励日期")
    @TableField("reward_date")
    private LocalDateTime rewardDate;

    @ApiModelProperty(value = "奖励金额")
    @TableField("reward_amount")
    private BigDecimal rewardAmount;

    @ApiModelProperty(value = "货币种类")
    @TableField("currency")
    private String currency;

    @ApiModelProperty(value = "审核状态")
    @TableField("chk_status")
    private String chkStatus;

    @ApiModelProperty(value = "审核人")
    @TableField("chk_user_id")
    private String chkUserId;

    @ApiModelProperty(value = "审核日期")
    @TableField("chk_date")
    private LocalDateTime chkDate;

    @ApiModelProperty(value = "审核时间")
    @TableField("chk_time")
    private LocalDateTime chkTime;

    @ApiModelProperty(value = "依托项目")
    @TableField("proj_id")
    private String projId;

    @ApiModelProperty(value = "本单位位次")
    @TableField("our_ranking")
    private String ourRanking;

    @ApiModelProperty(value = "著作权编号")
    @TableField("copyright_no")
    private String copyrightNo;

    @ApiModelProperty(value = "所属二级单位")
    @TableField("division_code")
    private String divisionCode;

    @ApiModelProperty(value = "学科门类")
    @TableField("classCode")
    private String classCode;

    @ApiModelProperty(value = "一级学科")
    @TableField("discipline")
    private String discipline;

    @ApiModelProperty(value = "医院署名")
    @TableField("school_sign")
    private String schoolSign;

    @ApiModelProperty(value = "著作权类型")
    @TableField("copyright_type")
    private String copyrightType;

    @ApiModelProperty(value = "成员人数")
    @TableField("author_num")
    private Integer authorNum;

    @ApiModelProperty(value = "创建人编号")
    @TableField("subuser_code")
    private String subuserCode;

    @ApiModelProperty(value = "创建人名称")
    @TableField("subuser_name")
    private String subuserName;

    @ApiModelProperty(value = "操作时间")
    @TableField("operate_time")
    private LocalDateTime operateTime;

    @ApiModelProperty(value = "第一作者编号")
    @TableField("in_fauthor_id")
    private String inFauthorId;

    @ApiModelProperty(value = "院内第一作者编号")
    @TableField("in_fauthor_code")
    private String inFauthorCode;

    @ApiModelProperty(value = "第一作者类型（本院，外院）")
    @TableField("fauthor_type")
    private String fauthorType;

    @ApiModelProperty(value = "第一作者姓名")
    @TableField("fauthor_name")
    private String fauthorName;

    @ApiModelProperty(value = "外部ID")
    @TableField("out_id")
    private String outId;

    @ApiModelProperty(value = "FileIds")
    @TableField("file_ids")
    private String fileIds;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "二级学科")
    @TableField("discipline_two")
    private String disciplineTwo;

    @ApiModelProperty(value = "一级学科")
    @TableField("discipline_three")
    private String disciplineThree;


}
