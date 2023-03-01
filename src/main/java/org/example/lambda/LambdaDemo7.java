package org.example.lambda;

import java.util.function.Consumer;

public class LambdaDemo7 {
    // 使用 Lambda 表达式将一个字符串转成大写和小写字符串。
    public static void main(String[] args) {
        test((s) -> {
            String lowerCase = s.toLowerCase();
            System.out.println(lowerCase);

            String upperCase = s.toUpperCase();
            System.out.println(upperCase);
        });
    }

    public static void test(Consumer<String> consumer) {
        consumer.accept("hello world!");
    }
}
