package edu.zjgs.ioc_06_FactoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBean使用场景
 *     1. 代理类的创建
 *     2. 第三方框架整合
 *     3. 复杂对象实例化等
 *
 *
 * BeanFactory和FactoryBean的区别
 * 共同点：都是接口
 * BeanFactory：Ioc容器的最大的接口
 * FactoryBean：标准化组件、是一个组件-java类
 */
public class JavaBeanFactoryBean implements FactoryBean<JavaBean> {

  private String value;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }



  @Override
  public JavaBean getObject() throws Exception {
    JavaBean javaBean=new JavaBean();
    javaBean.setName(value);
    return javaBean;
  }

  @Override
  public Class<?> getObjectType() {
    return JavaBean.class;
  }


  @Override
  public String toString() {
    return "JavaBeanFactoryBean{" +
        "value='" + value + '\'' +
        '}';
  }
}
