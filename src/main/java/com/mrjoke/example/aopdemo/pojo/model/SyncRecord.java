package com.mrjoke.example.aopdemo.pojo.model;

import javax.persistence.*;
import java.util.Date;

/**
 * project：aop-demo
 * class：SyncRecord
 * description：
 * <p>
 *
 * @author joker
 * @version 1.0
 * @since 2018/9/3 17:23
 */
@Entity
@Table(name = "tb_sync_record")
public class SyncRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer type;
    private String log;
    private Date createTime;
    private Date modifyTime;
    private String creator;
    private String modifier;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    @Override
    public String toString() {
        return "SyncRecord{" +
                "id=" + id +
                ", type=" + type +
                ", log='" + log + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", creator='" + creator + '\'' +
                ", modifier='" + modifier + '\'' +
                '}';
    }
}
