package org.example.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * 定义重复注解的容器
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTests {
    MyTest[] value();
}