package edu.zjgs.test;

import edu.zjgs.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: FindAllTest
 * @Package: edu.zjgs.test
 * @Param:
 * @return:
 * @Create: 2024/6/6 - 17:39
 * @Version: v1.0
 */

public class FindAllTest {
  @Test
  public void findAll(){
    ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("spring-01.xml");
    StudentController bean = classPathXmlApplicationContext.getBean(StudentController.class);
    bean.findAll();
    classPathXmlApplicationContext.close();
  }
}
