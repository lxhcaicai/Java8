package org.example.lambda;

import org.example.lambda.impl.Flyable;

public class LambdaCondition {
    public static void main(String[] args) {
        test(()->{
            System.out.println("飞");
        });

        //局部变量类型是接口，可以使用Lambda
        Flyable flyable = () -> {
            System.out.println("飞");
        };
    }

    /**
     * 方法参数类型可以使用 Lambda
     * @param flyable
     */
    public static void test(Flyable flyable) {
        flyable.fly();
    }
}
