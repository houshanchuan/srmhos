package com.mediway.hos.srm.business.center.model.dto.paper;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaperEmbodyDto {
    private Long rowId;
    private Long paperId;
    private String embodyId;
    private String embodyDate;
    private String fileId;
    private BigDecimal impactFactor;
    private LocalDateTime createTime;
    private String creatorCode;
    private String creatorId;
    private String note;
}
