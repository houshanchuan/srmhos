package com.mediway.hos.srm.business.center.controller.contract;


import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.contract.ContractInfoMemberVo;
import com.mediway.hos.srm.business.center.service.contract.SrmContractInfoMemberService;

import java.util.List;

/**
 * <p>
 * 合同参与人
 * </p>
 *
 * @author 代码生成器
 * @since 2025-02-25
 */
@RestController
@RequestMapping("srm/srmContractInfoMember")
@Api(tags = "合同参与人")
public class SrmContractInfoMemberController {
    @Autowired
    private SrmContractInfoMemberService srmContractInfoMemberService;
    @PostMapping({"/listContractInfoAuthor"})
    public BaseResponse listContractInfoAuthor(@RequestBody BaseDto baseDto) {
        List<ContractInfoMemberVo> list = srmContractInfoMemberService.listContractInfoAuthor(baseDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAuthorByIds"})
    public BaseResponse deleteAuthorByIds(@RequestBody BaseDto baseDto) {
        srmContractInfoMemberService.deleteAuthorById(baseDto);
        return BaseResponse.success("删除成功");

    }
}
