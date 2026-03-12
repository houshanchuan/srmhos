package com.mediway.hos.srm.business.center.serviceimpl.es;

import java.io.File;
import java.io.IOException;
import java.util.*;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.mediway.hos.srm.business.center.model.entity.es.PaperDoc;
import com.mediway.hos.srm.business.center.model.vo.es.PaperSearchVO;
import com.mediway.hos.srm.business.center.service.es.EsPaperService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

 
@Service
public class EsPaperServiceImpl implements EsPaperService {
 
    @Autowired
    private  ElasticsearchOperations elasticsearchOperations;
	@Autowired
	private ElasticsearchRestTemplate elasticsearchTemplate; // Elasticsearch 操作模板


	@Override
    public void save(PaperDoc paperDoc) {
    	elasticsearchOperations.save(paperDoc);
    }
 
    @Override
    public void delete(PaperDoc paperDoc) {
    	elasticsearchOperations.delete(paperDoc);
    }
 
	@Override
	public void saveAll(List<PaperDoc> list) {
		elasticsearchOperations.save(list);
	}

	@Override
	public PaperSearchVO serachByEs(String keyword) {
		// 1. 构建布尔查询（组合多条件）
		long startTime=System.currentTimeMillis();
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

		// 2. 全文检索条件：在 title 和 content 字段中检索关键词（分词匹配）
		boolQuery.should(QueryBuilders.matchQuery("title", keyword).boost(2.0f)); // title 权重更高（boost=2）
		boolQuery.should(QueryBuilders.matchQuery("content", keyword));

//		// 3. 可选过滤条件：作者精确匹配（keyword 类型字段）
//		if (author != null && !author.isEmpty()) {
//			boolQuery.filter(QueryBuilders.termQuery("author", author));
//		}
//
//		// 4. 可选过滤条件：阅读量大于等于 minReadCount
//		if (minReadCount != null) {
//			boolQuery.filter(QueryBuilders.rangeQuery("readCount").gte(minReadCount));
//		}

		// 5. 构建高亮（可选：对匹配的关键词标红）
		HighlightBuilder highlightBuilder = new HighlightBuilder();
		highlightBuilder.field("title") // 对 title 字段高亮
				.field("content") // 对 content 字段高亮
				.preTags("<em style='color:red'>") // 高亮前缀
				.postTags("</em>") // 高亮后缀
				.requireFieldMatch(false); // 允许多个字段同时高亮

		// 6. 构建 NativeSearchQuery
		NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(boolQuery) // 设置查询条件
				.withHighlightFields(highlightBuilder.fields()) // 设置高亮
				//.withSort(QueryBuilders.fieldSort("readCount").order(SortOrder.DESC)) // 按阅读量降序
				//.withPageable(PageRequest.of(pageNum, pageSize)) // 分页
				.build();

		// 7. 执行查询并处理结果
		SearchHits<PaperDoc> searchHits = elasticsearchTemplate.search(searchQuery, PaperDoc.class);

		long endTime=System.currentTimeMillis();
		double searchTime=(endTime-startTime)*1d/1000;
		PaperSearchVO searchVO=new PaperSearchVO();
		searchVO.setSearchTime(searchTime);
		searchVO.setTotal(searchHits.getTotalHits());
		searchVO.setList(searchHits.getSearchHits());
		// 8. 转换为 Page 结果（如需处理高亮，可在这里替换原始字段为高亮内容）
		return searchVO;// (Page<Article>) elasticsearchTemplate.paginationResult(searchHits, searchQuery.getPageable());
	}

