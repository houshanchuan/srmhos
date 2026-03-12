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

import com.mediway.hos.srm.business.center.model.dto.baseData.PaperCASPartitionDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPaperCasPartition;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmPaperCasPartitionMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperCASPartitionVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPaperCasPartitionService;

import javax.annotation.Resource;

/**
 * <p>
 * 中科院论文分区 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPaperCasPartitionServiceImpl extends BaseServiceImpl<SrmPaperCasPartitionMapper, SrmPaperCasPartition> implements SrmPaperCasPartitionService {
    @Autowired
    private SrmPaperCasPartitionService  srmPaperCasPartitionService;
    @Autowired
    private SrmPaperCasPartitionMapper srmPaperCasPartitionMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdatePaperCasPartition(BaseDataLearningDto baseDataLearningDto) {
        List<PaperCASPartitionDto> paperCasPartitionDtos =baseDataLearningDto.getPaperCASPartitions();

        List<SrmPaperCasPartition> paperCasPartitionList=new ArrayList<>();
        for (PaperCASPartitionDto paperCasPartitionDto :paperCasPartitionDtos) {
            SrmPaperCasPartition srmPaperCasPartition = new SrmPaperCasPartition();
            srmPaperCasPartition.setId(paperCasPartitionDto.getRowId());
            if(ObjectUtil.isEmpty(paperCasPartitionDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PT_CAS_PART, 1, "");
                srmPaperCasPartition.setCode(code);
            }else{
                srmPaperCasPartition.setCode(paperCasPartitionDto.getCode());
            }
            srmPaperCasPartition.setName(paperCasPartitionDto.getName());
            srmPaperCasPartition.setIsValid(Integer.valueOf(paperCasPartitionDto.getIsValid()));

            paperCasPartitionList.add(srmPaperCasPartition);
            Long RowId = srmPaperCasPartition.getId();
        }
        super.saveOrUpdateBatch(paperCasPartitionList);
        return RowId;
    }
    @Override
    public PaperCASPartitionVo getDetailPaperCasPartition(Long RowId) {
        return null;
    }

    @Override
    public IPage<PaperCASPartitionVo> listPaperCasPartition(PaperCASPartitionDto paperCasPartitionDto) {
        Page<PaperCASPartitionVo> page = new Page<>(paperCasPartitionDto.getPage(), paperCasPartitionDto.getRows());
        IPage<PaperCASPartitionVo> res= srmPaperCasPartitionMapper.listPaperCasPartition(page, paperCasPartitionDto);
        //List<PaperCasPartitionVo> records=res.getRecords();
        //List<PaperCasPartitionVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePaperCasPartition(BaseDto baseDto) {
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
