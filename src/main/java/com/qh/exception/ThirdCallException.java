package com.qh.exception;


import com.qh.constant.ErrorCode;

/**
 * @describe:
 * @author: mayue
 * @date: Created in 6/13/23 5:51 PM
 * @Modified By: 6/13/23 5:51 PM
 */
public class ThirdCallException extends RuntimeException {

    private String message;

    private Integer code;

    public ThirdCallException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ThirdCallException(ErrorCode errorCode) {
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
