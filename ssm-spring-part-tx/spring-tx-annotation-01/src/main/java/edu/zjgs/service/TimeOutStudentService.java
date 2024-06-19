package edu.zjgs.service;


import edu.zjgs.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TimeOutStudentService {

  @Autowired
  private StudentDao studentDao;

  /**
   * 超时回滚，释放资源
   * timeout设置事务超时事件，单位秒，
   * 默认：-1s 永不超时，不限制事务的超时时间
   * 设置 timeout=时间
   */
  @Transactional(readOnly = false,timeout = 3)
  public void changeInfo(){
    studentDao.updateAgeById(88,1);
    //设置线程睡眠
    try {
      Thread.sleep(4);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("-----------");
    studentDao.updateNameById("test2",1);
  }


}
