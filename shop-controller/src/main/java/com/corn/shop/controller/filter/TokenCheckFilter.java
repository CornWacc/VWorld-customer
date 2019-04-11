package com.corn.shop.controller.filter;


import com.corn.shop.common.util.RedisOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yyc
 * @apiNote 用户token校验过滤器
 * */
public class TokenCheckFilter implements Filter {

    @Autowired
    private RedisOperator redisOperator;

    private static final Logger log = LoggerFactory.getLogger(TokenCheckFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        log.info("********** token过滤器初始化 ********** , redis实例化:"+(null == redisOperator ? "OK" : "FAIL"));

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        filterChain.doFilter(request,response);

    }

    @Override
    public void destroy() {

        log.info("********** token过滤器销毁 **********");

    }
}
