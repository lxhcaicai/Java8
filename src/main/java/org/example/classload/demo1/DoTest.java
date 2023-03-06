package org.example.classload.demo1;

import org.junit.Test;

import java.lang.annotation.ElementType;

public class DoTest {
    @Test
    public void test() {
        // 基本数据类型和 void
        Class<Integer> integerClass = int.class;
        System.out.println("integerClass = " + integerClass);
        Class<Void>  voidClass = void.class;
        System.out.println("voidClass = " + voidClass);

        // 类和接口
        Class<String> stringClass = String.class;
        System.out.println("stringClass = " + stringClass);
        Class<Comparable> comparableClass = Comparable.class;
        System.out.println("comparableClass = " + comparableClass);

        // 枚举
        Class<ElementType> elementTypeClass = ElementType.class;
        System.out.println("elementTypeClass = " + elementTypeClass);

        // 注解
        Class<Override> overrideClass = Override.class;
        System.out.println("overrideClass = " + overrideClass);

        // 数组
        Class<int[]> aClass = int[].class;
        System.out.println("aClass = " + aClass);
    }
}
