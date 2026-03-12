package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.mediway.hos.file.model.vo.FileVo;
import com.mediway.hos.file.model.vo.HosSysFileConfigVo;
import com.mediway.hos.file.platform.impl.MinIOFileStorage;
import com.mediway.hos.file.service.FileService;
import com.mediway.hos.file.service.FileStorageService;
import com.mediway.hos.file.service.HosSysFileConfigService;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.minio.MinioClient;
import io.minio.RemoveObjectArgs;
import io.minio.errors.MinioException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmAppxfileTypeMapper;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmFtpInfoConfigMapper;
import com.mediway.hos.srm.business.center.model.dto.baseData.FileDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.UploadInfoDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAppxfileType;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmFtpInfoConfig;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmUploadInfo;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmUploadInfoMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.UploadInfoVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmUploadInfoService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.service.baseData.SrmUploadSFtpService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;

import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * <p>
 * 上传信息表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-06
 */
@Service
@Slf4j
public class SrmUploadInfoServiceImpl extends BaseServiceImpl<SrmUploadInfoMapper, SrmUploadInfo> implements SrmUploadInfoService {

    //private FileconfigService fileconfigService;
    @Autowired
    private SrmFtpInfoConfigMapper srmFtpInfoConfigMapper;
    @Autowired
    private SrmUploadSFtpService srmUploadSFtpService;
    @Autowired
    private SrmUploadInfoMapper srmUploadInfoMapper;
    @Autowired
    private SrmAppxfileTypeMapper srmAppxfileTypeMapper;
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private MinIOFileStorage minIOFileStorage;
    @Autowired
    private HosSysFileConfigService sysFileConfigService;
    @Autowired
    private FileService fileService;

    @Override
    @Transactional
    public void uploadByMinio(FileDto fileDto) {
        String filename=fileDto.getFilename();
        FileVo fileVo=fileStorageService.upload(filename,fileDto.getMultipartFile());
        if(ObjectUtil.isEmpty(fileVo.getFileUrl())){
            throw  new ErrorException("-200","文件上传失败");
        }
        String fileType=filename.substring(filename.lastIndexOf(".")+1 );
        try{
            SrmUploadInfo srmUploadInfo=new SrmUploadInfo();
            srmUploadInfo.setSysNo(fileDto.getSysNo());
            srmUploadInfo.setRecId(fileDto.getRecId());
            srmUploadInfo.setFileName(fileVo.getFileName());
            srmUploadInfo.setFileUrl(fileVo.getPath());
            srmUploadInfo.setAppxFileType(fileDto.getType());
            srmUploadInfo.setFileType(fileType);
            srmUploadInfo.setAppxFileType(fileDto.getType());
            srmUploadInfo.setFileSize(fileVo.getFileSize());
            srmUploadInfo.setSysFileId(fileVo.getId());
            Long srmUserRowId= srmUserService.getUserIdByAccount(fileDto.getUserCode());
            srmUploadInfo.setSubUserId(String.valueOf(srmUserRowId));
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String nowDate = now.format(formatter);
            srmUploadInfo.setSubDate(nowDate);
            super.saveOrUpdate(srmUploadInfo);
        }catch (Exception exception){
            log.error("文件上传失败",exception);
            throw  new ErrorException("-200",exception.getMessage());
        }

    }
    @Override
    @Transactional
    public void upload(FileDto fileDto) {
        String filename=fileDto.getFilename();
        int year= LocalDate.now().getYear();
        int month= LocalDate.now().getMonthValue();
        int day= LocalDate.now().getDayOfMonth();
        String uuId= UUID.randomUUID().toString().replaceAll("-", "");
        String fileType=filename.substring(filename.lastIndexOf(".")+1 );
        String newFilename=uuId+"."+fileType;
        fileDto.setRealFilename(newFilename);
        String fileUrl=String.valueOf(year)+'/'+month+'/'+day+'/'+newFilename;
        fileDto.setYyMmDd(String.valueOf(year)+'-'+month+'-'+day);
        try{
            QueryWrapper<SrmFtpInfoConfig> srmFtpInfoConfigQueryWrapper=new QueryWrapper<>();
            srmFtpInfoConfigQueryWrapper.eq("ftp_type","1");
            SrmFtpInfoConfig srmFtpInfoConfig=srmFtpInfoConfigMapper.selectOne(srmFtpInfoConfigQueryWrapper);
            System.out.println(fileDto);
            if("sftp".equals(srmFtpInfoConfig.getFtpSsl())){
                srmUploadSFtpService.upload(fileDto,srmFtpInfoConfig);
            }
            SrmUploadInfo srmUploadInfo=new SrmUploadInfo();
            srmUploadInfo.setSysNo(fileDto.getSysNo());
            srmUploadInfo.setRecId(fileDto.getRecId());
            srmUploadInfo.setFileName(filename);
            srmUploadInfo.setFileUrl(fileUrl);
            srmUploadInfo.setAppxFileType(fileDto.getType());
            srmUploadInfo.setFileType(fileType);
            String userCode=fileDto.getUserCode();
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            srmUploadInfo.setSubUserId(String.valueOf(srmUserRowId));
            LocalDateTime now = LocalDateTime.now();
            // 创建一个DateTimeFormatter实例来定义日期和时间的格式
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            // 使用format方法将LocalDateTime转换为String
            String nowDate = now.format(formatter);
            srmUploadInfo.setSubDate(nowDate);
            super.saveOrUpdate(srmUploadInfo);
        }catch (Exception exception){
            throw  new ErrorException("-200",exception.getMessage());
        }

    }

