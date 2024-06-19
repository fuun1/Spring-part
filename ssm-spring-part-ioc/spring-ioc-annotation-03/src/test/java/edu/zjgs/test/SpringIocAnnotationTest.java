package edu.zjgs.test;

import edu.zjgs.ioc_01_Annotation.CommonComponent;
import edu.zjgs.ioc_01_Annotation.XxxController;
import edu.zjgs.ioc_03_scope.JavaBean;
import edu.zjgs.ioc_03_scope.JavaBean2;
import edu.zjgs.ioc_04_DiAnnotationReferenceType.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringIocAnnotationTest {
  @Test
  public void testAnnotation(){
    ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("spring-01.xml");
    CommonComponent commonComponent = classPathXmlApplicationContext.getBean(CommonComponent.class);
    System.out.println("commonComponent = " + commonComponent);
    XxxController xxxController = classPathXmlApplicationContext.getBean(XxxController.class);
    System.out.println("xxxController = " + xxxController);
    Object xxxDao = classPathXmlApplicationContext.getBean("XxxDao");
    System.out.println("xxxDao = " + xxxDao);

    classPathXmlApplicationContext.close();
  }
  @Test
  public void testLifeCycle(){
    ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("spring-02.xml");
    edu.zjgs.ioc_02_LifeCycle.JavaBean javaBean = classPathXmlApplicationContext
        .getBean(edu.zjgs.ioc_02_LifeCycle.JavaBean.class);

    classPathXmlApplicationContext.close();

  }
  @Test
  public void testScope(){
    ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("spring-03.xml");
    JavaBean Scope1 = classPathXmlApplicationContext.getBean(JavaBean.class);
    JavaBean Scope2 = classPathXmlApplicationContext.getBean(JavaBean.class);
    JavaBean2 Scope3 = classPathXmlApplicationContext.getBean(JavaBean2.class);
    JavaBean2 Scope4 = classPathXmlApplicationContext.getBean(JavaBean2.class);
    System.out.println("Scope = " + Scope1);
    System.out.println("Scope2 = " + Scope2);
    System.out.println(Scope1==Scope2);
    System.out.println(Scope3==Scope4);
    classPathXmlApplicationContext.close();

  }

  @Test
  public void testDiAnnotationReferenceType(){
    ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("spring-04.xml");
    UserController userController = classPathXmlApplicationContext.getBean(UserController.class);
    System.out.println("userController = " + userController);
    userController.show();
    classPathXmlApplicationContext.close();

  }

  @Test
  public void testDiAnnotationBaseType(){
    ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("spring-05.xml");
    edu.zjgs.ioc_05_DiAnnotationBaseType.JavaBean bean = classPathXmlApplicationContext
        .getBean(edu.zjgs.ioc_05_DiAnnotationBaseType.JavaBean.class);
    System.out.println(bean.toString());
    System.out.println("bean = " + bean);
    classPathXmlApplicationContext.close();

  }

}
