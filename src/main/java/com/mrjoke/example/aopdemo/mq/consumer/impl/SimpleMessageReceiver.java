package com.mrjoke.example.aopdemo.mq.consumer.impl;

import com.mrjoke.example.aopdemo.dao.SyncRecordDao;
import com.mrjoke.example.aopdemo.mq.consumer.MessageReceiver;
import com.mrjoke.example.aopdemo.pojo.model.SyncRecord;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * project：aop-demo
 * class：SimpleMessageReceiver
 * description：
 * <p>
 *
 * @author joker
 * @version 1.0
 * @since 2018/9/3 18:01
 */
@Component
public class SimpleMessageReceiver implements MessageReceiver {
    @Autowired
    private Jackson2JsonMessageConverter jackson2JsonMessageConverter;
    @Autowired
    private SyncRecordDao syncRecordDao;

    @RabbitListener(queues = {"#{anonymousQueue.name}"})
    @Override
    public void receive(Message message, Channel channel) throws IOException {
        System.out.println("接收到mq消息……");
        Object obj = jackson2JsonMessageConverter.fromMessage(message);
        if (obj instanceof SyncRecord){
            try {
                System.out.println("消息类型为同步记录消息：" + obj);
                syncRecordDao.save((SyncRecord)obj);
                channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            } catch (Exception e) {
                e.printStackTrace();
                channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
            }
        }else {
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);//消息处理不了，重排队列
        }
    }
}
