package edu.zjgs.statics;


import edu.zjgs.Calculator;

public class StaticProxyCalculator implements Calculator {
  //房东
  private Calculator calculator;

  //构造函数传入房东
  public StaticProxyCalculator(Calculator calculator) {
    this.calculator = calculator;
  }

  @Override
  public int add(int i, int j) {
    //非核心业务 中介使用
    System.out.println("i = " + i + ", j = " + j);
    int add=add(i,j);
    System.out.println("add = " + add);
    return add;

  }

  @Override
  public int sub(int i, int j) {
    return 0;
  }

  @Override
  public int mul(int i, int j) {
    return 0;
  }

  @Override
  public int div(int i, int j) {
    return 0;
  }
}
