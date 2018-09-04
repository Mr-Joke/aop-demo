package com.mrjoke.example.aopdemo.dao;

import com.mrjoke.example.aopdemo.pojo.model.SyncRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * project：aop-demo
 * class：SyncRecordDao
 * description：
 * <p>
 *
 * @author joker
 * @version 1.0
 * @since 2018/9/3 17:31
 */
@Repository
public interface SyncRecordDao extends CrudRepository<SyncRecord,Integer> {
}
