package com.corn.shop.controller.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yyc
 * @apiNote 跨域过滤器
 * */
public class CrosFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(CrosFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        log.info("********** 跨域过滤器初始化 **********");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        log.info("跨域拦截,url:{},请求方式:{}",request.getRequestURI(),request.getMethod());

        response.setHeader("Access-Control-Expose-Headers", "app,x-requested-with,content-type,No-Cache,Access-Control-Allow-Origin");
        //请求方法
        response.setHeader("Access-Control-Request-Method", "GET,POST,PUT,DELETE,OPTIONS");
        //请求头
        response.setHeader("Access-Control-Request-Headers", "app,x-requested-with,content-type,No-Cache,Access-Control-Allow-Origin");
        //同意的方法
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        //同意的请求头
        response.setHeader("Access-Control-Allow-Headers", "app,x-requested-with,content-type,No-Cache,Access-Control-Allow-Origin");

        response.setHeader("Access-Control-Allow-Credentials", "true");

        if(request.getMethod().equals("OPTIONS")){

            response.setStatus(HttpServletResponse.SC_OK);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("cross pass ok !");
            return;
        }

        filterChain.doFilter(request,response);

    }

    @Override
    public void destroy() {

        log.info("********** 跨域过滤器销毁 **********");

    }
}

