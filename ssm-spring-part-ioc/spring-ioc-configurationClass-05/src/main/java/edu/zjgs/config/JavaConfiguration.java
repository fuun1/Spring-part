package edu.zjgs.config;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * java的配置类替代xml配置文件
 * @Configuration 代表当前类是配置类
 * 1、包扫描注解配置 @ComponentScan("edu.zjgs.ioc_01_class")   单个包
 *    @ComponentScan({"edu.zjgs.ioc_01_class","edu.zjgs.ioc_02_test"}) 多个包
 *    内部：String[] value() default {};数组value可以多个
 * 2、引用外部的配置:@PropertySource(value = "classPath:jdbc.properties")
 * 3、声明第三方依赖的bean组件
 *
 * 总结：
 * @Configuration指定一个类为配置类，可以添加配置注解，替代配置xml文件
 *
 * @ComponentScan(basePackages = {"包","包"}) 替代<context:component-scan标签实现注解扫描
 *
 * @PropertySource("classpath:配置文件地址") 替代 <context:property-placeholder标签
 *
 * 配合IoC/DI注解，可以进行完整注解开发！
 *  标记IoC注解：@Component,@Service,@Controller,@Repository
 *  标记DI注解：@Autowired @Qualifier @Resource @Value
 *
 *  <context:component-scan标签指定注解范围使用@ComponentScan(basePackages = {"com.atguigu.components"})替代
 *  <context:property-placeholder引入外部配置文件使用@PropertySource({"classpath:application.properties","classpath:jdbc.properties"})替代
 *  <bean 标签使用@Bean注解和方法实现
 *  IoC具体容器实现选择AnnotationConfigApplicationContext对象
 */

@ComponentScan({"edu.zjgs.ioc_01_class","edu.zjgs.ioc_02_test"})
@PropertySource(value = "classpath:jdbc.properties")
@Configuration //代表是配置类
public class JavaConfiguration {

  @Value("${edu.url}")
  private String url;

  @Value("${edu.driver}")
  private String driver;

  @Value("${edu.username}")
  private String username;

  @Value("${edu.password}")
  private String password;
  /**
   * 方法体可以自定义实现过程
   * @Bean会真正让配置类的方法创建的组件存储到ioc容器
   *   如果第三方类进行IoC管理, 无法直接使用@Component相关注解
   *   解决方案: xml方式可以使用<bean标签
   *   解决方案: 配置类方式,可以使用方法返回值+@Bean注解
   */

  @Bean
  public DruidDataSource druidDataSource(){
    DruidDataSource druidDataSource = new DruidDataSource();
    druidDataSource.setUrl(url);//url地址
    druidDataSource.setDriverClassName(driver);//jdbc驱动
    druidDataSource.setUsername(username);//账号
    druidDataSource.setPassword(password);//密码
    return druidDataSource;
  }



//  @Bean
//  public DataSource createDataSource(@Value("${jdbc.user}") String username,
//      @Value("${jdbc.password}")String password,
//      @Value("${jdbc.url}")String url,
//      @Value("${jdbc.driver}")String driverClassName){

//    //使用Java代码实例化
//    DruidDataSource dataSource = new DruidDataSource();
//    dataSource.setUsername(username);
//    dataSource.setPassword(password);
//    dataSource.setUrl(url);
//    dataSource.setDriverClassName(driverClassName);
//    //返回结果即可
//    return dataSource;

//  }


  /**
   * @Bean注解细节
   * 1、beanName：默认方法名：  这里是LifeCycle
   *           指定：name/value 属性名字覆盖方法名
   * 2、周期方法如何指定：
   *           原有注解：@PostConstruct + @PreDestroy注解
   *
   *           bean属性指定：initMethod  destroyMethod
   *               <bean id="javaBean" class="edu.zjgs.ioc_04_LifeCycle.JavaBean" init-method="init" destroy-method="destroy"/>
   *3、作用域：和以前一样@Scope注解，默认是单例
   *          scopeName与value效果一样
   *          @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)//多例
   *          @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)//单例
   * 4、如何引用其他的ioc组件
   *
   *
   */
  @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
  @Bean(name = "XxxValue",initMethod ="",destroyMethod = "")
  public void LifeCycle(){

  }

  @Bean
  public JdbcTemplate jdbcTemplate(){
    JdbcTemplate jdbcTemplate=new JdbcTemplate();
    //1、可以直接调用其他@Bean方法
    //2、形参列表中生命想要的组件信息，一个或多个，ioc容器会注入
    jdbcTemplate.setDataSource(druidDataSource());
    return  jdbcTemplate;
  }

  @Bean
  public JdbcTemplate jdbcTemplate1(DataSource dataSource){
    JdbcTemplate jdbcTemplate=new JdbcTemplate();
    //1、可以直接调用其他@Bean方法
    //2、形参列表中生命想要的组件信息，一个或多个，ioc容器会注入
    jdbcTemplate.setDataSource(druidDataSource());
    return  jdbcTemplate;
  }

}
