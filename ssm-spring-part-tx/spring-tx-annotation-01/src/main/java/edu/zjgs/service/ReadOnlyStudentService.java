package edu.zjgs.service;

import edu.zjgs.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional//当前类中的所有方法均有事务
public class ReadOnlyStudentService {

  @Autowired
  private StudentDao studentDao;

  /**
   * @Transactional
   * 注解 方法上/类上
   * 方法上：当前方法有事务
   * 类上：当前类中的所有方法有事务
   *
   * 当类上和方法上都存在@Transactional时，以方法上的为主，类上此时设置的失效
   */

  //update修改操作不用只读模式，会报错
  public void changeInfo(){
    studentDao.updateAgeById(88,1);
    System.out.println("-----------");
    studentDao.updateNameById("test2",1);
  }

  //查询方法可以再次设置Transactional为readOnly为true只读模式，提高查询效率
  @Transactional(readOnly = true)//readOnly = false默认值为false
  public void getStudentInfo(){

  }
}
