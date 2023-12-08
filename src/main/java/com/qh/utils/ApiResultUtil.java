package com.qh.utils;


import com.qh.constant.ApiResult;
import com.qh.constant.ErrorCode;

public class ApiResultUtil {

    public static ApiResult tokenInvalid() {
        return fail(ErrorCode.TOKEN_ERROR);
    }

    public static ApiResult akSkError() {
        return fail(ErrorCode.AK_SK_ERROR);
    }

    public static ApiResult success() {
        return new ApiResult<>(0, "", null);
    }

    public static ApiResult success(Object data) {
        return new ApiResult<>(0, "", data);
    }

    public static ApiResult fail(Integer code, String message) {
        return new ApiResult(code, message);
    }

    public static ApiResult fail(ErrorCode errorCode) {
        return new ApiResult(errorCode.getCode(), errorCode.getDesc());
    }
}
