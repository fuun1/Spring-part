package edu.zjgs.test;

import edu.zjgs.config.JavaConfig;
import edu.zjgs.service.Calculator;
import edu.zjgs.service.impl.CalculatorPureImpl;
import edu.zjgs.service.impl.TestCglibCalculatorPure;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @ClassName: SpringAopTest
 * @Package: edu.zjgs.test
 * @Param:
 * @return:
 * @Create: 2024/6/9 - 19:12
 * @Version: v1.0
 */
@SpringJUnitConfig(value = JavaConfig.class)
public class SpringAopTest {
  //有接口取值的时候使用接口取
  @Autowired//Di依赖注入
  private Calculator calculatorJdk;//√√√√√√√√√√√√接口取
  private CalculatorPureImpl XXXXXcalculatorPure;//××××××××××实现类取 此时实现类放入ioc容器中
  @Autowired
  private TestCglibCalculatorPure testCglibCalculatorPure;
  //后期使用aop时放入ioc容器的就不是此实现类

  @Test
  public void testJdk(){
    int add = calculatorJdk.add(1, 1);
    System.out.println("add = " + add);
  }

  @Test
  public void testCglib(){
    int add = testCglibCalculatorPure.add(1, 1);
    System.out.println("add = " + add);
  }
}
