package com.mediway.hos.srm.business.center.model.entity.es;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Data
@Document(indexName = "research",shards=1,replicas=0,createIndex=true,refreshInterval="10s")
public class PaperDoc  implements Serializable{

    private static final long serialVersionUID = 1L;

    @Field(type = FieldType.Text,analyzer = "ik_smart",searchAnalyzer = "ik_smart")
    private String title;
    @Field(type = FieldType.Text,analyzer = "ik_smart",searchAnalyzer = "ik_smart")
    private String content;

    private String searchSource;
    private String searchValue;
    private int searchType;
    private String potencyLevel;
    private String region;
    private String hangye;
    private String orderName;
    private int pageNum;
    private int pageSize;
    private String timeliness;
}


