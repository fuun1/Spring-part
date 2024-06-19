package edu.zjgs;


/**
 * 实现计算接口,单纯添加 + - * / 实现! 掺杂其他功能!
 *
 * 问题：
 * 附加功能代码重复，分散在各个业务功能方法中！冗余，且不方便统一
 * 附加功能代码重复，分散在各个业务功能方法中！冗余，且不方便统一维护！
 *
 *
 * 解决：
 * 核心就是：解耦。我们需要把附加功能从业务功能代码中抽取出来
 * 将重复的代码统一提取，并且[[动态插入]]到每个业务方法
 *
 * 解决问题的困难：提取重复附加功能代码到一个类中，可以实现
 *
 * 非核心业务提取出来：解耦
 * System.out.println("i = " + i + ", j = " + j);//soutp 参数输出 非核心代码
 * System.out.println("result = " + result);//soutv  结果输出 非核心代码
 *
 * 引入：
 * 通过提供一个代理类，让我们在调用目标方法的时候，不再是直接对目标方法进行调用，而是通过代理类间接调用。
 * 让不属于目标方法核心逻辑的代码从目标方法中剥离出来——解耦。
 * 调用目标方法时先调用代理对象的方法，减少对目标方法的调用和打扰，同时让附加功能能够集中在一起也有利于统一维护。
 *
 * 代理：将非核心逻辑剥离出来以后，封装这些非核心逻辑的类、对象、方法
 * 代理在开发中实现的方式具体有两种：静态代理，[动态代理技术]
 *
 *
 * AOP（面向切面编程）是一种编程范式，它通过将通用的横切关注点（如日志、事务、权限控制等）与业务逻辑分离，使得代码更加清晰、简洁、易于维护。AOP可以应用于各种场景，以下是一些常见的AOP应用场景：
 *
 * 1. 日志记录：在系统中记录日志是非常重要的，可以使用AOP来实现日志记录的功能，可以在方法执行前、执行后或异常抛出时记录日志。
 * 2. 事务处理：在数据库操作中使用事务可以保证数据的一致性，可以使用AOP来实现事务处理的功能，可以在方法开始前开启事务，在方法执行完毕后提交或回滚事务。
 * 3. 安全控制：在系统中包含某些需要安全控制的操作，如登录、修改密码、授权等，可以使用AOP来实现安全控制的功能。可以在方法执行前进行权限判断，如果用户没有权限，则抛出异常或转向到错误页面，以防止未经授权的访问。
 * 4. 性能监控：在系统运行过程中，有时需要对某些方法的性能进行监控，以找到系统的瓶颈并进行优化。可以使用AOP来实现性能监控的功能，可以在方法执行前记录时间戳，在方法执行完毕后计算方法执行时间并输出到日志中。
 * 5. 异常处理：系统中可能出现各种异常情况，如空指针异常、数据库连接异常等，可以使用AOP来实现异常处理的功能，在方法执行过程中，如果出现异常，则进行异常处理（如记录日志、发送邮件等）。
 * 6. 缓存控制：在系统中有些数据可以缓存起来以提高访问速度，可以使用AOP来实现缓存控制的功能，可以在方法执行前查询缓存中是否有数据，如果有则返回，否则执行方法并将方法返回值存入缓存中。
 * 7. 动态代理：AOP的实现方式之一是通过动态代理，可以代理某个类的所有方法，用于实现各种功能。
 *
 * 综上所述，AOP可以应用于各种场景，它的作用是将通用的横切关注点与业务逻辑分离，使得代码更加清晰、简洁、易于维护。
 *
 *
 */
public class CalculatorPureImpl implements Calculator {
    
    @Override
    public int add(int i, int j) {
        System.out.println("i = " + i + ", j = " + j);//soutp 参数输出 非核心代码
        int result = i + j;
        System.out.println("result = " + result);//soutv  结果输出 非核心代码
        return result;
    }
    
    @Override
    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }
    
    @Override
    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }
    
    @Override
    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}