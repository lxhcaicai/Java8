package org.example.lambda;

import org.example.lambda.impl.Swimmable;

/**
 * Lambda表达式的标准格式：
 * (参数列表)->{}
 * (参数列表)：参数列表
 * {}：方法体
 * ->：没有实际含义，起到连接的作用
 */
public class LambdaDemo3 {

    public static void main(String[] args) {
        goSwimming(new Swimmable() {
            @Override
            public void swimming() {
                System.out.println("我是匿名内部类的游泳");
            }
        });

        goSwimming(() -> {
            System.out.println("我是lambda的游泳");
        });
    }

    /**
     * 无参数无返回值的Lambda
     *
     * @param swimmable
     */
    public static void goSwimming(Swimmable swimmable) {
        swimmable.swimming();
    }
}
