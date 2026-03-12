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
 * 期刊表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmJournal对象", description="期刊表")
@TableName("srm_journal")
public class SrmJournal extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "代码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "期刊名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "是否有效")
    @TableField("is_valid")
    private Integer isValid;

    @ApiModelProperty(value = "ISSN 码")
    @TableField("issn_code")
    private String issnCode;

    @ApiModelProperty(value = "CN 码")
    @TableField("cn_code")
    private String cnCode;

    @ApiModelProperty(value = "出版周期")
    @TableField("publish_cycle")
    private String publishCycle;

    @ApiModelProperty(value = "邮发代号")
    @TableField("mailing_code")
    private String mailingCode;

    @ApiModelProperty(value = "期刊源")
    @TableField("source")
    private String source;

    @ApiModelProperty(value = "负责单位名称")
    @TableField("responsible_unit_name")
    private String responsibleUnitName;

    @ApiModelProperty(value = "影响因子")
    @TableField("factor")
    private String factor;

    @ApiModelProperty(value = "EISSN 码")
    @TableField("eissn_code")
    private String eissnCode;

    @ApiModelProperty(value = "JCR 分区")
    @TableField("jcr")
    private String jcr;

    @ApiModelProperty(value = "助记别名")
    @TableField("alias")
    private String alias;


}
