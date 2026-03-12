package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetItemDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetItemVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetItem;

/**
 * <p>
 * 预算项目(科目)表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBudgetItemService extends BaseService<FundBudgetItem> {

    @Transactional
    Long saveOrUpdateFundBudgetItem(BaseDataFundDto baseDataFundDto);

    FundBudgetItemVo getDetailFundBudgetItem(Long RowId);
    IPage<FundBudgetItemVo> listFundBudgetItem(FundBudgetItemDto fundBudgetItemDto);

    void deleteFundBudgetItem(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getItemCode();
}
