package edu.zjgs.ioc_03_scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @ClassName: JavaBean2
 * @Package: edu.zjgs.ioc_03_scope
 * @Param:
 * @return:
 * @Create: 2024/6/5 - 20:13
 * @Version: v1.0
 */
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)//单例

@Component
public class JavaBean2 {

}
