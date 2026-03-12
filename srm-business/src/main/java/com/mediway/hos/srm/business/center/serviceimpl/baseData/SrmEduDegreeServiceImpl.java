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
import com.mediway.hos.srm.business.center.model.dto.baseData.EduDegreeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEduDegree;
import com.mediway.hos.srm.business.center.model.vo.baseData.EduDegreeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmEduDegreeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmEduDegreeMapper;

/**
 * <p>
 * 学位表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmEduDegreeServiceImpl extends BaseServiceImpl<SrmEduDegreeMapper, SrmEduDegree> implements SrmEduDegreeService {
    @Autowired
    private SrmEduDegreeService  srmEduDegreeService;
    @Autowired
    private SrmEduDegreeMapper srmEduDegreeMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateEduDegree(BaseDataUserDto baseDataUserDto) {
        List<EduDegreeDto> eduDegreeDtos =baseDataUserDto.getEduDegrees();

        List<SrmEduDegree> eduDegreeList=new ArrayList<>();
        for (EduDegreeDto eduDegreeDto :eduDegreeDtos) {
            SrmEduDegree srmEduDegree = new SrmEduDegree();
            srmEduDegree.setId(eduDegreeDto.getRowId());
            if(ObjectUtil.isEmpty(eduDegreeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.USER_EU_DEGREE, 2, "");
                srmEduDegree.setCode(code);
            }else{
                srmEduDegree.setCode(eduDegreeDto.getCode());
            }
            srmEduDegree.setName(eduDegreeDto.getName());
            srmEduDegree.setIsValid(Integer.valueOf(eduDegreeDto.getIsValid()));

            eduDegreeList.add(srmEduDegree);
            Long RowId = srmEduDegree.getId();
        }
        super.saveOrUpdateBatch(eduDegreeList);
        return RowId;
    }
    @Override
    public EduDegreeVo getDetailEduDegree(Long RowId) {
        return null;
    }

    @Override
    public IPage<EduDegreeVo> listEduDegree(EduDegreeDto eduDegreeDto) {
        Page<EduDegreeVo> page = new Page<>(eduDegreeDto.getPage(), eduDegreeDto.getRows());
        IPage<EduDegreeVo> res= srmEduDegreeMapper.listEduDegree(page, eduDegreeDto);
        //List<EduDegreeVo> records=res.getRecords();
        //List<EduDegreeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteEduDegree(BaseDto baseDto) {
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

    public List<CombVo> getEduDegree(EduDegreeDto eduDegreeDto){
        return srmEduDegreeMapper.getEduDegree(eduDegreeDto);
    }

}
