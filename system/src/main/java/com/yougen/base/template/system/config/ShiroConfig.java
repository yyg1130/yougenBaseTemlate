package com.yougen.base.template.system.config;

import com.yougen.base.template.system.security.realm.CustomRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.mapstruct.Qualifier;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yyg
 */
@Configuration
public class ShiroConfig {
    /**
     *哈希密码比较器
     *
     * @return
     */
    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;

    }
    /**
     * 配置自定义realm
     *
     * @return
     */
    @Bean(name = "customRealm")
    public CustomRealm customRealm(HashedCredentialsMatcher hashedCredentialsMatcher) {
        CustomRealm customRealm=new CustomRealm();
        customRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return customRealm;
    }



    /**
     * @return
     */
    @Bean(name = "securityManager")
    public SecurityManager securityManager( CustomRealm customRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(customRealm);
        return manager;
    }

    /**
     * 开启AOP注解
     *
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    /**
     *DefaultAdvisorAutoProxyCreator，Spring的一个bean，由Advisor决定对哪些类的方法进行AOP代理
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    /**
     * Filter工厂，设置对应的过滤条件和跳转条件
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
     ShiroFilterFactoryBean  filterFactoryBean=new ShiroFilterFactoryBean();
     filterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterMap = new LinkedHashMap<>();

        filterMap.put("/sys/logout", "logout");
        // swagger
        filterMap.put("/docs.html", "anon");
        filterMap.put("/swagger**/**", "anon");
        filterMap.put("/webjars/**", "anon");
        filterMap.put("/v2/**", "anon");
        filterMap.put("/**", "authc");
        filterFactoryBean.setLoginUrl("/sys/login");
        filterFactoryBean.setUnauthorizedUrl("/403");
        filterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return filterFactoryBean;

    }
}
