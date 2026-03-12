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
 * 项目参与人
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmProjectsInfoMember对象", description="项目参与人")
@TableName("srm_projects_info_member")
public class SrmProjectsInfoMember extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "项目DR　")
    @TableField("proj_id")
    private Long projId;

    @ApiModelProperty(value = "成员编号")
    @TableField("member")
    private String member;

    @ApiModelProperty(value = "成员姓名")
    @TableField("member_name")
    private String memberName;

    @ApiModelProperty(value = "成员职工号")
    @TableField("member_code")
    private String memberCode;

    @ApiModelProperty(value = "所在单位编号　")
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
    @TableField("edu_level")
    private String eduLevel;

    @ApiModelProperty(value = "年工作量编号　")
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

    @ApiModelProperty(value = "性别编号　")
    @TableField("sex")
    private String sex;

    @ApiModelProperty(value = "作者类型编号　")
    @TableField("author_type_code")
    private String authorTypeCode;

    @ApiModelProperty(value = "作者角色类型编号")
    @TableField("memberrole_code")
    private String memberroleCode;

    @ApiModelProperty(value = "涉密级别编号")
    @TableField("secret_level")
    private String secretLevel;


}
