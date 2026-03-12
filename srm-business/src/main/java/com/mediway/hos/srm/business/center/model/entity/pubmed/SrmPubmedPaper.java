package com.mediway.hos.srm.business.center.model.entity.pubmed;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="pubmed论文对象", description="pubmed论文表")
@TableName("srm_pubmed_paper")
public class SrmPubmedPaper  extends BasePO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "pmid")
    @TableField("pmid")
    private String pmid;

    @ApiModelProperty(value = "pmcid")
    @TableField("pmcid")
    private String pmcid;

    @ApiModelProperty(value = "刊登日期")
    @TableField(value = "pub_date")
    private String pubDate;
    @ApiModelProperty(value = "doi")
    @TableField("doi")
    private String doi;
    @ApiModelProperty(value = "期刊")
    @TableField(value = "journal")
    private String journal;
    @ApiModelProperty(value = "标题")
    @TableField(value = "title")
    private String title;

    @ApiModelProperty(value = "作者")
    @TableField(value = "author")
    private String author;

    @ApiModelProperty(value = "摘要")
    @TableField(value = "intro")
    private String intro;

    @ApiModelProperty(value = "收录时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "add_time")
    private Date addTime;

    @ApiModelProperty(value = "状态")
    @TableField("status")
    private String status;

    @ApiModelProperty(value = "来源")
    @TableField("source")
    private String source;

    @ApiModelProperty(value = "是否下载")
    @TableField("is_down")
    private int isDown;

    @ApiModelProperty(value = "论文地址")
    @TableField("file_url")
    private String fileUrl;
}