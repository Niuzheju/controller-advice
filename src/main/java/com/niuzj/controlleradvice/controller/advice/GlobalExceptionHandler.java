package com.niuzj.controlleradvice.controller.advice;

import com.niuzj.controlleradvice.model.Result;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 * 可以避免在service层写try catch代码
 * @author niuzj
 * @date 2019/4/26 14:56
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * ExceptionHandler 的属性为异常的class对象, 如果不指定就是方法参数的class, 且同一个异常不能重复出现多个方法中
     * 此处使用ResponseBody返回json数据,也可以和Controller方法一样返回其他类型
     */
    @ResponseBody
    @ExceptionHandler
    public Result handlerException(Exception e) {
        logger.error(ExceptionUtils.getFullStackTrace(e));
        return new Result(1000, e.getMessage());
    }

    /**
     * 一个方法可以处理多个异常, 指定多个异常的class, 但是方法参数只能是一个,即多个异常的父类
     */
    @ResponseBody
    @ExceptionHandler({ArithmeticException.class, ArrayIndexOutOfBoundsException.class})
    public Result handlerMathException(Exception e) {
        logger.error(ExceptionUtils.getFullStackTrace(e));
        return new Result(2000, e.getMessage());
    }

}
