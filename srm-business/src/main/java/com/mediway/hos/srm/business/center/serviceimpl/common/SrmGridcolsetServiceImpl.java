package com.mediway.hos.srm.business.center.serviceimpl.common;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.common.GridColSetDto;
import com.mediway.hos.srm.business.center.model.dto.common.GridColSetMainDto;
import com.mediway.hos.srm.business.center.model.dto.common.GridColSetRowDto;
import com.mediway.hos.srm.business.center.model.entity.common.SrmGridcolset;
import com.mediway.hos.srm.business.center.mapper.common.SrmGridcolsetMapper;
import com.mediway.hos.srm.business.center.model.vo.common.GridColSetRowVo;
import com.mediway.hos.srm.business.center.service.common.SrmGridcolsetService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>
 * 列设置 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-11
 */
@Service
public class SrmGridcolsetServiceImpl extends BaseServiceImpl<SrmGridcolsetMapper, SrmGridcolset> implements SrmGridcolsetService {
    @Autowired
    private SrmGridcolsetMapper srmGridcolsetMapper;
    @Override
    public String ifGridColSetExist(GridColSetMainDto gridColSetMainDto) {
        return srmGridcolsetMapper.ifGridColSetExist(gridColSetMainDto);
    }

    @Override
    @Transactional
    public void saveGridColSet(GridColSetDto gridColSetDto) {
        GridColSetMainDto gridColSetMainDto=gridColSetDto.getGridColSetMainDto();
        List<GridColSetRowDto> gridColSetRowDtoList=gridColSetDto.getGridColSetRowDtoList();
        String usrCode=gridColSetMainDto.getUserCode();
        String hospId=gridColSetMainDto.getHospId();
        String groupId=gridColSetMainDto.getGroupId();
        String moduleType=gridColSetMainDto.getModuleType();
        String gridId=gridColSetMainDto.getGridId();
        String gridUrl=gridColSetMainDto.getGridUrl();
        String refence=null;
        try{
            if(moduleType!=null&&moduleType.equals("SSUser")){
                refence=usrCode;
            }
            if(moduleType!=null&&moduleType.equals("SSGroup")){
                if(groupId==null){
                    groupId="无安全组";
                }
                refence=groupId;
            }
            if(moduleType!=null&&moduleType.equals("SITE")){
                if(hospId==null){
                    hospId="无医院";
                }
                refence=hospId;
            }
            if(gridColSetRowDtoList.isEmpty()){
                throw new ErrorException("-200","没有要保存的数据!");
            }
            int order=0;
            List<SrmGridcolset> gridcolsets=new ArrayList<>();
            for (GridColSetRowDto gridColSetRowDto : gridColSetRowDtoList){
                order=order+1;
                SrmGridcolset gridcolset=new SrmGridcolset();
                gridcolset.setId(gridColSetRowDto.getRowId());
                gridcolset.setGridId(gridId);
                gridcolset.setGridurl(gridUrl);
                gridcolset.setType(moduleType);
                gridcolset.setReference(refence);
                gridcolset.setColName(gridColSetRowDto.getName());
                gridcolset.setColHeader(gridColSetRowDto.getHeader());
                gridcolset.setIsHidden(gridColSetRowDto.getHidden());
                gridcolset.setColOrder(order);
                gridcolset.setIsCopy(0);
                gridcolset.setIsNecessary(gridColSetRowDto.getNecessary());
                gridcolset.setIsFrozen(gridColSetRowDto.getFrozen());
                gridcolsets.add(gridcolset);
                gridcolset.setColAlign(gridColSetRowDto.getAlign());
                gridcolset.setColEnterOrder(gridColSetRowDto.getEnterSort());
                gridcolset.setColWidth(gridColSetRowDto.getWidth());
            }
            if(gridColSetRowDtoList.isEmpty()){
                throw new ErrorException("-201","没有要保存的数据!");
            }

            super.saveOrUpdateBatch(gridcolsets);
        }catch (Exception e){
            throw new ErrorException("-202",e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<GridColSetRowVo> initGridColSet(GridColSetDto gridColSetDto) {
        GridColSetMainDto gridColSetMainDto=gridColSetDto.getGridColSetMainDto();
        String moduleType=this.ifGridColSetExist(gridColSetMainDto);
        if(StringUtils.isEmpty(moduleType)){
            // 如果不存在，则需要重新生成
            this.saveGridColSet(gridColSetDto);
        }

        List<GridColSetRowDto> gridColSetRowDtoList=gridColSetDto.getGridColSetRowDtoList();
        SrmGridcolset gridcolset=new SrmGridcolset();
        return this.getGridColSet(gridColSetMainDto);
    }

    @Override
    public List<GridColSetRowVo> getGridColSet(GridColSetMainDto gridColSetMainDto) {
        return srmGridcolsetMapper.getGridColSet(gridColSetMainDto);
    }

    @Override
    public void retSetGridCol(GridColSetMainDto gridColSetMainDto) {
         srmGridcolsetMapper.retSetGridCol(gridColSetMainDto);

    }
}
