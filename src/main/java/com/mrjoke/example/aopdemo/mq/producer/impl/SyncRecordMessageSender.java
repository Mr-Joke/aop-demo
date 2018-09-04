package com.mrjoke.example.aopdemo.mq.producer.impl;

import com.mrjoke.example.aopdemo.mq.producer.MessageSender;
import com.mrjoke.example.aopdemo.pojo.model.SyncRecord;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * project：aop-demo
 * class：SyncRecordMessageSender
 * description：
 * <p>
 *
 * @author joker
 * @version 1.0
 * @since 2018/9/3 17:54
 */
@Component
public class SyncRecordMessageSender implements MessageSender<SyncRecord>, RabbitTemplate.ReturnCallback, RabbitTemplate.ConfirmCallback {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private DirectExchange directExchange;

    @Override
    public void send(SyncRecord syncRecord) {
        System.out.println("发送mq消息：" + syncRecord.toString());
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
        rabbitTemplate.convertAndSend(directExchange.getName(),"com.mrjoke.example.sync.routing",syncRecord);
//        rabbitTemplate.convertAndSend("fuck","com.mrjoke.example.sync.routing",syncRecord);
//        rabbitTemplate.convertAndSend(directExchange.getName(),"com.mrjoke.example.sync.routingw",syncRecord);
    }

    /**
     * 发送确认，成功发送到交换机时ack=true（无论是否路由到队列），否则ack=false。
     *
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("CorrelationData : " + correlationData);
        System.out.println("ack : " + ack);
        System.out.println("cause : " + cause);
    }

    /**
     * 发送返回：在消息成功发送到exchange后，若无法路由得到队列，则会返回。
     *
     * @param message
     * @param replyCode
     * @param replyText
     * @param exchange
     * @param routingKey
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("message : " + message);
        System.out.println("replyCode : " + replyCode);
        System.out.println("replyText : " + replyText);
        System.out.println("exchange : " + exchange);
        System.out.println("routingKey : " + routingKey);
    }
}
