package edu.zjgs.Test;

import edu.zjgs.components.TestA;
import edu.zjgs.components.TestB;
import edu.zjgs.config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @SpringJUnitConfig 用于在 JUnit 测试中加载 Spring 应用程序上下文，并指定用于加载上下文的配置类
 * 简化测试类的编写
 * @SpringJUnitConfig(locations = //指定配置的xml，value= //指定配置类)
 * @SpringJUnitConfig(classes = {JavaConfig.class})
 * @SpringJUnitConfig({JavaConfig.class,JavaConfig2.class})
 */

@SpringJUnitConfig(value=JavaConfig.class)
public class Junit5Test {

  /**
   * 测试类 可以使用 Spring 的依赖注入功能（例如 @Autowired）来获取被测试的 bean
   */
  @Autowired
  private TestA testA;

  @Autowired
  private TestB testB;

  @Test
  public void test(){
    testA.show();
    testB.show();
  }
}
