package com.mrjoke.example.aopdemo.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * project：aop-demo
 * class：RabbitMqConfig
 * description：
 * <p>
 *
 * @author joker
 * @version 1.0
 * @since 2018/9/3 17:43
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("com.mrjoke.example.sync.exchange",true,false);
    }

    @Bean
    public Queue anonymousQueue(){
        return QueueBuilder.durable().build();
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(anonymousQueue()).to(directExchange()).with("com.mrjoke.example.sync.routing");
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
