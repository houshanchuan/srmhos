package com.mediway.hos.srm.business.center.model.dto.pubmed;

import lombok.Data;

@Data
public class PubmedPaperDto {

    private int page;
    private int rows;
    private String startDate;
    private String endDate;
    private String keywords;
    private int state;
}
