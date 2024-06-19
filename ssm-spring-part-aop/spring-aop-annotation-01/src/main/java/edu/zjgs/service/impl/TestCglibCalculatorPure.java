package edu.zjgs.service.impl;


import org.springframework.stereotype.Component;

@Component//aop实现动态代理相关代理内容需要在ioc容器中
public class TestCglibCalculatorPure {
    

    public int add(int i, int j) {
    
        int result = i + j;
    
        return result;
    }
    

    public int sub(int i, int j) {
    
        int result = i - j;
    
        return result;
    }
    

    public int mul(int i, int j) {
    
        int result = i * j;
    
        return result;
    }
    

    public int div(int i, int j) {
    
        int result = i / j;
    
        return result;
    }
}