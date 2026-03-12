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

import com.mediway.hos.srm.business.center.model.dto.baseData.NationDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmNation;
import com.mediway.hos.srm.business.center.model.vo.baseData.NationVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmNationService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmNationMapper;
/**
 * <p>
 * 民族代码表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmNationServiceImpl extends BaseServiceImpl<SrmNationMapper, SrmNation> implements SrmNationService {
    @Autowired
    private SrmNationService  srmNationService;
    @Autowired
    private SrmNationMapper srmNationMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateNation(BaseDataUserDto baseDataUserDto) {
        List<NationDto> nationDtos =baseDataUserDto.getNations();

        List<SrmNation> nationList=new ArrayList<>();
        for (NationDto nationDto :nationDtos) {
            SrmNation srmNation = new SrmNation();
            srmNation.setId(nationDto.getRowId());
            if(ObjectUtil.isEmpty(nationDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_NATION, 1, "");
                srmNation.setCode(code);
            }else{
                srmNation.setCode(nationDto.getCode());
            }
            srmNation.setName(nationDto.getName());
            srmNation.setIsValid(Integer.valueOf(nationDto.getIsValid()));

            nationList.add(srmNation);
            Long RowId = srmNation.getId();
        }
        super.saveOrUpdateBatch(nationList);
        return RowId;
    }
    @Override
    public NationVo getDetailNation(Long RowId) {
        return null;
    }

    @Override
    public IPage<NationVo> listNation(NationDto nationDto) {
        Page<NationVo> page = new Page<>(nationDto.getPage(), nationDto.getRows());
        IPage<NationVo> res= srmNationMapper.listNation(page, nationDto);
        //List<NationVo> records=res.getRecords();
        //List<NationVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteNation(BaseDto baseDto) {
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
    public List<CombVo> getNation(NationDto nationDto){
        return srmNationMapper.getNation(nationDto);
    }
}
