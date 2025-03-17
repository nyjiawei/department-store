package com.fjw.provide.config;


import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fjw.provide.common.model.ResponseData;
import com.fjw.provide.enums.ResponseEnum;
import com.fjw.provide.exception.ApplicationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * @Author：jiawei
 * @CreateTime：2022-07-19 16:35
 * @Description：MVC异常全局处理
 * @Version：1.0
 **/

@ControllerAdvice
public class WebExceptionHandler {


    //处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常，详情继续往下看代码
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseData<Integer> BindExceptionHandler(BindException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(";"));
        return new ResponseData<>(ResponseEnum.INVALID.getCode(),message,-1);
    }

    //处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是javax.validation.ConstraintViolationException
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseData<Integer> ConstraintViolationExceptionHandler(ConstraintViolationException e) {
        String message = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));
        return new ResponseData<>(ResponseEnum.INVALID.getCode(),message,-1 );
    }

    //处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseData<Integer> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(";"));
        return new ResponseData<>(ResponseEnum.INVALID.getCode(),message,-1 );
    }

    @ExceptionHandler(ApplicationException.class)
    @ResponseBody
    public ResponseData<Integer> ApplicationExceptionHandler(ApplicationException e) {
        String message = e.getMessage();
        return new ResponseData<>(e.getCode(),message,-1);
    }

    @ExceptionHandler(TokenExpiredException.class)
    @ResponseBody
    public ResponseData<Integer> TokenExpiredExceptionHandler(TokenExpiredException e) {
        String message = e.getMessage();
        return new ResponseData<>(ResponseEnum.UNAUTHORIZED);
    }

}
