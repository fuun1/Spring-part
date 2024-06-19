package edu.zjgs.config;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName: JavaConfiguration
 * @Package: edu.zjgs.config
 * @Param:
 * @return:
 * @Create: 2024/6/8 - 11:38
 * @Version: v1.0
 */
@ComponentScan(basePackages="edu.zjgs")
@PropertySource("classpath:jdbc.properties")
@Configuration
public class JavaConfiguration {

  @Bean
  public DataSource dataSource(@Value("${edu.url}") String url,
                                          @Value("${edu.driver}") String driver,
                                          @Value("${edu.username}") String username,
                                          @Value("${edu.password}") String password){
    DruidDataSource druidDataSource = new DruidDataSource();
    druidDataSource.setUrl(url);//url地址
    druidDataSource.setDriverClassName(driver);//jdbc驱动
    druidDataSource.setUsername(username);//账号
    druidDataSource.setPassword(password);//密码
    return druidDataSource;
  }
  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource){
    JdbcTemplate jdbcTemplate=new JdbcTemplate();
    jdbcTemplate.setDataSource(dataSource);
    return jdbcTemplate;
  }

}
