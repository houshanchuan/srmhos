package com.mediway.hos.srm.business.center.model.entity.paper;

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
 * 论文作者表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmPaperAuthor对象", description="论文作者表")
@TableName("srm_paper_author")
public class SrmPaperAuthor extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "论文DR")
    @TableField("paper_id")
    private Long paperId;

    @ApiModelProperty(value = "院内院外标志")
    @TableField("in_out")
    private String inOut;

    @ApiModelProperty(value = "作者DR")
    @TableField("author")
    private String author;

    @ApiModelProperty(value = "作者姓名")
    @TableField("author_name")
    private String authorName;

    @ApiModelProperty(value = "作者单位")
    @TableField("author_unit")
    private String authorUnit;

    @ApiModelProperty(value = "作者代码")
    @TableField("author_code")
    private String authorCode;

    @ApiModelProperty(value = "作者类型")
    @TableField("author_type")
    private String authorType;

    @ApiModelProperty(value = "作者单位")
    @TableField("author_dept_id")
    private String authorDeptId;

    @ApiModelProperty(value = "作者工号")
    @TableField("author_account")
    private String authorAccount;

    @ApiModelProperty(value = "作者科室")
    @TableField("author_unit_name")
    private String authorUnitName;

    @ApiModelProperty(value = "作者教研室")
    @TableField("author_division")
    private String authorDivision;

    @ApiModelProperty(value = "性别")
    @TableField("sex")
    private String sex;

    @ApiModelProperty(value = "作者排名(Order)")
    @TableField("ranking")
    private String ranking;

    @ApiModelProperty(value = "通讯作者标志")
    @TableField("is_corr_author")
    private Integer isCorrAuthor;

    @ApiModelProperty(value = "学位")
    @TableField("edu_degree")
    private String eduDegree;

    @ApiModelProperty(value = "学历")
    @TableField("edu_level")
    private String eduLevel;

    @ApiModelProperty(value = "职称")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "贡献率")
    @TableField("work_ratio")
    private BigDecimal workRatio;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "学生？")
    @TableField("is_student")
    private Integer isStudent;

    @ApiModelProperty(value = "身份证号")
    @TableField("id_no")
    private String idNo;

    @ApiModelProperty(value = "银行")
    @TableField("bank")
    private String bank;

    @ApiModelProperty(value = "银行账号")
    @TableField("bank_account")
    private String bankAccount;

    @ApiModelProperty(value = "联系电话")
    @TableField("contact_tel")
    private String contactTel;

    @ApiModelProperty(value = "共同通讯作者(并列通讯作者)")
    @TableField("is_tied_corr_author")
    private Integer isTiedCorrAuthor;


}
