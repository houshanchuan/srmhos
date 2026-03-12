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
import com.mediway.hos.srm.business.center.model.dto.baseData.PageSpaceDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPageSpace;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmPageSpaceMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.PageSpaceVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPageSpaceService;

import javax.annotation.Resource;

/**
 * <p>
 * 版面 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPageSpaceServiceImpl extends BaseServiceImpl<SrmPageSpaceMapper, SrmPageSpace> implements SrmPageSpaceService {
    @Autowired
    private SrmPageSpaceService  srmPageSpaceService;
    @Autowired
    private SrmPageSpaceMapper srmPageSpaceMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdatePageSpace(BaseDataLearningDto baseDataLearningDto) {
        List<PageSpaceDto> pageSpaceDtos =baseDataLearningDto.getPageSpaces();

        List<SrmPageSpace> pageSpaceList=new ArrayList<>();
        for (PageSpaceDto pageSpaceDto :pageSpaceDtos) {
            SrmPageSpace srmPageSpace = new SrmPageSpace();
            srmPageSpace.setId(pageSpaceDto.getRowId());
            if(ObjectUtil.isEmpty(pageSpaceDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PT_PAGE_SPACE, 1, "");
                srmPageSpace.setCode(code);
            }else{
                srmPageSpace.setCode(pageSpaceDto.getCode());
            }
            srmPageSpace.setName(pageSpaceDto.getName());
            srmPageSpace.setIsValid(Integer.valueOf(pageSpaceDto.getIsValid()));

            pageSpaceList.add(srmPageSpace);
            Long RowId = srmPageSpace.getId();
        }
        super.saveOrUpdateBatch(pageSpaceList);
        return RowId;
    }
    @Override
    public PageSpaceVo getDetailPageSpace(Long RowId) {
        return null;
    }

    @Override
    public IPage<PageSpaceVo> listPageSpace(PageSpaceDto pageSpaceDto) {
        Page<PageSpaceVo> page = new Page<>(pageSpaceDto.getPage(), pageSpaceDto.getRows());
        IPage<PageSpaceVo> res= srmPageSpaceMapper.listPageSpace(page, pageSpaceDto);
        //List<PageSpaceVo> records=res.getRecords();
        //List<PageSpaceVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePageSpace(BaseDto baseDto) {
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
    public List<CombVo> getPageSpace(PageSpaceDto pageSpaceDto) {
        return srmPageSpaceMapper.getPageSpace(pageSpaceDto);
    }

}
