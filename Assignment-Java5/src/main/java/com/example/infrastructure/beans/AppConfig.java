package com.example.infrastructure.beans;

import com.example.infrastructure.filters.AdminFilter;
import com.example.infrastructure.filters.UserFilter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public FilterRegistrationBean<AdminFilter> adminSessionFilter() {
        FilterRegistrationBean<AdminFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AdminFilter());
        registrationBean.addUrlPatterns("/admin/*"); // Chỉ áp dụng filter cho đường dẫn /admin/*
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<UserFilter> userSessionFilter() {
        FilterRegistrationBean<UserFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new UserFilter());
        registrationBean.addUrlPatterns("/cart/*");
        registrationBean.addUrlPatterns("/bill/*");
        return registrationBean;
    }
}