	@Override
	public String serachByAi(String text) {
		String result=null;
		// 1. 创建 HttpClient 实例（原生方式）
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

			// 2. 创建 POST 请求，指定 URL
			HttpPost httpPost = new HttpPost("https://openai.imedicalai.com/imedway-ai/app-api/rag/open/v1/app/chat");

			// 3. 设置请求头（和 curl 完全一致）
			httpPost.setHeader("Content-Type", "application/json");
			httpPost.setHeader("Api-Key", "sk-26df5f14ae1e494590850cf1f8f20747");
			httpPost.setHeader("App-Id", "0227054130f2fd7e797e92d80933e63e");

			// 4. 构建请求体（JSON 格式，和 curl 的 -d 参数一致）
			Map<String, Object> requestBody = new HashMap<>();
			List<Map<String, String>> messages = new ArrayList<>();
			Map<String, String> userMsg = new HashMap<>();
			userMsg.put("role", "user");
			userMsg.put("content", text);
			messages.add(userMsg);
			requestBody.put("messages", messages);
			requestBody.put("isStream", true);
			requestBody.put("temperature", 0.2);

			// 转为 JSON 字符串并设置到请求中
			String jsonBody = JSONObject.toJSONString(requestBody);
			httpPost.setEntity(new StringEntity(jsonBody, "UTF-8"));

			// 5. 发送请求并获取响应
			try (CloseableHttpResponse response = httpClient.execute(httpPost)) {

				// 6. 读取响应内容
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					result = EntityUtils.toString(entity, "UTF-8");
					System.out.println("响应结果：" + result);
				}
				EntityUtils.consume(entity); // 释放资源
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//@Override
	public SearchHits<PaperDoc> serachPaper1(String value) {
	    value="部署";
		SearchHits<PaperDoc> searchHits=null;
		NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder();
		String[] sourceField=new String[] {"_id","title","content"};
	    FetchSourceFilter fetchSourceFilter = new FetchSourceFilter(sourceField, null);
		//设置高亮显示
		searchQueryBuilder.withHighlightFields(new HighlightBuilder.Field("content"));
		searchQueryBuilder.withHighlightBuilder(new HighlightBuilder().fragmentSize(500).preTags("<span style='color:red'>").postTags("</span>"));
		int searchType=2;
	 // 使用BoolQueryBuilder来组合两个条件
		String source="content";
	 	BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery(); 
	    if(value!=null&&!value.trim().equals("")) {
		 	if(StrUtil.equals(source, "issueNo"))  {
		 		if(searchType==2) {//模糊搜索
		 			 boolQueryBuilder.must(QueryBuilders.matchQuery("content", value));
		 		}else{//精准查询
				//QueryBuilders.wildcardQuery(lawBody.getSearchSource(), lawBody.getSearchValue());
				// 添加第一个条件（例如，字段"field1"的值必须为"value1"）  
					boolQueryBuilder.must(QueryBuilders.termQuery("content", value));
		 		}
		 	}
	    }
		/**
	 	//精确检索法规类型字段
		if(lawBody.getPotencyLevel()!=null&&!lawBody.getPotencyLevel().equals(""))
			boolQueryBuilder.must(QueryBuilders.termQuery("potencyLevel",lawBody.getPotencyLevel()));
		//精确检索时效性字段
		if(lawBody.getTimeliness()!=null)
			boolQueryBuilder.must(QueryBuilders.termsQuery("timeliness", lawBody.getTimeliness()));  
		//精确检索法规区域字段
		if(lawBody.getRegion()!=null)
			boolQueryBuilder.must(QueryBuilders.termsQuery("regions",lawBody.getRegion()));

		//创建索引库未添加，应该使用wildcardQuery查询，存在多对多的关系，检索法规行业字段，
		if(lawBody.getHangye()!=null)
			boolQueryBuilder.must(QueryBuilders.termsQuery("hangye", lawBody.getHangye()));  
		**/
		searchQueryBuilder.withQuery(boolQueryBuilder);
		//if(lawBody.getOrderName()!=null&&!lawBody.getOrderName().equals("")) {
		//	FieldSortBuilder fieldSortBuilder = SortBuilders.fieldSort("title").order(SortOrder.DESC);
		//	searchQueryBuilder.withSort(fieldSortBuilder);
		//}
		//设置分页对象
	    PageRequest page=PageRequest.of(1, 10);
	    searchQueryBuilder.withPageable(page);  
	    // 设置要返回的源字段（只包括这些字段）  
	    searchQueryBuilder.withSourceFilter(fetchSourceFilter); 
	    searchHits= elasticsearchOperations.search(searchQueryBuilder.build(), PaperDoc.class);
	    if(StrUtil.isNotEmpty(value)) {
		    List<SearchHit<PaperDoc>> slist=searchHits.getSearchHits();
		    for(SearchHit<PaperDoc> tmp:slist) {
		       	Map<String ,List<String>> hlFields=tmp.getHighlightFields();
		       	tmp.getContent().setTitle(hlFields.get(source)==null? tmp.getContent().getTitle():hlFields.get(source).get(0));
		    }
	    }
	    
	    
		return searchHits;
	}

	 
    
	 
}