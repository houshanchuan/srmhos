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
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.ParttimeJobDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmParttimeJob;
import com.mediway.hos.srm.business.center.model.vo.baseData.ParttimeJobVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmParttimeJobService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmParttimeJobMapper;

/**
 * <p>
 * 兼职职位表(职务类型) 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmParttimeJobServiceImpl extends BaseServiceImpl<SrmParttimeJobMapper, SrmParttimeJob> implements SrmParttimeJobService {
    @Autowired
    private SrmParttimeJobService  srmParttimeJobService;
    @Autowired
    private SrmParttimeJobMapper srmParttimeJobMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateParttimeJob(BaseDataUserDto baseDataUserDto) {
        List<ParttimeJobDto> parttimeJobDtos =baseDataUserDto.getParttimeJobs();

        List<SrmParttimeJob> parttimeJobList=new ArrayList<>();
        for (ParttimeJobDto parttimeJobDto :parttimeJobDtos) {
            SrmParttimeJob srmParttimeJob = new SrmParttimeJob();
            srmParttimeJob.setId(parttimeJobDto.getRowId());
            if(ObjectUtil.isEmpty(parttimeJobDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_PARTTIME_JOB, 1, "");
                srmParttimeJob.setCode(code);
            }else{
                srmParttimeJob.setCode(parttimeJobDto.getCode());
            }
            srmParttimeJob.setName(parttimeJobDto.getName());
            srmParttimeJob.setIsValid(Integer.valueOf(parttimeJobDto.getIsValid()));

            parttimeJobList.add(srmParttimeJob);
            Long RowId = srmParttimeJob.getId();
        }
        super.saveOrUpdateBatch(parttimeJobList);
        return RowId;
    }
    @Override
    public ParttimeJobVo getDetailParttimeJob(Long RowId) {
        return null;
    }

    @Override
    public IPage<ParttimeJobVo> listParttimeJob(ParttimeJobDto parttimeJobDto) {
        Page<ParttimeJobVo> page = new Page<>(parttimeJobDto.getPage(), parttimeJobDto.getRows());
        IPage<ParttimeJobVo> res= srmParttimeJobMapper.listParttimeJob(page, parttimeJobDto);
        //List<ParttimeJobVo> records=res.getRecords();
        //List<ParttimeJobVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteParttimeJob(BaseDto baseDto) {
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
    public List<CombVo> getPartTimeJob(ParttimeJobDto parttimeJobDto){ return srmParttimeJobMapper.getPartTimeJob(parttimeJobDto); }
}