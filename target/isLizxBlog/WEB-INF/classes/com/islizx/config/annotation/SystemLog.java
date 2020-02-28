package com.islizx.config.annotation;

import com.islizx.model.enums.LogTypeEnum;

import java.lang.annotation.*;

/**
 * 系统日志自定义注解
 *
 * @author lizx
 * @date 2020-02-21 - 15:06
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})//作用于参数或方法上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {
    /**
     * 日志名称
     * @return
     */
    String description() default "";

    /**
     * 日志类型
     * @return
     */
    LogTypeEnum type() default LogTypeEnum.OPERATION;
}
