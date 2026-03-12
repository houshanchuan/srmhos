package com.mediway.hos.srm.business.center.serviceimpl.fund;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.model.dto.user.UserDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.service.fund.FundBudgetItemService;
import com.mediway.hos.srm.business.center.service.fund.FundCommonService;
import com.mediway.hos.srm.business.center.service.fund.FundProjectInfoService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import com.mediway.hos.srm.business.center.service.fund.FundTravelVehicleService;

import java.util.List;
@Service
public class FundCommonServiceImpl implements FundCommonService {
    @Autowired
    private FundProjectInfoService fundProjectInfoService;
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private FundBudgetItemService fundBudgetItemService;
    @Autowired
    private FundTravelVehicleService fundTravelVehicleService;


    @Override
    public List<CombVo> getProject() {
        return fundProjectInfoService.getProject();
    }

    @Override
    public List<CombVo> getUser() {
        UserDto userDto=new UserDto();
        return srmUserService.getUser(userDto);
    }

    @Override
    public List<CombVo> getItemCode() {
        return fundBudgetItemService.getItemCode();
    }
    @Override
    public List<CombVo> getVehicle() {
        return fundTravelVehicleService.getVehicle();
    }



}
