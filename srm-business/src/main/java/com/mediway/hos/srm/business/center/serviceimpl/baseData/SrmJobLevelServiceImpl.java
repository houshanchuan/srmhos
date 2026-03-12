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

import com.mediway.hos.srm.business.center.model.dto.baseData.JobLevelDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmJobLevel;
import com.mediway.hos.srm.business.center.model.vo.baseData.JobLevelVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmJobLevelService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmJobLevelMapper;


/**
 * <p>
 * 科研人员岗位层级 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmJobLevelServiceImpl extends BaseServiceImpl<SrmJobLevelMapper, SrmJobLevel> implements SrmJobLevelService {
    @Autowired
    private SrmJobLevelService  srmJobLevelService;
    @Autowired
    private SrmJobLevelMapper srmJobLevelMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateJobLevel(BaseDataUserDto baseDataUserDto) {
        List<JobLevelDto> jobLevelDtos =baseDataUserDto.getJobLevels();

        List<SrmJobLevel> jobLevelList=new ArrayList<>();
        for (JobLevelDto jobLevelDto :jobLevelDtos) {
            SrmJobLevel srmJobLevel = new SrmJobLevel();
            srmJobLevel.setId(jobLevelDto.getRowId());
            if(ObjectUtil.isEmpty(jobLevelDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_JOB_LEVEL, 2, "");
                srmJobLevel.setCode(code);
            }else{
                srmJobLevel.setCode(jobLevelDto.getCode());
            }
            srmJobLevel.setName(jobLevelDto.getName());
            srmJobLevel.setIsValid(Integer.valueOf(jobLevelDto.getIsValid()));

            jobLevelList.add(srmJobLevel);
            Long RowId = srmJobLevel.getId();
        }
        super.saveOrUpdateBatch(jobLevelList);
        return RowId;
    }
    @Override
    public JobLevelVo getDetailJobLevel(Long RowId) {
        return null;
    }

    @Override
    public IPage<JobLevelVo> listJobLevel(JobLevelDto jobLevelDto) {
        Page<JobLevelVo> page = new Page<>(jobLevelDto.getPage(), jobLevelDto.getRows());
        IPage<JobLevelVo> res= srmJobLevelMapper.listJobLevel(page, jobLevelDto);
        //List<JobLevelVo> records=res.getRecords();
        //List<JobLevelVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteJobLevel(BaseDto baseDto) {
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
    public List<CombVo> getJobLevel(){
        return srmJobLevelMapper.getJobLevel();
    }
}
