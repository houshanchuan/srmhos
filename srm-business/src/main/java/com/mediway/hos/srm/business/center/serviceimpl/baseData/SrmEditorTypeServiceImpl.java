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
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.dto.baseData.EditorTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEditorType;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmEditorTypeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.EditorTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmEditorTypeService;

import javax.annotation.Resource;


/**
 * <p>
 * 编者类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
@Service
public class SrmEditorTypeServiceImpl extends BaseServiceImpl<SrmEditorTypeMapper, SrmEditorType> implements SrmEditorTypeService {
    @Autowired
    private SrmEditorTypeService  srmEditorTypeService;
    @Autowired
    private SrmEditorTypeMapper srmEditorTypeMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateEditorType(BaseDataLearningDto baseDataLearningDto) {
        List<EditorTypeDto> editorTypeDtos =baseDataLearningDto.getEditorTypes();

        List<SrmEditorType> editorTypeList=new ArrayList<>();
        for (EditorTypeDto editorTypeDto :editorTypeDtos) {
            SrmEditorType srmEditorType = new SrmEditorType();
            srmEditorType.setId(editorTypeDto.getRowId());
            if(ObjectUtil.isEmpty(editorTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PT_EDITOR_TYPE, 1, "");
                srmEditorType.setCode(code);
            }else{
                srmEditorType.setCode(editorTypeDto.getCode());
            }
            srmEditorType.setName(editorTypeDto.getName());
            srmEditorType.setIsValid(Integer.valueOf(editorTypeDto.getIsValid()));

            editorTypeList.add(srmEditorType);
            Long RowId = srmEditorType.getId();
        }
        super.saveOrUpdateBatch(editorTypeList);
        return RowId;
    }
    @Override
    public EditorTypeVo getDetailEditorType(Long RowId) {
        return null;
    }

    @Override
    public IPage<EditorTypeVo> listEditorType(EditorTypeDto editorTypeDto) {
        Page<EditorTypeVo> page = new Page<>(editorTypeDto.getPage(), editorTypeDto.getRows());
        IPage<EditorTypeVo> res= srmEditorTypeMapper.listEditorType(page, editorTypeDto);
        //List<EditorTypeVo> records=res.getRecords();
        //List<EditorTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteEditorType(BaseDto baseDto) {
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
    public List<CombVo> getEditorType() {
        return srmEditorTypeMapper.getEditorType();
    }
}
