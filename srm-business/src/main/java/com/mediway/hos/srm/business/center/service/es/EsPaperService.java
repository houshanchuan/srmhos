package com.mediway.hos.srm.business.center.service.es;

import java.io.IOException;
import java.util.List;

import com.mediway.hos.srm.business.center.model.entity.es.PaperDoc;
import com.mediway.hos.srm.business.center.model.vo.es.PaperSearchVO;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

@Service  
public interface EsPaperService {
     
        //保存
        public void save(PaperDoc paperDoc);
        //删除
        public void delete(PaperDoc paperDoc);
       
        //批量添加文档
        public void saveAll(List<PaperDoc> list);
        //复杂查询
        public PaperSearchVO serachByEs(String text);
        public String serachByAi(String text) throws IOException;

}