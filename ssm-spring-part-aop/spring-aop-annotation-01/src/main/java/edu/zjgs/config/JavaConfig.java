package edu.zjgs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan("edu.zjgs")
@EnableAspectJAutoProxy//允许自动pc注解配置  等价于xml中的  <aop:aspectj-autoproxy/>
// 是一个用于启用 AspectJ 自动代理的注解
//这个注解告诉 Spring 容器去扫描标记了 @Aspect 注解的类，并为它们创建代理对象，以便在方法调用前后执行切面逻辑
public class JavaConfig {

}
