package org.example.math;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

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

    // 大整数加减乘除
    @Test
    public void test2() {
        BigInteger b1 = new BigInteger("124");
        BigInteger b2 = new BigInteger("123");

        System.out.println("加法：" + b1.add(b2)); // 加法：247
        System.out.println("减法：" + b1.subtract(b2)); // 减法：1
        System.out.println("乘法：" + b1.multiply(b2)); // 乘法：15252
        System.out.println("除法：" + b1.divide(b2)); // 除法：1
        System.out.println("余数：" + b1.remainder(b2)); // 余数：1
    }

    // BigDecimal
    @Test
    public void test3() {
        BigDecimal b1 = new BigDecimal("3.55");
        BigDecimal b2 = new BigDecimal("2.22");

        System.out.println("加法： " + b1.add(b2));
        System.out.println("减法： " + b1.subtract(b2));
        System.out.println("乘法： " + b1.multiply(b2));
        System.out.println("除法: " + b1.divide(b2, 2, RoundingMode.HALF_UP));
    }
}
