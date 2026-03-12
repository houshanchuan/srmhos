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
import com.mediway.hos.srm.business.center.model.dto.baseData.TutorTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmTutorType;
import com.mediway.hos.srm.business.center.model.vo.baseData.TutorTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmTutorTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmTutorTypeMapper;


/**
 * <p>
 * 指导老师类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmTutorTypeServiceImpl extends BaseServiceImpl<SrmTutorTypeMapper, SrmTutorType> implements SrmTutorTypeService {
    @Autowired
    private SrmTutorTypeService  srmTutorTypeService;
    @Autowired
    private SrmTutorTypeMapper srmTutorTypeMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateTutorType(BaseDataUserDto baseDataUserDto) {
        List<TutorTypeDto> tutorTypeDtos =baseDataUserDto.getTutorTypes();

        List<SrmTutorType> tutorTypeList=new ArrayList<>();
        for (TutorTypeDto tutorTypeDto :tutorTypeDtos) {
            SrmTutorType srmTutorType = new SrmTutorType();
            srmTutorType.setId(tutorTypeDto.getRowId());
            if(ObjectUtil.isEmpty(tutorTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_TUTOR_TYPE, 1, "");
                srmTutorType.setCode(code);
            }else{
                srmTutorType.setCode(tutorTypeDto.getCode());
            }
            srmTutorType.setName(tutorTypeDto.getName());
            srmTutorType.setIsValid(Integer.valueOf(tutorTypeDto.getIsValid()));

            tutorTypeList.add(srmTutorType);
            Long RowId = srmTutorType.getId();
        }
        super.saveOrUpdateBatch(tutorTypeList);
        return RowId;
    }
    @Override
    public TutorTypeVo getDetailTutorType(Long RowId) {
        return null;
    }

    @Override
    public IPage<TutorTypeVo> listTutorType(TutorTypeDto tutorTypeDto) {
        Page<TutorTypeVo> page = new Page<>(tutorTypeDto.getPage(), tutorTypeDto.getRows());
        IPage<TutorTypeVo> res= srmTutorTypeMapper.listTutorType(page, tutorTypeDto);
        //List<TutorTypeVo> records=res.getRecords();
        //List<TutorTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteTutorType(BaseDto baseDto) {
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
    public List<CombVo>getTutorType()
    {   return srmTutorTypeMapper.getTutorType();    }

}
