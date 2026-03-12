package com.mediway.hos.srm.business.center.mapper.baseData;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.baseData.UploadInfoDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmUploadInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.UploadInfoVo;

import java.util.List;

/**
 * <p>
 * 上传信息表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-06
 */
public interface SrmUploadInfoMapper extends BaseMapper<SrmUploadInfo> {
    List<UploadInfoVo> listUploadInfo(@Param("uploadInfoDto") UploadInfoDto uploadInfoDto);
}
