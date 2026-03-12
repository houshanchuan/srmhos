package com.mediway.hos.srm.business.center.serviceimpl.approvalProcess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.approvalProcess.EafMainDto;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafMain;
import com.mediway.hos.srm.business.center.mapper.approvalProcess.SrmEafMainMapper;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafMainVo;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafMainService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 审批流主表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-21
 */
@Service
public class SrmEafMainServiceImpl extends BaseServiceImpl<SrmEafMainMapper, SrmEafMain> implements SrmEafMainService {
    @Autowired
    private SrmEafMainMapper srmEafMainMapper;
    @Override
    @Transactional
    public void saveeafMain(List<EafMainDto> eafMainDtos) {
        try{
            List<SrmEafMain> eafMainList=new ArrayList<>();
            for (EafMainDto eafMainDto :eafMainDtos){
                SrmEafMain eafMain=new SrmEafMain();
                eafMain.setId(eafMainDto.getRowId());
                eafMain.setCode(eafMainDto.getCode());
                if(eafMainDto.getCode()==null||eafMainDto.getCode().isEmpty()){
                    throw new ErrorException("-200","代码不能为空");
                }
                eafMain.setName(eafMainDto.getName());
                eafMain.setIsValid(eafMainDto.getIsValid());
                eafMainList.add(eafMain);
            }
            super.saveOrUpdateBatch(eafMainList);
        }catch (Exception exception){
            throw new ErrorException("-200","保存失败");
        }

    }

    @Override
    public List<EafMainVo> listEafMain() {
        return srmEafMainMapper.listEafMain();
    }

    @Override
    @Transactional
    public void delete(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            super.deleteByIds(idStr);
        }catch (Exception exception){
            throw  new ErrorException("-200",exception.getMessage());
        }
    }
}
