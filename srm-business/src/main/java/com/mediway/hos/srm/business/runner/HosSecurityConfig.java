package com.mediway.hos.srm.business.runner;

import com.mediway.hos.app.core.filter.HosLoginListener;
import com.mediway.hos.app.core.filter.HosPostInfoService;
import com.mediway.hos.app.core.service.sys.HosUserAccountService;
import com.mediway.hos.security.core.DestroyTokenManger;
import com.mediway.hos.security.core.DestroyTokenProviderManager;
import com.mediway.hos.security.login.HosOAuth2LoginDestroyTokenManger;
import com.mediway.hos.security.login.store.OAuth2TokenStore;
import com.mediway.hos.security.properties.HosSecurityProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HosSecurityConfig {

    /**
     * DestroyTokenManger 销毁token的管理类
     * 对接了统一认证销毁的逻辑
     * @param oauth2TokenStore
     * @param hosSecurityProperties
     * @return
     */
    @Bean
    @ConditionalOnProperty(prefix = "hos-security.oauth2", name = "enable", havingValue = "true")
    @ConditionalOnMissingBean(DestroyTokenManger.class)
    public DestroyTokenManger destroyTokenManger(OAuth2TokenStore oauth2TokenStore, HosSecurityProperties hosSecurityProperties) {
        // 让统一认证退出
        HosOAuth2LoginDestroyTokenManger hosOAuth2LoginDestroyTokenManger = new HosOAuth2LoginDestroyTokenManger(oauth2TokenStore, hosSecurityProperties);
        DestroyTokenProviderManager destroyTokenProviderManager = new DestroyTokenProviderManager(hosOAuth2LoginDestroyTokenManger);
        return destroyTokenProviderManager;
    }

    /**
     * DestroyTokenManger 销毁token的管理类
     * 单体销毁逻辑
     * 可以支持token销毁后业务自己定制化逻辑处理
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(DestroyTokenManger.class)
    public DestroyTokenManger defaultDestroyTokenManger() {
        DestroyTokenProviderManager destroyTokenProviderManager = new DestroyTokenProviderManager();
        return destroyTokenProviderManager;
    }

    /**
     * 用户登录成功后的监听处理（登录成功之后，获取岗位信息，以及岗位token过期时间）
     * @param hosUserAccountService
     * @return
     */
    @Bean
    public HosLoginListener hosLoginListener(HosUserAccountService hosUserAccountService, HosPostInfoService hosPostInfoService) {
        return new HosLoginListener(hosUserAccountService, hosPostInfoService);
    }
}
