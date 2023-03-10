package org.example.lambda;

import java.util.function.Predicate;

public class LambdaDemo11 {
    public static void main(String[] args) {
        //使用Lambda表达式判断一个字符串即包含W也包含H
        testAnd(s1 -> s1.contains("W"), s2 -> s2.contains("H"), "Hello World");
        testOr(s1 -> s1.contains("W"), s2 -> s2.contains("H"), "Hello World");
        testNegate(s1 -> s1.contains("W"),  "Hello World");
    }

    public static void testAnd(Predicate<String> p1, Predicate<String> p2, String str) {
        boolean test = p1.and(p2).test(str);
        if(test) {
            System.out.println(str + "既包含W也包含H");
        }
    }

    public static void testOr(Predicate<String> p1, Predicate<String> p2, String str) {
        boolean test = p1.or(p2).test(str);
        if(test) {
            System.out.println(str + "包含W或包含H");
        }
    }

    public static void testNegate(Predicate<String> p1, String str) {
        boolean test = p1.negate().test(str);
        if(test) {
            System.out.println(str + "不包含W");
        }
    }
}
