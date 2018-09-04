package com.mrjoke.example.aopdemo.service.impl;

import com.mrjoke.example.aopdemo.annotations.SyncLog;
import org.springframework.stereotype.Service;

/**
 * project：aop-demo
 * class：TestServiceImpl
 * description：
 * <p>
 *
 * @author joker
 * @version 1.0
 * @since 2018/9/4 11:33
 */
@Service
public class TestServiceImpl {

    @SyncLog(log = false)
    public void test(){
        System.out.println("测试业务处理中……");
    }
}
