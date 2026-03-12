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
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.LanguageDegreeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmLanguageDegree;
import com.mediway.hos.srm.business.center.model.vo.baseData.LanguageDegreeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmLanguageDegreeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmLanguageDegreeMapper;

/**
 * <p>
 * 语言等级代码表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmLanguageDegreeServiceImpl extends BaseServiceImpl<SrmLanguageDegreeMapper, SrmLanguageDegree> implements SrmLanguageDegreeService {

    @Autowired
    private SrmLanguageDegreeService  srmLanguageDegreeService;
    @Autowired
    private SrmLanguageDegreeMapper srmLanguageDegreeMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateLanguageDegree(BaseDataUserDto baseDataUserDto) {
        List<LanguageDegreeDto> languageDegreeDtos =baseDataUserDto.getLanguageDegrees();

        List<SrmLanguageDegree> languageDegreeList=new ArrayList<>();
        for (LanguageDegreeDto languageDegreeDto :languageDegreeDtos) {
            SrmLanguageDegree srmLanguageDegree = new SrmLanguageDegree();
            srmLanguageDegree.setId(languageDegreeDto.getRowId());
            if(ObjectUtil.isEmpty(languageDegreeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_LANGUAGE_DEGREE, 1, "");
                srmLanguageDegree.setCode(code);
            }else{
                srmLanguageDegree.setCode(languageDegreeDto.getCode());
            }
            srmLanguageDegree.setName(languageDegreeDto.getName());
            srmLanguageDegree.setIsValid(Integer.valueOf(languageDegreeDto.getIsValid()));

            languageDegreeList.add(srmLanguageDegree);
            Long RowId = srmLanguageDegree.getId();
        }
        super.saveOrUpdateBatch(languageDegreeList);
        return RowId;
    }
    @Override
    public LanguageDegreeVo getDetailLanguageDegree(Long RowId) {
        return null;
    }

    @Override
    public IPage<LanguageDegreeVo> listLanguageDegree(LanguageDegreeDto languageDegreeDto) {
        Page<LanguageDegreeVo> page = new Page<>(languageDegreeDto.getPage(), languageDegreeDto.getRows());
        IPage<LanguageDegreeVo> res= srmLanguageDegreeMapper.listLanguageDegree(page, languageDegreeDto);
        //List<LanguageDegreeVo> records=res.getRecords();
        //List<LanguageDegreeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteLanguageDegree(BaseDto baseDto) {
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
