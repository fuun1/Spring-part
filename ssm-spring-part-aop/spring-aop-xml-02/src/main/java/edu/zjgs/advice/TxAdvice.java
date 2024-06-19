package edu.zjgs.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName: TxAdvice
 * @Package: edu.zjgs.advice
 * @Param:
 * @return:
 * @Create: 2024/6/10 - 22:43
 * @Version: v1.0
 */
@Component
@Aspect
public class TxAdvice {
  @Pointcut("execution(* edu..impl.*.*(..))")
  public void pc(){}

  //使用统一管理切面包下的配置类
  @Before("pc()")
  public void before(JoinPoint joinPoint){

  }

  @AfterReturning(value = "pc()",returning = "result")
  public void afterReturning(JoinPoint joinPoint,Object result){

  }
  @After("pc()")
  public void after(JoinPoint joinPoint){

  }
  @AfterThrowing(value = "pc()",throwing = "throwable")
  public void AfterThrowing(JoinPoint joinPoint,Throwable throwable){

  }
}
