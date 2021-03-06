package com.chanpion.boot.admin.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author April Chen
 */
@Component
@Aspect
public class UserAccessAspect {

    @Pointcut(value = "@annotation(com.chanpion.boot.admin.aop.UserLog)")
    public void access() {

    }

    @Before("access()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        System.out.println("second before");
    }

    @Around("@annotation(userLog)")
    public Object around(ProceedingJoinPoint pjp, UserLog userLog) {
        //获取注解里的值
        System.out.println("second around:" + userLog.desc());
        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}