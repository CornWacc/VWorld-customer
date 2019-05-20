package com.corn.vworld.controller.filter;


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

/**
 * 设置跨域属性
 * Access-Control-Allow-Origin      该字段是必须的。它的值要么是请求时Origin字段的值，要么是一个*，表示接受任意域名的请求
 * Access-Control-Expose-Headers    该字段可选。CORS请求时，XMLHttpRequest对象的getResponseHeader()方法只能拿到6个基本字段：
 * -                                Cache-Control、Content-Language、Content-Type、Expires、Last-Modified、Pragma。
 * -                                如果想拿到其他字段，就必须在Access-Control-Expose-Headers里面指定。
 * -                                getResponseHeader('FooBar')可以返回FooBar字段的值。
 * Access-Control-Request-Method    用来列出浏览器的CORS请求会用到哪些HTTP方法
 * Access-Control-Request-Headers   该字段是一个逗号分隔的字符串，指定浏览器CORS请求会额外发送的头信息字段
 * Access-Control-Allow-Methods     该字段必需，它的值是逗号分隔的一个字符串，表明服务器支持的所有跨域请求的方法
 * Access-Control-Allow-Headers     如果浏览器请求包括Access-Control-Request-Headers字段，
 * -                                则Access-Control-Allow-Headers字段是必需的。
 * -                                它也是一个逗号分隔的字符串，表明服务器支持的所有头信息字段，不限于浏览器在"预检"中请求的字段。
 * Access-Control-Allow-Credentials 该字段可选。它的值是一个布尔值，表示是否允许发送Cookie。默认情况下，Cookie不包括在CORS请求之中。
 * -                                设为true，即表示服务器明确许可，Cookie可以包含在请求中，一起发给服务器。这个值也只能设为true，
 * -                                如果服务器不要浏览器发送Cookie，删除该字段即可。
 * Access-Control-Max-Age           该字段可选，用来指定本次预检请求的有效期，单位为秒。上面结果中，有效期是20天（1728000秒），
 * -                                即允许缓存该条回应1728000秒（即20天），在此期间，不用发出另一条预检请求。
 * */

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

