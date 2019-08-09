package com.ktcn.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解,定义日志的信息
 * @author Administrator
 *
 */
@Retention(RetentionPolicy.RUNTIME)// 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Target({ElementType.PARAMETER, ElementType.METHOD })// 该注解可以使用在方法，参数
@Documented// 注解包含在javadoc中：
public @interface SysLog {
    // 定义属性，注解中的属性
    String logModule() default "";
    String logName() default "";
}