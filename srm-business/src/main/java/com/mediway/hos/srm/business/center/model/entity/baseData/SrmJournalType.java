package com.mediway.hos.srm.business.center.model.entity.baseData;

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
 * 期刊类型表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SrmJournalType对象", description="期刊类型表")
@TableName("ct_srm_journal_type")
public class SrmJournalType extends BasePO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "代码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @TableField("is_valid")
    private Integer isValid;

    @TableField("reward_amount")
    private BigDecimal rewardAmount;

    @TableField("reimbursement_amount")
    private BigDecimal reimbursementAmount;

    @TableField("paper_mode")
    private String paperMode;

    @TableField("is_magazine")
    private Integer isMagazine;

    @TableField("magazine_source_string")
    private String magazineSourceString;

    @TableField("is_emboday")
    private Integer isEmboday;

    @TableField("note")
    private String note;


}
