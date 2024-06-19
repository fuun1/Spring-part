package edu.zjgs.ioc_04_LifeCycle;

/**
 * @ClassName: JavaBean
 * @Package: edu.zjgs.ioc_04_LifeCycle
 * @Param:
 * @return:
 * @Create: 2024/6/4 - 1:48
 * @Version: v1.0
 */
public class JavaBean {

  /**
   * 必须时public void返回值类型 无参数的
   */
  public void init(){
    System.out.println("JavaBean.Init");
  }

  public void destroy(){
    System.out.println("JavaBean.destroy");
  }
}
