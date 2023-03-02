package org.example.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 定义重复注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyTests.class)
public @interface MyTest {
    String value();
}