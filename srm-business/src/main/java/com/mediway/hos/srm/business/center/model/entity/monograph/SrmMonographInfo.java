package com.mediway.hos.srm.business.center.model.entity.monograph;

import com.baomidou.mybatisplus.annotation.*;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 著作信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="MonographInfo对象", description="著作信息表")
@TableName("srm_monograph_info")
public class SrmMonographInfo extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "RowId")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "著作名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "申请科室")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty(value = "总字数(千字)")
    @TableField("total_words_num")
    private BigDecimal totalWordsNum;

    @ApiModelProperty(value = "本单位作者字数(千字)")
    @TableField("our_unit_words_num")
    private BigDecimal ourUnitWordsNum;

    @ApiModelProperty(value = "出版社")
    @TableField("press")
    private String press;

    @ApiModelProperty(value = "出版时间")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="publish_time")
    private LocalDateTime publishTime;

    @ApiModelProperty(value = "印刷时间（日期）")
    @TableField(updateStrategy = FieldStrategy.IGNORED,value="print_time")
    private LocalDateTime printTime;

    @ApiModelProperty(value = "ISBN号")
    @TableField("isbn")
    private String isbn;

    @ApiModelProperty(value = "申请人")
    @TableField("sub_user_id")
    private String subUserId;

    @ApiModelProperty(value = "申请时间")
    @TableField("sub_date")
    private LocalDateTime subDate;

    @ApiModelProperty(value = "数据状态")
    @TableField("data_status")
    private Integer dataStatus;

    @ApiModelProperty(value = "系统号")
    @TableField("sys_no")
    private String sysNo;

    @ApiModelProperty(value = "年度")
    @TableField("year")
    private String year;

    @ApiModelProperty(value = "出版次数")
    @TableField("publish_freq")
    private String publishFreq;

    @ApiModelProperty(value = "著作类别")
    @TableField("work_type")
    private String workType;

    @ApiModelProperty(value = "计算得分")
    @TableField("score")
    private Integer score;

    @ApiModelProperty(value = "本院为第几完成单位")
    @TableField("our_unit_ranking")
    private String ourUnitRanking;

    @ApiModelProperty(value = "类型")
    @TableField("biz_type")
    private String bizType;

    @ApiModelProperty(value = "研究领域")
    @TableField("research_field")
    private String researchField;

    @ApiModelProperty(value = "CIP")
    @TableField("cip")
    private String cip;

    @ApiModelProperty(value = "教研室")
    @TableField("disvision_code")
    private String disvisionCode;

    @ApiModelProperty(value = "学科门类代码")
    @TableField("classCode")
    private String classCode;

    @ApiModelProperty(value = "出版单位名称")
    @TableField("pub_unit_name")
    private String pubUnitName;

    @ApiModelProperty(value = "出版社级别")
    @TableField("pub_level")
    private String pubLevel;

    @ApiModelProperty(value = "出版地")
    @TableField("pub_address_type")
    private String pubAddressType;

    @ApiModelProperty(value = "项目来源代码")
    @TableField("projsource_code")
    private String projsourceCode;

    @ApiModelProperty(value = "学科分类代码")
    @TableField("discipline")
    private String discipline;

    @ApiModelProperty(value = "二级学科代码")
    @TableField("discipline_two")
    private String disciplineTwo;

    @ApiModelProperty(value = "三级级学科代码")
    @TableField("discipline_three")
    private String disciplineThree;

    @ApiModelProperty(value = "是否译成外文")
    @TableField("is_translated")
    private Integer isTranslated;

    @ApiModelProperty(value = "语种")
    @TableField("language")
    private String language;

    @ApiModelProperty(value = "作者人数")
    @TableField("author_num")
    private Integer authorNum;

    @ApiModelProperty(value = "审核状态代码")
    @TableField("check_status")
    private String checkStatus;

    @ApiModelProperty(value = "简介")
    @TableField("intro")
    private String intro;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "创建时间")
    @TableField("sub_time")
    private LocalDateTime subTime;

    @ApiModelProperty(value = "记录创建人名称")
    @TableField("subuser_name")
    private String subuserName;

    @ApiModelProperty(value = "是否为修订版")
    @TableField("is_recension")
    private Integer isRecension;

    @ApiModelProperty(value = "医院署名")
    @TableField("school_sign")
    private String schoolSign;

    @ApiModelProperty(value = "本院为第一作者")
    @TableField("is_first_author")
    private Integer isFirstAuthor;

    @ApiModelProperty(value = "第一作者姓名")
    @TableField("fauthor_name")
    private String fauthorName;

    @ApiModelProperty(value = "第一作者职称")
    @TableField("fauthor_title")
    private String fauthorTitle;

    @ApiModelProperty(value = "第一作者性别")
    @TableField("fauthor_sex")
    private String fauthorSex;

    @ApiModelProperty(value = "院内第一作者最后学历")
    @TableField("infauthor_edu_level")
    private String infauthorEduLevel;

    @ApiModelProperty(value = "院内第一作者最后学位")
    @TableField("infauthor_edu_degree")
    private String infauthorEduDegree;

    @ApiModelProperty(value = "院内第一作者工号")
    @TableField("infauthor_code")
    private String infauthorCode;

    @ApiModelProperty(value = "操作时间")
    @TableField("operate_time")
    private String operateTime;

    @ApiModelProperty(value = "院内第一作者ID")
    @TableField("infauthor_id")
    private String infauthorId;

    @ApiModelProperty(value = "第一作者类型")
    @TableField("fauthor_type")
    private String fauthorType;

    @ApiModelProperty(value = "附件文件ID")
    @TableField("file_ids")
    private String fileIds;

    @ApiModelProperty(value = "出版时间（年月）")
    @TableField("pub_yearmon")
    private String pubYearmon;

    @ApiModelProperty(value = "著作奖励")
    @TableField("reward_fee_amt")
    private BigDecimal rewardFeeAmt;

    @ApiModelProperty(value = "序列号")
    @TableField("serial_no")
    private String serialNo;

    @ApiModelProperty(value = "印刷次数")
    @TableField("print_num")
    private Integer printNum;


}
