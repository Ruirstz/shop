package com.ruirui.demo05.vo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @date 2021/4/19 - 14:51
 */
@Slf4j
public class ResultVo {
    private int code;//状态码  1000 2000
    private String msg;//响应信息
    private Object result;//返回数据
    public static ResultVo sucess(Object result){
        ResultVo resultVo = new ResultVo();
        resultVo.setResult(result);
        resultVo.setCode(1000);
        return resultVo;
    }
    public static ResultVo sucess(String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setMsg(msg);
        resultVo.setCode(1000);
        return resultVo;
    }
    public static ResultVo file(String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setMsg(msg);
        resultVo.setCode(2000);
        return resultVo;
    }
    public static ResultVo file(String msg, Exception e){
        ResultVo resultVo = new ResultVo();
        resultVo.setMsg(msg);
        resultVo.setCode(2000);
        log.error(msg,e);
        return resultVo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
