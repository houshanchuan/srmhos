package com.mediway.hos.srm.business.center.model.dto.baseData;

import com.mediway.hos.srm.business.center.model.dto.fund.FundSourceTypeDto;
import lombok.Data;

import java.util.List;
@Data
public class BaseDataLearningDto {
    private List<PaperThesisTypeDto> paperThesisTypes; //论文类别
    private List<JournalLevelDto> journalLevels; //期刊级别
    private List<JournalTypeDto> journalTypes; //期刊类型
    private List<JournalDictDto> journalDicts; //期刊字典
    private List<WorkTypeDto> workTypes; //著作类别
    private List<PressInfoDto> pressInfos; //出版社信息
    private List<PatentTypeDto> patentTypes; //专利类型
    private List<EditorTypeDto> editorTypes; //编著角色类型
    private List<RewardDictDto> rewardDicts; //奖项字典
    private List<RewardTypeDto> rewardTypes; //奖项类别
    private List<RewardLevelInfoDto> rewardLevelInfos; //奖项分类
    private List<SubjectClassDto> subjectClasss; //学科门类
    private List<AchvCatDto> achvCats; //成果分类
    private List<DisciplineDto> disciplines; //学科分类
    private List<ResearchTypeDto> researchTypes; //研究类型
    private List<ResearchFieldDto> researchFields; //研究领域
    private List<PaperSourceDto> paperSources; //论文来源途径
    private List<PaperRewardeeTypeDto> paperRewardeeTypes; //论文奖励作者类型
    private List<PaperReshipNameDto> paperReshipNames; //论文转载名称
    private List<PaperReshipTypeDto> paperReshipTypes; //论文转载类型
    private List<PaperEmbodyTypeDto> paperEmbodyTypes; //论文收录类型
    private List<JournalSourceDto> journalSources; //期刊源
    private List<ContentRealDto> contentReals; //论文内容真实性
    private List<PaperSciPartitionDto> paperSciPartitions; //SCI论文分区
    private List<PaperCASPartitionDto> paperCASPartitions; //中科院论文分区
    private List<PaperAuthorOrderDto> paperAuthorOrders; //论文作者排序代码表
    private List<ScopeTypeDto> scopeTypes; //发表范围
    private List<PubRangeDto> pubRanges; //期刊发行范围
    private List<PageSpaceDto> pageSpaces; //期刊版面
    private List<ReimbursementWayDto> reimbursementWays; //报销途径
    private List<PublishLevelDto> publishLevels; //出版社级别
    private List<PublishAddressTypeDto> publishAddressTypes; //出版类型
    private List<PatentScopeDto> patentScopes; //专利范围
    private List<PatentAgencyFeeSourceDto> patentAgencyFeeSources; //专利代理费用来源
    private List<SoftwareCpRtTypeDto> softwareCpRtTypes; //软著类型
    private List<ProductModeDto> productModes; //成果(产品)形式
    private List<ProductTypeDto> productTypes; //成果类型表
    private List<AwardLevelDto> awardLevels; //获奖级别
    private List<AwardGradeDto> awardGrades; //奖项等级
    private List<AchvTransferTypeDto> achvTransferTypes; //成果转化类型
    private List<AchvAuthorTypeDto> achvAuthorTypes; //成果作者类型
    private List<AchvTransGranteeTypeDto> achvTransGranteeTypes; //成果转化受让单位类型
    private List<AchvTransformantsTypeDto> achvTransformantsTypes; //成果转化物
    private List<AchvTransAgreementTypeDto> achvTransAgreementTypes; //成果转化协议类型
    private List<MeetingAtdStatusDto> meetingAtdStatuss; //参会身份
    private List<ConferenceTypeDto> conferenceTypes; //会议类型
    private List<FundSourceTypeDto> fundSourceTypes; //费用来源类型
    private List<LectureLevelDto> lectureLevels;
    private List<LectureTypeDto> lectureTypes;
    private List<ParttimeTypeDto> parttimeTypes;
    private List<SchoolSignDto> schoolSigns;




}
