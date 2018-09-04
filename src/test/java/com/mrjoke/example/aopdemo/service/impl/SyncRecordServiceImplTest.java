package com.mrjoke.example.aopdemo.service.impl;

import com.mrjoke.example.aopdemo.annotations.SyncLog;
import com.mrjoke.example.aopdemo.pojo.model.SyncRecord;
import com.mrjoke.example.aopdemo.service.SyncRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Method;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * project：aop-demo
 * class：SyncRecordServiceImplTest
 * description：
 * <p>
 *
 * @author joker
 * @version 1.0
 * @since 2018/9/3 16:26
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SyncRecordServiceImplTest {
    @Autowired
    private SyncRecordService syncRecordService;
    @Autowired
    private TestServiceImpl testServiceImpl;

    @Test
    public void sync() {
        Date currentDate = new Date();
        SyncRecord syncRecord = new SyncRecord();
        syncRecord.setLog("测试同步日志");
        syncRecord.setType(1);
        syncRecord.setCreateTime(currentDate);
        syncRecord.setModifyTime(currentDate);
        syncRecord.setCreator("mq");
        syncRecord.setModifier("mq");
        syncRecordService.sync(syncRecord);
    }

    /**
     * 测试一下反射取注解
     */
    @Test
    public void reflect(){
        //直接通过syncRecordService.getClass()拿到的类是CGLIB的代理类，取不到注解
        Class<? extends SyncRecordService> clazz = syncRecordService.getClass();
//        Class<? extends SyncRecordService> clazz = SyncRecordServiceImpl.class;
        Method[] declaredMethods = clazz.getSuperclass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            SyncLog syncLog = method.getAnnotation(SyncLog.class);
            if (syncLog != null){
                System.out.println(syncLog.log());
                System.out.println("method : " + method.getName());
            }
        }
    }

    @Test
    public void test(){
        testServiceImpl.test();
    }
}