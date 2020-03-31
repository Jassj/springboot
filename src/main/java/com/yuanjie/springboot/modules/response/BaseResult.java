package com.yuanjie.springboot.modules.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * description
 * 响应对象
 * @author yuanjie 2020/03/31 11:45
 */
@ApiModel(description = "响应对象")
public class BaseResult<T> {
    private static final int SUCCESS_CODE = 0;
    private static final String SUCCESS_MESSAGE = "成功";

    @ApiModelProperty(value = "响应码", name = "code", required = true, example = "" + SUCCESS_CODE)
    private int code;

    @ApiModelProperty(value = "响应消息", name = "msg", required = true, example = SUCCESS_MESSAGE)
    private String msg;

    @ApiModelProperty(value = "响应数据", name = "data")
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BaseResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private BaseResult() {
        this(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    private BaseResult(int code, String msg) {
        this(code, msg, null);
    }

    private BaseResult(T data) {
        this(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static <T> BaseResult<T> success() {
        return new BaseResult<>();
    }

    public static <T> BaseResult<T> successWithData(T data) {
        return new BaseResult<>(data);
    }

    public static <T> BaseResult<T> failWithCodeAndMsg(int code, String msg) {
        return new BaseResult<>(code, msg, null);
    }


}
