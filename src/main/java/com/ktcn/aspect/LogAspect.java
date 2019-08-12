package com.ktcn.aspect;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ktcn.entity.Log;

/**
 * 注解切入类
 */
@Aspect
@Component
public class LogAspect {
    // 获取日志对象
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    // 声明切入点, 参数为自定义注解类的全限定类名
    @Pointcut("@annotation(com.ktcn.aspect.SysLog)")
    public void controllerAspect() {
    }

    /**
     * 正常返回通知
     */
    @AfterReturning("controllerAspect()")
    public void AfterReturning(JoinPoint joinPoint) {
        try {
            // 获取ip地址
            String ip = InetAddress.getLocalHost().toString();
            String logModule = null;
            String logName = null;
            // 获取类的全限定名
            String targetName = joinPoint.getTarget().getClass().getName();
            // 获取方法名
            String methodName = joinPoint.getSignature().getName();

            // 获取所有参数
            Object[] arguments = joinPoint.getArgs();
            // 通过类全限定名获取此类的对象
            Class targetClass = Class.forName(targetName);
            // 通过类对象获取类中所有的方法
            Method[] methods = targetClass.getMethods();
            // 获取一个日志类对象
            Log log = new Log();
            // 获取当前时间
            Date date = new Date();
            // 遍历所有的方法
            for (Method method : methods) {
                // 判断哪一个是当前调用AOP的方法
                if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();
                    if (clazzs.length == arguments.length) {
                        logModule = method.getAnnotation(SysLog.class).logModule();
                        logName = method.getAnnotation(SysLog.class).logName();
                        log.setOperModel(logModule);
                        log.setOperName(logName);
                        logger.info("操作模块:" + logModule);
                        logger.info("操作内容:" + logName);
                        logger.info("ip地址: "+ip);
                        logger.info(log.toString());
                    }
                }
            }
        } catch (Exception e) {
            logger.error("日志获取错误");
        }
    }
}