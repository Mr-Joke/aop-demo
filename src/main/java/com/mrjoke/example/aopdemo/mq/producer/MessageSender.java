package com.mrjoke.example.aopdemo.mq.producer;

/**
 * project：aop-demo
 * class：MessageSender
 * description：
 * <p>
 *
 * @author joker
 * @version 1.0
 * @since 2018/9/3 17:53
 */
public interface MessageSender<T> {
    void send(T obj);
}
