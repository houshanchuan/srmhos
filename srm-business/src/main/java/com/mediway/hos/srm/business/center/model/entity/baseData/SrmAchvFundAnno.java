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
 * 科研成果基金标注
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmAchvFundAnno对象", description="科研成果基金标注")
@TableName("srm_achv_fund_anno")
public class SrmAchvFundAnno extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId  ")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "成果rowid")
    @TableField("achv_rec_id")
    private String achvRecId;

    @ApiModelProperty(value = "成果类型")
    @TableField("achv_type")
    private String achvType;

    @ApiModelProperty(value = "第一标注基金")
    @TableField("first_fund_anno")
    private String firstFundAnno;

    @ApiModelProperty(value = "第一标注基金号")
    @TableField("first_fund_no")
    private String firstFundNo;

    @ApiModelProperty(value = "第一标注合同号")
    @TableField("first_ctrt_no")
    private String firstCtrtNo;

    @ApiModelProperty(value = "第二标注基金")
    @TableField("second_fund_anno")
    private String secondFundAnno;

    @ApiModelProperty(value = "第二标注基金号")
    @TableField("second_fund_no")
    private String secondFundNo;

    @ApiModelProperty(value = "第二标注合同号")
    @TableField("second_ctrt_no")
    private String secondCtrtNo;

    @ApiModelProperty(value = "第三标注基金")
    @TableField("third_fund_anno")
    private String thirdFundAnno;

    @ApiModelProperty(value = "第三标注基金号")
    @TableField("third_fund_no")
    private String thirdFundNo;

    @ApiModelProperty(value = "第三标注合同号")
    @TableField("third_ctrt_no")
    private String thirdCtrtNo;


}
