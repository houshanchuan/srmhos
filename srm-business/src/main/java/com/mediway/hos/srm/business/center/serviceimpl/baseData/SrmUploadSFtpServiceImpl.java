package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import cn.hutool.core.io.IoUtil;
import cn.hutool.extra.ssh.JschUtil;
import com.jcraft.jsch.*;
import com.mediway.hos.base.exception.BaseBusinessException;
import com.mediway.hos.base.exception.SysExceptionEnum;
import com.mediway.hos.base.model.BaseResponse;

import com.mediway.hos.file.model.vo.HosSysFileConfigVo;
import com.mediway.hos.file.platform.impl.MinIOFileStorage;
import com.mediway.hos.file.service.FileService;
import com.mediway.hos.file.service.HosSysFileConfigService;
import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.docx4j.jaxb.Context;
import org.docx4j.Docx4J;
import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.fonts.PhysicalFont;
import org.docx4j.fonts.PhysicalFonts;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.FileDto;

import com.mediway.hos.srm.business.center.model.entity.baseData.SrmFtpInfoConfig;
import com.mediway.hos.srm.business.center.platform.SftpUserInfo;
import com.mediway.hos.srm.business.center.service.baseData.SrmUploadSFtpService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBElement;
import java.io.*;

import java.net.URI;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;


