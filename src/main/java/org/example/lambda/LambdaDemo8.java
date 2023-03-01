package org.example.lambda;

import java.util.function.Consumer;

public class LambdaDemo8 {
    public static void main(String[] args) {
        // 使用Lambda表达式先将一个字符串转成小写，再转成大写
        test((s)-> {
            System.out.println(s.toLowerCase());
        }, (s) ->{
            System.out.println(s.toUpperCase());
        });

    }

    public static void test(Consumer<String> c1, Consumer<String> c2) {
        c1.andThen(c2).accept("hello world!");
    }

}
