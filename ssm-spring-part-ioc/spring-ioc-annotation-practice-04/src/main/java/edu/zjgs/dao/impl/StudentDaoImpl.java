package edu.zjgs.dao.impl;

import edu.zjgs.dao.StudentDao;
import edu.zjgs.pojo.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: StudentDaoImpl
 * @Package: edu.zjgs.pojo.impl
 * @Param:
 * @return:
 * @Create: 2024/6/6 - 17:22
 * @Version: v1.0
 */
@Repository
public class StudentDaoImpl implements StudentDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<Student> findAll() {
    String sql="select id,name,gender,age,class as classes from students";
    List<Student> student = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    return student;
  }
}
