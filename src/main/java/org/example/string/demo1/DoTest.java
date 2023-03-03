package org.example.string.demo1;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class DoTest {

    @Test
    public void test() {
        String s1 = "123";
        String s2 = "123";

        s1 = "hello";

        System.out.println("s1 = " + s1); // s1 = hello
        System.out.println("s2 = " + s2); // s2 = 123
    }

    @Test
    public void test2() {
        String str = "abc";
        String str2 = new String("abc");
        System.out.println(str == str2);
    }

    /**
     *  构造 String 对象
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        // 字符串常量对象
        String str = "hello";
        System.out.println("str = " + str);

        // 无参构造
        String str1 = "";
        System.out.println("str1 = " + str1);

        // 创建"hello"字符串常量的副本
        String str2 = new String("Hello");
        System.out.println("str2 = " + str2);

        // 通过字符数组创建
        char[] chs = {'a', 'b', 'c', 'd'};
        String str3 = new String(chs);
        String str4 = new String(chs, 0, 3);
        System.out.println("str3 = " + str3);
        System.out.println("str4 = " + str4);

        // 通过字节数组构造
        byte[] bytes = {97, 98, 99};
        String str5 = new String(bytes);
        String str6 = new String(bytes, "utf-8");
        System.out.println("str5 = " + str5);
        System.out.println("str6 = " + str6);
    }
}
