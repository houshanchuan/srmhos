package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
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

import com.mediway.hos.srm.business.center.model.dto.baseData.ExpertGroupDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ExpertGroupVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmExpertGroup;
import com.mediway.hos.srm.business.center.service.baseData.SrmExpertGroupService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmExpertGroupMapper;

/**
 * <p>
 * 专家组 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmExpertGroupServiceImpl extends BaseServiceImpl<SrmExpertGroupMapper, SrmExpertGroup> implements SrmExpertGroupService {

    @Autowired
    private SrmExpertGroupMapper srmExpertGroupMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateSrmExpertGroup(BaseDataUserDto baseDataUserDto) {
        List<ExpertGroupDto> expertGroupDtos =baseDataUserDto.getExpertGroups();

        List<SrmExpertGroup> srmExpertGroupList=new ArrayList<>();
        for (ExpertGroupDto expertGroupDto :expertGroupDtos) {
            SrmExpertGroup srmExpertGroup = new SrmExpertGroup();
            srmExpertGroup.setId(expertGroupDto.getRowId());
            srmExpertGroup.setCode(expertGroupDto.getCode());
            srmExpertGroup.setName(expertGroupDto.getName());
            srmExpertGroup.setIsValid(expertGroupDto.getIsValid());

            srmExpertGroupList.add(srmExpertGroup);
            Long RowId = srmExpertGroup.getId();
        }
        super.saveOrUpdateBatch(srmExpertGroupList);
        return RowId;
    }
    @Override
    public ExpertGroupVo getDetailSrmExpertGroup(Long RowId) {
        return null;
    }

    @Override
    public IPage<ExpertGroupVo> listSrmExpertGroup(ExpertGroupDto expertGroupDto) {
        Page<ExpertGroupVo> page = new Page<>(expertGroupDto.getPage(),expertGroupDto.getRows());
        IPage<ExpertGroupVo> res= srmExpertGroupMapper.listSrmExpertGroup(page,expertGroupDto);
        //List<ExpertGroupVo> records=res.getRecords();
        //List<ExpertGroupVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteSrmExpertGroup(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                if(StringUtils.isEmpty(idStr)){
                    idStr=String.valueOf(RowId);
                }else{
                    idStr=idStr+""+String.valueOf(RowId);
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
    public List<CombVo> getExpertGroup(){
        return srmExpertGroupMapper.getExpertGroup();
    }
}
