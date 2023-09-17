package com.cspiration.mooc.interception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class WebMvcConf extends WebMvcConfigurerAdapter {

    @Autowired
    private AuthActionInterceptor authActionInterceptor;

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(authInterceptor).excludePathPatterns("/static").addPathPatterns("/**");
       registry.addInterceptor(authActionInterceptor)
               .addPathPatterns("/accounts/profile")
               .addPathPatterns("/course/learn")
               .addPathPatterns("/course/learn/comment/commentPublish")
               .addPathPatterns("/accounts/myCourse");
       super.addInterceptors(registry);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
    }
}
