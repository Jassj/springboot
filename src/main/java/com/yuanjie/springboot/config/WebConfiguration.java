package com.yuanjie.springboot.config;

import com.yuanjie.springboot.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * description: web相关配置
 * @author yuanjie 2020/03/13 16:05
 */
@Configuration
public class WebConfiguration {

    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.setName("MyFilter");
        Map<String, String> initParameters = new HashMap<>(); // 初始化参数集合
        initParameters.put("PROJECT_NAME", "project for alex");
        registration.setInitParameters(initParameters);
        registration.setOrder(6); // 过滤器优先级，数字越小优先级越高
        return registration;
    }

}
