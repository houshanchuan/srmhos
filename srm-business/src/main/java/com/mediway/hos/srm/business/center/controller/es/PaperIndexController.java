package com.mediway.hos.srm.business.center.controller.es;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.es.PaperSearchDTO;
import com.mediway.hos.srm.business.center.model.entity.es.PaperDoc;
import com.mediway.hos.srm.business.center.model.vo.es.PaperSearchVO;
import com.mediway.hos.srm.business.center.service.es.EsPaperService;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("srm/search")
public class PaperIndexController {

    @Autowired
    private ElasticsearchOperations esOperations;
    @Autowired
    private EsPaperService esPaperService;

    // 项目启动时执行
    //@PostConstruct
    public void createIndex() {
        // 为 PaperDoc 实体类创建索引

        // 打印索引是否存在
        boolean exists = esOperations.indexOps(PaperDoc.class).exists();
        if(!exists)
            esOperations.indexOps(PaperDoc.class).create();
        System.out.println("索引 'research' 是否创建：" + exists);
    }

    @PostMapping({"/test"})
    public void createDocument() {
        List<PaperDoc> list = readDocx("D:\\科研管理系统部署文档.docx");
        esPaperService.saveAll(list);
    }
    @PostMapping({"/es"})
    public BaseResponse searchByEs(@RequestBody PaperSearchDTO searchDTO) {
       // esPaperService.searchArticles(keyword);
         PaperSearchVO vo =esPaperService.serachByEs(searchDTO.getKeyword());
        return BaseResponse.success(vo);
    }
    @PostMapping({"/ai"})
    public BaseResponse searchByAi(@RequestBody PaperSearchDTO searchDTO) {
        // esPaperService.searchArticles(keyword);
        String result=null;
        try {
            searchDTO.setKeyword("关于动物肝脏移植到人体的论文");
            result = esPaperService.serachByAi(searchDTO.getKeyword());
            return BaseResponse.success(result);
        }catch (Exception e){
            e.printStackTrace();
            result="发生错误："+e.getMessage();
            return BaseResponse.error(result);
        }
    }

    public static List<PaperDoc> readDocx(String filePath) {
        List<PaperDoc> list=new ArrayList<>();
        try (InputStream is = new FileInputStream(filePath);
             XWPFDocument document = new XWPFDocument(is)) {
            // 遍历所有段落
            PaperDoc doc=null;
            for (XWPFParagraph paragraph : document.getParagraphs()) {
                doc=new PaperDoc();
                doc.setTitle("科研管理系统部署文档");
                doc.setContent(paragraph.getText());
                list.add(doc);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
