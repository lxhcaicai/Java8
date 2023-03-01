package org.example.lambda;

import java.util.function.Function;

// 数据类型[]::new
public class LambdaDemo18 {
    public static void main(String[] args) {
        Function<Integer,String[]> function = (length) -> {
            return new String[length];
        };
        //使用Lambda表达式创建指定长度的String数组
        String[] str = function.apply(2);
        System.out.println("str.length = " + str.length);
        //使用方法引用简化上面的代码
        function = String[]::new;
        str = function.apply(5);
        System.out.println("str.length = " + str.length);
    }
}
