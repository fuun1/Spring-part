package edu.zjgs.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 *  * 1、定义方法
 *  * 2、使用注解指定对应的位置
 *  * 3、配置切点表达式选中方法
 *       execution (   public int       edu.zjgs.service.impl.CalculatorPureImpl.add.(int,int))
 *        固定格式   权限修饰符（可用*替代）          方法所在类型的全类名                方法名   参数列表
 *                   int为方法的返回值                                          *（方法名任意） 使用(..)形式表示参数列表任意
 *       --访问修饰符：public / private
 *       --方法的返回值类型：int string void   连个可以都写为*不考虑访问修饰符和返回值类型
 *       --包的位置：具体包  : edu.zjgs.service.impl
 *                 单层模糊: edu.zjgs.service.*
 *                 多层模糊: edu..impl
 *                 细节： ..不能开头
 *       --类的名称：具体：CalculatorPureImpl
 *                 模糊：*
 *                 部分模糊：*Impl
 *       --形参列表：没有参数：()
 *                 有具体参数：(String)
 *
 *  * 4、切面和ioc容器的配置
 *  * 5、开启aspectj注解的支持
 *
 *  获取目标方法中的信息：方法名、参数、访问修饰符、所属类的信息
 *          JoinPoint joinPoint 直接在形参列表中声明
 *  返回结果：@AfterReturning
 *          public void afterReturning(JoinPoint joinPoint,Object result)   result接收返回结果
 *          @AfterReturning(value = "execution(* edu.zjgs.service.impl.*.*(..))",returning = "形参名")
 *  异常信息：@AfterThrowing
 *          public void AfterThrowing(JoinPoint joinPoint,Throwable throwable)
 *          @AfterThrowing(value = "execution(* edu.zjgs.service.impl.*.*(..))",throwing = "形参名")
 *
 */
//@Component
//@Aspect
public class MyAdvice {
  //"execution(* edu..impl.*.*(..))"  edu包下的..不考虑中间包 impl包中的所有类的所有方法
  @Before("execution(* edu..impl.*.*(..))")
  public void before(JoinPoint joinPoint){
    //导的包一定是aspectj中的JoinPoint对象    import org.aspectj.lang.JoinPoint;
    //spring自动从ioc容器中帮我们获取

    //获取方法属于类的信息
    String simpleName = joinPoint.getTarget().getClass().getSimpleName();
    System.out.println("simpleName = " + simpleName);
    //获取方法名称
    String name = joinPoint.getSignature().getName();
    System.out.println("name = " + name);
    //获取参数列表
    Object[] args = joinPoint.getArgs();
    System.out.println("args = " + args);
  }

  @AfterReturning(value = "execution(* edu.zjgs.service.impl.*.*(..))",returning = "result")
  public void afterReturning(JoinPoint joinPoint,Object result){
    //接返回结果result
    System.out.println("result="+result);
  }
  @After("execution(* edu.zjgs.service.impl.*.*(..))")
  public void after(JoinPoint joinPoint){

  }
  @AfterThrowing(value = "execution(* edu.zjgs.service.impl.*.*(..))",throwing = "throwable")
  public void AfterThrowing(JoinPoint joinPoint,Throwable throwable){
    System.out.println("throwable"+throwable);
  }

}
