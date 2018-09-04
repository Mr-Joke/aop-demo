package com.mrjoke.example.aopdemo.service.impl;

import com.mrjoke.example.aopdemo.annotations.SyncLog;
import com.mrjoke.example.aopdemo.dao.SyncRecordDao;
import com.mrjoke.example.aopdemo.pojo.model.SyncRecord;
import com.mrjoke.example.aopdemo.service.SyncRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * project：aop-demo
 * class：SyncRecordServiceImpl
 * description：
 * <p>
 *
 * @author joker
 * @version 1.0
 * @since 2018/9/3 16:11
 */
@Service
public class SyncRecordServiceImpl implements SyncRecordService {
    @Autowired
    private SyncRecordDao syncRecordDao;

    @SyncLog(log = false)
    @Override
    public void sync(SyncRecord syncRecord) {
        System.out.println("正在同步中……");
        /*if (true){
            throw new RuntimeException("同步异常啦……");
        }*/
    }
}
