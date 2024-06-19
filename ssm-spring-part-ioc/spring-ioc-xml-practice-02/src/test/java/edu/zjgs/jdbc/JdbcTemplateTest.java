package edu.zjgs.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import edu.zjgs.controller.StudentsController;
import edu.zjgs.pojo.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * 一、JdbcTemplate(只是用于简化数据库增删改查动作crud 不提供连接池):
 * 为了在特定领域帮助我们简化代码，Spring 封装了很多 『Template』形式的模板类。
 * 例如：RedisTemplate、RestTemplate 等等，包括我们今天要学习的 JdbcTemplate  类似于DBUtil
 *
 * 二、DruidDataSource 负责连接的创建和数据库驱动的注册等等
 */

public class JdbcTemplateTest {

  @Test
  public void testForJava() {
    //创建连接池对象
    DruidDataSource druidDataSource = new DruidDataSource();
    druidDataSource.setUrl("jdbc:mysql:///studb?useUnicode=true&characterEncoding=utf8");//url地址
    druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");//jdbc驱动
    druidDataSource.setUsername("root");//账号
    druidDataSource.setPassword("123456");//密码
    //1、实例化对象
    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    jdbcTemplate.setDataSource(druidDataSource);//jdbcTemplate.setDataSource(连接池对象);
    //2、调用方法
    /**
     * 1、jdbcTemplate.update();//非查询语句 DDL DML DCL
     *
     * SQL 语句主要可以划分为以下 3 个类别。
     *
     * DDL（Data Definition Languages）语句：数据定义语言，这些语句定义了不同的数据段、数据库、表、列、索引等数据库对象的定义。
     * 常用的语句关键字主要包括 create、drop、alter等。
     * DML（Data Manipulation Language）语句：数据操纵语句，用于添加、删除、更新和查询数据库记录（增删改查），并检查数据完整性，
     * 常用的语句关键字主要包括 insert、delete、update等。
     * DCL（Data Control Language）语句：数据控制语句，用于控制不同数据段直接的许可和访问级别的语句。这些语句定义了数据库、表、字段、用户的访问权限和安全级别。
     * 主要的语句关键字包括 grant 、 deny 、 revoke 、 c o m m i t 、 s a v e p o i n t 、 r o l l b a c k grant、deny、revoke、commit、savepoint、rollbackgrant、deny、revoke、commit、savepoint、rollback 等。
     */
    /**
     * 2、jdbcTemplate.queryForObject(); DQL查询单个对象
     */
    /**
     * 3、jdbcTemplate.query(); DQL查询集合
     */
    String sql="insert into students(name,gender,age,class) values(?,?,?,?)";

    int update = jdbcTemplate.update(sql, "阿三", "男", 18, "三年级二班");
    System.out.println(update);

////    删除数据
//      String sql2 = "DELETE FROM students WHERE id = ?";
//      int deletedRows = jdbcTemplate.update(sql2, 20);
//      System.out.println("deletedRows = " + deletedRows);
  }

  /**
   * 通过ioc容器读取配置的jdbcTemplate组件
   */

   @Test
    public void testForJavaIOC() {
      //创建ioc容器
      ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("spring-01.xml");
      //获取jdbcTemplate组件
      JdbcTemplate jdbcTemplate = classPathXmlApplicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
      //数据库增删改查操作

        //可以带?占位符只能替代值不能替代关键字insert等
        //返回值：int 影响行数
//      String sql="insert into students(name,gender,age,class) values(?,?,?,?)";
//      int update = jdbcTemplate.update(sql, "李胜利", "男", 21, "三年级二班");
//      System.out.println("update = " + update);//soutv输出

     //删除数据
//      String sql2 = "DELETE FROM students WHERE id = ?";
//      int deletedRows = jdbcTemplate.update(sql2, 18);
//      System.out.println("deletedRows = " + deletedRows);

      //查询单条数据：根据id查询学生数据、返回一个对应的实体对象
      String sql3="select * from students where id=?";
      Student student = jdbcTemplate.queryForObject(sql3, new RowMapper<Student>() {
       @Override
       public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
         //rs 结果集
         //rowNum 行数
         //rs结果集中获取列的值，赋值给实体类对象
         Student student = new Student();
         student.setId(rs.getInt("id"));
         student.setName(rs.getString("name"));
         student.setGender(rs.getString("gender"));
         student.setAge(rs.getInt("age"));
         student.setClasses(rs.getString("class"));
         return student;
       }
     }, 2);
     System.out.println("student = " + student);

//     Lambda表达式 react函数 vue中的箭头
//     jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
//       Student student = new Student();
//       student.setId(rs.getInt("id"));
//       student.setName(rs.getString("name"));
//       student.setGender(rs.getString("gender"));
//       student.setAge(rs.getInt("age"));
//       student.setClasses(rs.getString("class"));
//       return student;
//     });




     //查询所有学生的数据信息
     //rowMapper
     String sql4="select id,name,gender,age,class as classes from students";
     List<Student> studentList1 = jdbcTemplate.query(sql4, new RowMapper<Student>() {
       @Override
       public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
         Student student = new Student();
         student.setId(rs.getInt("id"));
         student.setName(rs.getString("name"));
         student.setGender(rs.getString("gender"));
         student.setAge(rs.getInt("age"));
         student.setClasses(rs.getString("classes"));
         return student;
       }
     });
     System.out.println("studentList1 = " + studentList1);
     //rowMapper自动映射属性名  :BeanPropertyRowMapper要求列明和属性名一致，不一致起别名class as classes
     List<Student> studentList = jdbcTemplate.query(sql4, new BeanPropertyRowMapper<Student>(Student.class));
     System.out.println("studentList = " + studentList);

   }

   @Test
   public void finAll(){
     ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("spring-02.xml");
     StudentsController studentsController = classPathXmlApplicationContext.getBean(StudentsController.class);
     studentsController.findAll();
     classPathXmlApplicationContext.close();
   }


}
