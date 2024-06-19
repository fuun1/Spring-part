package edu.zjgs.ioc_05_DiAnnotationBaseType;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName: JavaBean
 * @Package: edu.zjgs.ioc_05_DiAnnotationBaseType
 * @Param:
 * @return:
 * @Create: 2024/6/6 - 16:36
 * @Version: v1.0
 */
@Component
public class JavaBean {

  /**
   * <bean id="" class=""
   *    <property name="name" value="二狗子"/>
   * </bean>
   */
  //方案一直接赋值
  private String name="二狗子";
  //方案二注解赋值
  @Value("19")//无意义
  private int age;

  //@Value注解用于配置外部文件时使用  读取外部文件
  //@Value("${key:value默认值}")
  @Value("${edu.jdbc.username:admin}")
  public String Username;
  @Value("${edu.jdbc.password}")
  public int Password;

  @Override
  public String toString() {
    return "JavaBean{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", Username='" + Username + '\'' +
        ", Password=" + Password +
        '}';
  }
}
