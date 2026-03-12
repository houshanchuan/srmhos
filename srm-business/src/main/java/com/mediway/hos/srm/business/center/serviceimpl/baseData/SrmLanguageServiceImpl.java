package com.mediway.hos.srm.business.center.serviceimpl.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.dto.baseData.LanguageDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmLanguage;
import com.mediway.hos.srm.business.center.model.vo.baseData.LanguageVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmLanguageService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmLanguageMapper;

/**
 * <p>
 * 语言代码表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
@Service
public class SrmLanguageServiceImpl extends BaseServiceImpl<SrmLanguageMapper, SrmLanguage> implements SrmLanguageService {
    @Autowired
    private SrmLanguageMapper srmLanguageMapper;
    @Override
    public List<CombVo> getLanguage(LanguageDto languageDto) {
        return srmLanguageMapper.getLanguage(languageDto);
    }

    @Autowired
    private SrmLanguageService  srmLanguageService;

    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateLanguage(BaseDataUserDto baseDataUserDto) {
        List<LanguageDto> languageDtos =baseDataUserDto.getLanguages();

        List<SrmLanguage> languageList=new ArrayList<>();
        for (LanguageDto languageDto :languageDtos) {
            SrmLanguage srmLanguage = new SrmLanguage();
            srmLanguage.setId(languageDto.getRowId());
            srmLanguage.setCode(languageDto.getCode());
            srmLanguage.setName(languageDto.getName());
            srmLanguage.setIsValid(Integer.valueOf(languageDto.getIsValid()));

            languageList.add(srmLanguage);
            Long RowId = srmLanguage.getId();
        }
        super.saveOrUpdateBatch(languageList);
        return RowId;
    }
    @Override
    public LanguageVo getDetailLanguage(Long RowId) {
        return null;
    }

    @Override
    public IPage<LanguageVo> listLanguage(LanguageDto languageDto) {
        Page<LanguageVo> page = new Page<>(languageDto.getPage(), languageDto.getRows());
        IPage<LanguageVo> res= srmLanguageMapper.listLanguage(page, languageDto);
        //List<LanguageVo> records=res.getRecords();
        //List<LanguageVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteLanguage(BaseDto baseDto) {
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
