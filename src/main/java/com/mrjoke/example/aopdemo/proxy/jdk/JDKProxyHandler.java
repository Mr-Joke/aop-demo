package com.mrjoke.example.aopdemo.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * project：aop-demo
 * class：JDKProxyHandler
 * description：
 * <p>
 *
 * @author joker
 * @version 1.0
 * @since 2018/9/4 15:31
 */
public class JDKProxyHandler implements InvocationHandler {
    private Object object;

    public JDKProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("被代理业务方法执行前……");
        Object obj = method.invoke(object, args);
        System.out.println("被代理业务方法执行后……");
        return obj;
    }
}
