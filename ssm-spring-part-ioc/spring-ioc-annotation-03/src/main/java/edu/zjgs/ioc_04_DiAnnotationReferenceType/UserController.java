package edu.zjgs.ioc_04_DiAnnotationReferenceType;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;


@Controller
public class UserController {


  //相当于<property name="" ref=""/>对应类型的bean装配   应用类型
  //自动装配注解(DI)：在ioc容器查找复合类型的组件对象 设置给当前的属性
//  @Autowired
//  private UserServiceImpl userService;
//  public void show(){
//    String show = userService.show();
//    System.out.println("show = " + show);
//  }

  /**
   * 1. 如果没有指定name,先根据属性名查找IoC中组件xxxService
   * 2. 如果没有指定name,并且属性名没有对应的组件,会根据属性类型查找
   * 3. 可以指定name名称查找!  @Resource(name='test') == @Autowired + @Qualifier(value='test')
   */
  @Resource
  private UserService userService;

  //@Resource(name = "指定beanName")
  //private XxxService xxxService;

  public void show(){
    System.out.println("XxxController.show");
    userService.show();
  }
}
