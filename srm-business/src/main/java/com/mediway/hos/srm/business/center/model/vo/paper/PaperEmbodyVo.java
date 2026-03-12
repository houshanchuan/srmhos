package com.mediway.hos.srm.business.center.model.vo.paper;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaperEmbodyVo {
    private Long rowId;
    private Long paperId;
    private String embodyId;
    private String embodyName;
    private String embodyDate;
    private String fileId;
    private BigDecimal impactFactor;
    private LocalDateTime createTime;
    private String creatorCode;
    private String creatorId;
    private String note;
}
