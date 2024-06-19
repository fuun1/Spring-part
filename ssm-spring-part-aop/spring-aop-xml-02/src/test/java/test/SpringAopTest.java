package test;

import edu.zjgs.service.Calculator;
import edu.zjgs.service.impl.TestCglibCalculatorPure;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig(locations = "classpath:spring-01.xml")
public class SpringAopTest {
  //有接口取值的时候使用接口取
  @Autowired//Di依赖注入
  private Calculator calculatorJdk;

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
