package com.mrjoke.example.aopdemo.mq.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;

import java.io.IOException;

/**
 * project：aop-demo
 * class：MessageReceiver
 * description：
 * <p>
 *
 * @author joker
 * @version 1.0
 * @since 2018/9/3 18:00
 */
public interface MessageReceiver {
    void receive(Message message, Channel channel) throws IOException;
}
