package com.mrjoke.example.aopdemo.proxy.jdk;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

/**
 * project：aop-demo
 * class：ModelClassTest
 * description：
 * <p>
 *
 * @author joker
 * @version 1.0
 * @since 2018/9/4 15:35
 */
public class ModelClassTest {

    @Test
    public void hello() {
        ModelInterface model = new ModelClass();
        JDKProxyHandler jdkProxyHandler = new JDKProxyHandler(model);
        ModelInterface modelClass = (ModelInterface) Proxy.newProxyInstance(jdkProxyHandler.getClass().getClassLoader(), model.getClass().getInterfaces(), jdkProxyHandler);
        modelClass.hello();
    }
}