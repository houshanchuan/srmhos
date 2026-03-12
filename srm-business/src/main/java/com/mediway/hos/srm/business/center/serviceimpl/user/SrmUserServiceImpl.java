package com.mediway.hos.srm.business.center.serviceimpl.user;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.app.core.model.sys.dto.HosUserAccountDTO;
import com.mediway.hos.app.core.model.sys.entity.HosUserAccount;
import com.mediway.hos.app.core.service.sys.HosUserAccountService;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.app.org.model.orgperson.entity.HosOrgEmpPosition;
import com.mediway.hos.app.org.model.orgperson.entity.HosOrgEmpPost;
import com.mediway.hos.app.org.model.orgperson.entity.HosOrgEmployee;
import com.mediway.hos.app.org.model.person.entity.HosOrgPerson;
import com.mediway.hos.app.org.model.pos.entity.HosOrgPosition;
import com.mediway.hos.app.org.model.post.entity.HosOrgPost;
import com.mediway.hos.app.org.service.orgperson.HosEmpPositionService;
import com.mediway.hos.app.org.service.orgperson.HosEmpPostService;
import com.mediway.hos.app.org.service.orgperson.HosOrgEmployeeService;
import com.mediway.hos.app.org.service.person.HosPersonService;
import com.mediway.hos.app.org.service.pos.HosPositionService;
import com.mediway.hos.app.org.service.post.HosPostService;
import com.mediway.hos.base.exception.BaseBusinessException;
import com.mediway.hos.common.util.StringUtil;
import com.mediway.hos.common.util.UUIDUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.mapper.user.SrmUserMapper;
import com.mediway.hos.srm.business.center.model.dto.user.UserDto;
import com.mediway.hos.srm.business.center.model.entity.dept.SrmDept;
import com.mediway.hos.srm.business.center.model.entity.dept.SrmDeptUser;
import com.mediway.hos.srm.business.center.model.entity.user.SrmUser;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.dept.DeptUserVo;
import com.mediway.hos.srm.business.center.model.vo.user.UserVo;
import com.mediway.hos.srm.business.center.service.dept.HosSrmService;
import com.mediway.hos.srm.business.center.service.dept.SrmDeptService;
import com.mediway.hos.srm.business.center.service.dept.SrmDeptUserService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import com.mediway.hos.srm.business.center.utils.DateTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.RowId;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 科研人员库 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
@Service
public class SrmUserServiceImpl extends BaseServiceImpl<SrmUserMapper, SrmUser> implements SrmUserService {
    @Resource
    private SrmUserMapper srmUserMapper;
    @Autowired
    private SrmDeptUserService srmDeptUserService;
    @Resource
    private HosOrgEmployeeService hosOrgEmployeeService;
    @Resource
    private HosPersonService hosPersonService;
    @Resource
    private HosSrmService hosSrmService;
    @Resource
    private SrmDeptService srmDeptService;
    @Resource
    private  HosEmpPositionService hosEmpPositionService;
    @Resource
    private HosPositionService hosPositionService;
    @Resource
    private HosUserAccountService hosUserAccountService;
    @Resource
    private HosEmpPostService hosEmpPostService;
    @Resource
    private HosPostService hosPostService;

    @Override
    public List<CombVo> getUser(UserDto userDto) {
        return srmUserMapper.getUser(userDto);
    }

    @Override
    public List<String> getUserNamesByIds(List<String> ids) {
        return srmUserMapper.getUserNamesByIds(ids);
    }

    @Override
    public Long getUserIdByAccount(String account) {
        if(StringUtil.isBlank(account)) {
            HosUser hosUser = SecurityUtils.getLoginUser();
            account = hosUser.getAccountCode();
        }
        return srmUserMapper.getUserIdByAccount(account);
    }

    @Override
    public UserVo getUserDetail(String id, String code) {
        return srmUserMapper.getUserDetail(id, code);
    }

