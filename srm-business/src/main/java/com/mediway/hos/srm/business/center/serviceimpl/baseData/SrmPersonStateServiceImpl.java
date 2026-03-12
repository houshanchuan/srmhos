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

import com.mediway.hos.srm.business.center.model.dto.baseData.PersonStateDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPersonState;
import com.mediway.hos.srm.business.center.model.vo.baseData.PersonStateVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPersonStateService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmPersonStateMapper;

/**
 * <p>
 * 人员状态表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPersonStateServiceImpl extends BaseServiceImpl<SrmPersonStateMapper, SrmPersonState> implements SrmPersonStateService {
    @Autowired
    private SrmPersonStateService  srmPersonStateService;
    @Autowired
    private SrmPersonStateMapper srmPersonStateMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdatePersonState(BaseDataUserDto baseDataUserDto) {
        List<PersonStateDto> personStateDtos =baseDataUserDto.getPersonStates();

        List<SrmPersonState> personStateList=new ArrayList<>();
        for (PersonStateDto personStateDto :personStateDtos) {
            SrmPersonState srmPersonState = new SrmPersonState();
            srmPersonState.setId(personStateDto.getRowId());
            if(ObjectUtil.isEmpty(personStateDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_PERSON_STATE, 1, "");
                srmPersonState.setCode(code);
            }else{
                srmPersonState.setCode(personStateDto.getCode());
            }
            srmPersonState.setName(personStateDto.getName());
            srmPersonState.setIsValid(Integer.valueOf(personStateDto.getIsValid()));

            personStateList.add(srmPersonState);
            Long RowId = srmPersonState.getId();
        }
        super.saveOrUpdateBatch(personStateList);
        return RowId;
    }
    @Override
    public PersonStateVo getDetailPersonState(Long RowId) {
        return null;
    }

    @Override
    public IPage<PersonStateVo> listPersonState(PersonStateDto personStateDto) {
        Page<PersonStateVo> page = new Page<>(personStateDto.getPage(), personStateDto.getRows());
        IPage<PersonStateVo> res= srmPersonStateMapper.listPersonState(page, personStateDto);
        //List<PersonStateVo> records=res.getRecords();
        //List<PersonStateVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePersonState(BaseDto baseDto) {
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
    public List<CombVo> getPersonState(){
        return srmPersonStateMapper.getPersonState();
    }
}
