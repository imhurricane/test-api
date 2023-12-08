package com.qh.handle.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class IgnoreTokenAuthAspect {
    /**
     * 设置操作日志切入点   在注解的位置切入代码
     */
    @Pointcut("@annotation(com.qh.handle.aop.annotation.IgnoreTokenAuth)")
    public void IgnoreTokenAuth() {
    }
}
