package edu.zjgs.test;

import edu.zjgs.ioc_03_IocCreatAndUse.HappyComponent;
import edu.zjgs.ioc_04_LifeCycle.JavaBean;
import edu.zjgs.ioc_05_scope.JavaBean_Prototype;
import edu.zjgs.ioc_05_scope.JavaBean_singleton;
import edu.zjgs.ioc_06_FactoryBean.JavaBeanFactoryBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: SpringIocTest
 * @Package: edu.zjgs.test
 * @Param:
 * @return:
 * @Create: 2024/6/3 - 22:48
 * @Version: v1.0
 */
public class SpringIocTest {
  /**
   * 创建ioc容器
   *  四种BeanFactory子接口ApplicationContext的
   *  ClassPathXmlApplicationContext
   *  WebApplicationContext
   *  FilmSystemApplicationContext
   *  AnnotationConfigApplicationContext
   */
  public void creatIoc(){
    //方式一：直接创建
    /**
     * ClassPathXmlApplicationContext 和 ApplicationContext 都是接口
     * 但是 ClassPathXmlApplicationContext 是 ApplicationContext 的一个具体实现类
     *
     * ApplicationContext中没有定义close()
     * ClassPathXmlApplicationContext定义了close()
     */
    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-03.xml");
    ClassPathXmlApplicationContext applicationContext0=new ClassPathXmlApplicationContext();
    //方式二先创建ioc容器对象，再指定配置文件，再刷新
    ClassPathXmlApplicationContext applicationContext1=new ClassPathXmlApplicationContext();
    applicationContext1.setConfigLocations("spring-03.xml");
    applicationContext1.refresh();//调用ioc和di
  }

  /**
   * Ioc容器获取组件Bean
   */
  @Test
  public void getBeanFromIoc(){
    //创建ioc容器
    ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext();
    applicationContext.setConfigLocations("spring-03.xml");
    applicationContext.refresh();
    //读取ioc容器的组件 直接根据BeanId获取即可
    //方式一 没有指定类型,返回为Object,需要类型转化!
    HappyComponent happyComponent =(HappyComponent) applicationContext.getBean("happyComponent");
    //方式二 根据类型获取,但是要求,同类型(当前类,或者之类,或者接口的实现类)只能有一个对象交给IoC容器管理
    //配置两个或者以上出现: org.springframework.beans.factory.NoUniqueBeanDefinitionException 问题
    HappyComponent happyComponent1 = applicationContext.getBean("happyComponent", HappyComponent.class);
    //方式三
    HappyComponent happyComponent2 = applicationContext.getBean(HappyComponent.class);
    happyComponent.doWork();

    System.out.println(happyComponent==happyComponent1);
    System.out.println(happyComponent2==happyComponent1);
  }


  @Test
  public void lifeCycleTest(){
    ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-04.xml");
    JavaBean javaBean = applicationContext.getBean("javaBean", JavaBean.class);
//    javaBean.init();
//    javaBean.destroy();
    //正常结束ioc容器
    applicationContext.close();
  }

  @Test
  public void Scope(){
    ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-05.xml");
    //单例  取值singleton（默认值），bean在IOC容器中只有一个实例，IOC容器初始化时创建对象
    JavaBean_singleton javaBean_singleton = applicationContext.getBean("javaBean_singleton", JavaBean_singleton.class);
    JavaBean_singleton javaBean_singleton1 = applicationContext.getBean("javaBean_singleton", JavaBean_singleton.class);
    System.out.println(javaBean_singleton==javaBean_singleton1);//true
    //多例  取值prototype，bean在IOC容器中可以有多个实例，getBean()时创建对象
    JavaBean_Prototype javaBean_prototype = applicationContext.getBean("javaBean_prototype", JavaBean_Prototype.class);
    JavaBean_Prototype javaBean_prototype1 = applicationContext.getBean("javaBean_prototype", JavaBean_Prototype.class);
    System.out.println(javaBean_prototype==javaBean_prototype1);//false
  }

  @Test
  public void JavaBeanFactoryBeanTest(){
    ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("spring-06.xml");
    edu.zjgs.ioc_06_FactoryBean.JavaBean javaBean = classPathXmlApplicationContext.getBean("javaBean", edu.zjgs.ioc_06_FactoryBean.JavaBean.class);
    Object bean = classPathXmlApplicationContext.getBean("&javaBean");//只写名时
    System.out.println(javaBean);
    System.out.println(bean);
    classPathXmlApplicationContext.close();
  }

}
