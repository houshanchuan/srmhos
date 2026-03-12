package com.mediway.hos.srm.business.center.serviceimpl.ai;

import com.mediway.hos.srm.business.center.service.ai.DHCAssistantService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class DHCAssistantServiceImpl implements DHCAssistantService {

    private static  String UPLOAD_URL="https://openai.imedicalai.com/imedway-ai/app-api/rag/open/v1/kb/doc/upload?kbId=91d1fb131bf3f8cc4c51e9fe99e8979b";
    private static String API_KEY="sk-a0e58d47dc9d4152bb865df9e89c9ea3";

    public static void main(String[] args){
        try {
            uploadFile("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String uploadFile(String kbId) throws IOException {
        // 创建HttpClient实例
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(UPLOAD_URL);

            // 设置请求头
            httpPost.setHeader("Api-Key", API_KEY);

            // 构建多部分表单数据
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            File file = new File("D:\\医院智慧管理分级评估实证材料模板.docx");

            // 添加文件参数
            builder.addBinaryBody(
                    "file",
                    file,
                    ContentType.APPLICATION_OCTET_STREAM,
                    file.getName()
            );

            // 设置实体
            HttpEntity entity = builder.build();
            httpPost.setEntity(entity);

            // 执行请求
            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode >= 200 && statusCode < 300) {
                    return EntityUtils.toString(response.getEntity(), "UTF-8");
                } else {
                    throw new RuntimeException("上传失败，状态码: " + statusCode);
                }
            }
        }
       // return null;
    }

    @Override
    public String uploadFile(String kbId, MultipartFile file) throws IOException {
        return null;
    }
}
