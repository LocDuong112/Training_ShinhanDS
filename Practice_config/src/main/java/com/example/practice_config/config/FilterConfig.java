package com.example.practice_config.config;

import com.example.practice_config.filter.BrowserDetectorFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Autowired
    private BrowserDetectorFilter browserDetectorFilter;

    @Bean
    public FilterRegistrationBean<BrowserDetectorFilter> browserDetectorFilterFilterRegistrationBean() {
        FilterRegistrationBean<BrowserDetectorFilter> registrationBean = new FilterRegistrationBean<BrowserDetectorFilter>();
        registrationBean.setFilter(browserDetectorFilter);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