    @Override
    @Transactional
    public String saveUser(UserDto userDto) {
        String rowId = userDto.getRowId();
        SrmUser srmUser =null;
        try {
            if (StringUtil.isNotBlank(rowId)) {
                srmUser = this.selectById(rowId);
                if (ObjectUtil.isEmpty(srmUser)) {
                    throw new BaseBusinessException("200", "不存在的用户");
                }
            } else {
                srmUser = new SrmUser();
                HosUser hosUser = SecurityUtils.getLoginUser();
                //srmUser.setId(UUIDUtils.getUUID());
                srmUser.setCreateTime(LocalDateTime.now());
                srmUser.setCreatorCode(hosUser.getAccountCode());
            }
            // String userCode = userDto.getUserCode();
            // Long srmUserRowId = this.getUserIdByAccount(userCode);
            srmUser.setHrUserCode(userDto.getUserCode());
            srmUser.setCode(userDto.getCode());
            srmUser.setName(userDto.getName());
            srmUser.setSex(userDto.getSexComb());
            srmUser.setPersonType(userDto.getPersonType());
            srmUser.setOccupationCategory(userDto.getOccupationCategory());
            srmUser.setTitle(userDto.getTitle());
            srmUser.setEduLevel(userDto.getEduLevel());
            srmUser.setDutyDate(DateTransform.getLocalDateTime(userDto.getDutyDate()));
            srmUser.setDept(userDto.getDept());
            srmUser.setEduDegree(userDto.getEduDegree());
            srmUser.setHonorTitle(userDto.getHonorTitle());
            srmUser.setDivision(userDto.getDivision());
            srmUser.setHrDeptCode(userDto.getHrDept());
            srmUser.setAccount(userDto.getAccount());
            srmUser.setIsExpert(userDto.getIsExpert());
            srmUser.setIsValid(userDto.getIsValid());
            srmUser.setIsEthicalExpert(userDto.getIsEthicalExpert());
            srmUser.setIsStat(userDto.getIsStat());
            srmUser.setDirection(userDto.getDirection());
            srmUser.setIntroduction(userDto.getIntroduction());
            srmUser.setIdNum(userDto.getIdNum());
            srmUser.setBirthday(DateTransform.getLocalDateTime(userDto.getBirthday()));
            srmUser.setEmail(userDto.getEmail());
            srmUser.setJobLevel(userDto.getJobLevel());
            srmUser.setJobType(userDto.getJobType());
            srmUser.setClassCode(userDto.getClassCode());
            srmUser.setDisciplineOne(userDto.getDisciplineOne());
            srmUser.setDisciplineTwo(userDto.getDisciplineTwo());
            srmUser.setDisciplineThree(userDto.getDisciplineThree());
            srmUser.setParttimePos(userDto.getParttimePos());
            srmUser.setGraduateSchool(userDto.getGraduateSchool());
            srmUser.setStartDate(DateTransform.getLocalDateTime(userDto.getStartDate()));
            srmUser.setEndDate(DateTransform.getLocalDateTime(userDto.getEndDate()));
            srmUser.setProfess(userDto.getProfess());
            srmUser.setTeacherType(userDto.getTeacherType());
            srmUser.setEmployDate(DateTransform.getLocalDateTime(userDto.getEmployDate()));
            srmUser.setDuty(userDto.getDuty());
            srmUser.setPolity(userDto.getPolity());
            srmUser.setNationlity(userDto.getNationlity());
            srmUser.setNation(userDto.getNation());
            srmUser.setPortraiture(userDto.getPortraiture());
            srmUser.setPostcode(userDto.getPostcode());
            srmUser.setPhone(userDto.getPhone());
            srmUser.setLearning(userDto.getLearning());
            srmUser.setExperienceAbroad(userDto.getExperienceAbroad());
            srmUser.setCreateTime(LocalDateTime.now());
            srmUser.setClassCode(userDto.getClassCode());
            srmUser.setPersonState(userDto.getPersonState());
            srmUser.setIsTeacher(userDto.getIsTeacher());
            srmUser.setCheckStatus("0");
            super.saveOrUpdate(srmUser);
            if (userDto.getDept() != null && !userDto.getDept().isEmpty()) {
                SrmDeptUser srmDeptUser = new SrmDeptUser();
                DeptUserVo deptUserVo = srmDeptUserService.getRowIdByDeptUser(userDto.getDept(), srmUser.getId().toString());
                if (deptUserVo != null) {
                    srmDeptUser.setId(deptUserVo.getId());
                }
                srmDeptUser.setDept(userDto.getDept());
                srmDeptUser.setUser(String.valueOf(rowId));
                srmDeptUser.setIsValid(1);
                srmDeptUser.setIsDirector(userDto.getIsDirector());
                srmDeptUser.setIsSecretary(0);
                srmDeptUserService.saveDeptUser(srmDeptUser);
            }
            //处理科研人员数据同步到hos系统
            if (StringUtil.isBlank(rowId)) {
                //添加人员信息
                HosOrgPerson person = new HosOrgPerson();
                person.setId(srmUser.getId().toString());
                person.setName(srmUser.getName());
                person.setPersonId(srmUser.getAccount());
                person.setPersonStatus("100");
                person.setIsDeleted(0);
                person.setActivity(true);
                hosPersonService.insert(person);
                //添加组织人员
                HosOrgEmployee employee = new HosOrgEmployee();
                employee.setId(person.getId());
                employee.setActivity(true);
                SrmDept dept = srmDeptService.getById(srmUser.getDept());
                employee.setOrgCode(dept.getHospital());
                employee.setStatus("10");
                employee.setPaPersonId(person.getPersonId());
                employee.setPersonCode(person.getPersonId());
                hosOrgEmployeeService.insert(employee);
                //添加部门人员
                HosOrgEmpPosition empPosition = new HosOrgEmpPosition();
                empPosition.setId(UUIDUtils.getUUID());
                empPosition.setDeptCode(dept.getCode());
                empPosition.setPaPersonId(person.getPersonId());
                HosOrgPosition tmpPosition = new HosOrgPosition();
                tmpPosition.setDeptCode(dept.getCode());
                List<HosOrgPosition> positionList = hosPositionService.selectList(tmpPosition);
                if (positionList == null || positionList.size() == 0) {
                    throw new ErrorException("200", "组织职位信息不存在，用户创建失败");
                }
                empPosition.setPosCode(positionList.get(0).getCode());//组织职位
                empPosition.setActivity(true);
                empPosition.setStatus(true);
                hosEmpPositionService.insert(empPosition);
                //添加人员账号
                HosUserAccount account = hosUserAccountService.selectByCode(person.getPersonId());
                if (account == null) {
                    HosUserAccountDTO userAccount = new HosUserAccountDTO();
                    userAccount.setId(UUIDUtils.getUUID());
                    userAccount.setCode(person.getPersonId());
                    userAccount.setName(srmUser.getName());
                    userAccount.setPaPersonId(person.getPersonId());
                    userAccount.setActivity(true);
                    hosUserAccountService.insert(userAccount);
                }
                //添加人员默认岗位everyone
                HosOrgEmpPost empPost = new HosOrgEmpPost();
                empPost.setId(UUIDUtils.getUUID());
                empPost.setDeptCode(dept.getCode());
                empPost.setStatus(true);
                empPost.setActivity(true);
                empPost.setPaPersonId(userDto.getAccount());
                //获取组织岗位
                HosOrgPost orgPost = hosSrmService.getDefaultHosOrgPost(dept.getCode());
                if (ObjectUtil.isEmpty(orgPost)) {
                    throw new ErrorException("200", "未获取到组织岗位，无法添加用户");
                }
                empPost.setPostCode(orgPost.getCode());
                hosEmpPostService.insert(empPost);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new BaseBusinessException("新增人员错误");
        }
        return rowId;
    }

    @Override
    public UserVo getDetail(String RowId) {
        return srmUserMapper.getDetail(RowId);
    }

    @Override
    public IPage<UserVo> listUser(UserDto userDto) {
        System.out.println(userDto);
        Page<UserVo> page = new Page<>(userDto.getPage(), userDto.getRows());
        IPage<UserVo> res = srmUserMapper.listUser(page, userDto);
        return res;
    }

    @Override
    public IPage<UserVo> listAuditUser(UserDto userDto) {
        //System.out.println(userDto);
        Page<UserVo> page = new Page<>(userDto.getPage(), userDto.getRows());
        IPage<UserVo> res = srmUserMapper.listAuditUser(page, userDto);
        return res;
    }

    @Override
    public Long auditUserYes(UserDto userDto) {
        String rowId=userDto.getRowId();
        SrmUser srmUser=new SrmUser();
        srmUser.setId(rowId);
        HosUser user = SecurityUtils.getLoginUser();
        Long srmUserRowId=getUserIdByAccount(user.getAccountCode());
        srmUser.setUpdateUser(srmUserRowId);
        srmUser.setUpdateTime(LocalDateTime.now());
        srmUser.setCheckStatus("1");
        return srmUserMapper.updateById(srmUser)+0l;
        //return srmUserMapper.auditUserChkStatus(rowId,"1");
    }

    @Override
    public Long auditUserNo(UserDto userDto) {
        String rowId=userDto.getRowId();
        SrmUser srmUser=new SrmUser();
        srmUser.setId(rowId);
        HosUser user = SecurityUtils.getLoginUser();
        Long srmUserRowId=getUserIdByAccount(user.getAccountCode());
        srmUser.setUpdateUser(srmUserRowId);
        srmUser.setUpdateTime(LocalDateTime.now());
        srmUser.setCheckStatus("2");
        return srmUserMapper.updateById(srmUser)+0l;
       // return srmUserMapper.auditUserChkStatus(rowId,"2");
    }

    @Override
    public List<CombVo> getTutor(){
        return srmUserMapper.getTutor();
    }

}
