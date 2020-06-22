package com.czt.config;

import com.czt.util.GlobalConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMVCConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //注册一个地址和视图的绑定
        registry.addViewController("/toAdd").setViewName("/dept_add.html");
        //绑定首页
//        registry.addViewController("/").setViewName("/index.html");
    }

 /*   @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册一个拦截器
        registry.addInterceptor(new HelloInter()).addPathPatterns("/**"); //.excludePathPatterns():要排除的路径
    }*/

    @Override
    public void addFormatters(FormatterRegistry registry) {
        //注册一个全局的日期转换器
        registry.addConverter(new GlobalConverter());
    }
}
