package com.mediway.hos.srm.business.center.model.entity.patent;

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
 * 专利权人记录表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmPatentInfoPatentee对象", description="专利权人记录表")
@TableName("srm_patent_info_patentee")
public class SrmPatentInfoPatentee extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "专利Id")
    @TableField("patent_info_id")
    private Long patentInfoId;

    @ApiModelProperty(value = "专利权人类型")
    @TableField("patentee_type")
    private String patenteeType;

    @ApiModelProperty(value = "专利权人id")
    @TableField("patentee_rec_id")
    private String patenteeRecId;

    @ApiModelProperty(value = "专利权人姓名")
    @TableField("patentee_name")
    private String patenteeName;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "联系人")
    @TableField("contact_person")
    private String contactPerson;

    @ApiModelProperty(value = "联系电话")
    @TableField("contact_tel")
    private String contactTel;

    @ApiModelProperty(value = "联系email")
    @TableField("contact_email")
    private String contactEmail;

    @ApiModelProperty(value = "是否本院")
    @TableField("is_hosp")
    private Integer isHosp;


}
