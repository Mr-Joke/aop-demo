package com.mrjoke.example.aopdemo.service.impl;

import com.mrjoke.example.aopdemo.pojo.model.SyncRecord;
import com.mrjoke.example.aopdemo.service.SyncRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}