@Service
public class SrmUploadSFtpServiceImpl implements SrmUploadSFtpService {
    private String privateKeyPath;
    private long connectionTimeout = 10000L;
    private Charset charset = StandardCharsets.UTF_8;
    @Autowired
    private MinIOFileStorage minIOFileStorage;
    @Autowired
    private HosSysFileConfigService sysFileConfigService;
    @Autowired
    private FileService fileService;
    public Session getSession(String host, int port, String user, String password) {
        Session session = null;
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(user, host, port);
            session.setPassword(password);
            System.out.println(user+","+host+","+port+","+password);
            SftpUserInfo sftpUserInfo = new SftpUserInfo();
            session.setUserInfo((UserInfo)sftpUserInfo);
            return session;
        } catch (Exception e) {
            JschUtil.close(session);
            throw new ErrorException("-200",e.getMessage());
            //throw new BaseBusinessException(FileExceptionEnum.CREATE_SFTP_CLIENT_ERROR.getCode(), FileExceptionEnum.CREATE_SFTP_CLIENT_ERROR.getMsg(), e);
        }
    }
    @Override
    public BaseResponse upload(FileDto fileDto, SrmFtpInfoConfig srmFtpInfoConfig) {
        String sysNo=fileDto.getSysNo();
        String type=fileDto.getType();
        String filename=fileDto.getFilename();
        String yyMmDd=fileDto.getYyMmDd();
        String[] yyArr=yyMmDd.split("-");
        String year=yyArr[0];
        String month= yyArr[1];
        String day= yyArr[2];
        //String uuId= UUID.randomUUID().toString().replaceAll("-", "");
        //String fileType=filename.substring(filename.lastIndexOf(".")+1 );
        String generateFileName=fileDto.getRealFilename();
        MultipartFile file = fileDto.getMultipartFile();
        InputStream inputStream = null;
        Session session = null;
        try {
            session = getSession(srmFtpInfoConfig.getFtpIp(), 22, srmFtpInfoConfig.getFtpUser(), srmFtpInfoConfig.getFtpPassword());
            inputStream = file.getInputStream();
            String uploadPath=year+"/"+month+"/"+day;
            uploadFile(session, inputStream, uploadPath, generateFileName);
            // 下面要处理附件业务表

        } catch (Exception e) {
            //FileUtil.del(fileInfoDTO.getFilePath());
            throw new ErrorException("-200",e.getMessage());
        } finally {
            IoUtil.close(inputStream);
        }
        return BaseResponse.success("成功");
    }
    public void uploadFile(Session session, InputStream inputStream, String remoteOffersFilePath, String fileName) throws Exception {
        Channel channel = null;
        ChannelSftp c = null;
        try {
            session.setTimeout(3000);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            c = (ChannelSftp)channel;
            System.out.println(remoteOffersFilePath);
            c.cd("/data");
            mkdirs(c, remoteOffersFilePath);
            c.put(inputStream, fileName, 0);


        } finally {
            if (c != null)
                try {
                    c.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            if (channel != null)
                try {
                    channel.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            if (session != null)
                try {
                    session.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }
    @Override
    public void download(FileDto fileDto, SrmFtpInfoConfig srmFtpInfoConfig, HttpServletResponse response) {
        System.out.println(fileDto);
        Session session = null;
        Channel channel = null;
        ChannelSftp c = null;
        InputStream in = null;
        try {
            //String rowId=fileDto.getId();
            session = getSession(srmFtpInfoConfig.getFtpIp(), 22, srmFtpInfoConfig.getFtpUser(), srmFtpInfoConfig.getFtpPassword());
            session.setTimeout(3000);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            c = (ChannelSftp) channel;
            String fileUrl=fileDto.getFilepath();
            String orginalFileName=fileDto.getFilename();
            String[] fileArr=fileUrl.split("/");
            System.out.println(fileArr.toString());
            int length=fileArr.length;
            c.cd("/data");
            //c.cd("2025");
            //c.cd("1");
            //c.cd("23");

            if(length==0){
                //c.cd("/data");

            }else{
                //c.cd("/data");
                for(int i=0;i<length-1;i++){
                    String path=fileArr[i];
                    System.out.println(path);
                    c.cd(path);
                }
            }
            String filename=fileArr[length-1];
            String downloadName=java.net.URLEncoder.encode(orginalFileName, "UTF-8");
            in=c.get(filename);
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment; filename=\"" + downloadName + "\"");
            // 循环取出流中的数据
            byte[] b = new byte[3072];
            int len;
            while ((len = in.read(b)) > 0) {

                response.getOutputStream().write(b, 0, len);
            }
            in.close();
        }
        catch (Exception e) {
            //FileUtil.del(fileInfoDTO.getFilePath());
            throw new ErrorException("-200",e.getMessage());
        }
        finally {
            if (c != null)
                try {
                    c.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            if (channel != null)
                try {
                    channel.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            if (session != null)
                try {
                    session.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }

    private void mkdirs(ChannelSftp sftp, String dir) throws SftpException {
        String[] folders = dir.split("/");
        for (String folder : folders) {
            if (folder.length() > 0)
                try {
                    sftp.cd(folder);
                }catch(Exception exception){
                    sftp.mkdir(folder);//创建目录
                    sftp.cd(folder);  //进入目录
                }

        }
    }

    /*
    word转PDF流
    **/
    @Override
    public void downloadWord(FileDto fileDto, SrmFtpInfoConfig srmFtpInfoConfig, HttpServletResponse response) {

        Session session = null;
        Channel channel = null;
        ChannelSftp c = null;
        InputStream in = null;
        try {
//            session = getSession(srmFtpInfoConfig.getFtpIp(), 22, srmFtpInfoConfig.getFtpUser(), srmFtpInfoConfig.getFtpPassword());
//            session.setTimeout(3000);
//            session.connect();
//            channel = session.openChannel("sftp");
//            channel.connect();
//            c = (ChannelSftp) channel;
//            String fileUrl=fileDto.getFilepath();
//            String orginalFileName=fileDto.getFilename();
//            String[] fileArr=fileUrl.split("/");
//
//            int length=fileArr.length;
//            c.cd("/data");
//            if(length==0){
//
//            }else{
//                //c.cd("/data");
//                for(int i=0;i<length-1;i++){
//                    String path=fileArr[i];
//
//                    c.cd(path);
//                }
//            }
//            String filename=fileArr[length-1];
//            String downloadName=java.net.URLEncoder.encode("tmp.pdf", "UTF-8");
//            in=c.get(filename);

            String downloadName=java.net.URLEncoder.encode(fileDto.getFilename(), "UTF-8");
            try {
                HosSysFileConfigVo fileConfig = this.sysFileConfigService.getActiveFileConfig();
                MinioClient client = minIOFileStorage.getClient(fileConfig.getUserName(), fileConfig.getPassword(), fileConfig.getHostAddress());
                String path = fileDto.getFilepath();
                if (path.startsWith("/")) {
                    path = path.replaceFirst("/", "");
                }

                int index = path.indexOf("/");
                String pathWithNoBucket = path.substring(index);
                in = client.getObject((GetObjectArgs) ((GetObjectArgs.Builder) ((GetObjectArgs.Builder) GetObjectArgs.builder().bucket(fileConfig.getBucketName())).object(pathWithNoBucket)).build());
                if (Objects.isNull(in)) {
                    throw new BaseBusinessException(SysExceptionEnum.BUSINESS_EXE_ERROR.getCode(), "文件下载失败，下载的文件流为空！,filename:" +downloadName );
                }
            }catch (Exception e){
                e.printStackTrace();
                throw new BaseBusinessException(SysExceptionEnum.BUSINESS_EXE_ERROR.getCode(),"文件下载失败"+e.getMessage());
            }



            //response.setCharacterEncoding("UTF-8");
            ServletOutputStream outputStream = response.getOutputStream();
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment; filename=\"" + downloadName + "\"");
            if(fileDto.getType().contains("DOC")) {
                WordprocessingMLPackage wordMLPackage = Docx4J.load(in);
                Docx4J.toPDF(wordMLPackage, outputStream);
            }else {
                byte[] buffer = new byte[8192]; // 8KB缓冲区
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }


            }
            in.close();
        }
        catch (Exception e) {
            //FileUtil.del(fileInfoDTO.getFilePath());
            e.printStackTrace();
            throw new ErrorException("-200",e.getMessage());
        }
        finally {
            if (c != null)
                try {
                    c.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            if (channel != null)
                try {
                    channel.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            if (session != null)
                try {
                    session.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }

    private static void configureMinimalFontMapper(WordprocessingMLPackage pkg) {
        try {
            // 创建一个只包含默认字体的字体提供者
//            MinimalFontMapper fontMapper = new MinimalFontMapper();
//
//            // 设置默认字体
//            // 这里使用 Arial 作为示例，你也可以选择其他可用字体
//            PhysicalFont defaultFont = createDefaultFont();
//            fontMapper.setDefaultFont(defaultFont);
//
//            // 为文档设置字体映射器
//            pkg.getMainDocumentPart().setFontMapper(fontMapper);

            System.out.println("已配置极简字体映射器，使用默认字体");
        } catch (Exception e) {
            System.err.println("配置字体映射器失败: " + e.getMessage());
            e.printStackTrace();
        }
    }
    /**
     * 替换文档中所有非法的字体 URI
     */
    private void replaceIllegalFontURIs(WordprocessingMLPackage pkg) {
        // 定义非法 URI 模式（例如包含空格或反斜杠的 file: 路径）
        Pattern illegalUriPattern = Pattern.compile("file:[^/].*[\\\\\\s]");

        // 获取所有文本内容
        List<Object> texts = pkg.getMainDocumentPart().getContent();

        // 遍历并替换非法字体引用
        for (Object text : texts) {
            processElement(text, illegalUriPattern);
        }
    }

    private static void processElement(Object element, Pattern pattern) {
        // 处理文本元素
        if (element instanceof Text) {
            Text text = (Text) element;
            // 检查并处理文本内容
        }
        // 处理带样式的文本
        else if (element instanceof JAXBElement &&
                ((JAXBElement<?>) element).getValue() instanceof R) {
            R run = (R) ((JAXBElement<?>) element).getValue();
            RPr rPr = run.getRPr();
            if (rPr != null && rPr.getRFonts() != null) {
                RFonts rFonts = rPr.getRFonts();
                // 检查 rFonts 中的字体引用是否包含非法 URI
                // 实际实现可能需要更复杂的逻辑
            }
        }

        // 递归处理子元素
        if (element instanceof ContentAccessor) {
            List<Object> children = ((ContentAccessor) element).getContent();
            for (Object child : children) {
                processElement(child, pattern);
            }
        }
    }
    @Override
    public void downloadTxt(FileDto fileDto, SrmFtpInfoConfig srmFtpInfoConfig, HttpServletResponse response) {
        System.out.println(2222222);
        Session session = null;
        Channel channel = null;
        ChannelSftp c = null;
        InputStream in = null;
        try {
            //String rowId=fileDto.getId();
            session = getSession(srmFtpInfoConfig.getFtpIp(), 22, srmFtpInfoConfig.getFtpUser(), srmFtpInfoConfig.getFtpPassword());
            session.setTimeout(3000);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            c = (ChannelSftp) channel;
            String fileUrl=fileDto.getFilepath();
            String orginalFileName=fileDto.getFilename();
            String[] fileArr=fileUrl.split("/");

            int length=fileArr.length;
            c.cd("/data");
            //c.cd("2025");
            //c.cd("1");
            //c.cd("23");

            if(length==0){
                //c.cd("/data");

            }else{
                //c.cd("/data");
                for(int i=0;i<length-1;i++){
                    String path=fileArr[i];

                    c.cd(path);
                }
            }
            String filename=fileArr[length-1];
            String downloadName=java.net.URLEncoder.encode(orginalFileName, "UTF-8");
            in=c.get(filename);
            response.setContentType("text/plain");
            response.addHeader("Content-Disposition", "attachment; filename=\"" + downloadName + "\"");

            InputStreamReader inputStreamReader = new InputStreamReader(in);
            BufferedReader bufferedRead = new BufferedReader(inputStreamReader);
            ServletOutputStream out = response.getOutputStream();
            String line;
            while ((line = bufferedRead.readLine()) != null) {
                out.write(line.getBytes());
                //out.write("<BR>".getBytes());
                out.write('\n'); // 添加换行符
            }
            bufferedRead.close();
            in.close();

        }
        catch (Exception e) {
            //FileUtil.del(fileInfoDTO.getFilePath());
            throw new ErrorException("-200",e.getMessage());
        }
        finally {
            if (c != null)
                try {
                    c.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            if (channel != null)
                try {
                    channel.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            if (session != null)
                try {
                    session.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }


    private ResponseEntity<byte[]> createPdfByWord(FileDto fileDto, SrmFtpInfoConfig srmFtpInfoConfig){
        Session session = null;
        Channel channel = null;
        ChannelSftp c = null;
        InputStream in = null;
        ByteArrayOutputStream outputPdfStream = new ByteArrayOutputStream();
        try {
            session = getSession(srmFtpInfoConfig.getFtpIp(), 22, srmFtpInfoConfig.getFtpUser(), srmFtpInfoConfig.getFtpPassword());
            session.setTimeout(3000);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            c = (ChannelSftp) channel;
            String fileUrl=fileDto.getFilepath();
            String orginalFileName=fileDto.getFilename();
            String[] fileArr=fileUrl.split("/");
            int length=fileArr.length;
            c.cd("/data");
            if(length==0){
                //c.cd("/data");
            }else{
                //c.cd("/data");
                for(int i=0;i<length-1;i++){
                    String path=fileArr[i];

                    c.cd(path);
                }
            }
            String filename=fileArr[length-1];
            String downloadName=java.net.URLEncoder.encode(orginalFileName, "UTF-8");
            in=c.get(filename);

            //ByteArrayInputStream pdfInputStream = new ByteArrayInputStream(in);
            WordprocessingMLPackage wordMLPackage = Docx4J.load(in);
            Docx4J.toPDF(wordMLPackage, outputPdfStream);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (c != null)
                try {
                    c.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            if (channel != null)
                try {
                    channel.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            if (session != null)
                try {
                    session.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", LocalDateTime.now().toString()+".pdf");
        byte[] pdfBytes = outputPdfStream.toByteArray();
        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfBytes);
    }

}
