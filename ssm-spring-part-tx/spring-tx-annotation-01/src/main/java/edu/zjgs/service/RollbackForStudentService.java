package edu.zjgs.service;

import edu.zjgs.dao.StudentDao;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *           Throwable
 *         /         \
 * error终止×             Exception
 *                      /        \
 *            RuntimeException   IoException
 *
 *  指定异常回滚：运行时异常
 *  rollbackFor = 指定哪些异常才会回滚,默认是 RuntimeException and Error 异常方可回滚!
 *  通过设置rollbackFor =Exception.class指定异常所有都回滚
 *  noRollbackFor = 指定哪些异常不会回滚, 默认没有指定,如果指定,应该在rollbackFor的范围内!
 *
 *  下面
 *  不设置rollbackFor =Exception.class时，studentDao.updateAgeById(88,1);修改成功
 *  设置rollbackFor =Exception.class时，studentDao.updateAgeById(88,1);修改不成功
 *
 *
 *
 *   isolation = 设置事务的隔离级别,mysql默认是repeatable read!
 */

@Service
public class RollbackForStudentService {
  @Autowired
  private StudentDao studentDao;

  @Transactional(readOnly = false,timeout = 3,rollbackFor =Exception.class,noRollbackFor = FileNotFoundException.class)
  public void changeInfo() throws FileNotFoundException {
    studentDao.updateAgeById(88,1);
    new FileInputStream("xxxx");//类路径不存在 报异常属于：IoException
    System.out.println("-----------");
    studentDao.updateNameById("test2",1);
  }
}
