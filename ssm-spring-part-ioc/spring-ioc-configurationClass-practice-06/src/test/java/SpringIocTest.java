import edu.zjgs.config.JavaConfiguration;
import edu.zjgs.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: SpringIocTest
 * @Package: PACKAGE_NAME
 * @Param:
 * @return:
 * @Create: 2024/6/8 - 12:01
 * @Version: v1.0
 */
public class SpringIocTest {
  @Test
  public void test(){
    AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(
        JavaConfiguration.class);
    StudentController bean = applicationContext.getBean(StudentController.class);
    bean.findAll();
    System.out.println("bean = " + bean);
  }

}
