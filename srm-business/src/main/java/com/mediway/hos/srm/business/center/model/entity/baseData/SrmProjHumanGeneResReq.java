package com.mediway.hos.srm.business.center.model.entity.baseData;

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
 * 人类遗传资源申报申请表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmProjHumanGeneResReq对象", description="人类遗传资源申报申请表")
@TableName("srm_proj_human_gene_res_req")
public class SrmProjHumanGeneResReq extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "申请单号")
    @TableField("req_no")
    private String reqNo;

    @ApiModelProperty(value = "系统业务号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "日期")
    @TableField("req_date")
    private LocalDateTime reqDate;

    @ApiModelProperty(value = "时间")
    @TableField("req_time")
    private LocalDateTime reqTime;

    @ApiModelProperty(value = "申请人")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "科室")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty(value = "项目标志")
    @TableField("proj_flag")
    private String projFlag;

    @ApiModelProperty(value = "项目ID")
    @TableField("proj_id")
    private String projId;

    @ApiModelProperty(value = "项目名称")
    @TableField("proj_name")
    private String projName;

    @ApiModelProperty(value = "负责人")
    @TableField("head")
    private String head;

    @ApiModelProperty(value = "负责人电话")
    @TableField("tel")
    private String tel;

    @ApiModelProperty(value = "负责人Email")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "样本类型")
    @TableField("sample_type")
    private String sampleType;

    @ApiModelProperty(value = "活动类型")
    @TableField("req_type")
    private String reqType;

    @ApiModelProperty(value = "采集方式")
    @TableField("coll_mode")
    private String collMode;

    @ApiModelProperty(value = "采集方式-其他：")
    @TableField("coll_m")
    private String collM;

    @ApiModelProperty(value = "采集例数")
    @TableField("coll_number_of_case")
    private Integer collNumberOfCase;

    @ApiModelProperty(value = "采集目的")
    @TableField("coll_purpose")
    private String collPurpose;

    @ApiModelProperty(value = "涉及疾病类型")
    @TableField("coll_disease_type")
    private String collDiseaseType;

    @ApiModelProperty(value = "采集用途")
    @TableField("coll_util")
    private String collUtil;

    @ApiModelProperty(value = "存储方式")
    @TableField("store_mode")
    private String storeMode;

    @ApiModelProperty(value = "存储条件")
    @TableField("store_con")
    private String storeCon;

    @ApiModelProperty(value = "存储条件其他")
    @TableField("store_con_other")
    private String storeConOther;

    @ApiModelProperty(value = "存储例数")
    @TableField("store_number_of_case")
    private Integer storeNumberOfCase;

    @ApiModelProperty(value = "存储场所")
    @TableField("store_addr_type")
    private String storeAddrType;

    @ApiModelProperty(value = "存储地点")
    @TableField("store_address")
    private String storeAddress;

    @ApiModelProperty(value = "存储地点测试化验单位")
    @TableField("store_addr_serv_unit")
    private String storeAddrServUnit;

    @ApiModelProperty(value = "遗传家系大小")
    @TableField("genetic_family_size")
    private String geneticFamilySize;

    @ApiModelProperty(value = "家系世代")
    @TableField("genetic_family_generation")
    private String geneticFamilyGeneration;

    @ApiModelProperty(value = "重要家系标志")
    @TableField("is_genetic_family_vip")
    private Integer isGeneticFamilyVip;

    @ApiModelProperty(value = "年度")
    @TableField("year")
    private String year;

    @ApiModelProperty(value = "数据状态")
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

    @ApiModelProperty(value = "审核状态")
    @TableField("chk_status")
    private String chkStatus;

    @ApiModelProperty(value = "最后审核人")
    @TableField("chk_user_id")
    private String chkUserId;

    @ApiModelProperty(value = "最后审核日期")
    @TableField("chk_date")
    private LocalDateTime chkDate;

    @ApiModelProperty(value = "最后审核时间")
    @TableField("chk_time")
    private LocalDateTime chkTime;

    @ApiModelProperty(value = "最后审核描述")
    @TableField("chk_desc")
    private String chkDesc;


}
