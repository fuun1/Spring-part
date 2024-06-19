package edu.zjgs;

import edu.zjgs.dyn.ProxyFactory;
import edu.zjgs.statics.StaticProxyCalculator;

/**
 * @ClassName: UseAop
 * @Package: edu.zjgs
 * @Param:
 * @return:
 * @Create: 2024/6/8 - 21:52
 * @Version: v1.0
 */
public class UseAop {

  public static void main(String[] args) {
    //静态代理实现
    //房东
    Calculator calculator=new CalculatorPureImpl();
    //中介 代理
    StaticProxyCalculator proxy=new StaticProxyCalculator(calculator);
    //调用
    int add=proxy.add(1,1);
    System.out.println("add = " + add);






  }
}
