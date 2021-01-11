package com.hfxt.tools;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAdvice {
    private Logger logger= Logger.getLogger(MyAdvice.class);

    // 定义一个空方法，借用其注解抽取切点表达式
    @Pointcut("execution(* com.hfxt.service..*.*(..))")
    public void pc() {}

    @Before("pc()")
    public void before(JoinPoint joinpoint) {
        System.out.println("---------------前置通知开始(注解)~~~~~~~~~~~");
        //+"的"+joinpoint.getSignature().getName()
        logger.info("调用了"+joinpoint.getSignature()+"方法，方法的参数是："
                +(joinpoint.getArgs().length==0?"无参":joinpoint.getArgs()[0]));
        System.out.println("---------------前置通知结束(注解)~~~~~~~~~~~");
    }

    @AfterReturning(value = "pc()", returning = "resultValue")
    public void after(JoinPoint joinpoint, Object resultValue) {
        System.out.println("---------------后置通知开始(注解)~~~~~~~~~~~");
        logger.info("调用了"+joinpoint.getSignature()+"的"+
                joinpoint.getSignature().getName()+"方法，方法的返回值是："+
                resultValue);
        System.out.println("---------------后置通知结束(注解)~~~~~~~~~~~");
    }

    // 异常通知
    @AfterThrowing("pc()")
    public void afterException() {
        System.out.println("这是异常通知(发生异常后调用)~~~~~~~~~~~(注解)");
    }

    // 最终通知(发生异常也会在最终调用)
    //@After("pc()")
    public void after() {
        System.out.println("这是最终通知(发生异常也会在最终调用)........(注解)");
    }

}
