package com.mediway.hos.srm.business.center.serviceimpl.paper;

import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperReship;
import com.mediway.hos.srm.business.center.mapper.paper.SrmPaperReshipMapper;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperEmbodyVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperReshipVo;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperReshipService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 论文转载表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPaperReshipServiceImpl extends BaseServiceImpl<SrmPaperReshipMapper, SrmPaperReship> implements SrmPaperReshipService {
    @Autowired
    private SrmPaperReshipMapper srmPaperReshipMapper;
    @Override
    public List<PaperReshipVo> listPaperReship(BaseDto baseDto) {
        return srmPaperReshipMapper.listPaperReship(baseDto.getId());
    }

    @Override
    public void deletePaperReshipByPaper(Long paperId) {

    }

    @Override
    @Transactional
    public void deletePaperReshipByIds(BaseDto baseDto) {
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
