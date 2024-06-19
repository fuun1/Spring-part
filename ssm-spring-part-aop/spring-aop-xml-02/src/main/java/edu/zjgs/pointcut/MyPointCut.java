package edu.zjgs.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MyPointCut
 * @Package: edu.zjgs.pointcut
 * @Param:
 * @return:
 * @Create: 2024/6/10 - 22:48
 * @Version: v1.0
 */
@Component
@Aspect
public class MyPointCut {
  @Pointcut("execution(* edu..impl.*.*(..))")
  public void TestPc(){}

  @Pointcut("execution(* edu.zjgs.service.impl.*.*(..))")
  public void LogPc(){}

  @Pointcut("execution(* edu.zjgs.service.impl.*.*(..))")
  public void RoundAdvice(){}
}
