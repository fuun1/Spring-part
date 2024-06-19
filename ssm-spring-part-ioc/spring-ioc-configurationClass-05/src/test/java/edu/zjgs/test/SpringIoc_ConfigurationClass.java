package edu.zjgs.test;

import edu.zjgs.config.JavaConfiguration;
import edu.zjgs.config.JavaConfigurationA;
import edu.zjgs.config.JavaConfigurationB;
import edu.zjgs.config.JavaConfigurationC;
import edu.zjgs.ioc_01_class.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 四种spring配置方式回顾
 * ClassPathXmlApplicationContext：通过读取类路径下的 XML 格式的配置文件创建 IOC 容器对象
 * FileSystemXmlApplicationContext：通过文件系统路径读取 XML 格式的配置文件创建 IOC 容器对象
 * AnnotationConfigApplicationContext：通过读取Java配置类创建 IOC 容器对象
 * WebApplicationContext：专门为 Web 应用准备，基于 Web 环境创建 IOC 容器对象，并将对象引入存入 ServletContext 域中。
 */
public class SpringIoc_ConfigurationClass {
  @Test
  public  void testXml(){
    // xml方式配置文件使用ClassPathXmlApplicationContext容器读取
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("spring-01.xml");
  }


  @Test
  public void testConfigurationClass(){

    //方式一
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfiguration.class);

    //方式二 等同于spring-ioc-xml-01方式中的SpringIocTest
    /**
     *     ClassPathXmlApplicationContext applicationContext1=new ClassPathXmlApplicationContext();
     *     applicationContext1.setConfigLocations("spring-03.xml");
     *     applicationContext1.refresh();//调用ioc和di
     */
    // AnnotationConfigApplicationContext-IOC容器对象
    AnnotationConfigApplicationContext applicationContext1 = new AnnotationConfigApplicationContext();
    //外部设置配置类
    applicationContext1.register(JavaConfiguration.class);
    //刷新后方可生效！！
    applicationContext1.refresh();

    StudentController studentController = applicationContext.getBean(StudentController.class);

    System.out.println("studentController = " + studentController);

    applicationContext1.close();

  }

  @Test
  public void testConfigurationImport(){
    AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(
        JavaConfigurationA.class, JavaConfigurationB.class);
    //或者使用
    AnnotationConfigApplicationContext applicationContext1=new AnnotationConfigApplicationContext(
        JavaConfigurationC.class);
  }



}
