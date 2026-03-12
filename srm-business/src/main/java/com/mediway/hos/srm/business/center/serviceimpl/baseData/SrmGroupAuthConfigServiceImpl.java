package com.mediway.hos.srm.business.center.serviceimpl.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.GroupAuthConfigDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.GroupAuthConfigVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmGroupAuthConfig;
import com.mediway.hos.srm.business.center.service.baseData.SrmGroupAuthConfigService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmGroupAuthConfigMapper;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmGroupAuthConfigServiceImpl extends BaseServiceImpl<SrmGroupAuthConfigMapper, SrmGroupAuthConfig> implements SrmGroupAuthConfigService {

    @Autowired
    private SrmGroupAuthConfigMapper srmGroupAuthConfigMapper;
    private Long RowId;

    public List<CombVo> getGroup() {
        return srmGroupAuthConfigMapper.getGroup();
    }

    @Override
    @Transactional
    public Long saveOrUpdateGroupAuthConfig(BaseDataCommonDto baseDataCommonDto) {
        List<GroupAuthConfigDto> groupAuthConfigDtos =baseDataCommonDto.getGroupAuthConfigs();

        List<SrmGroupAuthConfig> groupAuthConfigList=new ArrayList<>();
        for (GroupAuthConfigDto groupAuthConfigDto :groupAuthConfigDtos) {
            SrmGroupAuthConfig srmGroupAuthConfig = new SrmGroupAuthConfig();
            srmGroupAuthConfig.setId(groupAuthConfigDto.getRowId());
            srmGroupAuthConfig.setGroupId(groupAuthConfigDto.getGroupId());
            srmGroupAuthConfig.setDataModify(String.valueOf(groupAuthConfigDto.getDataModify()));
            srmGroupAuthConfig.setMaintAllUser(String.valueOf(groupAuthConfigDto.getAuthMaintUser()));
            srmGroupAuthConfig.setWorkbenchPermissions(String.valueOf(groupAuthConfigDto.getWorkbenchPermissionsid()));
            srmGroupAuthConfig.setReqFieldsSetup(String.valueOf(groupAuthConfigDto.getRequiredFieldSet()));
            groupAuthConfigList.add(srmGroupAuthConfig);
            Long RowId = srmGroupAuthConfig.getId();
        }
        super.saveOrUpdateBatch(groupAuthConfigList);
        return RowId;
    }
    @Override
    public GroupAuthConfigVo getDetailGroupAuthConfig(Long RowId) {
        return null;
    }

    @Override
    public IPage<GroupAuthConfigVo> listGroupAuthConfig(GroupAuthConfigDto groupAuthConfigDto) {
        Page<GroupAuthConfigVo> page = new Page<>(groupAuthConfigDto.getPage(), groupAuthConfigDto.getRows());
        IPage<GroupAuthConfigVo> res= srmGroupAuthConfigMapper.listGroupAuthConfig(page, groupAuthConfigDto);
        //List<GroupAuthConfigVo> records=res.getRecords();
        //List<GroupAuthConfigVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteGroupAuthConfig(BaseDto baseDto) {
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
}
