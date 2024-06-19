**两类事务管理：**
编程式事务管理：
        Connection conn = ...;
        try {
        // 开启事务：关闭事务的自动提交
        conn.setAutoCommit(false);
        // 核心操作
        // 业务代码
        // 提交事务
        conn.commit();
        }catch(Exception e){
            // 回滚事务
            conn.rollBack();
        }finally{
            // 释放数据库连接
            conn.close();
        }
        按照自己的需求来控制事务的粒度、模式等等
声明式事务管理：声明式事务是指使用注解或 XML 配置的方式来控制事务的提交和回滚。开发者只需要添加配置即可， 具体事务的实现由第三方框架实现，避免我们直接进行事务操作


- 编程式事务需要手动编写代码来管理事务
- 而声明式事务可以通过配置文件或注解来控制事务。

1. Spring声明式事务对应依赖
    - spring-tx: 包含声明式事务实现的基本规范（事务管理器规范接口和事务增强等等）
    - spring-jdbc: 包含DataSource方式事务管理器实现类DataSourceTransactionManager
    - spring-orm: 包含其他持久层框架的事务管理器实现类例如：Hibernate/Jpa等
2. Spring声明式事务对应事务管理器接口
   DataSourceTransactionManager类中的主要方法：
   - doBegin()：开启事务
   - doSuspend()：挂起事务
   - doResume()：恢复挂起的事务
   - doCommit()：提交事务
   - doRollback()：回滚事务



**声明式事务管理 **
1、选择对应事务管理器实现加入到ioc容器
spring声明式事务管理给我们提供了各类管理器实现需要那种加入到ioc容器中即可
mybatis jdbc jdbcTemplate --》Datasource TM   依赖spring-tx spring-jdbc
hibernate                 --》Hibernate  TM
2、只需要使用注解指定哪些方法需要添加事务即可