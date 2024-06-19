package edu.zjgs.service.impl;

import edu.zjgs.service.StudentsService;
import edu.zjgs.dao.StudentsDao;
import edu.zjgs.pojo.Student;
import java.util.List;

/**
 * @ClassName: StudentsServiceImpl
 * @Package: edu.zjgs.service.impl
 * @Param:
 * @return:
 * @Create: 2024/6/5 - 18:21
 * @Version: v1.0
 */
public class StudentsServiceImpl implements StudentsService {

  private StudentsDao studentsDao;

  public void setStudentsDao(StudentsDao studentsDao) {
    this.studentsDao = studentsDao;
  }

  @Override
  public List<Student> finAll() {
    List<Student> studentList = studentsDao.queryAll();
    System.out.println("studentListService = " + studentList);
    return studentList;
  }
}
