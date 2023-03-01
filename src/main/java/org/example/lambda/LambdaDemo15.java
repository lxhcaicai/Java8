package org.example.lambda;

import java.util.function.Supplier;

public class LambdaDemo15 {
    /**
     * 方法引用：   类名::静态方法名
     */
    public static void main(String[] args) {
        //使用Lambda表达式获取当前的毫秒值
        Supplier<Long> supplier = () -> {
            return System.currentTimeMillis();
        };
        System.out.println("supplier = " + supplier.get());

        supplier = System::currentTimeMillis;
        System.out.println("supplier = " + supplier.get());
    }
}
