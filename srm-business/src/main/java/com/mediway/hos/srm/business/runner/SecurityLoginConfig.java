package com.mediway.hos.srm.business.runner;

import cn.hutool.core.collection.CollectionUtil;
import com.mediway.hos.app.common.enums.PunctuationEnum;
import com.mediway.hos.app.core.config.seure.HosAppTokenHandler;
import com.mediway.hos.app.core.filter.HosCoreFilter;
import com.mediway.hos.app.core.filter.HosPostFilter;
import com.mediway.hos.app.core.filter.HosPostInfoService;
import com.mediway.hos.app.core.property.FrameworkSecurity;
import com.mediway.hos.app.core.util.NoneRequestMatcher;
import com.mediway.hos.common.util.StringUtil;
import com.mediway.hos.common.util.context.SpringContextUtils;
import com.mediway.hos.i18n.constant.I18nConstant;
import com.mediway.hos.i18n.service.I18nStaticTranslationService;
import com.mediway.hos.i18n.utils.HosI18nUtil;
import com.mediway.hos.i18n.utils.I18nUtil;
import com.mediway.hos.security.core.CommonAuthenticationHandler;
import com.mediway.hos.security.core.util.SecurityUtil;
import com.mediway.hos.security.filter.XssFilter;
import com.mediway.hos.security.login.HosSecurityLoginDatabaseAutoConfiguration;
import com.mediway.hos.security.login.HosUserDetailsService;
import com.mediway.hos.security.login.configurers.HosConfigurerUtils;
import com.mediway.hos.security.login.configurers.HosLoginConfigurer;
import com.mediway.hos.security.login.enums.LoginAccountEnum;
import com.mediway.hos.security.login.mapper.HosBaseUserMapper;
import com.mediway.hos.security.login.service.HosUserDetailsDBService;
import com.mediway.hos.security.login.service.LoginModelService;
import com.mediway.hos.security.properties.HosSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Joe Grandja
 * @since 0.0.1
 */
@EnableWebSecurity
@Configuration
@AutoConfigureAfter({HosSecurityLoginDatabaseAutoConfiguration.class})
@EnableConfigurationProperties(FrameworkSecurity.class)
public class SecurityLoginConfig {

    @Autowired
    private FrameworkSecurity frameworkSecurity;

    /**
     * 登录模块错误码国际化翻译
     */
    static {
        CommonAuthenticationHandler.setBaseResponseConsumer(baseResponse -> {
            if (StringUtil.isBlank(baseResponse.getCode()) || "200".equals(baseResponse.getCode())) {
                return;
            }
            if (HosI18nUtil.isOpenI18n()) {
                I18nStaticTranslationService i18nStaticTranslationService = SpringContextUtils.getBean(I18nStaticTranslationService.class);
                String defaultLanguage = I18nConstant.I18N_DEFAULT_LANGUAGE;
                String language = HosI18nUtil.getRequestLanguage();
                String msg = i18nStaticTranslationService.queryTransByResponseCode(baseResponse.getCode(), baseResponse.getMsg(), defaultLanguage, language);
                if (StringUtil.isNotBlank(msg)) {
                    baseResponse.setMsg(msg);
                }
            }
        });
        LoginAccountEnum.function = keys -> {
            List<String> values = new ArrayList<>();
            keys.forEach(key -> {
                String msg = I18nUtil.mapStaticTrans(LoginAccountEnum.class, key, true);
                values.add(msg);
            });
            String split = I18nUtil.mapStaticTrans(PunctuationEnum.class, PunctuationEnum.SEPARATOR.getCode(), true);
            return String.join(split, values);
        };
    }

    /**
     * 单体自己使用 登录获取用户信息service
     * @param hosUserMapper 登录获取用户信息mapper
     * @param loginModelService 登录方式service
     * @param hosSecurityProperties 登录配置
     * @return
     */
    @Bean
    public HosUserDetailsService hosUserDetailsService(HosBaseUserMapper hosUserMapper, LoginModelService loginModelService, HosSecurityProperties hosSecurityProperties) {
        return new HosUserDetailsDBService(hosUserMapper, loginModelService, hosSecurityProperties);
    }

    /**
     * 登录完成返回用户默认数据（默认首页等信息）
     * @return
     */
    @Bean
    public HosAppTokenHandler hosAppTokenHandler() {
        return new HosAppTokenHandler();
    }

    // @formatter:off
    @Bean
    @Order(value = Ordered.HIGHEST_PRECEDENCE + 100)
    SecurityFilterChain securityFilterChain(HttpSecurity http, HosSecurityProperties hosSecurityProperties, HosPostInfoService hosPostInfoService) throws Exception {
        // 配置白名单
        List<String> whiteList = SecurityUtil.getWhiteList(hosSecurityProperties.getLogin().getWhiteList());
        http
                .authorizeHttpRequests(authorize ->
                        authorize
                                .antMatchers(whiteList.stream().toArray(String[]::new)).permitAll()
                                .anyRequest().authenticated()
                );
        // 加载登录配置
        HosLoginConfigurer hosLoginConfigurer = new HosLoginConfigurer();
        // 加载统一认证配置
        if (hosSecurityProperties.getOauth2().isEnable()) {
            hosLoginConfigurer.hosOAuth2Login();
        }
        http.apply(hosLoginConfigurer);
        // 安全过滤、岗位token验证过滤器，放在登录成功后
        http.addFilterAfter(new HosCoreFilter(), RememberMeAuthenticationFilter.class);
        RequestMatcher ignoreRenewalRequestMatcher;
        List<String> ignoreRenewals = frameworkSecurity.getRenewal().getIgnores();
        if(Objects.nonNull(ignoreRenewals) && !ignoreRenewals.isEmpty()){
            List<RequestMatcher> requestMatchers = ignoreRenewals.stream().map(ignoreRenewal ->new AntPathRequestMatcher(ignoreRenewal, null)).collect(Collectors.toList());
            ignoreRenewalRequestMatcher = new OrRequestMatcher(requestMatchers);
        }else {
            ignoreRenewalRequestMatcher = NoneRequestMatcher.INSTANCE;
        }
        http.addFilterBefore(new HosPostFilter(HosConfigurerUtils.getTokenStore(http), hosPostInfoService, ignoreRenewalRequestMatcher), RememberMeAuthenticationFilter.class);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //http.csrf(csrf -> csrf.disable());
        http.headers().frameOptions().disable();
        // xss
        if (!frameworkSecurity.getCsrf().isEnable()) {
            http.csrf().disable();
        }
        if (frameworkSecurity.getCors().isEnable()) {
            http.cors();
        }
        if (frameworkSecurity.getXss().isEnable()) {
            // 注册xss过滤器
            XssFilter xssFilter = new XssFilter();
            xssFilter.setEnabled(true);
            List<String> xssExcludes = frameworkSecurity.getXss().getExcludes();
            if (CollectionUtil.isNotEmpty(xssExcludes)) {
                xssFilter.setExcludes(xssExcludes);
            }
            http.addFilterAfter(xssFilter, CsrfFilter.class);
        }
        return http.build();
    }

}
