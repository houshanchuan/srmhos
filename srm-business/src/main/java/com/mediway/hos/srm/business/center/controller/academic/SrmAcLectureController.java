package com.mediway.hos.srm.business.center.controller.academic;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.academic.AcLectureDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.academic.AcLectureVo;
import com.mediway.hos.srm.business.center.service.academic.SrmAcLectureService;

/**
 * <p>
 * 学术讲座
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmAcLecture")
@Api(tags = "学术讲座")
public class SrmAcLectureController {
    @Autowired
    private SrmAcLectureService srmAcLectureService;
    @PostMapping({"/saveAcLecture"})
    public BaseResponse saveAcLecture(@RequestBody AcLectureDto acLectureDto) {
        System.out.println(acLectureDto);
        Long RowId= srmAcLectureService.saveAcLecture(acLectureDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        AcLectureVo acLectureVo = srmAcLectureService.getDetail(RowId);
        return BaseResponse.success(acLectureVo);
    }

    @PostMapping({"/listAcLecture"})
    public BaseResponse listAcLecture(@RequestBody AcLectureDto acLectureDto) {
        IPage<AcLectureVo> list = srmAcLectureService.listAcLecture(acLectureDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAcLecture"})
    public BaseResponse deleteAcLecture(@RequestBody BaseDto baseDto) {
        srmAcLectureService.deleteAcLecture(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/subMit"})
    public BaseResponse subMit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmAcLectureService.subMit(baseDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/listAuditAcLecture"})
    public BaseResponse listAuditAcConferenceHost(@RequestBody AcLectureDto acLectureDto) {
        IPage<AcLectureVo> list = srmAcLectureService.listAuditAcLecture(acLectureDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/audit"})
    public BaseResponse audit(@RequestBody BaseDto baseDto) {
        srmAcLectureService.audit(baseDto);
        return BaseResponse.success("审批成功!");

    }
}
