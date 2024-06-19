package edu.zjgs.dao.impl;

import edu.zjgs.dao.StudentsDao;
import edu.zjgs.pojo.Student;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName: StudentsDaoImpl
 * @Package: edu.zjgs.dao.impl
 * @Param:
 * @return:
 * @Create: 2024/6/5 - 18:12
 * @Version: v1.0
 */
public class StudentsDaoImpl implements StudentsDao {

  //学会使用ioc容器 帮助管理
  //jdbcTemplate注入setter方法
  //jdbcTemplate 简化了 JDBC 的用法，它提供了诸如查询、更新、批处理操作等功能，并且处理了资源管理、异常处理等细节，大大减少了开发者的工作量
  private JdbcTemplate jdbcTemplate;

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Student> queryAll() {
    String sql="select id,name,gender,age,class as classes from students";
    List<Student> students = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    System.out.println("studentsDao = " + students);
    return students;
  }
}
