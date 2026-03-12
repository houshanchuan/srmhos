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
 * 课题明细表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmProjectDetailInfo对象", description="课题明细表")
@TableName("srm_project_detail_info")
public class SrmProjectDetailInfo extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "课题")
    @TableField("proj_id")
    private Long projId;

    @ApiModelProperty(value = "合同号")
    @TableField("contract_no")
    private String contractNo;

    @ApiModelProperty(value = "研究目标")
    @TableField("destination")
    private String destination;

    @ApiModelProperty(value = "研究内容")
    @TableField("research_content")
    private String researchContent;

    @ApiModelProperty(value = "考核指标")
    @TableField("check_index")
    private String checkIndex;

    @ApiModelProperty(value = "存储类型")
    @TableField("store_type")
    private String storeType;


}
