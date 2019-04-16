package com.corn.vworld.controller.filter;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author
 * @apiNote 过滤器管理
 * */
@Configuration
public class FilterBeanAdministration {

    @Bean("crosFilter")
    public FilterRegistrationBean<CrosFilter> createCrosFilter(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new CrosFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;

    }
//
//    @Bean("tokenCheckFilter")
//    public FilterRegistrationBean<TokenCheckFilter> createTokenCheckFilter(){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setOrder(2);
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.setFilter(new TokenCheckFilter());
//        return filterRegistrationBean;
//    }

}

