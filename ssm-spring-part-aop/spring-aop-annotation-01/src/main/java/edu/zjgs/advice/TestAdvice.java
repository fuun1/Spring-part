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
 * @ClassName: TestAdivice
 * @Package: edu.zjgs.advice
 * @Param:
 * @return:
 * @Create: 2024/6/10 - 21:13
 * @Version: v1.0
 */
@Component
@Aspect
public class TestAdvice {

  /**
   * aop统一切点管理
   * 1、空方法
   *   切点表达式的提取和复用
   *   定义一个空方法pc()
   *   注解Pointcut()
   *   使用时直接调用方法
   * 2、创建一个存储切点的类  类似于ioc容器配置类
   *    单独维护切点表达式
   *    其他类的切点方法 类的全限定符号.方法名()
   */
  @Pointcut("execution(* edu..impl.*.*(..))")
  public void pc(){}

  //使用统一管理切面包下的配置类
  @Before("edu.zjgs.pointcut.MyPointCut.TestPc()")
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
