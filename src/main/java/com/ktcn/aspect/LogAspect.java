package com.ktcn.aspect;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktcn.entity.Log;
import com.ktcn.entity.Tb_user;
import com.ktcn.service.LogService;

/**
 * 注解切入类
 */
@Aspect
@Component
public class LogAspect {
    // 获取日志对象
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    // 获取日志service层实例
    @Resource
    private LogService logService;
    
    // 获取request对象
    @Autowired
    private HttpServletRequest request;
    
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
        	// 获取当前登录人信息
        	Tb_user user = (Tb_user) request.getSession().getAttribute("nowuser");
        	// 开发使用, 上线删除
    		if (user == null) {
    			user = new Tb_user();
    			user.setUser_id(111);
    			user.setName("测试用户名称");
    		}
    		
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
            Class<?> targetClass = Class.forName(targetName);
            // 通过类对象获取类中所有的方法
            Method[] methods = targetClass.getMethods();
            // 获取Log对象
            Log log = new Log();
            // 遍历所有的方法
            for (Method method : methods) {
                // 判断哪一个是当前调用AOP的方法
                if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();
                    if (clazzs.length == arguments.length) {
                        logModule = method.getAnnotation(SysLog.class).logModule();
                        logName = method.getAnnotation(SysLog.class).logName();
                        // 写入日志信息
                        log.setUser_id(user.getUser_id());
                        log.setUser(user.getName());
                        log.setOperTime(new Date());
                        log.setOperModel(logModule);
                        log.setOperName(logName);
                        // 写入客户机ip
                        log.setUserIp("111");
                        log.setUserIp(this.getIpAddr(request));
                        logger.info("访问ip: "+this.getIpAddr(request));
                        logService.addUserLog(log);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("日志获取错误");
        }
    }
    
    
    public String getIpAddr(HttpServletRequest request) {
	//处理代理访问获取不到真正的ip问题的        
	String ip = request.getHeader("x-forwarded-for");
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	//获取代理中中的ip
	            ip = request.getHeader("PRoxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	//获取代理中中的ip

	            ip = request.getHeader("WL-Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	//非代理的情况获取ip
	            ip = request.getRemoteAddr();
	        }
	        
	        return ip;
	    }
}