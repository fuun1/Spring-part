package edu.zjgs.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 步骤
 * 1、定义方法
 * 2、使用注解指定对应的位置
 * 3、配置切点表达式选中方法
 * 4、切面和ioc容器的配置
 * 5、开启aspectj注解的支持
 *
 * try{
 *   前置
 *   目标方法执行   //环绕
 *   后置
 * }catch(){
 *   异常
 * }finally{
 *   最后
 * }
 *
 */
@Component//放入ioc容器中
@Aspect//切面
public class LogAdvice {
  @Before("execution(* edu.zjgs.service.impl.*.*(..))")
  public void start(){
    System.out.println("开始");
  }
//  @AfterReturning
//  public void after(){
//    System.out.println("后置");
//  }
  @After("execution(* edu.zjgs.service.impl.*.*(..))")
  public void end(){
    System.out.println("最后");
  }
  @AfterThrowing("execution(* edu.zjgs.service.impl.*.*(..))")
  public void error(){
    System.out.println("异常");
  }
//  @Around()
//  public void round(){
//    System.out.println("环绕");
//  }
}

