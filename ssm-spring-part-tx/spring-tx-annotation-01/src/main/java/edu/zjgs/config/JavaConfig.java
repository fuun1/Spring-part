package edu.zjgs.config;



import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan("edu.zjgs")
@PropertySource("classpath:jdbc.properties")
@EnableAspectJAutoProxy//开启aspectj注解的支持
@EnableTransactionManagement//开启事务注解的支持
public class JavaConfig {

  @Bean
  public DataSource dataSource(@Value("${edu.url}") String url,
                                @Value("${edu.driver}") String drive,
                                @Value("${edu.username}") String username,
                                @Value("${edu.password}") String password){
    DruidDataSource dataSource=new DruidDataSource();
    dataSource.setUrl(url);
    dataSource.setDriverClassName(drive);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    return dataSource;

  }

  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource){
    JdbcTemplate jdbcTemplate=new JdbcTemplate();
    jdbcTemplate.setDataSource(dataSource);
    return jdbcTemplate;
  }


  //装配事务管理实现的对象
  @Bean
  public TransactionManager transactionManager(DataSource dataSource){
    DataSourceTransactionManager dataSourceTransactionManager=new DataSourceTransactionManager();
    //内部要进行事务的操作，基于的连接池   需要连接池对象
    dataSourceTransactionManager.setDataSource(dataSource);
    return dataSourceTransactionManager;
  }

}
