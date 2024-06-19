package edu.zjgs.ioc_02_LifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

/**
 * @ClassName: JavaBean
 * @Package: edu.zjgs.ioc_02
 * @Param:
 * @return:
 * @Create: 2024/6/5 - 19:54
 * @Version: v1.0
 */

@Component

public class JavaBean {

  @PostConstruct
  public void init(){
    System.out.println("JavaBean.init");
  }
  @PreDestroy
  public void destroy(){
    System.out.println("JavaBean.destroy");
  }
}
