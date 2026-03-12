package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import com.mediway.hos.srm.business.center.constants.BusinessConstants;
import com.mediway.hos.srm.business.center.service.baseData.SrmBusinessnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.IdentifyResultDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.IdentifyResultVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmIdentifyResult;
import com.mediway.hos.srm.business.center.service.baseData.SrmIdentifyResultService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmIdentifyResultMapper;
/**
 * <p>
 * 鉴定结果（结论） 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmIdentifyResultServiceImpl extends BaseServiceImpl<SrmIdentifyResultMapper, SrmIdentifyResult> implements SrmIdentifyResultService {

    @Autowired
    private SrmIdentifyResultService  srmIdentifyResultService;
    @Autowired
    private SrmIdentifyResultMapper srmIdentifyResultMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateIdentifyResult(BaseDataProjDto baseDataProjDto) {
        List<IdentifyResultDto> identifyResultDtos =baseDataProjDto.getIdentifyResults();

        List<SrmIdentifyResult> identifyResultList=new ArrayList<>();
        for (IdentifyResultDto identifyResultDto :identifyResultDtos) {
            SrmIdentifyResult srmIdentifyResult = new SrmIdentifyResult();
            srmIdentifyResult.setId(identifyResultDto.getRowId());
            if(ObjectUtil.isEmpty(identifyResultDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.IDENTY_RESULT, 1, "");
                srmIdentifyResult.setCode(code);
            }else{
                srmIdentifyResult.setCode(identifyResultDto.getCode());
            }
            srmIdentifyResult.setName(identifyResultDto.getName());
            srmIdentifyResult.setIsValid(Integer.valueOf(identifyResultDto.getIsValid()));

            identifyResultList.add(srmIdentifyResult);
            Long RowId = srmIdentifyResult.getId();
        }
        super.saveOrUpdateBatch(identifyResultList);
        return RowId;
    }
    @Override
    public IdentifyResultVo getDetailIdentifyResult(Long RowId) {
        return null;
    }

    @Override
    public IPage<IdentifyResultVo> listIdentifyResult(IdentifyResultDto identifyResultDto) {
        Page<IdentifyResultVo> page = new Page<>(identifyResultDto.getPage(), identifyResultDto.getRows());
        IPage<IdentifyResultVo> res= srmIdentifyResultMapper.listIdentifyResult(page, identifyResultDto);
        //List<IdentifyResultVo> records=res.getRecords();
        //List<IdentifyResultVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteIdentifyResult(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                if(StringUtils.isEmpty(idStr)){
                    idStr=String.valueOf(RowId);
                }else{
                    idStr=idStr+","+String.valueOf(RowId);
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
}
