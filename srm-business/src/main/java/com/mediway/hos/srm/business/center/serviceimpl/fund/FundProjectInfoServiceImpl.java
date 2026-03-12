package com.mediway.hos.srm.business.center.serviceimpl.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjectInfoDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjectInfoVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundProjectInfo;
import com.mediway.hos.srm.business.center.service.fund.FundProjectInfoService;
import com.mediway.hos.srm.business.center.mapper.fund.FundProjectInfoMapper;

/**
 * <p>
 * 项目字典表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-25
 */
@Service
public class FundProjectInfoServiceImpl extends BaseServiceImpl<FundProjectInfoMapper, FundProjectInfo> implements FundProjectInfoService {

    @Autowired
    private FundProjectInfoMapper fundProjectInfoMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateFundProjectInfo(BaseDataFundDto baseDataFundDto) {
        List<FundProjectInfoDto> fundProjectInfoDtos =baseDataFundDto.getFundProjectInfos();

        List<FundProjectInfo> fundProjectInfoList=new ArrayList<>();
        for (FundProjectInfoDto fundProjectInfoDto :fundProjectInfoDtos) {
            FundProjectInfo fundProjectInfo = new FundProjectInfo();
            fundProjectInfo.setId(fundProjectInfoDto.getRowId());
            fundProjectInfo.setCode(fundProjectInfoDto.getCode());
            fundProjectInfo.setName(fundProjectInfoDto.getName());
            fundProjectInfo.setYear(fundProjectInfoDto.getYear());
            fundProjectInfo.setHospCode(fundProjectInfoDto.getHospCode());
            fundProjectInfo.setAlias(fundProjectInfoDto.getAlias());
            fundProjectInfo.setHeadCode(fundProjectInfoDto.getHeadCode());
            fundProjectInfo.setIssuedDate(fundProjectInfoDto.getIssuedDate());
            fundProjectInfo.setDeptCode(fundProjectInfoDto.getDeptCode());
            fundProjectInfo.setState(fundProjectInfoDto.getState());
            fundProjectInfo.setCategory(fundProjectInfoDto.getCategory());
            fundProjectInfo.setIsGovBuy(fundProjectInfoDto.getIsGovBuy());
            fundProjectInfo.setFundGov(fundProjectInfoDto.getFundGov());
            fundProjectInfo.setFundOwn(fundProjectInfoDto.getFundOwn());
            fundProjectInfo.setFundTotal(fundProjectInfoDto.getFundTotal());
            fundProjectInfo.setBudgetDept(fundProjectInfoDto.getBudgetDept());
            fundProjectInfo.setBudgetMode(fundProjectInfoDto.getBudgetMode());
            fundProjectInfo.setChkFlowId(fundProjectInfoDto.getChkFlowId());
            fundProjectInfo.setBlanceType(fundProjectInfoDto.getBlanceType());
            fundProjectInfo.setAccountTotal(fundProjectInfoDto.getAccountTotal());
            fundProjectInfo.setProjectId(fundProjectInfoDto.getSrmProjectId());


            fundProjectInfoList.add(fundProjectInfo);
            Long RowId = fundProjectInfo.getId();
        }
        super.saveOrUpdateBatch(fundProjectInfoList);
        return RowId;
    }
    @Override
    public FundProjectInfoVo getDetailFundProjectInfo(Long RowId) {
        return null;
    }

    @Override
    public IPage<FundProjectInfoVo> listFundProjectInfo(FundProjectInfoDto fundProjectInfoDto) {
        Page<FundProjectInfoVo> page = new Page<>(fundProjectInfoDto.getPage(),fundProjectInfoDto.getRows());
        IPage<FundProjectInfoVo> res= fundProjectInfoMapper.listFundProjectInfo(page,fundProjectInfoDto);
        //List<FundProjectInfoVo> records=res.getRecords();
        //List<FundProjectInfoVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteFundProjectInfo(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                if(StringUtils.isEmpty(idStr)){
                    idStr=String.valueOf(RowId);
                }else{
                    idStr=idStr+""+String.valueOf(RowId);
                }
            }
            super.deleteByIds(idStr);
        }catch (Exception exception){
            throw  new ErrorException("-200",exception.getMessage());
        }
    }

    @Override
    public Long getIdByName(String name) {
        return null;
    }

    public List<CombVo> getProject() {
        return fundProjectInfoMapper.getProject();
    }
}
