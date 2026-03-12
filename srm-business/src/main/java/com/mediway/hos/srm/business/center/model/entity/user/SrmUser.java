package com.mediway.hos.srm.business.center.model.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 科研人员库
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="User对象", description="科研人员库")
@TableName("ct_srm_user")
public class SrmUser extends BasePO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID")
    private String id;

    @ApiModelProperty(value = "代码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "类型")
    @TableField("person_type")
    private String personType;

    @ApiModelProperty(value = "是否有效")
    @TableField("is_valid")
    private Integer isValid;

    @ApiModelProperty(value = "性别")
    @TableField("sex")
    private Integer sex;

    @ApiModelProperty(value = "生日")
    @TableField("birthday")
    private LocalDateTime birthday;

    @ApiModelProperty(value = "ID")
    @TableField("id_num")
    private String idNum;

    @ApiModelProperty(value = "职称")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "电话")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "电子邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "学位")
    @TableField("edu_degree")
    private String eduDegree;

    @ApiModelProperty(value = "机构")
    @TableField("hospital_id")
    private String hospitalId;

    @ApiModelProperty(value = "专著数")
    @TableField("monograph_num")
    private Integer monographNum;

    @ApiModelProperty(value = "发表论文数")
    @TableField("paper_num")
    private Integer paperNum;

    @ApiModelProperty(value = "专利数")
    @TableField("patent_num")
    private Integer patentNum;

    @ApiModelProperty(value = "参与定制技术标准数")
    @TableField("inv_tech_std_num")
    private Integer invTechStdNum;

    @ApiModelProperty(value = "培养人员数")
    @TableField("train_num")
    private Integer trainNum;

    @ApiModelProperty(value = "举办培训班数")
    @TableField("hold_train_num")
    private Integer holdTrainNum;

    @ApiModelProperty(value = "参与培训班数")
    @TableField("in_training_num")
    private Integer inTrainingNum;

    @ApiModelProperty(value = "所属科室编码")
    @TableField("dept")
    private String dept;

    @ApiModelProperty(value = "岗位性质")
    @TableField("job_type")
    private String jobType;

    @ApiModelProperty(value = "是否有教师资格证")
    @TableField("is_teacher")
    private Integer isTeacher;

    @ApiModelProperty(value = "是否专家")
    @TableField("is_expert")
    private Integer isExpert;

    @ApiModelProperty(value = "是否伦理专家")
    @TableField("is_ethical_expert")
    private Integer isEthicalExpert;

    @ApiModelProperty(value = "专业")
    @TableField("profess")
    private String profess;

    @ApiModelProperty(value = "研究方向")
    @TableField("direction")
    private String direction;

    @ApiModelProperty(value = "兼职职位名称")
    @TableField("parttime_pos")
    private String parttimePos;

    @ApiModelProperty(value = "开始日期")
    @TableField("start_date")
    private LocalDateTime startDate;

    @ApiModelProperty(value = "停止日期")
    @TableField("end_date")
    private LocalDateTime endDate;

    @ApiModelProperty(value = "教研室ID")
    @TableField("division")
    private String division;

    @ApiModelProperty(value = "学科门类ID")
    @TableField("class_code")
    private String classCode;

    @ApiModelProperty(value = "一级学科")
    @TableField("discipline_one")
    private String disciplineOne;

    @ApiModelProperty(value = "二级学科")
    @TableField("discipline_two")
    private String disciplineTwo;

    @ApiModelProperty(value = "三级学科")
    @TableField("discipline_three")
    private String disciplineThree;

    @ApiModelProperty(value = "英文名")
    @TableField("name_en")
    private String nameEn;

    @ApiModelProperty(value = "系统账号")
    @TableField("account")
    private String account;

    @ApiModelProperty(value = "系统账号状态")
    @TableField("account_state")
    private String accountState;

    @ApiModelProperty(value = "是否参与统计")
    @TableField("is_stat")
    private Integer isStat;

    @ApiModelProperty(value = "学历")
    @TableField("edu_level")
    private String eduLevel;

    @ApiModelProperty(value = "国籍")
    @TableField("nationlity")
    private String nationlity;

    @ApiModelProperty(value = "民族")
    @TableField("nation")
    private String nation;

    @ApiModelProperty(value = "政治面貌")
    @TableField("polity")
    private String polity;

    @ApiModelProperty(value = "职务")
    @TableField("duty")
    private String duty;

    @ApiModelProperty(value = "履职日期")
    @TableField("duty_date")
    private LocalDateTime dutyDate;

    @ApiModelProperty(value = "入职日期")
    @TableField("work_date")
    private LocalDateTime workDate;

    @ApiModelProperty(value = "在职状态")
    @TableField("person_state")
    private String personState;

    @ApiModelProperty(value = "导师类型")
    @TableField("tutor_type")
    private String tutorType;

    @ApiModelProperty(value = "聘任时间")
    @TableField("employ_date")
    private LocalDateTime employDate;

    @ApiModelProperty(value = "操作时间")
    @TableField("operate_time")
    private LocalDateTime operateTime;

    @ApiModelProperty(value = "创建人姓名")
    @TableField("creator_name")
    private String creatorName;

    @ApiModelProperty(value = "创建人ID")
    @TableField("creator_code")
    private String creatorCode;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "推荐人姓名")
    @TableField("advisor_name")
    private String advisorName;

    @ApiModelProperty(value = "推荐人ID")
    @TableField("advisor_code")
    private String advisorCode;

    @ApiModelProperty(value = "推荐人单位")
    @TableField("advisor_unit")
    private String advisorUnit;

    @ApiModelProperty(value = "QQ号")
    @TableField("qq")
    private String qq;

    @ApiModelProperty(value = "银行")
    @TableField("bank_name")
    private String bankName;

    @ApiModelProperty(value = "银行账号")
    @TableField("bank_account")
    private String bankAccount;

    @ApiModelProperty(value = "毕业学校")
    @TableField("graduate_school")
    private String graduateSchool;

    @ApiModelProperty(value = "国外经历")
    @TableField("experience_abroad")
    private String experienceAbroad;

    @ApiModelProperty(value = "简介")
    @TableField("introduction")
    private String introduction;

    @ApiModelProperty(value = "荣誉称号")
    @TableField("honor_title")
    private String honorTitle;

    @ApiModelProperty(value = "职业类别")
    @TableField("occupation_category")
    private String occupationCategory;

    @ApiModelProperty(value = "进修培训情况")
    @TableField("learning")
    private String learning;

    @ApiModelProperty(value = "社会兼职")
    @TableField("parttime")
    private String parttime;

    @ApiModelProperty(value = "学术特长")
    @TableField("learn_specialty")
    private String learnSpecialty;

    @ApiModelProperty(value = "审核状态")
    @TableField("check_status")
    private String checkStatus;

    @ApiModelProperty(value = "人员删除标志")
    @TableField("is_deleted")
    private Integer isDeleted;

    @ApiModelProperty(value = "是否涉密")
    @TableField("is_refer_secret")
    private Integer isReferSecret;

    @ApiModelProperty(value = "助记别名")
    @TableField("alias")
    private String alias;

    @ApiModelProperty(value = "外语语种1")
    @TableField("foreign_language1")
    private String foreignLanguage1;

    @ApiModelProperty(value = "外语语种1熟悉程度")
    @TableField("foreign_language1_degree")
    private String foreignLanguage1Degree;

    @ApiModelProperty(value = "外语语种2")
    @TableField("foreign_language2")
    private String foreignLanguage2;

    @ApiModelProperty(value = "外语语种2熟悉程度")
    @TableField("foreign_language2_degree")
    private String foreignLanguage2Degree;

    @ApiModelProperty(value = "邮政编码")
    @TableField("postcode")
    private String postcode;

    @ApiModelProperty(value = "传真")
    @TableField("portraiture")
    private String portraiture;

    @ApiModelProperty(value = "手机")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty(value = "教师类型")
    @TableField("teacher_type")
    private String teacherType;

    @ApiModelProperty(value = "备注")
    @TableField("note")
    private String note;

    @ApiModelProperty(value = "岗位层级")
    @TableField("job_level")
    private String jobLevel;

    @ApiModelProperty(value = "人事部门")
    @TableField("hr_dept_code")
    private String hrDeptCode;

    @ApiModelProperty(value = "人事代码（人员对照）")
    @TableField("hr_user_code")
    private String hrUserCode;

    @ApiModelProperty(value = "审核人")
    @TableField("update_user")
    private Long updateUser;

    @ApiModelProperty(value = "审核时间")
    @TableField("update_time")
    private LocalDateTime updateTime;
}
