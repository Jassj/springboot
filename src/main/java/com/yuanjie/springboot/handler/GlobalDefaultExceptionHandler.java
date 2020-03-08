package com.yuanjie.springboot.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * description:
 * 全局异常捕获类，可捕获程序中抛出的指定类型异常
 * @author yuanjie 2020/03/06 16:00
 */
@ControllerAdvice // Todo注解含义
public class GlobalDefaultExceptionHandler {

    /**
     * Class<? extends Throwable>[] value() default {}
     * 默认处理所有继承Throwable的异常
     */
    @ExceptionHandler(value = ArithmeticException.class)
    public void defaultExceptionHandler(HttpServletRequest request, ArithmeticException e) {
        // If the exception is annotated with @ResponseStatus rethrow it and let
        // the framework handle it - like the OrderNotFoundException example
        // at the start of this post. Todo
        e.printStackTrace();

//        return new ModelAndView("error"); // 可以返回通用异常处理页面或其他响应体
    }

}
