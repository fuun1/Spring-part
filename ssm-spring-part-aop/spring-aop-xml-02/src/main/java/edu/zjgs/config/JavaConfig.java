package edu.zjgs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan("edu.zjgs")
@EnableAspectJAutoProxy
public class JavaConfig {

}
