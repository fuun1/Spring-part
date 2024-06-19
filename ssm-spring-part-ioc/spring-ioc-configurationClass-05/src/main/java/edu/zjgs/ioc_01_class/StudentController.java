package edu.zjgs.ioc_01_class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @ClassName: StudentContoller
 * @Package: edu.zjgs.ioc_01_class
 * @Param:
 * @return:
 * @Create: 2024/6/7 - 12:33
 * @Version: v1.0
 */
@Controller
public class StudentController {
  @Autowired
  private StudentService studentService;

}
