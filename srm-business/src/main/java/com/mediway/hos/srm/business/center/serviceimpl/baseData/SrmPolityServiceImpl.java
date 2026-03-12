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

import com.mediway.hos.srm.business.center.model.dto.baseData.PolityDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPolity;
import com.mediway.hos.srm.business.center.model.vo.baseData.PolityVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPolityService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmPolityMapper;


/**
 * <p>
 * 政治面貌 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPolityServiceImpl extends BaseServiceImpl<SrmPolityMapper, SrmPolity> implements SrmPolityService {
    @Autowired
    private SrmPolityService  srmPolityService;
    @Autowired
    private SrmPolityMapper srmPolityMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdatePolity(BaseDataUserDto baseDataUserDto) {
        List<PolityDto> polityDtos =baseDataUserDto.getPolitys();

        List<SrmPolity> polityList=new ArrayList<>();
        for (PolityDto polityDto :polityDtos) {
            SrmPolity srmPolity = new SrmPolity();
            srmPolity.setId(polityDto.getRowId());
            if(ObjectUtil.isEmpty(polityDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_POLITY, 2, "");
                srmPolity.setCode(code);
            }else{
                srmPolity.setCode(polityDto.getCode());
            }
            srmPolity.setName(polityDto.getName());
            srmPolity.setIsValid(Integer.valueOf(polityDto.getIsValid()));

            polityList.add(srmPolity);
            Long RowId = srmPolity.getId();
        }
        super.saveOrUpdateBatch(polityList);
        return RowId;
    }
    @Override
    public PolityVo getDetailPolity(Long RowId) {
        return null;
    }

    @Override
    public IPage<PolityVo> listPolity(PolityDto polityDto) {
        Page<PolityVo> page = new Page<>(polityDto.getPage(), polityDto.getRows());
        IPage<PolityVo> res= srmPolityMapper.listPolity(page, polityDto);
        //List<PolityVo> records=res.getRecords();
        //List<PolityVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePolity(BaseDto baseDto) {
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
    public List<CombVo> getPolity(){
        return srmPolityMapper.getPolity();
    }

}
