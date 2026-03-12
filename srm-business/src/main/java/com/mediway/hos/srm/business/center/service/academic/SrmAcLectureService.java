package com.mediway.hos.srm.business.center.service.academic;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.academic.AcLectureDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.academic.SrmAcLecture;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.academic.AcLectureVo;

/**
 * <p>
 * 学术讲座 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAcLectureService extends BaseService<SrmAcLecture> {
    Long saveAcLecture(AcLectureDto acLectureDto);
    AcLectureVo getDetail(Long rowId);
    IPage<AcLectureVo> listAcLecture(AcLectureDto acLectureDto);

    void deleteAcLecture(BaseDto baseDto);
    void subMit(BaseDto baseDto);

    void audit(BaseDto baseDto);
    IPage<AcLectureVo> listAuditAcLecture(AcLectureDto acLectureDto);

}
