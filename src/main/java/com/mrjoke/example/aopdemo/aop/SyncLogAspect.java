package com.mrjoke.example.aopdemo.aop;

import com.mrjoke.example.aopdemo.annotations.SyncLog;
import com.mrjoke.example.aopdemo.mq.producer.MessageSender;
import com.mrjoke.example.aopdemo.pojo.model.SyncRecord;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * project：aop-demo
 * class：SyncLogAspect
 * description：
 * <p>
 *
 * @author joker
 * @version 1.0
 * @since 2018/9/3 16:15
 */
@Aspect
@Component
public class SyncLogAspect {
    @Autowired
    private MessageSender messageSender;
    @Before(value = "execution(* com.mrjoke.example.aopdemo.service.impl..*.*(..)) && @annotation(syncLog)")
    public void before(SyncLog syncLog){
        System.out.println("方法执行前切入……是否同步：" + syncLog.log());
    }

    @After(value = "execution(* com.mrjoke.example.aopdemo.service.impl..*.*(..)) && @annotation(com.mrjoke.example.aopdemo.annotations.SyncLog)")
    public void after(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0){
            if (args[0] instanceof SyncRecord){
                SyncRecord syncRecord = (SyncRecord) args[0];
                System.out.println("方法执行后切入,发送mq消息……");
                messageSender.send(syncRecord);
            }
        }
    }

  /*  @AfterReturning(value = "execution(* com.mrjoke.example.aopdemo.service.impl..*.*(..)) && @annotation(com.mrjoke.example.aopdemo.annotations.SyncLog)")
    public void afterReturning(){
        System.out.println("方法执行返回后切入……" + Thread.currentThread().getName());
    }

    @AfterThrowing(value = "execution(* com.mrjoke.example.aopdemo.service.impl..*.*(..)) && @annotation(com.mrjoke.example.aopdemo.annotations.SyncLog)")
    public void afterThrowing(){
        System.out.println("方法执行异常后切入……" + Thread.currentThread().getName());
    }*/
}
