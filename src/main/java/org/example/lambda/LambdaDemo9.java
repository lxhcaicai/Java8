package org.example.lambda;

import java.util.function.Function;

public class LambdaDemo9 {
    public static void main(String[] args) {
        //使用Lambda表达式将字符串转成数字
        getNumber((s) -> {
            int num = Integer.parseInt(s);
            return num;
        });
    }

    public static void getNumber(Function<String,Integer> function) {
        Integer num = function.apply("10");
        System.out.println("num = " + num);
    }
}
