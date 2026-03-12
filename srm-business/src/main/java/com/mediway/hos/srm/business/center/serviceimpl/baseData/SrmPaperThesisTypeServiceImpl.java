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
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.PaperThesisTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPaperThesisType;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmPaperThesisTypeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperThesisTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPaperThesisTypeService;

import javax.annotation.Resource;

/**
 * <p>
 * 论文形式类别表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPaperThesisTypeServiceImpl extends BaseServiceImpl<SrmPaperThesisTypeMapper, SrmPaperThesisType> implements SrmPaperThesisTypeService {
    @Autowired
    private SrmPaperThesisTypeService  srmPaperThesisTypeService;
    @Autowired
    private SrmPaperThesisTypeMapper srmPaperThesisTypeMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdatePaperThesisType(BaseDataLearningDto baseDataLearningDto) {
        List<PaperThesisTypeDto> paperThesisTypeDtos =baseDataLearningDto.getPaperThesisTypes();

        List<SrmPaperThesisType> paperThesisTypeList=new ArrayList<>();
        for (PaperThesisTypeDto paperThesisTypeDto :paperThesisTypeDtos) {
            SrmPaperThesisType srmPaperThesisType = new SrmPaperThesisType();
            srmPaperThesisType.setId(paperThesisTypeDto.getRowId());
            if(ObjectUtil.isEmpty(paperThesisTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PT_TYPE, 1, "");
                srmPaperThesisType.setCode(code);
            }else{
                srmPaperThesisType.setCode(paperThesisTypeDto.getCode());
            }
            srmPaperThesisType.setName(paperThesisTypeDto.getName());
            srmPaperThesisType.setIsValid(paperThesisTypeDto.getIsValid());

            paperThesisTypeList.add(srmPaperThesisType);
            Long RowId = srmPaperThesisType.getId();
        }
        super.saveOrUpdateBatch(paperThesisTypeList);
        return RowId;
    }
    @Override
    public PaperThesisTypeVo getDetailPaperThesisType(Long RowId) {
        return null;
    }

    @Override
    public IPage<PaperThesisTypeVo> listPaperThesisType(PaperThesisTypeDto paperThesisTypeDto) {
        Page<PaperThesisTypeVo> page = new Page<>(paperThesisTypeDto.getPage(), paperThesisTypeDto.getRows());
        IPage<PaperThesisTypeVo> res= srmPaperThesisTypeMapper.listPaperThesisType(page, paperThesisTypeDto);
        //List<PaperThesisTypeVo> records=res.getRecords();
        //List<PaperThesisTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePaperThesisType(BaseDto baseDto) {
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
    @Override
    public List<CombVo> getPaperThesisType() {
        return srmPaperThesisTypeMapper.getPaperThesisType();
    }

}
