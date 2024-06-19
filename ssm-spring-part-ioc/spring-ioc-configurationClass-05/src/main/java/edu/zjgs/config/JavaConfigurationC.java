package edu.zjgs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Import(value = JavaConfigurationA.class)
 * {}数组可以传多个
 */
@Import({JavaConfigurationA.class,JavaConfigurationB.class})
@Configuration
public class JavaConfigurationC {

}
