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
 * 研究机构设备表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmPlatResearchUnitEquipment对象", description="研究机构设备表")
@TableName("srm_plat_research_unit_equipment")
public class SrmPlatResearchUnitEquipment extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId  ")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "机构编号 ")
    @TableField("res_unit_code")
    private String resUnitCode;

    @ApiModelProperty(value = "设备编号")
    @TableField("equipment_code")
    private String equipmentCode;

    @ApiModelProperty(value = "设备名称")
    @TableField("equipment_name")
    private String equipmentName;

    @ApiModelProperty(value = "批准单位")
    @TableField("authorize_unit")
    private String authorizeUnit;

    @ApiModelProperty(value = "批准时间")
    @TableField("authorize_date")
    private LocalDateTime authorizeDate;

    @ApiModelProperty(value = "一级学科 ")
    @TableField("discipline_one")
    private String disciplineOne;

    @ApiModelProperty(value = "二级学科 ")
    @TableField("discipline_two")
    private String disciplineTwo;

    @ApiModelProperty(value = "设备型号")
    @TableField("equipment_model")
    private String equipmentModel;

    @ApiModelProperty(value = "审核状态 ")
    @TableField("check_status")
    private String checkStatus;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "记录创建人编号")
    @TableField("creator")
    private String creator;

    @ApiModelProperty(value = "记录创建人名称")
    @TableField("creator_name")
    private String creatorName;

    @ApiModelProperty(value = "记录创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "所属单位 ")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty(value = "所属二级单位 ")
    @TableField("division")
    private String division;

    @ApiModelProperty(value = "设备数量")
    @TableField("counts")
    private BigDecimal counts;

    @ApiModelProperty(value = "英文名称")
    @TableField("english_name")
    private String englishName;

    @ApiModelProperty(value = "产地国别")
    @TableField("country")
    private String country;

    @ApiModelProperty(value = "制造商")
    @TableField("manf_name")
    private String manfName;

    @ApiModelProperty(value = "设备状态")
    @TableField("equip_status")
    private String equipStatus;

    @ApiModelProperty(value = "购置日期")
    @TableField("buy_date")
    private LocalDateTime buyDate;

    @ApiModelProperty(value = "启用日期")
    @TableField("start_date")
    private LocalDateTime startDate;

    @ApiModelProperty(value = "在用累计时间（天数）")
    @TableField("days_used")
    private BigDecimal daysUsed;

    @ApiModelProperty(value = "额定有效期限（天数）")
    @TableField("standard_days")
    private BigDecimal standardDays;

    @ApiModelProperty(value = "有效使用日期")
    @TableField("exp_date")
    private LocalDateTime expDate;

    @ApiModelProperty(value = "环境要求描述")
    @TableField("environmental_requirements")
    private String environmentalRequirements;

    @ApiModelProperty(value = "主要功能及特色描述")
    @TableField("function_desc")
    private String functionDesc;

    @ApiModelProperty(value = "主要附件及配置描述")
    @TableField("accessary_desc")
    private String accessaryDesc;

    @ApiModelProperty(value = "贵重仪器标志")
    @TableField("is_expensive")
    private Integer isExpensive;

    @ApiModelProperty(value = "收费方式")
    @TableField("charge_mode")
    private String chargeMode;

    @ApiModelProperty(value = "收费单位")
    @TableField("charge_unit")
    private String chargeUnit;

    @ApiModelProperty(value = "收费单位费用")
    @TableField("charge_unit_fee_amt")
    private BigDecimal chargeUnitFeeAmt;

    @ApiModelProperty(value = "地址")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "房间号")
    @TableField("room_no")
    private String roomNo;

    @ApiModelProperty(value = "位置号")
    @TableField("location")
    private String location;

    @ApiModelProperty(value = "联系人")
    @TableField("contact_person")
    private String contactPerson;

    @ApiModelProperty(value = "邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "电话")
    @TableField("tel")
    private String tel;

    @ApiModelProperty(value = "开放日")
    @TableField("open_week_day")
    private String openWeekDay;

    @ApiModelProperty(value = "开放时间（起始）")
    @TableField("open_time_from")
    private String openTimeFrom;

    @ApiModelProperty(value = "开放时间（截止）")
    @TableField("open_time_to")
    private String openTimeTo;


}
