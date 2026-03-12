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

import com.mediway.hos.srm.business.center.model.dto.baseData.IndustryCodeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.IndustryCodeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmIndustryCode;
import com.mediway.hos.srm.business.center.service.baseData.SrmIndustryCodeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmIndustryCodeMapper;
/**
 * <p>
 * 行业代码 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmIndustryCodeServiceImpl extends BaseServiceImpl<SrmIndustryCodeMapper, SrmIndustryCode> implements SrmIndustryCodeService {

    @Autowired
    private SrmIndustryCodeService  srmIndustryCodeService;
    @Autowired
    private SrmIndustryCodeMapper srmIndustryCodeMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateIndustryCode(BaseDataProjDto baseDataProjDto) {
        List<IndustryCodeDto> industryCodeDtos =baseDataProjDto.getIndustryCodes();

        List<SrmIndustryCode> industryCodeList=new ArrayList<>();
        for (IndustryCodeDto industryCodeDto :industryCodeDtos) {
            SrmIndustryCode srmIndustryCode = new SrmIndustryCode();
            srmIndustryCode.setId(industryCodeDto.getRowId());
            if(ObjectUtil.isEmpty(industryCodeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PRJ_INDUSTRY, 4, "");
                srmIndustryCode.setCode(code);
            }else{
                srmIndustryCode.setCode(industryCodeDto.getCode());
            }
            srmIndustryCode.setName(industryCodeDto.getName());
            srmIndustryCode.setIsValid(Integer.valueOf(industryCodeDto.getIsValid()));

            industryCodeList.add(srmIndustryCode);
            Long RowId = srmIndustryCode.getId();
        }
        super.saveOrUpdateBatch(industryCodeList);
        return RowId;
    }
    @Override
    public IndustryCodeVo getDetailIndustryCode(Long RowId) {
        return null;
    }

    @Override
    public IPage<IndustryCodeVo> listIndustryCode(IndustryCodeDto industryCodeDto) {
        Page<IndustryCodeVo> page = new Page<>(industryCodeDto.getPage(), industryCodeDto.getRows());
        IPage<IndustryCodeVo> res= srmIndustryCodeMapper.listIndustryCode(page, industryCodeDto);
        //List<IndustryCodeVo> records=res.getRecords();
        //List<IndustryCodeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteIndustryCode(BaseDto baseDto) {
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
