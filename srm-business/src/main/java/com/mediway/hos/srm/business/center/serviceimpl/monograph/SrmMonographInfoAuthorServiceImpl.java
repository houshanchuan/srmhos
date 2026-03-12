package com.mediway.hos.srm.business.center.serviceimpl.monograph;

import com.mediway.hos.srm.business.center.model.dto.monograph.MonographAuthorDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.monograph.SrmMonographInfoAuthor;
import com.mediway.hos.srm.business.center.mapper.monograph.SrmMonographInfoAuthorMapper;
import com.mediway.hos.srm.business.center.model.vo.monograph.MonographAuthorVo;
import com.mediway.hos.srm.business.center.service.monograph.SrmMonographInfoAuthorService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 著作作者表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-25
 */
@Service
public class SrmMonographInfoAuthorServiceImpl extends BaseServiceImpl<SrmMonographInfoAuthorMapper, SrmMonographInfoAuthor> implements SrmMonographInfoAuthorService {
    @Autowired
    private SrmMonographInfoAuthorMapper srmMonographInfoAuthorMapper;
    @Override
    public Long saveOrUpdateMonographAuthor(SrmMonographInfoAuthor monographInfoAuthor) {

        super.saveOrUpdate(monographInfoAuthor);
        Long rowid=monographInfoAuthor.getId();
        return rowid;
    }

    @Override
    @Transactional
    public void deleteAuthorByMon(Long monographId) {
        srmMonographInfoAuthorMapper.deleteAuthorByMon(monographId);
    }

    @Override
    @Transactional
    public void deleteMonographAuthor(BaseDto baseDto) {
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

    @Override
    public List<MonographAuthorVo> ListMonographAuthor(Long monographId) {
        return srmMonographInfoAuthorMapper.ListMonographAuthor(monographId);
    }

    @Override
    public List<Long> getIdByMon(Long parref) {
        return srmMonographInfoAuthorMapper.getIdByMon(parref);
    }

    @Override
    public Long saveAuthor(MonographAuthorDto monographAuthorDto) {
        SrmMonographInfoAuthor srmMonographInfoAuthor=new SrmMonographInfoAuthor();
        srmMonographInfoAuthor.setId(monographAuthorDto.getRowId());
        return srmMonographInfoAuthor.getId();
    }
}
