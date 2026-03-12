package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import cn.hutool.core.io.IoUtil;
import cn.hutool.extra.ftp.Ftp;
import cn.hutool.extra.ftp.FtpConfig;
import cn.hutool.extra.ftp.FtpMode;
import com.mediway.hos.base.model.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.FileDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmFileconfig;
import com.mediway.hos.srm.business.center.service.baseData.SrmUploadFtpService;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
@Service
public class SrmUploadFtpServiceImpl implements SrmUploadFtpService {
    @Getter
    @Setter
    private Charset charset = StandardCharsets.UTF_8;
    @Getter
    @Setter
    private long soTimeout = 30000L;
    @Getter
    @Setter
    private String serverLanguageCode;
    @Getter
    @Setter
    private long connectionTimeout = 30000L;
    @Getter
    @Setter
    private String systemKey;
    @Getter
    @Setter
    private Boolean isActive = Boolean.valueOf(false);
    private Ftp getClient(String host, int port, String user, String password) {
        FtpConfig config = FtpConfig.create()
                .setHost(host)
                .setPort(port).setUser(user)
                .setPassword(password)
                .setCharset(this.charset)
                .setConnectionTimeout(this.connectionTimeout)
                .setSoTimeout(this.soTimeout)
                .setServerLanguageCode(this.serverLanguageCode)
                .setSystemKey(this.systemKey);
        return new Ftp(config, this.isActive.booleanValue() ? FtpMode.Active : FtpMode.Passive);
    }
    @Override
    public BaseResponse upload(FileDto fileDto, SrmFileconfig fileconfig){
        //MultipartFile file = fileDto.getMultipartFile();
        InputStream inputStream = null;
        Ftp client = getClient(fileconfig.getFtpip(), Integer.parseInt(fileconfig.getFtpport()), fileconfig.getFtpusername(), fileconfig.getFtppassword());
        try {
            //inputStream = file.getInputStream();
            String filePath ="var/ftp/test/2024/09/06/111.pdf";
            String tmpstr="111.pdf";
            inputStream = new FileInputStream(tmpstr);// 文件的存放路径

            String generateFileName = filePath.substring(filePath.lastIndexOf("/") + 1);
            String uploadPath = "/" + filePath.replace(generateFileName, "");
            client.upload(uploadPath, generateFileName, inputStream);

        } catch (IOException e) {
            //client.delFile(fileInfoDTO.getFilePath());
            throw new ErrorException("-200",e.getMessage());
        } finally {
            IoUtil.close(inputStream);
            IoUtil.close((Closeable)client);
        }
        return BaseResponse.success("成功");
    }
    @Override
    public void download(FileDto fileDto, SrmFileconfig fileconfig){
        MultipartFile file = fileDto.getMultipartFile();
        InputStream inputStream = null;
        Ftp client = getClient(fileconfig.getFtpip(), Integer.parseInt(fileconfig.getFtpport()), fileconfig.getFtpusername(), fileconfig.getFtppassword());
        try {
            //inputStream = file.getInputStream();
            String filePath ="var/ftp/test/2024/09/06/111.pdf";
            String tmpstr="111.pdf";
            inputStream = new FileInputStream(tmpstr);// 文件的存放路径

            String generateFileName = filePath.substring(filePath.lastIndexOf("/") + 1);
            String uploadPath = "/" + filePath.replace(generateFileName, "");

            client.upload(uploadPath, generateFileName, inputStream);

        } catch (IOException e) {
            throw new ErrorException("-200",e.getMessage());
            //throw new BaseBusinessException(SysExceptionEnum.BUSINESS_EXE_ERROR.getCode(), "+ fileInfoDTO.getFileName(), e);
        } finally {
            IoUtil.close(inputStream);
            IoUtil.close((Closeable)client);
        }
    }
}
