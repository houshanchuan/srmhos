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
import com.mediway.hos.srm.business.center.model.dto.baseData.JobTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmJobType;
import com.mediway.hos.srm.business.center.model.vo.baseData.JobTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmJobTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmJobTypeMapper;

/**
 * <p>
 * 科研人员岗位性质 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmJobTypeServiceImpl extends BaseServiceImpl<SrmJobTypeMapper, SrmJobType> implements SrmJobTypeService {
    @Autowired
    private SrmJobTypeService  srmJobTypeService;
    @Autowired
    private SrmJobTypeMapper srmJobTypeMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateJobType(BaseDataUserDto baseDataUserDto) {
        List<JobTypeDto> jobTypeDtos =baseDataUserDto.getJobTypes();

        List<SrmJobType> jobTypeList=new ArrayList<>();
        for (JobTypeDto jobTypeDto :jobTypeDtos) {
            SrmJobType srmJobType = new SrmJobType();
            srmJobType.setId(jobTypeDto.getRowId());
            if(ObjectUtil.isEmpty(jobTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_JOB_TYPE, 3, "");
                srmJobType.setCode(code);
            }else{
                srmJobType.setCode(jobTypeDto.getCode());
            }
            srmJobType.setName(jobTypeDto.getName());
            srmJobType.setIsValid(Integer.valueOf(jobTypeDto.getIsValid()));

            jobTypeList.add(srmJobType);
            Long RowId = srmJobType.getId();
        }
        super.saveOrUpdateBatch(jobTypeList);
        return RowId;
    }
    @Override
    public JobTypeVo getDetailJobType(Long RowId) {
        return null;
    }

    @Override
    public IPage<JobTypeVo> listJobType(JobTypeDto jobTypeDto) {
        Page<JobTypeVo> page = new Page<>(jobTypeDto.getPage(), jobTypeDto.getRows());
        IPage<JobTypeVo> res= srmJobTypeMapper.listJobType(page, jobTypeDto);
        //List<JobTypeVo> records=res.getRecords();
        //List<JobTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteJobType(BaseDto baseDto) {
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
    public List<CombVo> getJobType(JobTypeDto jobTypeDto)  {
            return srmJobTypeMapper.getJobType(jobTypeDto);
    }
}
