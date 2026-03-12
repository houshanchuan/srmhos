package com.mediway.hos.srm.business.center.model.dto.es;

import lombok.Data;

@Data
public class PaperSearchDTO {
    private String keyword;
    private int page;
    private int pageSize;
}
