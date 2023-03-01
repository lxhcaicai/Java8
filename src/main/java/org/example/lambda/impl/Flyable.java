package org.example.lambda.impl;


/**
 * 只有一个抽象方法的接口称为函数函数式接口。
 * @FunctionalInterface 注解用来检测这个接口是不是只有一个抽象方法
 */
@FunctionalInterface
public interface Flyable {
    void fly();
}
