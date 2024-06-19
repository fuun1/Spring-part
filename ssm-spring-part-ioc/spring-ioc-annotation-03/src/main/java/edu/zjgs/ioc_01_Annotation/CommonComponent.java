package edu.zjgs.ioc_01_Annotation;

import org.springframework.stereotype.Component;

/**
 * projectName: com.atguigu.components
 *
 * description: 普通的组件
 *
 *使用三层架构时对应类中用对应的注解，
 *不适用三层架构 使用spring ioc容器使用注解@Component
 *     1、标记注解：@Component
 *     2、配置指定的包
 */


@Component  //注解等价于<bean id=""commonComponent class="CommonComponent"/>
public class CommonComponent {

}
