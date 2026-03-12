package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.ReviewStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ReviewStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmReviewState;
import com.mediway.hos.srm.business.center.service.baseData.SrmReviewStateService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmReviewStateMapper;


/**
 * <p>
 * 评审状态 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmReviewStateServiceImpl extends BaseServiceImpl<SrmReviewStateMapper, SrmReviewState> implements SrmReviewStateService {

    @Autowired
    private SrmReviewStateService  srmReviewStateService;
    @Autowired
    private SrmReviewStateMapper srmReviewStateMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateReviewState(BaseDataCommonDto baseDataProjDto) {
        List<ReviewStateDto> reviewStateDtos =baseDataProjDto.getReviewStates();

        List<SrmReviewState> reviewStateList=new ArrayList<>();
        for (ReviewStateDto reviewStateDto :reviewStateDtos) {
            SrmReviewState srmReviewState = new SrmReviewState();
            srmReviewState.setId(reviewStateDto.getRowId());
            srmReviewState.setCode(reviewStateDto.getCode());
            srmReviewState.setName(reviewStateDto.getName());
            srmReviewState.setIsValid(Integer.valueOf(reviewStateDto.getIsValid()));

            reviewStateList.add(srmReviewState);
            Long RowId = srmReviewState.getId();
        }
        super.saveOrUpdateBatch(reviewStateList);
        return RowId;
    }
    @Override
    public ReviewStateVo getDetailReviewState(Long RowId) {
        return null;
    }

    @Override
    public IPage<ReviewStateVo> listReviewState(ReviewStateDto reviewStateDto) {
        Page<ReviewStateVo> page = new Page<>(reviewStateDto.getPage(), reviewStateDto.getRows());
        IPage<ReviewStateVo> res= srmReviewStateMapper.listReviewState(page, reviewStateDto);
        //List<ReviewStateVo> records=res.getRecords();
        //List<ReviewStateVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteReviewState(BaseDto baseDto) {
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
