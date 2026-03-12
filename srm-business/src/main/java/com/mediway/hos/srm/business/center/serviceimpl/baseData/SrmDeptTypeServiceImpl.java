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

import com.mediway.hos.srm.business.center.model.dto.baseData.DeptTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmDeptType;
import com.mediway.hos.srm.business.center.model.vo.baseData.DeptTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmDeptTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmDeptTypeMapper;



/**
 * <p>
 * 部门类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmDeptTypeServiceImpl extends BaseServiceImpl<SrmDeptTypeMapper, SrmDeptType> implements SrmDeptTypeService {

    @Autowired
    private SrmDeptTypeService  srmDeptTypeService;
    @Autowired
    private SrmDeptTypeMapper srmDeptTypeMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateDeptType(BaseDataUserDto baseDataUserDto) {
        List<DeptTypeDto> deptTypeDtos =baseDataUserDto.getDeptTypes();

        List<SrmDeptType> deptTypeList=new ArrayList<>();
        for (DeptTypeDto deptTypeDto :deptTypeDtos) {
            SrmDeptType srmDeptType = new SrmDeptType();
            srmDeptType.setId(deptTypeDto.getRowId());
            if(ObjectUtil.isEmpty(deptTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_DEPT_TYPE, 2, "");
                srmDeptType.setCode(code);
            }else{
                srmDeptType.setCode(deptTypeDto.getCode());
            }
            srmDeptType.setLevel(1);
            srmDeptType.setName(deptTypeDto.getName());
            srmDeptType.setIsValid(Integer.valueOf(deptTypeDto.getIsValid()));

            deptTypeList.add(srmDeptType);
            Long RowId = srmDeptType.getId();
        }
        super.saveOrUpdateBatch(deptTypeList);
        return RowId;
    }
    @Override
    public DeptTypeVo getDetailDeptType(Long RowId) {
        return null;
    }

    @Override
    public IPage<DeptTypeVo> listDeptType(DeptTypeDto deptTypeDto) {
        Page<DeptTypeVo> page = new Page<>(deptTypeDto.getPage(), deptTypeDto.getRows());
        IPage<DeptTypeVo> res= srmDeptTypeMapper.listDeptType(page, deptTypeDto);
        //List<DeptTypeVo> records=res.getRecords();
        //List<DeptTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteDeptType(BaseDto baseDto) {
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
