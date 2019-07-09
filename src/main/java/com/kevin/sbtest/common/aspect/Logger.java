package com.kevin.sbtest.common.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 用来记录日志的类(模拟的通知类)
 */

@Aspect
@Component
public class Logger {

    /**
     * 切入点表达式
     */
    @Pointcut("execution(* com.kevin.sbtest.controller..*(..))")
    private void pt1() {
    }

    ;

    /**
     * 前置通知
     */
    @Before("pt1()")
    public void beforeAdvice() {
        System.out.println("before:开始记录日志...");
    }

    /**
     * 后置通知
     */
    @After("pt1()")
    public void afterAdvice() {
        System.out.println("afterAdvice......");
    }

    /**
     * 最终通知
     */
    @AfterReturning("pt1()")
    public void finallyAdvice() {
        System.out.println("afterReturningAdvice.........");
    }

    /**
     * 异常通知
     */
    @AfterThrowing("pt1()")
    public void exceptionAdvice() {
        System.out.println("exceptionAdvice....");
    }


    /**
     * 环绕通知
     *
     * @param pjp
     */
    @Around("pt1()")
    public Object aroundPringLog(ProceedingJoinPoint pjp) {
        Object obj = null;
        try {
            Object[] args = pjp.getArgs();// 得到方法所需的参数
            System.out.println("环绕通知:前置...");
            //明确调用业务层方法
            obj = pjp.proceed(args);
            System.out.println("环绕通知:后置...");
            return obj;
        } catch (Throwable throwable) {
            System.out.println("环绕通知:异常...");
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("环绕通知:最终...");
        }
    }
}