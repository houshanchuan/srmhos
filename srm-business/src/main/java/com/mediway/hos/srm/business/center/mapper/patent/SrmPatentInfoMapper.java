package com.mediway.hos.srm.business.center.mapper.patent;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentInfoDto;
import com.mediway.hos.srm.business.center.model.entity.patent.SrmPatentInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentInfoVo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 专利信息表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPatentInfoMapper extends BaseMapper<SrmPatentInfo> {
    PatentInfoVo getDetail(@Param("rowId") Long rowId);
    IPage<PatentInfoVo> listPatentInfo(@Param("page") Page<PatentInfoVo> page, @Param("patentInfoDto") PatentInfoDto patentInfoDto);
    void updateStatus(@Param("rowId") Long rowId, @Param("status") Integer status, @Param("checkStatus") String checkStatus, @Param("serialNo") String serialNo, @Param("subDate") LocalDateTime subDate, @Param("subUserId") String subUserId);
    IPage<PatentInfoVo> listAuditPatentInfo(@Param("page") Page<PatentInfoVo> page, @Param("patentInfoDto") PatentInfoDto patentInfoDto);
    List<CombVo> getPatentApply(@Param("userId") String userId);
    List<CombVo> getPatentInfo(@Param("userId") String userId);

}
