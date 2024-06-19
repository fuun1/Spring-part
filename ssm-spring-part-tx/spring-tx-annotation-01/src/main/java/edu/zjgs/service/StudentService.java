package edu.zjgs.service;

import edu.zjgs.dao.StudentDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    
    @Autowired
    private StudentDao studentDao;

    /**
     * @Transactional
     * 注解 方法上/类上
     * 方法上：当前方法有事务
     * 类上：当前类中的所有方法有事务
     */

    @Transactional
    public void changeInfo(){
        studentDao.updateAgeById(88,1);
        System.out.println("-----------");
        studentDao.updateNameById("test2",1);
    }
}
