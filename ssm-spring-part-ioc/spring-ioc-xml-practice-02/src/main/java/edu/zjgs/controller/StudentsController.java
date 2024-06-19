package edu.zjgs.controller;

import edu.zjgs.pojo.Student;
import edu.zjgs.service.StudentsService;
import java.util.List;

/**
 * @ClassName: StudentsController
 * @Package: edu.zjgs.controller
 * @Param:
 * @return:
 * @Create: 2024/6/5 - 18:26
 * @Version: v1.0
 */
public class StudentsController {
  private StudentsService studentsService;

  public void setStudentsService(StudentsService studentsService) {
    this.studentsService = studentsService;
  }

  public  void findAll(){
    List<Student> studentList = studentsService.finAll();
    System.out.println("studentListController = " + studentList);
  }
}
