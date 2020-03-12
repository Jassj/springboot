package com.yuanjie.springboot.common;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class HttpResult {
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HttpResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public HttpResult(String code, BindingResult result) {
        this.code = code;
        StringBuilder sb = new StringBuilder();
        List<FieldError> list = result.getFieldErrors();
        for(FieldError fieldError : list) {
            sb.append(fieldError.getDefaultMessage()).append("! ");
        }
        this.msg = sb.toString();
    }


    @Override
    public String toString() {
        return "HttpResult{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
