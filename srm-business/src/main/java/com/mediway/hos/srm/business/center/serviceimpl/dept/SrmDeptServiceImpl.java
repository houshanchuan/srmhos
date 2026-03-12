package com.mediway.hos.srm.business.center.serviceimpl.dept;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.app.org.model.organization.entity.HosOrgDepartment;
import com.mediway.hos.app.org.model.pos.entity.HosOrgPosition;
import com.mediway.hos.app.org.model.pos.entity.HosOrgPositionDict;
import com.mediway.hos.app.org.model.post.entity.HosOrgPost;
import com.mediway.hos.app.org.service.organization.HosDepartmentService;
import com.mediway.hos.app.org.service.pos.HosPositionService;
import com.mediway.hos.app.org.service.post.HosPostService;
import com.mediway.hos.common.util.StringUtil;
import com.mediway.hos.common.util.UUIDUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import com.mediway.hos.srm.business.center.constants.SrmConstants;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.mapper.dept.SrmDeptMapper;
import com.mediway.hos.srm.business.center.model.dto.dept.DeptDto;
import com.mediway.hos.srm.business.center.model.entity.dept.SrmDept;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.dept.DeptVo;
import com.mediway.hos.srm.business.center.service.dept.HosSrmService;
import com.mediway.hos.srm.business.center.service.dept.SrmDeptService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 科室信息表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-19
 */
@Slf4j
@Service
public class SrmDeptServiceImpl extends BaseServiceImpl<SrmDeptMapper, SrmDept> implements SrmDeptService {
    @Resource
    private SrmDeptMapper srmDeptMapper;
    @Resource
    private SrmUserService srmUserService;
    @Resource
    private HosDepartmentService hosDepartmentService;
    @Resource
    private HosPositionService hosPositionService;
    @Resource
    private HosSrmService hosSrmService;
    @Resource
    private HosPostService hosPostService;

    @Override
    public IPage<DeptVo> listDept(DeptDto deptDto) {
        Page<DeptVo> page = new Page<>(deptDto.getPage(), deptDto.getRows());
        return srmDeptMapper.listDept(page, deptDto);

    }

    @Override
    public List<CombVo> getDept(DeptDto deptDto) {
        System.out.println(deptDto);
        return srmDeptMapper.getDept(deptDto);
    }

    @Override
    @Transactional
    public String saveDept(DeptDto deptDto) {
        String rowId=deptDto.getRowId();
        SrmDept srmDept = new SrmDept();
        try {
            if(StringUtil.isBlank(rowId)) {
                HosUser hosUser = SecurityUtils.getLoginUser();
                //srmDept.setId(UUIDUtils.getUUID());
                srmDept.setCreatorNo(hosUser.getAccountCode());
                srmDept.setCreateDate(LocalDateTime.now());
            }else{
                srmDept.setId(rowId);
                srmDept.setOperateTime(LocalDateTime.now());
            }
            srmDept.setCode(deptDto.getCode());
            srmDept.setName(deptDto.getName());
            srmDept.setDeptLevel(deptDto.getDeptLevel());
            srmDept.setDeptType(deptDto.getDeptType());
            srmDept.setHospital(deptDto.getHospital());
            srmDept.setHrId(deptDto.getHrId());
            srmDept.setIsAccounting(deptDto.getIsAccounting());
            srmDept.setIsBudg(deptDto.getIsBudg());
            srmDept.setIsItem(deptDto.getIsItem());
            srmDept.setIsValid(deptDto.getIsValid());
            srmDept.setIsLast(deptDto.getIsLast());
            srmDept.setIsResearch(deptDto.getIsResearch());
            if(ObjectUtil.isEmpty(deptDto.getSuperDeptId()))
                srmDept.setSuperDeptId("0");
            else
                srmDept.setSuperDeptId(deptDto.getSuperDeptId());
            srmDept.setDirector(deptDto.getDirector());
            srmDept.setDisciplineCode(deptDto.getDisciplineCode());
            srmDept.setHospital(deptDto.getHospital());
            super.saveOrUpdate(srmDept);
            //判断HOS是否存在对应科室
            if(StringUtil.isBlank(rowId)) {
                //同步hosdepartment表
                HosOrgDepartment hosOrgDepartmen = hosDepartmentService.selectById(srmDept.getId());
                if (ObjectUtil.isEmpty(hosOrgDepartmen)) {
                    hosOrgDepartmen = new HosOrgDepartment();
                    hosOrgDepartmen.setId(srmDept.getId());
                }
                hosOrgDepartmen.setOrgCode(srmDept.getHospital());
                hosOrgDepartmen.setCode(srmDept.getCode());
                hosOrgDepartmen.setParentId(srmDept.getSuperDeptId());
                hosOrgDepartmen.setName(srmDept.getName());
                hosOrgDepartmen.setActivity(true);
                hosOrgDepartmen.setOrgCode(srmDept.getHospital());
                hosDepartmentService.insert(hosOrgDepartmen);
                //新增部门职位关系
                //判断关系是否存在


                HosOrgPositionDict hosPositionDict = hosSrmService.getHosDefaultPositionDit();
                if (ObjectUtil.isEmpty(hosPositionDict)) {
                    throw new ErrorException("200", "没有对应的职位信息，无法创建科室");
                }
                //增加组织职位信息
                HosOrgPosition hosOrgPosition=new HosOrgPosition();
                hosOrgPosition.setId(UUIDUtils.getUUID());
                hosOrgPosition.setActivity(true);
                hosOrgPosition.setPoscCode(hosPositionDict.getCode());
                hosOrgPosition.setDeptCode(srmDept.getCode());
                hosOrgPosition.setPoscCode(hosPositionDict.getCode());
                hosOrgPosition.setDeptCode(srmDept.getCode());
                hosOrgPosition.setCode(srmDept.getCode() + "_" + hosPositionDict.getCode());
                hosOrgPosition.setName(srmDept.getName() + "_" + hosPositionDict.getName());
                hosPositionService.insert(hosOrgPosition);
                //添加业务岗位
                HosOrgPost hosOrgPost = new HosOrgPost();
                hosOrgPost.setId(UUIDUtils.getUUID());
                hosOrgPost.setDeptCode(srmDept.getCode());
                hosOrgPost.setCode(srmDept.getCode() + "_"+ SrmConstants.DEFAULT_POST_CODE);
                hosOrgPost = new HosOrgPost();
                hosOrgPost.setName(srmDept.getName() + "_everyone");
                hosOrgPost.setCode(srmDept.getCode() + "_everyone");
                hosOrgPost.setDeptCode(srmDept.getCode());
                hosOrgPost.setBuCode(SrmConstants.DEFAULT_BUSINESS_UNIT_CODE);
                hosOrgPost.setActivity(true);
                hosOrgPost.setPostcCode(SrmConstants.DEFAULT_POST_CODE);
                hosPostService.insert(hosOrgPost);
            }
        }catch (Exception e){
            log.info("新增部门异常：",e);
            throw new ErrorException("200", e.getMessage());
        }
        return rowId;
    }

    @Override
    public DeptVo getDetail(String rowId) {
        return srmDeptMapper.getDetail(rowId);
    }
    @Override
    public List<CombVo> getDivision() {
        return srmDeptMapper.getDivision();
    }
}
