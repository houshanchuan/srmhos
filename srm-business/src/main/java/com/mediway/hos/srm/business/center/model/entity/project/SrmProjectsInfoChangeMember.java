package com.mediway.hos.srm.business.center.model.entity.project;

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
 * 项目变更人员信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmProjectsInfoChangeMember对象", description="项目变更人员信息表")
@TableName("srm_projects_info_change_member")
public class SrmProjectsInfoChangeMember extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Rowid")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "变更DR ")
    @TableField("change_parref_id")
    private Long changeParrefId;

    @ApiModelProperty(value = "变更类型")
    @TableField("change_type")
    private String changeType;

    @ApiModelProperty(value = "成员ID ")
    @TableField("member")
    private String member;

    @ApiModelProperty(value = "成员姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "成员工号")
    @TableField("work_code")
    private String workCode;

    @ApiModelProperty(value = "成员类型")
    @TableField("person_type")
    private String personType;

    @ApiModelProperty(value = "排序")
    @TableField("ranking")
    private String ranking;

    @ApiModelProperty(value = "职称")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "学历")
    @TableField("edu_level")
    private String eduLevel;

    @ApiModelProperty(value = "性别")
    @TableField("sex")
    private String sex;

    @ApiModelProperty(value = "科室(代码)")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty(value = "单位")
    @TableField("rely_unit")
    private String relyUnit;

    @ApiModelProperty(value = "科室或单位名称")
    @TableField("dept_unit_name")
    private String deptUnitName;

    @ApiModelProperty(value = "原成员DR ")
    @TableField("orig_member_id")
    private String origMemberId;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "贡献率")
    @TableField("work_ratio")
    private BigDecimal workRatio;


}
