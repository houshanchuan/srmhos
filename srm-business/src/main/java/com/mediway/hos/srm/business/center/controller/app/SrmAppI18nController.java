package com.mediway.hos.srm.business.center.controller.app;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mediway.hos.app.i18n.model.entity.I18nElement;
import com.mediway.hos.app.i18n.service.AppI18nElementService;
import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.common.util.StringUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("srm/language")
@Api(tags = "App")
public class SrmAppI18nController {

    @Autowired
    private AppI18nElementService appI18nElementService;

    @PostMapping({"/getLanguagePack"})
    public BaseResponse srmRequest(@RequestBody String language) {
        QueryWrapper<I18nElement> queryWrap=new QueryWrapper<I18nElement>();
        List<String> moduleList=new ArrayList<>();
        moduleList.add("srm.mobile");
        moduleList.add("srm.main");
        moduleList.add("srm.hostingmeetings");
        queryWrap.in("module_code", moduleList);
        List<I18nElement> list=appI18nElementService.list(queryWrap);//listBusinessElements("srm.mobile");
        HashMap<String,String> map=new HashMap<>();
        String value=null;
        String lang = JSONObject.parseObject(language).getString("language");
        for(I18nElement e:list){
            if(StringUtil.isNotBlank(e.getTranslation())) {
                JSONObject json = JSONObject.parseObject(e.getTranslation());
                map.put(e.getCode(),json.getString(lang));
            }
        }
        return BaseResponse.success(map);
    }
    @PostMapping({"/getLoginPageElements"})
    public BaseResponse getLoginPageElements() {
        Map<String, String> list=appI18nElementService.getLoginPageElements("srm.mobile");

        return null;
    }

}
