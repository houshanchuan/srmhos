package com.mediway.hos.srm.business.center.model.entity.dept;

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
 * 科室信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Dept对象", description="科室信息表")
@TableName("ct_srm_dept")
public class SrmDept extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "ID")
    private String id;

    @ApiModelProperty(value = "代码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "类型")
    @TableField("dept_type")
    private String deptType;

    @ApiModelProperty(value = "是否有效")
    @TableField("is_valid")
    private Integer isValid;

    @ApiModelProperty(value = "级别")
    @TableField("dept_level")
    private Integer deptLevel;

    @ApiModelProperty(value = "上级科室")
    @TableField("super_dept_id")
    private String superDeptId;

    @ApiModelProperty(value = "责任科室标志")
    @TableField("is_accounting")
    private Integer isAccounting;

    @ApiModelProperty(value = "医疗机构(医院)ID")
    @TableField("hospital")
    private String hospital;

    @ApiModelProperty(value = "学科")
    @TableField("discipline_code")
    private String disciplineCode;

    @ApiModelProperty(value = "研究部门标志")
    @TableField("is_research")
    private Integer isResearch;

    @ApiModelProperty(value = "创建人编号")
    @TableField("creator_no")
    private String creatorNo;

    @ApiModelProperty(value = "创建日期")
    @TableField("create_date")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "最后操作时间")
    @TableField("operate_time")
    private LocalDateTime operateTime;

    @ApiModelProperty(value = "别名")
    @TableField("alias")
    private String alias;

    @ApiModelProperty(value = "HR_ID")
    @TableField("hr_id")
    private String hrId;

    @ApiModelProperty(value = "科主任")
    @TableField("director")
    private String director;

    @ApiModelProperty(value = "归口科室标志")
    @TableField("is_budg")
    private Integer isBudg;

    @ApiModelProperty(value = "是否用于项目预算")
    @TableField("is_item")
    private Integer isItem;

    @ApiModelProperty(value = "是否末级")
    @TableField("is_last")
    private Integer isLast;

    @ApiModelProperty(value = "管理员")
    @TableField("administrator")
    private String administrator;


}
