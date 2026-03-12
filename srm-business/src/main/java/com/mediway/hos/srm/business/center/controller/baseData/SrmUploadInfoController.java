package com.mediway.hos.srm.business.center.controller.baseData;


import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.FileDto;
import io.swagger.annotations.Api;
import com.mediway.hos.srm.business.center.model.dto.baseData.UploadInfoDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.UploadInfoVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmUploadInfoService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 上传信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-06
 */
@RestController
@RequestMapping("srm/uploadInfo")
@Api(tags = "上传信息表")
public class SrmUploadInfoController {
    @Autowired
    private SrmUploadInfoService srmUploadInfoService;

    @PostMapping({"/upload"})
    public BaseResponse upload(@RequestParam("file") MultipartFile file, @RequestParam("filename") String filename, @RequestParam("recId") String recId, @RequestParam("sysNo") String sysNo, @RequestParam("type") String type, @RequestParam("userCode") String userCode) {
        System.out.println(filename);
        FileDto fileDto = new FileDto();
        fileDto.setRecId(recId);
        fileDto.setSysNo(sysNo);
        fileDto.setType(type);
        fileDto.setUserCode(userCode);
        fileDto.setFilename(filename);
        fileDto.setMultipartFile(file);
        //srmUploadInfoService.upload(fileDto);
        srmUploadInfoService.uploadByMinio(fileDto);
        return BaseResponse.success("成功!");

    }

    @PostMapping({"/test"})
    public BaseResponse test(@RequestBody BaseDto baseDto) {
        srmUploadInfoService.test();
        return BaseResponse.success("成功!");

    }
    @PostMapping({"/deleteFile"})
    public BaseResponse deleteFile(@RequestBody BaseDto baseDto) {
        srmUploadInfoService.deletFile(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/listUploadInfo"})
    public BaseResponse listUploadInfo(@RequestBody UploadInfoDto uploadInfoDto) {
        List<UploadInfoVo> uploadInfoVoList = srmUploadInfoService.listUploadInfo(uploadInfoDto);
        return BaseResponse.success(uploadInfoVoList);

    }

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    @ResponseBody
    public void download(@RequestParam String id,@RequestParam String fileName, HttpServletResponse response) {
        FileDto fileDto=new FileDto();
        fileDto.setId(id);
        fileDto.setFilename(fileName);
        srmUploadInfoService.downloadByMinio(fileDto,response);
    }
    @RequestMapping(value = "/preViewFile", method = RequestMethod.POST)
    @ResponseBody
    public void preViewFile(@RequestParam String id,@RequestParam String fileName, HttpServletResponse response) {
        FileDto fileDto=new FileDto();
        fileDto.setId(id);
        fileDto.setFilename(fileName);
        srmUploadInfoService.preViewFile(fileDto,response);
    }
    @RequestMapping(value = "/preViewTxt", method = RequestMethod.POST)
    @ResponseBody
    public void preViewTxt(@RequestParam String id,@RequestParam String fileName, HttpServletResponse response) {
        FileDto fileDto=new FileDto();
        fileDto.setId(id);
        fileDto.setFilename(fileName);
        srmUploadInfoService.preViewTxt(fileDto,response);
    }

}
