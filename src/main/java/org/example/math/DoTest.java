package org.example.math;

import org.junit.Test;

public class DoTest {
    @Test
    public void test() {
        double pi = Math.PI;
        System.out.println("pi = " + pi);
        double e = Math.E;
        System.out.println("e = " + e);
        int abs = Math.abs(-1);
        System.out.println("abs = " + abs);

        // 向上取整：大于或等于参数的最小整数
        double ceil = Math.ceil(5.5);
        System.out.println("ceil = " + ceil);
        ceil = Math.ceil(5);
        System.out.println("ceil = " + ceil);
        ceil = Math.ceil(-5.5);
        System.out.println("ceil = " + ceil);

        // 向下取整：小于或等于参数的最大整数
        double floor = Math.floor(5.5);
        System.out.println("floor = " + floor); // floor = 5.0
        floor = Math.floor(5);
        System.out.println("floor = " + floor); // floor = 5.0
        floor = Math.floor(-5.5);
        System.out.println("floor = " + floor); // floor = -6.0

        // 四舍五入
        long round = Math.round(5.1);
        System.out.println("round = " + round);
        round = Math.round(5.65);
        System.out.println("round = " + round);

        // 指数
        double pow = Math.pow(2,2);
        System.out.println("pow = " + pow);

        // 平方根
        double sqrt = Math.sqrt(4);
        System.out.println("sqrt = " + sqrt);

        // 最大值
        int max = Math.max(1, 2);
        System.out.println("max = " + max);

        // 最小值
        int min = Math.min(1, -2);
        System.out.println("min = " + min);

    }
}
