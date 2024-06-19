package edu.zjgs.service;

import edu.zjgs.pojo.Student;
import java.util.List;

/**
 * @ClassName: StudentService
 * @Package: edu.zjgs.service
 * @Param:
 * @return:
 * @Create: 2024/6/6 - 17:24
 * @Version: v1.0
 */
public interface StudentService {
  List<Student> findAll();

}
