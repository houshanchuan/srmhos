package com.mediway.hos.srm.business.center.controller.app;

import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.app.AppBaseDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.FileDto;
import com.mediway.hos.srm.business.center.service.app.SrmAppService;
import com.mediway.hos.srm.business.center.service.baseData.SrmUploadInfoService;
import io.swagger.annotations.Api;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("srm/SrmApp")
@Api(tags = "App")
public class SrmAppController {
    @Autowired
    private SrmAppService srmAppService;
    @Autowired
    private SrmUploadInfoService srmUploadInfoService;
    @PostMapping({"/srmRequest"})
    //@OpenApi(code="srmRequest")
    public BaseResponse srmRequest(@RequestBody AppBaseDto appBaseDto) {
        return srmAppService.Operate(appBaseDto);
    }
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
        return srmAppService.upload(fileDto);


    }

    @RequestMapping(value = "/srmDownload", method = RequestMethod.GET)
    public void download(@RequestParam String id,@RequestParam String fileName, HttpServletResponse response) {
        FileDto fileDto=new FileDto();
        fileDto.setId(id);
        fileDto.setFilename(fileName);
        srmUploadInfoService.download(fileDto,response);
    }
}