    @Override
    public void saveUploadInfo(SrmUploadInfo srmUploadInfo) {
        super.saveOrUpdate(srmUploadInfo);
    }

    @Override
    public List<UploadInfoVo> listUploadInfo(UploadInfoDto uploadInfoDto) {
        return srmUploadInfoMapper.listUploadInfo(uploadInfoDto);
    }

    @Override
    public void download(FileDto fileDto, HttpServletResponse paramHttpServletResponse) {
        String rowId=fileDto.getId();
        SrmUploadInfo srmUploadInfo=srmUploadInfoMapper.selectById(rowId);
        String fileName=srmUploadInfo.getFileName();
        String fileUrl=srmUploadInfo.getFileUrl();
        fileDto.setFilename(fileName);
        fileDto.setFilepath(fileUrl);
        QueryWrapper<SrmFtpInfoConfig> srmFtpInfoConfigQueryWrapper=new QueryWrapper<>();
        srmFtpInfoConfigQueryWrapper.eq("ftp_type","1");
        SrmFtpInfoConfig srmFtpInfoConfig=srmFtpInfoConfigMapper.selectOne(srmFtpInfoConfigQueryWrapper);
        System.out.println(srmUploadInfo);
        if("sftp".equals(srmFtpInfoConfig.getFtpSsl())){
            srmUploadSFtpService.download(fileDto,srmFtpInfoConfig,paramHttpServletResponse);
        }
    }
    @Override
    public void downloadByMinio(FileDto fileDto, HttpServletResponse paramHttpServletResponse) {
        String rowId=fileDto.getId();
        SrmUploadInfo srmUploadInfo=srmUploadInfoMapper.selectById(rowId);
        String fileName=srmUploadInfo.getFileName();
        fileStorageService.download(srmUploadInfo.getSysFileId(),paramHttpServletResponse);
    }
    @Override
    public void preViewFile(FileDto fileDto, HttpServletResponse paramHttpServletResponse) {
        String rowId=fileDto.getId();
        SrmUploadInfo srmUploadInfo=srmUploadInfoMapper.selectById(rowId);
        String fileName=srmUploadInfo.getFileName();
        String fileUrl=srmUploadInfo.getFileUrl();
        fileDto.setFilename(fileName);
        fileDto.setFilepath(fileUrl);
//        QueryWrapper<SrmFtpInfoConfig> srmFtpInfoConfigQueryWrapper=new QueryWrapper<>();
//        srmFtpInfoConfigQueryWrapper.eq("ftp_type","1");
//        SrmFtpInfoConfig srmFtpInfoConfig=srmFtpInfoConfigMapper.selectOne(srmFtpInfoConfigQueryWrapper);
//        System.out.println(srmUploadInfo);
        String fileType=srmUploadInfo.getFileType().toUpperCase();
        fileDto.setType(fileType);
        srmUploadSFtpService.downloadWord(fileDto,null,paramHttpServletResponse);
//        if(fileType.contains("PDF")||fileType.contains("DOCX")){
//
//        }
    }
    @Override
    public void preViewTxt(FileDto fileDto, HttpServletResponse paramHttpServletResponse) {
        String rowId=fileDto.getId();
        SrmUploadInfo srmUploadInfo=srmUploadInfoMapper.selectById(rowId);
        String fileName=srmUploadInfo.getFileName();
        String fileUrl=srmUploadInfo.getFileUrl();
        fileDto.setFilename(fileName);
        fileDto.setFilepath(fileUrl);
        QueryWrapper<SrmFtpInfoConfig> srmFtpInfoConfigQueryWrapper=new QueryWrapper<>();
        srmFtpInfoConfigQueryWrapper.eq("ftp_type","1");
        SrmFtpInfoConfig srmFtpInfoConfig=srmFtpInfoConfigMapper.selectOne(srmFtpInfoConfigQueryWrapper);
        System.out.println(srmUploadInfo);
        if("sftp".equals(srmFtpInfoConfig.getFtpSsl())){
            srmUploadSFtpService.downloadTxt(fileDto,srmFtpInfoConfig,paramHttpServletResponse);
        }
    }
    @Override
    public void deletFile(BaseDto baseDto){
        SrmUploadInfo fileInfo=this.selectById(baseDto.getId());
        String flieName=fileInfo.getFileName();
        //删除
        if(ObjectUtil.isNotEmpty(flieName)) {
            HosSysFileConfigVo fileConfig = this.sysFileConfigService.getActiveFileConfig();
            MinioClient minioClient = minIOFileStorage.getClient(fileConfig.getUserName(), fileConfig.getPassword(), fileConfig.getHostAddress());
            try {
                minioClient.removeObject(
                        RemoveObjectArgs.builder()
                                .bucket(fileConfig.getBucketName())
                                .object(flieName)
                                .build()
                );
                this.deleteById(baseDto.getId());
                log.info("文件 " + flieName + " 已删除");
            } catch (MinioException | IOException | NoSuchAlgorithmException | InvalidKeyException e) {
                log.error("文件删除异常",e);
                throw  new ErrorException("-200",e.getMessage());
            }
        }
    }
    @Override
    public void test() {
        Session session = null;
        Channel channel = null;
        ChannelSftp c = null;
        try {
            String user="ftpuser";
            String host="175.24.134.85";
            String password="456aaasss@A";
            System.out.println(11111);
            JSch jsch = new JSch();
            session = jsch.getSession(user, host, 22);

            session.setPassword(password);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            session.setConfig(sshConfig);

            session.connect();
            System.out.println(11111);
            channel = session.openChannel("sftp");
            channel.connect();
            c = (ChannelSftp)channel;
            c.cd("/var/ftp");

            Vector<ChannelSftp.LsEntry> list = c.ls("*");
            for (ChannelSftp.LsEntry entry : list) {
                System.out.println(entry.getLongname() + "\t" + entry.getAttrs().getSize() + "\t" + entry.getFilename());
            }
            c.mkdir("2024");

        } catch (Exception e) {

            throw new ErrorException("-200",e.getMessage());
            //throw new BaseBusinessException(FileExceptionEnum.CREATE_SFTP_CLIENT_ERROR.getCode(), FileExceptionEnum.CREATE_SFTP_CLIENT_ERROR.getMsg(), e);
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
    }
    /**
     * 返回true代表必要的附件全部上传完成,false代表没有全部上传,不能提交
     * */
    @Override
    public Boolean getFileNessary(String recId, String sysNo) {
        QueryWrapper<SrmAppxfileType> srmAppxfileTypeQueryWrapper=new QueryWrapper<>();
        srmAppxfileTypeQueryWrapper.eq("sys_no",sysNo);
        srmAppxfileTypeQueryWrapper.eq("is_valid",1);
        srmAppxfileTypeQueryWrapper.eq("is_required",1);
        List<SrmAppxfileType> srmAppxfileTypes=srmAppxfileTypeMapper.selectList(srmAppxfileTypeQueryWrapper);
        if(srmAppxfileTypes.isEmpty()) return true;
        List<String> nessaryTypes=new ArrayList<>();
        for(SrmAppxfileType srmAppxfileType:srmAppxfileTypes){
            nessaryTypes.add(String.valueOf(srmAppxfileType.getId()));
        }
        QueryWrapper<SrmUploadInfo> srmUploadInfoQueryWrapper=new QueryWrapper<>();
        srmUploadInfoQueryWrapper.eq("rec_id",recId);
        srmUploadInfoQueryWrapper.eq("sys_no",sysNo);
        List<SrmUploadInfo> srmUploadInfos= srmUploadInfoMapper.selectList(srmUploadInfoQueryWrapper);
        if(srmUploadInfos.isEmpty()) return false;
        List<String> types=new ArrayList<>();
        for(SrmUploadInfo srmUploadInfo :srmUploadInfos){
            String appFileTypeId=srmUploadInfo.getAppxFileType();
            types.add(appFileTypeId);
        }
        return types.containsAll(nessaryTypes);
    }
}
