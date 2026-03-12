package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.dto.fund.FundProjectInfoDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjectInfoVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundProjectInfo;
/**
 * <p>
 * 项目字典表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-25
 */
public interface FundProjectInfoService extends BaseService<FundProjectInfo> {

    @Transactional
    Long saveOrUpdateFundProjectInfo(BaseDataFundDto baseDataFundDto);

    FundProjectInfoVo getDetailFundProjectInfo(Long RowId);

    IPage<FundProjectInfoVo> listFundProjectInfo(FundProjectInfoDto fundProjectInfoDto);

    void deleteFundProjectInfo(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getProject() ;

}
