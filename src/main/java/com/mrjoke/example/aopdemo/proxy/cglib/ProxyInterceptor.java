package com.mrjoke.example.aopdemo.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * project：aop-demo
 * class：ProxyInterceptor
 * description：
 * <p>
 *
 * @author joker
 * @version 1.0
 * @since 2018/9/4 14:46
 */
public class ProxyInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理执行前……");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("代理执行后……");
        return o1;
    }
}
