package edu.zjgs.controller;

import edu.zjgs.pojo.Student;
import edu.zjgs.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @ClassName: StudentController
 * @Package: edu.zjgs.controller
 * @Param:
 * @return:
 * @Create: 2024/6/6 - 17:38
 * @Version: v1.0
 */
@Controller
public class StudentController {
  @Autowired
  private StudentService studentService;
  public void findAll(){
    List<Student> student = studentService.findAll();
//    System.out.println(student);
    System.out.println("student = " + student);
  }
}
