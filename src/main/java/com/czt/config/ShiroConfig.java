package com.czt.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.czt.realm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public DefaultWebSecurityManager webSecurityManager(){
        //创建安全管理器的实现类的实例
        DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();
        //设置Realm实例
        webSecurityManager.setRealm(realm());
        return webSecurityManager;
    }

    @Bean
    public UserRealm realm(){
        UserRealm realm = new UserRealm();
        realm.setCredentialsMatcher(credentialsMatcher());
        return realm;
    }

    /**
     * 密码匹配
     * @return
     */
    @Bean
    public HashedCredentialsMatcher credentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(1024);
        credentialsMatcher.setStoredCredentialsHexEncoded(false);
        return credentialsMatcher;
    }

    @Bean
    public LifecycleBeanPostProcessor postProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator autoProxyCreator(){
        DefaultAdvisorAutoProxyCreator autoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        autoProxyCreator.setProxyTargetClass(true);
        return autoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor sourceAdvisor(){
        AuthorizationAttributeSourceAdvisor sourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        sourceAdvisor.setSecurityManager(webSecurityManager());
        return sourceAdvisor;
    }

    @Bean
    public ShiroFilterFactoryBean filterFactoryBean(){
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(webSecurityManager());
        filterFactoryBean.setLoginUrl("/login.html");
        filterFactoryBean.setSuccessUrl("/index.html");
        filterFactoryBean.setUnauthorizedUrl("/error.html");
        //要过滤的路径的Map集合
        Map<String,String> map=new HashMap<>();
        map.put("/user/login","anon");
        map.put("/user/roles","anon");
        map.put("/static/**","anon");
        map.put("/*.jar","anon");
        map.put("/logout","logout");
        map.put("/**","authc");
        filterFactoryBean.setFilterChainDefinitionMap(map);
        return filterFactoryBean;
    }

    /**
     * thymeleaf页面使用shiro标签
     * @return
     */
//    @Bean
//    public ShiroDialect dialect(){
//        return new ShiroDialect();
//    }
}
