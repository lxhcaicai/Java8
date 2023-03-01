package org.example.lambda;

import java.util.function.Function;

public class LambdaDemo16 {
    /**
     * 方法引用 类名::方法名
     */
    public static void main(String[] args) {
        //使用Lambda表达式将字符串转换为Long类型
        Function<String,Long> function = (s) -> {
            return Long.parseLong(s);
        };

        Long apply = function.apply("5");
        System.out.println("apply = " + apply);
        //使用Lambda简化上面的代码
        function = Long::parseLong;
        apply = function.apply("5");
        System.out.println("apply = " + apply);

    }
}
