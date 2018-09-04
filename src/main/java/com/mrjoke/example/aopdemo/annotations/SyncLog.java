package com.mrjoke.example.aopdemo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * project：aop-demo
 * class：SyncLog
 * description：
 * <p>
 *
 * @author joker
 * @version 1.0
 * @since 2018/9/3 16:12
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SyncLog {
    boolean log() default true;
}
