package com.mediway.hos.srm.business.center.model.entity.projectapply;

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
 * 项目申报参与人
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmProjectSolicitMember对象", description="项目申报参与人")
@TableName("srm_project_solicit_member")
public class SrmProjectSolicitMember extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "项目编号")
    @TableField("soli_proj_id")
    private Long soliProjId;

    @ApiModelProperty(value = "成员编号")
    @TableField("member_id")
    private String memberId;

    @ApiModelProperty(value = "成员姓名")
    @TableField("member_name")
    private String memberName;

    @ApiModelProperty(value = "项目组成员职工号")
    @TableField("member_code")
    private String memberCode;

    @ApiModelProperty(value = "所在单位编号")
    @TableField("dept_code")
    private String deptCode;

    @ApiModelProperty(value = "所在单位名称")
    @TableField("unit_name")
    private String unitName;

    @ApiModelProperty(value = "学科方向")
    @TableField("discipline")
    private String discipline;

    @ApiModelProperty(value = "职称编号")
    @TableField("title_code")
    private String titleCode;

    @ApiModelProperty(value = "成员学历编号")
    @TableField("edu_level_code")
    private String eduLevelCode;

    @ApiModelProperty(value = "年工作量编号")
    @TableField("work_time")
    private String workTime;

    @ApiModelProperty(value = "贡献率")
    @TableField("work_ratio")
    private BigDecimal workRatio;

    @ApiModelProperty(value = "排序号")
    @TableField("ranking")
    private String ranking;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "性别编号")
    @TableField("sex")
    private String sex;

    @ApiModelProperty(value = "作者类型编号")
    @TableField("author_type_code")
    private String authorTypeCode;

    @ApiModelProperty(value = "成员角色类型编号")
    @TableField("member_role_code")
    private String memberRoleCode;

    @ApiModelProperty(value = "涉密级别编号")
    @TableField("secret_level")
    private String secretLevel;


}
