package com.qh.exception;


import com.qh.constant.ErrorCode;

/**
 * 功能描述
 *
 * @author mayue
 * @create 2023/6/23 11:12 PM
 */
public class AuthException extends RuntimeException {
    private String message;

    private Integer code;

    public AuthException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public AuthException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getDesc();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
