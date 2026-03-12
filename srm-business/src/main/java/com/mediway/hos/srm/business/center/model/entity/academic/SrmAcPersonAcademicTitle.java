package com.mediway.hos.srm.business.center.model.entity.academic;

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
 * 学术称号表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmAcPersonAcademicTitle对象", description="学术称号表")
@TableName("srm_ac_person_academic_title")
public class SrmAcPersonAcademicTitle extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "称号名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "员工ID ")
    @TableField("person_id")
    private String personId;

    @ApiModelProperty(value = "取得称号日期")
    @TableField("pub_date")
    private LocalDateTime pubDate;

    @ApiModelProperty(value = "称号类型 ")
    @TableField("title_type")
    private String titleType;

    @ApiModelProperty(value = "创建人 ")
    @TableField("creator")
    private String creator;

    @ApiModelProperty(value = "提交状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "系统号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "审核状态 ")
    @TableField("check_status")
    private String checkStatus;


}
