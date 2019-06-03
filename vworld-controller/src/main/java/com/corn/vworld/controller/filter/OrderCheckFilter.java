package com.corn.vworld.controller.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author yyc
 * @apiNote 参数校验过滤器
 * */
public class OrderCheckFilter implements Filter {

    private static Logger log = LoggerFactory.getLogger(OrderCheckFilter.class);

    private static final String DEFAULT_DATE_PARSE_STRING = "yyyy-MM-dd HH:mm:ss";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        log.info("********** 参数校验过滤器初始化 **********");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String startTime = request.getParameter("createTime"); //开始时间
        if(startTime != null && startTime != ""){
            String endTime = request.getParameter("endTime"); //结束时间
            SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_PARSE_STRING);

            filterChain.doFilter(request,response);
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

        log.info("********** 参数校验过滤器销毁 **********");

    }
}
