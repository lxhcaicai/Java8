package org.example.lambda;

import java.util.Date;
import java.util.function.Supplier;

public class LambdaDemo14 {
    /**
     * 方法引用： 实例名::方法名
     */
    public static void main(String[] args) {
        Date date = new Date();
        //使用Lambda表达式获取当前秒数
        Supplier<Long> supplier = ()  -> {
            return date.getTime();
        };

        System.out.println(supplier.get());
        //使用方法引用简化上述代码
        supplier = date::getTime;
        System.out.println(supplier.get());
    }
}
