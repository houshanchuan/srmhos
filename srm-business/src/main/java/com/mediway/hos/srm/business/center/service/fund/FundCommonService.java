package com.mediway.hos.srm.business.center.service.fund;

import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import java.util.List;

public interface FundCommonService {

    List<CombVo> getProject();

    List<CombVo> getUser();

    List<CombVo> getItemCode();

    List<CombVo> getVehicle();

 }
