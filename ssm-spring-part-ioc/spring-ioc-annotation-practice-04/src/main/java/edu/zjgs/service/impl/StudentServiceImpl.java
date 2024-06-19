package edu.zjgs.service.impl;


import edu.zjgs.dao.StudentDao;
import edu.zjgs.pojo.Student;
import edu.zjgs.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: StudentServiceImpl
 * @Package: edu.zjgs.service.impl
 * @Param:
 * @return:
 * @Create: 2024/6/6 - 17:24
 * @Version: v1.0
 */
@Service
public class StudentServiceImpl implements StudentService {
  @Autowired
  private StudentDao studentDao;

  @Override
  public List<Student> findAll() {
    List<Student> studentList = studentDao.findAll();
    return studentList;
  }
}
