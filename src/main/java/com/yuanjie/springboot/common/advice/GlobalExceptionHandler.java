package com.yuanjie.springboot.common.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常捕获类，可捕获程序中抛出的指定类型异常
 * @author yuanjie 2020/11/06
 */
//@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public void defaultExceptionHandler(HttpServletRequest request, Exception e) {
//        If the exception is annotated with @ResponseStatus rethrow it and let
//        the framework handle it - like the OrderNotFoundException example at the start of this post.
//        被@ResponseStatus修饰的异常需要重新抛出让框架处理
//        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)  {
//            throw e;
//        }

        e.printStackTrace();
//        System.out.println("GlobalDefaultExceptionHandler.defaultErrorHandler()");

        // 返回Json或者String数据等响应体, 使用@ResponseBody注解修饰

        // 可以返回通用异常处理页面, 定义ModelAndView
    }

}
