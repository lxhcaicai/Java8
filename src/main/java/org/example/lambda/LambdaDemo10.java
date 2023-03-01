package org.example.lambda;

import java.util.function.Predicate;

public class LambdaDemo10 {
    public static void main(String[] args) {
        test((name) -> {
            return name.length() > 3;
        }, "lxhcaicai");
    }

    public static void test(Predicate<String> predicate, String name) {
        boolean test = predicate.test(name);
        if(test) {
            System.out.println(name + "的名称很长");
        } else {
            System.out.println(name + "的名称不长");
        }
    }
}
