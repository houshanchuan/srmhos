package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.FieldInputSetupDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.FieldInputSetupListDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmFieldInputSetup;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmFieldInputSetupMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.FieldInputSetUpVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmFieldInputSetupService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 字段输入属性设置 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-13
 */
@Service
public class SrmFieldInputSetupServiceImpl extends BaseServiceImpl<SrmFieldInputSetupMapper, SrmFieldInputSetup> implements SrmFieldInputSetupService {
    @Autowired
    private SrmFieldInputSetupMapper fieldInputSetupMapper;
    @Override
    @Transactional
    public void initFieldInputSetup(FieldInputSetupListDto fieldInputSetupListDto) {
        try{
            List<FieldInputSetupDto> fieldInputSetupDtoList=fieldInputSetupListDto.getFieldInputSetupDtoList();
            for(FieldInputSetupDto fieldInputSetupDto : fieldInputSetupDtoList){
                SrmFieldInputSetup fieldInputSetup=new SrmFieldInputSetup();
                fieldInputSetup.setId(fieldInputSetupDto.getRowId());
                String labelName=fieldInputSetupDto.getFieldLabel();
                String firstChar=labelName.substring(0,1);
                if(firstChar.equals("*")){
                    labelName=labelName.substring(1);
                }
                fieldInputSetup.setFieldLabel(labelName);
                fieldInputSetup.setFieldId(fieldInputSetupDto.getFieldId());
                fieldInputSetup.setFieldName(fieldInputSetupDto.getFieldName());
                fieldInputSetup.setAppFieldName(fieldInputSetupDto.getAppFieldName());
                fieldInputSetup.setUdfFieldLabel(fieldInputSetupDto.getUdfFieldLabel());
                fieldInputSetup.setWanYuanFlag(fieldInputSetupDto.getWanYuanFlag());
                fieldInputSetup.setIsRequired(fieldInputSetupDto.getIsRequired());
                fieldInputSetup.setSysNo(fieldInputSetupDto.getSysNo());
                Long rowId=fieldInputSetupMapper.getRowIdBySysField(fieldInputSetupDto.getSysNo(),fieldInputSetupDto.getFieldId());
                // 判断rowId是否存在，存在就不处理了
                if(rowId==null){
                    super.saveOrUpdate(fieldInputSetup);
                }
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    @Transactional
    public void saveFieldInputSetup(FieldInputSetupListDto fieldInputSetupListDto) {
        try{
            List<FieldInputSetupDto> fieldInputSetupDtoList=fieldInputSetupListDto.getFieldInputSetupDtoList();
            for(FieldInputSetupDto fieldInputSetupDto : fieldInputSetupDtoList){
                SrmFieldInputSetup fieldInputSetup=new SrmFieldInputSetup();
                fieldInputSetup.setId(fieldInputSetupDto.getRowId());
                fieldInputSetup.setFieldLabel(fieldInputSetupDto.getFieldLabel());
                fieldInputSetup.setFieldId(fieldInputSetupDto.getFieldId());
                fieldInputSetup.setFieldName(fieldInputSetupDto.getFieldName());
                fieldInputSetup.setAppFieldName(fieldInputSetupDto.getAppFieldName());
                fieldInputSetup.setUdfFieldLabel(fieldInputSetupDto.getUdfFieldLabel());
                fieldInputSetup.setWanYuanFlag(fieldInputSetupDto.getWanYuanFlag());
                fieldInputSetup.setIsRequired(fieldInputSetupDto.getIsRequired());
                fieldInputSetup.setSysNo(fieldInputSetupDto.getSysNo());
                super.saveOrUpdate(fieldInputSetup);
            }
        }catch (Exception e){
            throw new ErrorException("-200","保存失败!");
        }
    }

    @Override
    public List<FieldInputSetUpVo> getFieldInputSetup(FieldInputSetupDto fieldInputSetupDto) {
        String sysNo=fieldInputSetupDto.getSysNo();
        return fieldInputSetupMapper.getFieldInputSetup(sysNo);
    }

    @Override
    public void deleteFieldInputSet(FieldInputSetupDto fieldInputSetupDto) {
        String sysNo=fieldInputSetupDto.getSysNo();
        fieldInputSetupMapper.deleteFieldInputSet(sysNo);
    }
}
