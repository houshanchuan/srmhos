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
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjStatSourceDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjStatSourceVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjStatSource;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjStatSourceService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProjStatSourceMapper;
/**
 * <p>
 * 项目来源表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjStatSourceServiceImpl extends BaseServiceImpl<SrmProjStatSourceMapper, SrmProjStatSource> implements SrmProjStatSourceService {

    @Autowired
    private SrmProjStatSourceService  srmProjStatSourceService;
    @Autowired
    private SrmProjStatSourceMapper srmProjStatSourceMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateProjStatSource(BaseDataProjDto baseDataProjDto) {
        List<ProjStatSourceDto> projStatSourceDtos =baseDataProjDto.getProjStatSources();

        List<SrmProjStatSource> projStatSourceList=new ArrayList<>();
        for (ProjStatSourceDto projStatSourceDto :projStatSourceDtos) {
            SrmProjStatSource srmProjStatSource = new SrmProjStatSource();
            srmProjStatSource.setId(projStatSourceDto.getRowId());
            if(ObjectUtil.isEmpty(projStatSourceDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PRJ_SOURCE, 2, "");
                srmProjStatSource.setCode(code);
            }else{
                srmProjStatSource.setCode(projStatSourceDto.getCode());
            }
            srmProjStatSource.setName(projStatSourceDto.getName());
            srmProjStatSource.setIsValid(projStatSourceDto.getIsValid());
            srmProjStatSource.setClassCode(projStatSourceDto.getClassCode());

            projStatSourceList.add(srmProjStatSource);
            Long RowId = srmProjStatSource.getId();
        }
        super.saveOrUpdateBatch(projStatSourceList);
        return RowId;
    }
    @Override
    public ProjStatSourceVo getDetailProjStatSource(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProjStatSourceVo> listProjStatSource(ProjStatSourceDto projStatSourceDto) {
        Page<ProjStatSourceVo> page = new Page<>(projStatSourceDto.getPage(), projStatSourceDto.getRows());
        IPage<ProjStatSourceVo> res= srmProjStatSourceMapper.listProjStatSource(page, projStatSourceDto);
        //List<ProjStatSourceVo> records=res.getRecords();
        //List<ProjStatSourceVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteProjStatSource(BaseDto baseDto) {
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
    public List<CombVo> getProjStatSource() {
        return srmProjStatSourceMapper.getProjStatSource();
    }
}
