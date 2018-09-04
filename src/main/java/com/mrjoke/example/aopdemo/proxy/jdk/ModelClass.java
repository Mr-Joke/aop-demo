package com.mrjoke.example.aopdemo.proxy.jdk;

/**
 * project：aop-demo
 * class：ModelClass
 * description：
 * <p>
 *
 * @author joker
 * @version 1.0
 * @since 2018/9/4 15:30
 */
public class ModelClass implements ModelInterface {
    @Override
    public void hello() {
        System.out.println("你好，jdk动态代理！");
    }
}
