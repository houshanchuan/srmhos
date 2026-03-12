package com.mediway.hos.srm.business.center.serviceimpl.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.SchoolSignDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.SchoolSignVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmSchoolSign;
import com.mediway.hos.srm.business.center.service.baseData.SrmSchoolSignService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmSchoolSignMapper;
/**
 * <p>
 * 单位签名排序 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmSchoolSignServiceImpl extends BaseServiceImpl<SrmSchoolSignMapper, SrmSchoolSign> implements SrmSchoolSignService {

    @Autowired
    private SrmSchoolSignMapper srmSchoolSignMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateSchoolSign(BaseDataLearningDto baseDataLearningDto) {
        List<SchoolSignDto> schoolSignDtos =baseDataLearningDto.getSchoolSigns();

        List<SrmSchoolSign> schoolSignList=new ArrayList<>();
        for (SchoolSignDto schoolSignDto :schoolSignDtos) {
            SrmSchoolSign srmSchoolSign = new SrmSchoolSign();
            srmSchoolSign.setId(schoolSignDto.getRowId());
            srmSchoolSign.setCode(schoolSignDto.getCode());
            srmSchoolSign.setName(schoolSignDto.getName());
            srmSchoolSign.setIsValid(schoolSignDto.getIsValid());

            schoolSignList.add(srmSchoolSign);
            Long RowId = srmSchoolSign.getId();
        }
        super.saveOrUpdateBatch(schoolSignList);
        return RowId;
    }
    @Override
    public SchoolSignVo getDetailSchoolSign(Long RowId) {
        return null;
    }

    @Override
    public IPage<SchoolSignVo> listSchoolSign(SchoolSignDto schoolSignDto) {
        Page<SchoolSignVo> page = new Page<>(schoolSignDto.getPage(),schoolSignDto.getRows());
        IPage<SchoolSignVo> res= srmSchoolSignMapper.listSchoolSign(page,schoolSignDto);
        return res;
    }

    @Override
    public void deleteSchoolSign(BaseDto baseDto) {
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
