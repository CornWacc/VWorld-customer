package com.corn.shop.controller.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        log.info("跨域拦截,url:{},请求方式:{}",request.getRequestURI(),request.getMethod());


        response.setHeader("Access-Control-Expose-Headers", "isign,app,x-requested-with,content-type,No-Cache");
        //请求方法
        response.setHeader("Access-Control-Request-Method", "GET,POST,PUT,DELETE,OPTIONS");
        //请求头
        response.setHeader("Access-Control-Request-Headers", "isign,app,x-requested-with,content-type,No-Cache");
        //同意的方法
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        //同意的请求头
        response.setHeader("Access-Control-Allow-Headers", "isign,app,x-requested-with,content-type,No-Cache");

        response.setHeader("Access-Control-Allow-Credentials", "true");

        response.setHeader("Access-Control-Allow-Origin","*");

        response.setCharacterEncoding("UTF-8");
        try{
            if(request.getMethod().equalsIgnoreCase("OPTIONS")){
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write("cross pass ok !");
                return;

            }
            filterChain.doFilter(request,response);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void destroy() {

        log.info("********** 跨域过滤器销毁 **********");

    }
}

