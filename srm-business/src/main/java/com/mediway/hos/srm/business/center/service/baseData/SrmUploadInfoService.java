package com.mediway.hos.srm.business.center.service.baseData;

import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.FileDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.UploadInfoDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmUploadInfo;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.baseData.UploadInfoVo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 上传信息表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-06
 */
public interface SrmUploadInfoService extends BaseService<SrmUploadInfo> {
    void upload(FileDto fileDto);
    public void uploadByMinio(FileDto fileDto);
    void deletFile(BaseDto baseDto);
    void download(FileDto fileDto, HttpServletResponse paramHttpServletResponse);

    void downloadByMinio(FileDto fileDto, HttpServletResponse paramHttpServletResponse);

    void preViewFile(FileDto fileDto, HttpServletResponse paramHttpServletResponse);
    void preViewTxt(FileDto fileDto, HttpServletResponse paramHttpServletResponse);
    void test();
    void saveUploadInfo(SrmUploadInfo srmUploadInfo);
    List<UploadInfoVo> listUploadInfo(UploadInfoDto uploadInfoDto);
    Boolean getFileNessary(String recId,String sysNo);
}
