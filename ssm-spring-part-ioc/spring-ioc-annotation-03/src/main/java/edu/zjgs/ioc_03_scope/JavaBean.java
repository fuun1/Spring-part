package edu.zjgs.ioc_03_scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @ClassName: JavaBean
 * @Package: edu.zjgs.ioc_03_scope
 * @Param:
 * @return:
 * @Create: 2024/6/5 - 19:58
 * @Version: v1.0
 */
//scopeName与value效果一样
//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)//单例
// 每个bean都会转化成Spring内部的BeanDefinition对象 BeanDefinition对象中包含了定义的id class信息
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)//多例
@Component
public class JavaBean {

}
