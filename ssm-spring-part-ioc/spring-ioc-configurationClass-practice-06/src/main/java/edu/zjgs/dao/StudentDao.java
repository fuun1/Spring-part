package edu.zjgs.dao;

import edu.zjgs.pojo.Student;
import java.util.List;

/**
 * @ClassName: StudentDao
 * @Package: edu.zjgs.pojo
 * @Param:
 * @return:
 * @Create: 2024/6/6 - 17:21
 * @Version: v1.0
 */
public interface StudentDao {
  List<Student> findAll();
}
