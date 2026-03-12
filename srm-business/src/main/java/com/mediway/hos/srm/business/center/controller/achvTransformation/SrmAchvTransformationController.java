package com.mediway.hos.srm.business.center.controller.achvTransformation;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.achvTransformation.AchvTransformationDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.achvTransformation.AchvTransformationVo;
import com.mediway.hos.srm.business.center.service.achvTransformation.SrmAchvTransformationService;

/**
 * <p>
 * 成果转化申请表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmAchvTransformation")
@Api(tags = "成果转化申请表")
public class SrmAchvTransformationController {
    @Autowired
    private SrmAchvTransformationService srmAchvTransformationService;

    @PostMapping({"/saveAchvTransformation"})
    public BaseResponse saveAchvTransformation(@RequestBody AchvTransformationDto achvTransformationDto) {
        Long RowId= srmAchvTransformationService.saveAchvTransformation(achvTransformationDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        AchvTransformationVo achvTransformationVo = srmAchvTransformationService.getDetail(String.valueOf(RowId));
        return BaseResponse.success(achvTransformationVo);
    }

    @PostMapping({"/listAchvTransformation"})
    public BaseResponse listAchvTransformation(@RequestBody AchvTransformationDto achvTransformationDto) {
        IPage<AchvTransformationVo> list = srmAchvTransformationService.listAchvTransformation(achvTransformationDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAchvTransformation"})
    public BaseResponse deleteAchvTransformation(@RequestBody BaseDto baseDto) {
        srmAchvTransformationService.deleteAchvTransformation(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/subMit"})
    public BaseResponse subMit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmAchvTransformationService.subMit(baseDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/listAuditAchvTransformation"})
    public BaseResponse listAuditAchvTransformation(@RequestBody AchvTransformationDto achvTransformationDto) {
        System.out.println(achvTransformationDto);
        IPage<AchvTransformationVo> list = srmAchvTransformationService.listAuditAchvTransformation(achvTransformationDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/audit"})
    public BaseResponse audit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmAchvTransformationService.audit(baseDto);
        return BaseResponse.success("审批成功!");

    }
}
