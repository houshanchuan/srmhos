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
import com.mediway.hos.srm.business.center.model.dto.baseData.PersonTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPersonType;
import com.mediway.hos.srm.business.center.model.vo.baseData.PersonTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPersonTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmPersonTypeMapper;
/**
 * <p>
 * 人员类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
@Service
public class SrmPersonTypeServiceImpl extends BaseServiceImpl<SrmPersonTypeMapper, SrmPersonType> implements SrmPersonTypeService {
    @Autowired
    private SrmPersonTypeMapper srmPersonTypeMapper;
    @Override
    public List<CombVo> getPersonType() {
        return srmPersonTypeMapper.getPersonType();
    }

    @Autowired
    private SrmPersonTypeService  srmPersonTypeService;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdatePersonType(BaseDataUserDto baseDataUserDto) {
        List<PersonTypeDto> personTypeDtos =baseDataUserDto.getPersonTypes();

        List<SrmPersonType> personTypeList=new ArrayList<>();
        for (PersonTypeDto personTypeDto :personTypeDtos) {
            SrmPersonType srmPersonType = new SrmPersonType();
            srmPersonType.setId(personTypeDto.getRowId());
            if(ObjectUtil.isEmpty(personTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_PERSON_TYPE, 1, "");
                srmPersonType.setCode(code);
            }else{
                srmPersonType.setCode(personTypeDto.getCode());
            }
            srmPersonType.setName(personTypeDto.getName());
            srmPersonType.setIsValid(personTypeDto.getIsValid());
            srmPersonType.setIsGraduate(personTypeDto.getIsGraduate());
            srmPersonType.setIsExternal(personTypeDto.getIsExternal());
            srmPersonType.setIsInStaff(personTypeDto.getIsInStaff());

            personTypeList.add(srmPersonType);
            Long RowId = srmPersonType.getId();
        }
        super.saveOrUpdateBatch(personTypeList);
        return RowId;
    }
    @Override
    public PersonTypeVo getDetailPersonType(Long RowId) {
        return null;
    }

    @Override
    public IPage<PersonTypeVo> listPersonType(PersonTypeDto personTypeDto) {
        Page<PersonTypeVo> page = new Page<>(personTypeDto.getPage(), personTypeDto.getRows());
        IPage<PersonTypeVo> res= srmPersonTypeMapper.listPersonType(page, personTypeDto);
        //List<PersonTypeVo> records=res.getRecords();
        //List<PersonTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePersonType(BaseDto baseDto) {
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
