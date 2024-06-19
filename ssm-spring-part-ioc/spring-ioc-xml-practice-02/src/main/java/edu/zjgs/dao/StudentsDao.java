package edu.zjgs.dao;

import edu.zjgs.pojo.Student;
import java.util.List;

/**
 * @ClassName: StudentsDao
 * @Package: edu.zjgs.dao
 * @Param:
 * @return:
 * @Create: 2024/6/5 - 18:11
 * @Version: v1.0
 */
public interface StudentsDao {
  List<Student> queryAll();
}
