package edu.zjgs.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 环绕通知
 */
//@Component
//@Aspect
public class RoundAdvice {

  @Around("edu.zjgs.pointcut.MyPointCut.RoundAdvice()")
  public Object transaction(ProceedingJoinPoint joinPoint){

    Object[] args = joinPoint.getArgs();
    Object result =null;

    try {
      System.out.println("环绕通知 - 开启事务");
      Object proceed = joinPoint.proceed(args);
      System.out.println("环绕通知 - 结束事务");
    } catch (Throwable e) {
      //异常
      System.out.println("环绕通知 - 事务回滚");
      e.printStackTrace();
    } finally {

    }
    return  result;
  }
}
