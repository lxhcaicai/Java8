package org.example.lambda;


import org.example.lambda.impl.Smokeable;

/**
 * Lambda表达式的标准格式：
 * (参数列表)->{}
 * (参数列表)：参数列表
 * {}：方法体
 * ->：没有实际含义，起到连接的作用
 */
public class LambdaDemo4 {
    public static void main(String[] args) {
        goSmoking(new Smokeable() {
            @Override
            public int Smoking(String name) {
                System.out.println("匿名内部类:抽了" + name + "的烟");
                return 0;
            }
        });

        goSmoking((String name) -> {
            System.out.println("Lambda: 抽了" + name + "的烟");
            return 0;
        });
    }

    public static void goSmoking(Smokeable smokeable) {
        smokeable.Smoking("中华");
    }
}
