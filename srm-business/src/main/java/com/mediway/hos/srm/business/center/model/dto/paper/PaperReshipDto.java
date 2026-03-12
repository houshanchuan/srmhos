package com.mediway.hos.srm.business.center.model.dto.paper;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaperReshipDto {
    private Long rowId;
    private Long paperId;
    private String reshipId;
    private String reshipName;
    private String reshipType;
    private String reshipTypeName;
    private String reshipDate;
    private LocalDateTime createTime;
    private String creatorCode;
    private String creatorId;
    private String note;
}
