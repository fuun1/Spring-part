package edu.zjgs.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Order(20)//数字越小优先级越高，优先级越高 前置越先执行，后置越后执行
public class OrderAdviceB {
  @Before("edu.zjgs.pointcut.MyPointCut.TestPc()")
  public void before(JoinPoint joinPoint){
    System.out.println("OrderAdviceB的前置执行了");
  }

  @AfterReturning(value = "edu.zjgs.pointcut.MyPointCut.TestPc()",returning = "result")
  public void afterReturning(JoinPoint joinPoint,Object result){
    System.out.println("OrderAdviceB的后置执行了");
  }

  @AfterThrowing(value = "edu.zjgs.pointcut.MyPointCut.TestPc()",throwing = "throwable")
  public void AfterThrowing(JoinPoint joinPoint,Throwable throwable){

  }
}
