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

import com.mediway.hos.srm.business.center.model.dto.baseData.DeptLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.DeptLevelVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmDeptLevel;
import com.mediway.hos.srm.business.center.service.baseData.SrmDeptLevelService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmDeptLevelMapper;

/**
 * <p>
 * 部门级别 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmDeptLevelServiceImpl extends BaseServiceImpl<SrmDeptLevelMapper, SrmDeptLevel> implements SrmDeptLevelService {

    @Autowired
    private SrmDeptLevelMapper srmDeptLevelMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateDeptLevel(BaseDataUserDto baseDataUserDto) {
        List<DeptLevelDto> deptLevelDtos =baseDataUserDto.getDeptLevels();

        List<SrmDeptLevel> deptLevelList=new ArrayList<>();
        for (DeptLevelDto deptLevelDto :deptLevelDtos) {
            SrmDeptLevel srmDeptLevel = new SrmDeptLevel();
            srmDeptLevel.setId(deptLevelDto.getRowId());
            srmDeptLevel.setCode(deptLevelDto.getCode());
            srmDeptLevel.setName(deptLevelDto.getName());
            srmDeptLevel.setIsValid(deptLevelDto.getIsValid());

            deptLevelList.add(srmDeptLevel);
            Long RowId = srmDeptLevel.getId();
        }
        super.saveOrUpdateBatch(deptLevelList);
        return RowId;
    }
    @Override
    public DeptLevelVo getDetailDeptLevel(Long RowId) {
        return null;
    }

    @Override
    public IPage<DeptLevelVo> listDeptLevel(DeptLevelDto deptLevelDto) {
        Page<DeptLevelVo> page = new Page<>(deptLevelDto.getPage(),deptLevelDto.getRows());
        IPage<DeptLevelVo> res= srmDeptLevelMapper.listDeptLevel(page,deptLevelDto);
        return res;
    }

    @Override
    public void deleteDeptLevel(BaseDto baseDto) {
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
