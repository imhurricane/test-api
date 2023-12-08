package com.qh.constant;


public enum ErrorCode {
    SUCCESS(0, ""),
    COMMON_ERROR(10000, "error"),
    AK_SK_ERROR(10001, "ak/sk error"),
    TOKEN_ERROR(10002, "token error"),
    USERNAME_PASSWORD_ERROR(11000, "用户名或者密码错误"),
    ALARM_NOT_EXIST_ERROR(20001, "告警不存在"),
    THIRD_CALL_ERROR(50000, "调用第三方服务异常"),
    THIRD_CALL_RESULT_EMPTY(50001, "返回结果为空"),
    BUSINESS_ERROR(99999, "系统异常"),
    ;

    private Integer code;
    private String desc;

    private ErrorCode(Integer code, String desc) {
        this.setCode(code);
        this.setDesc(desc);
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
