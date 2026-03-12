package com.mediway.hos.srm.business.center.model.entity.baseData;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * 临床研究分中心
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmClResearchSubCenter对象", description="临床研究分中心")
@TableName("srm_cl_research_sub_center")
public class SrmClResearchSubCenter extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "项目DR")
    @TableField("proj_id")
    private String projId;

    @ApiModelProperty(value = "机构名称")
    @TableField("center_name")
    private String centerName;

    @ApiModelProperty(value = "邮编")
    @TableField("center_post")
    private String centerPost;

    @ApiModelProperty(value = "地址")
    @TableField("center_addr")
    private String centerAddr;

    @ApiModelProperty(value = "项目负责人姓名")
    @TableField("center_head_name")
    private String centerHeadName;

    @ApiModelProperty(value = "负责人手机")
    @TableField("center_head_tel")
    private String centerHeadTel;

    @ApiModelProperty(value = "负责人邮箱")
    @TableField("center_head_email")
    private String centerHeadEmail;


}
