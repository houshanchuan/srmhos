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

import com.mediway.hos.srm.business.center.model.dto.baseData.DegreeTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmDegreeType;
import com.mediway.hos.srm.business.center.model.vo.baseData.DegreeTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmDegreeTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmDegreeTypeMapper;
/**
 * <p>
 * 学位点类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmDegreeTypeServiceImpl extends BaseServiceImpl<SrmDegreeTypeMapper, SrmDegreeType> implements SrmDegreeTypeService {
    @Autowired
    private SrmDegreeTypeService  srmDegreeTypeService;
    @Autowired
    private SrmDegreeTypeMapper srmDegreeTypeMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateDegreeType(BaseDataUserDto baseDataUserDto) {
        List<DegreeTypeDto> degreeTypeDtos =baseDataUserDto.getDegreeTypes();

        List<SrmDegreeType> degreeTypeList=new ArrayList<>();
        for (DegreeTypeDto degreeTypeDto :degreeTypeDtos) {
            SrmDegreeType srmDegreeType = new SrmDegreeType();
            srmDegreeType.setId(degreeTypeDto.getRowId());
            if(ObjectUtil.isEmpty(degreeTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_DEGREE_TYPE, 1, "");
                srmDegreeType.setCode(code);
            }else{
                srmDegreeType.setCode(degreeTypeDto.getCode());
            }
            srmDegreeType.setName(degreeTypeDto.getName());
            srmDegreeType.setIsValid(Integer.valueOf(degreeTypeDto.getIsValid()));

            degreeTypeList.add(srmDegreeType);
            Long RowId = srmDegreeType.getId();
        }
        super.saveOrUpdateBatch(degreeTypeList);
        return RowId;
    }
    @Override
    public DegreeTypeVo getDetailDegreeType(Long RowId) {
        return null;
    }

    @Override
    public IPage<DegreeTypeVo> listDegreeType(DegreeTypeDto degreeTypeDto) {
        Page<DegreeTypeVo> page = new Page<>(degreeTypeDto.getPage(), degreeTypeDto.getRows());
        IPage<DegreeTypeVo> res= srmDegreeTypeMapper.listDegreeType(page, degreeTypeDto);
        //List<DegreeTypeVo> records=res.getRecords();
        //List<DegreeTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteDegreeType(BaseDto baseDto) {
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
