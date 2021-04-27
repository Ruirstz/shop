package com.ruirui.demo05.controller;

import com.ruirui.demo05.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResultVo exceptionHandler(RuntimeException ex){
        log.error("查询出现异常",ex);
        return ResultVo.file("查询失败",ex);
    }
}
