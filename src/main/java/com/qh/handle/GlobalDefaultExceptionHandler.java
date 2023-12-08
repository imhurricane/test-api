package com.qh.handle;

import com.qh.constant.ApiResult;
import com.qh.constant.ErrorCode;
import com.qh.exception.BusinessException;
import com.qh.exception.ThirdCallException;
import com.qh.utils.ApiResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 定义一个全局异常的处理类，需要使用
 *
 * @ExceptionHandler ：该注解作用对象为方法，并且在运行时有效，value()可以指定异常类。
 * 由该注解注释的方法可以具有灵活的输入参数
 * @ControllerAdvice：
 */
@RestControllerAdvice
@Slf4j
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler(ThirdCallException.class)
    public ApiResult thirdCallException(ThirdCallException e) {
        return ApiResultUtil.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public ApiResult businessException(BusinessException e) {
        return ApiResultUtil.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ApiResult systemException(Exception e) {
        log.error("系统异常！", e);
        return ApiResultUtil.fail(ErrorCode.BUSINESS_ERROR);
    }
}
