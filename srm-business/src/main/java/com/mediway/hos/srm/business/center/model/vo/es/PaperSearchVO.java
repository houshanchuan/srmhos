package com.mediway.hos.srm.business.center.model.vo.es;

import com.mediway.hos.srm.business.center.model.entity.es.PaperDoc;
import lombok.Data;
import org.springframework.data.elasticsearch.core.SearchHit;

import java.util.List;

@Data
public class PaperSearchVO {
    private long total;
    List<SearchHit<PaperDoc>> list;
    private double searchTime;
}
