package edu.zjgs.ioc_01_Annotation;

import org.springframework.stereotype.Controller;

/**
 * projectName: com.atguigu.components
 *
 * description: controller类型组件
 */
@Controller(value = "xxxController")//默认首字母小写的类名  每个 bean 都有一个唯一标识——id 属性的值，便于在其他地方引用
//类名首字母小写就是 bean 的 id
public class XxxController {
}
