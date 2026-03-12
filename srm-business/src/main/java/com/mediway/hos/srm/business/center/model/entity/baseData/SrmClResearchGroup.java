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
 * 临床研究分组
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmClResearchGroup对象", description="临床研究分组")
@TableName("srm_cl_research_group")
public class SrmClResearchGroup extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ROWID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "项目DR ")
    @TableField("proj_id")
    private String projId;

    @ApiModelProperty(value = "分组名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "样本量")
    @TableField("sample_size")
    private String sampleSize;

    @ApiModelProperty(value = "是否对照组")
    @TableField("compgroup")
    private String compgroup;

    @ApiModelProperty(value = "暴露因素(或干预措施)名称")
    @TableField("expofactors_name")
    private String expofactorsName;

    @ApiModelProperty(value = "暴露因素(或干预措施)类 ")
    @TableField("expofactors_type")
    private String expofactorsType;

    @ApiModelProperty(value = "暴露因素(或干预措施)描述")
    @TableField("expofactorsdesc")
    private String expofactorsdesc;


}
