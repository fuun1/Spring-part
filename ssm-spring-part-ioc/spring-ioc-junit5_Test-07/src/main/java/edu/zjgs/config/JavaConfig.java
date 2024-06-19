package edu.zjgs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName: JavaConfig
 * @Package: edu.zjgs.config
 * @Param:
 * @return:
 * @Create: 2024/6/8 - 12:26
 * @Version: v1.0
 */
@ComponentScan("edu.zjgs.components")
@PropertySource("classpath:test.properties")
@Configuration
public class JavaConfig {

}
