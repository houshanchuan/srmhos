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

import com.mediway.hos.srm.business.center.model.dto.baseData.PaperSciPartitionDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPaperSciPartition;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmPaperSciPartitionMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperSciPartitionVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPaperSciPartitionService;

import javax.annotation.Resource;

/**
 * <p>
 * SCI论文分区 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPaperSciPartitionServiceImpl extends BaseServiceImpl<SrmPaperSciPartitionMapper, SrmPaperSciPartition> implements SrmPaperSciPartitionService {
    @Autowired
    private SrmPaperSciPartitionService  srmPaperSciPartitionService;
    @Autowired
    private SrmPaperSciPartitionMapper srmPaperSciPartitionMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdatePaperSciPartition(BaseDataLearningDto baseDataLearningDto) {
        List<PaperSciPartitionDto> paperSciPartitionDtos =baseDataLearningDto.getPaperSciPartitions();

        List<SrmPaperSciPartition> paperSciPartitionList=new ArrayList<>();
        for (PaperSciPartitionDto paperSciPartitionDto :paperSciPartitionDtos) {
            SrmPaperSciPartition srmPaperSciPartition = new SrmPaperSciPartition();
            srmPaperSciPartition.setId(paperSciPartitionDto.getRowId());
            if(ObjectUtil.isEmpty(paperSciPartitionDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PT_SCI_PART, 1, "");
                srmPaperSciPartition.setCode(code);
            }else{
                srmPaperSciPartition.setCode(paperSciPartitionDto.getCode());
            }
            srmPaperSciPartition.setName(paperSciPartitionDto.getName());
            srmPaperSciPartition.setIsValid(Integer.valueOf(paperSciPartitionDto.getIsValid()));

            paperSciPartitionList.add(srmPaperSciPartition);
            Long RowId = srmPaperSciPartition.getId();
        }
        super.saveOrUpdateBatch(paperSciPartitionList);
        return RowId;
    }
    @Override
    public PaperSciPartitionVo getDetailPaperSciPartition(Long RowId) {
        return null;
    }

    @Override
    public IPage<PaperSciPartitionVo> listPaperSciPartition(PaperSciPartitionDto paperSciPartitionDto) {
        Page<PaperSciPartitionVo> page = new Page<>(paperSciPartitionDto.getPage(), paperSciPartitionDto.getRows());
        IPage<PaperSciPartitionVo> res= srmPaperSciPartitionMapper.listPaperSciPartition(page, paperSciPartitionDto);
        //List<PaperSciPartitionVo> records=res.getRecords();
        //List<PaperSciPartitionVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePaperSciPartition(BaseDto baseDto) {
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
