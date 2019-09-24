package com.corn.vworld.common.exceptionhandler;


import com.corn.boot.base.HttpBase;
import com.corn.boot.base.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yyc
 * @apiNote 异常拦截处理器
 * */
@RestControllerAdvice
public class ExceptionHandlers implements ErrorController {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandlers.class);
    /**
     * 该异常是Volidation校验出错的异常
     * */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JsonResult MethodArgumentNotValidExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        log.info("请求接口失败{},失败原因:{}",request.getRequestURI(),bindingResult.getFieldError().getDefaultMessage());
        return new JsonResult(HttpBase.HTTP_RESPONSE_ERROR_CODE,bindingResult.getFieldError().getDefaultMessage());
    }

    @Override
    public String getErrorPath() {
        return "/";
    }
}
