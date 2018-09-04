package com.mrjoke.example.aopdemo.proxy.cglib;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

/**
 * project：aop-demo
 * class：ModelClassTest
 * description：
 * <p>
 *
 * @author joker
 * @version 1.0
 * @since 2018/9/4 14:48
 */
public class ModelClassTest {

    /**
     * cglib方式动态代理：
     *
     * 1.设置父类，方便代理类继承
     * 2.设置拦截器，并在拦截器中写在被代理方法执行前后的业务代码
     * 3.创建代理类
     * 4.执行代理方法
     *
     * 代理方法执行过程：
     * 1.代理类方法中会判断是否设置了拦截器，若设置了拦截器则执行拦截器中intercept的方法
     * 2.拦截器intercept方法中需执行MethodProxy.invokeSuper()方法，此方法会执行被代理的方法。
     */
    @Test
    public void hello() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ModelClass.class);
        enhancer.setCallback(new ProxyInterceptor());
        ModelClass proxyModelClass = (ModelClass) enhancer.create();
        proxyModelClass.hello();
    }
}