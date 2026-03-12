package com.mediway.hos.srm.business.center.model.entity.academic;

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
 * 学术会议表(主办)
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmAcConferenceHost对象", description="学术会议表(主办)")
@TableName("srm_ac_conference_host")
public class SrmAcConferenceHost extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "会议编号(自动生成)")
    @TableField("no")
    private String no;

    @ApiModelProperty(value = "会议类型")
    @TableField("conference_type")
    private String conferenceType;

    @ApiModelProperty(value = "会议名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "年度")
    @TableField("year")
    private String year;

    @ApiModelProperty(value = "方向")
    @TableField("direction")
    private String direction;

    @ApiModelProperty(value = "主题")
    @TableField("subject")
    private String subject;

    @ApiModelProperty(value = "预计人数")
    @TableField("number_of_people")
    private Integer numberOfPeople;

    @ApiModelProperty(value = "资金预算")
    @TableField("budget_funds_amt")
    private BigDecimal budgetFundsAmt;

    @ApiModelProperty(value = "会议形式")
    @TableField("conference_form")
    private String conferenceForm;

    @ApiModelProperty(value = "会议线上URL")
    @TableField("online_url")
    private String onlineUrl;

    @ApiModelProperty(value = "开幕日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="open_date")
    private LocalDateTime openDate;

    @ApiModelProperty(value = "开幕时间")
    @TableField("open_time")
    private LocalDateTime openTime;

    @ApiModelProperty(value = "闭幕日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="close_date")
    private LocalDateTime closeDate;

    @ApiModelProperty(value = "闭幕时间")
    @TableField("close_time")
    private LocalDateTime closeTime;

    @ApiModelProperty(value = "举办城市")
    @TableField("city")
    private String city;

    @ApiModelProperty(value = "举办地点")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "主办协办")
    @TableField("host_type")
    private Integer hostType;

    @ApiModelProperty(value = "是否收费")
    @TableField("is_charge")
    private Integer isCharge;

    @ApiModelProperty(value = "支持缴费方式")
    @TableField("charge_manner")
    private String chargeManner;

    @ApiModelProperty(value = "缴费银行")
    @TableField("charge_bank")
    private String chargeBank;

    @ApiModelProperty(value = "缴费账号")
    @TableField("charge_account")
    private String chargeAccount;

    @ApiModelProperty(value = "缴费说明")
    @TableField("charge_remark")
    private String chargeRemark;

    @ApiModelProperty(value = "报名开始日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="register_start_date")
    private LocalDateTime registerStartDate;

    @ApiModelProperty(value = "报名截止日期")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="register_end_date")
    private LocalDateTime registerEndDate;

    @ApiModelProperty(value = "支持报名方式")
    @TableField("register_manner")
    private String registerManner;

    @ApiModelProperty(value = "报名网站地址")
    @TableField("register_url")
    private String registerUrl;

    @ApiModelProperty(value = "报名费用")
    @TableField("register_fee_amt")
    private BigDecimal registerFeeAmt;

    @ApiModelProperty(value = "报名费用备注")
    @TableField("reg_fee_remark")
    private String regFeeRemark;

    @ApiModelProperty(value = "是否提供发票")
    @TableField("fapiao_supplied")
    private String fapiaoSupplied;

    @ApiModelProperty(value = "联系人")
    @TableField("contact_person")
    private String contactPerson;

    @ApiModelProperty(value = "联系人地址")
    @TableField("contact_address")
    private String contactAddress;

    @ApiModelProperty(value = "联系人电话")
    @TableField("contact_tel")
    private String contactTel;

    @ApiModelProperty(value = "联系人Email")
    @TableField("contact_email")
    private String contactEmail;

    @ApiModelProperty(value = "微信公众号")
    @TableField("contact_wechat")
    private String contactWechat;

    @ApiModelProperty(value = "交通说明")
    @TableField("traffic_guide")
    private String trafficGuide;

    @ApiModelProperty(value = "食宿说明")
    @TableField("accom_guide")
    private String accomGuide;

    @ApiModelProperty(value = "申请人")
    @TableField("applicant")
    private String applicant;

    @ApiModelProperty(value = "提交状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "提交人")
    @TableField("sub_user_id")
    private String subUserId;

    @ApiModelProperty(value = "提交日期")
    @TableField("sub_date")
    private LocalDateTime subDate;

    @ApiModelProperty(value = "提交时间")
    @TableField("sub_time")
    private LocalDateTime subTime;

    @ApiModelProperty(value = "当前审批状态")
    @TableField("audit_status")
    private String auditStatus;

    @ApiModelProperty(value = "当前审批人")
    @TableField("audit_user_id")
    private String auditUserId;

    @ApiModelProperty(value = "当前审批日期")
    @TableField("audit_date")
    private LocalDateTime auditDate;

    @ApiModelProperty(value = "当前审批时间")
    @TableField("audit_time")
    private LocalDateTime auditTime;

    @ApiModelProperty(value = "当前审批描述")
    @TableField("audit_desc")
    private String auditDesc;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "承办部门")
    @TableField("dept_code")
    private String deptCode;

    @ApiModelProperty(value = "教研室")
    @TableField("division_code")
    private String divisionCode;

    @ApiModelProperty(value = "学科门类")
    @TableField("discipline_class")
    private String disciplineClass;

    @ApiModelProperty(value = "一级学科")
    @TableField("discipline_code")
    private String disciplineCode;

    @ApiModelProperty(value = "论文数量")
    @TableField("paper_num")
    private Integer paperNum;

    @ApiModelProperty(value = "经费来源")
    @TableField("fund_source")
    private String fundSource;

    @ApiModelProperty(value = "备注")
    @TableField("intro")
    private String intro;

    @ApiModelProperty(value = "操作时间")
    @TableField("operate_time")
    private LocalDateTime operateTime;

    @ApiModelProperty(value = "主办单位")
    @TableField("host_unit")
    private String hostUnit;

    @ApiModelProperty(value = "协办单位")
    @TableField("assist_unit")
    private String assistUnit;

    @ApiModelProperty(value = "会议负责人")
    @TableField("conference_head")
    private String conferenceHead;

    @ApiModelProperty(value = "伙食费用")
    @TableField("board_fee_amt")
    private BigDecimal boardFeeAmt;

    @ApiModelProperty(value = "交通费用")
    @TableField("traffic_fee_amt")
    private BigDecimal trafficFeeAmt;

    @ApiModelProperty(value = "场地费")
    @TableField("site_fee_amt")
    private BigDecimal siteFeeAmt;

    @ApiModelProperty(value = "资料费")
    @TableField("book_fee_amt")
    private BigDecimal bookFeeAmt;

    @ApiModelProperty(value = "其它费用")
    @TableField("other_fee_amt")
    private BigDecimal otherFeeAmt;

    @ApiModelProperty(value = "住宿费用")
    @TableField("accom_fee_amt")
    private BigDecimal accomFeeAmt;

    @ApiModelProperty(value = "负责人联系方式")
    @TableField("conference_phone")
    private String conferencePhone;

    @ApiModelProperty(value = "预计京外人数")
    @TableField("outnum_of_people")
    private Integer outnumOfPeople;

    @ApiModelProperty(value = "是否有差旅")
    @TableField("travel_flag")
    private String travelFlag;

    @ApiModelProperty(value = "创建人")
    @TableField("creator_id")
    private Long creatorId;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;


}
