package edu.zjgs.ioc_04_DiAnnotationReferenceType;

import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServicePmpl
 * @Package: edu.zjgs.ioc_04_DiAnnotation
 * @Param:
 * @return:
 * @Create: 2024/6/5 - 21:11
 * @Version: v1.0
 */

@Service
public class UserServiceImpl implements UserService{

  @Override
  public  String show() {
    return "UserServiceImpl show()";
  }
}
