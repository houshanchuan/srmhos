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

import com.mediway.hos.srm.business.center.model.dto.baseData.CommitteeTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CommitteeTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmCommitteeType;
import com.mediway.hos.srm.business.center.service.baseData.SrmCommitteeTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmCommitteeTypeMapper;


/**
 * <p>
 * 学会类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmCommitteeTypeServiceImpl extends BaseServiceImpl<SrmCommitteeTypeMapper, SrmCommitteeType> implements SrmCommitteeTypeService {

    @Autowired
    private SrmCommitteeTypeMapper srmCommitteeTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateCommitteeType(BaseDataUserDto baseDataUserDto) {
        List<CommitteeTypeDto> committeeTypeDtos =baseDataUserDto.getCommitteeTypes();

        List<SrmCommitteeType> committeeTypeList=new ArrayList<>();
        for (CommitteeTypeDto committeeTypeDto :committeeTypeDtos) {
            SrmCommitteeType committeeType = new SrmCommitteeType();
            committeeType.setId(committeeTypeDto.getRowId());
            committeeType.setCode(committeeTypeDto.getCode());
            committeeType.setName(committeeTypeDto.getName());
            committeeType.setIsValid(committeeTypeDto.getIsValid());

            committeeTypeList.add(committeeType);
            Long RowId = committeeType.getId();
        }
        super.saveOrUpdateBatch(committeeTypeList);
        return RowId;
    }
    @Override
    public CommitteeTypeVo getDetailCommitteeType(Long RowId) {
        return null;
    }

    @Override
    public IPage<CommitteeTypeVo> listCommitteeType(CommitteeTypeDto committeeTypeDto) {
        Page<CommitteeTypeVo> page = new Page<>(committeeTypeDto.getPage(),committeeTypeDto.getRows());
        IPage<CommitteeTypeVo> res= srmCommitteeTypeMapper.listCommitteeType(page,committeeTypeDto);
        //List<CommitteeTypeVo> records=res.getRecords();
        //List<CommitteeTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteCommitteeType(BaseDto baseDto) {
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
}
