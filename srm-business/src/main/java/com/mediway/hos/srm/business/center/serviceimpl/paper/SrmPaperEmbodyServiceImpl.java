package com.mediway.hos.srm.business.center.serviceimpl.paper;

import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperEmbody;
import com.mediway.hos.srm.business.center.mapper.paper.SrmPaperEmbodyMapper;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperEmbodyVo;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperEmbodyService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 论文收录表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPaperEmbodyServiceImpl extends BaseServiceImpl<SrmPaperEmbodyMapper, SrmPaperEmbody> implements SrmPaperEmbodyService {
    @Autowired
    private SrmPaperEmbodyMapper srmPaperEmbodyMapper;
    @Override
    public List<PaperEmbodyVo> listPaperEmbody(BaseDto baseDto) {

        System.out.println(baseDto);
        return srmPaperEmbodyMapper.listPaperEmbody(baseDto.getId());
    }

    @Override
    public void deletePaperEmbodyByPaper(Long paperId) {
        srmPaperEmbodyMapper.deletePaperEmbodyByPaper(paperId);
    }

    @Override
    @Transactional
    public void deletePaperEmbodyByIds(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
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
}
