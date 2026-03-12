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

import com.mediway.hos.srm.business.center.model.dto.baseData.ContentRealDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmContentReal;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmContentRealMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.ContentRealVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmContentRealService;

import javax.annotation.Resource;

/**
 * <p>
 * 内容真实性代码 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmContentRealServiceImpl extends BaseServiceImpl<SrmContentRealMapper, SrmContentReal> implements SrmContentRealService {
    @Autowired
    private SrmContentRealService  srmContentRealService;
    @Autowired
    private SrmContentRealMapper srmContentRealMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateContentReal(BaseDataLearningDto baseDataLearningDto) {
        List<ContentRealDto> contentRealDtos =baseDataLearningDto.getContentReals();

        List<SrmContentReal> contentRealList=new ArrayList<>();
        for (ContentRealDto contentRealDto :contentRealDtos) {
            SrmContentReal srmContentReal = new SrmContentReal();
            srmContentReal.setId(contentRealDto.getRowId());
            if(ObjectUtil.isEmpty(contentRealDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PT_CONTENT_REAL, 1, "");
                srmContentReal.setCode(code);
            }else{
                srmContentReal.setCode(contentRealDto.getCode());
            }
            srmContentReal.setName(contentRealDto.getName());
            srmContentReal.setIsValid(Integer.valueOf(contentRealDto.getIsValid()));

            contentRealList.add(srmContentReal);
            Long RowId = srmContentReal.getId();
        }
        super.saveOrUpdateBatch(contentRealList);
        return RowId;
    }
    @Override
    public ContentRealVo getDetailContentReal(Long RowId) {
        return null;
    }

    @Override
    public IPage<ContentRealVo> listContentReal(ContentRealDto contentRealDto) {
        Page<ContentRealVo> page = new Page<>(contentRealDto.getPage(), contentRealDto.getRows());
        IPage<ContentRealVo> res= srmContentRealMapper.listContentReal(page, contentRealDto);
        //List<ContentRealVo> records=res.getRecords();
        //List<ContentRealVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteContentReal(BaseDto baseDto) {
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
