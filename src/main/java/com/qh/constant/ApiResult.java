package com.qh.constant;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonPropertyOrder(value = {"errorCode", "msg", "data"})
@Data
public class ApiResult<T> {

    private Integer code;
    private String msg;
    private T data;

    public ApiResult() {
    }

    public ApiResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ApiResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
