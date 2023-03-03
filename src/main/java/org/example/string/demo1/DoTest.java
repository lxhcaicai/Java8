package org.example.string.demo1;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void test4() {
        char[] chs = {'A', 'B', '我', '是', '谁'};
        String s = String.valueOf(chs);
        System.out.println("s = " + s);

        String s1 = String.valueOf(chs, 0, 2);
        System.out.println("s1 = " + s1);

        Object obj = "你好啊";
        String s2 = String.valueOf(obj);
        System.out.println("s2 = " + s2);
    }

    @Test
    public void test5() {
        int num = 123456;
        String s = num + "";
        System.out.println("s = " + s);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        String str = list + "";
        System.out.println(str);
    }

    @Test
    public void test6() {
        String s1 = "hello";
        String s2 = "world";
        String s3 = "helloworld";

        String s4 = (s1 + "world").intern(); // 将拼接的结果放在常量池中
        String s5 = (s1 +s2).intern();
        System.out.println(s3 == s4); // true
        System.out.println(s3 == s5); // true
    }

    @Test
    public void test7() {
        final String s1 = "hello";
        final String s2 = "world";

        String s3 = "helloworld";

        String s4 = s1 + "world"; // s1是常量，"world"也是常量，所以s4是常量

        String s5 = s1 + s2; // s1是常量，s2是常量，所以s5是常量

        String s6 = "hello" + "world"; // "hello"是常量，"world"是常量，所以s6是常量

        System.out.println(s3 == s4); // true
        System.out.println(s3 == s5); // true
        System.out.println(s3 == s6); // true
    }

    @Test
    public void test8() {
        String str = "0";
        for(int i = 0; i < 5; i ++) {
            str += i;
        }
        System.out.println("str = " + str);
    }

    @Test
    public void test9() {
        String s1 = "hello";
        String s2 = "world";
        String s3 = "helloworld";

        String s4 = "hello".concat("world");
        String s5 = "hello" + "world";

        System.out.println(s3 == s4); // false
        System.out.println(s3 == s5); // true
        System.out.println(s1 + s2 == s5); // false
    }

    @Test
    public void test10(){
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2);

        String s3 = new String("hello");
        String s4 = new String("hello");
        System.out.println(s3 == s4);
        System.out.println(s1 == s4);
    }

    @Test
    public void test11() {
        String s1 = "hello";
        String s2 = "hello";

        System.out.println(s1.equals(s2)); // true

        String s3 = new String("hello");
        String s4 = new String("hello");
        System.out.println(s3.equals(s4)); // true
        System.out.println(s1.equals(s4)); // true
    }

    @Test
    public void test12() {
        String s1 = new String("hello");
        String s2 = new String("HELLO");
        System.out.println(s1.equalsIgnoreCase(s2));
    }

    @Test
    public void test13() {
        String s1 = "i";
        String s2 = "love";

        System.out.println(s1.compareTo(s2));
    }

    @Test
    public void test14() {
        String s1 = new String("hello");
        String s2 = new String("HELLO");
        System.out.println(s1.compareToIgnoreCase(s2));;
    }

    @Test
    public void test15() {
        String s1 = "";
        String s2 = new String();
        String s3 = new String("");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

    @Test
    public void test16() {
        String str = "";

        if ("".equals(str)) {
            System.out.println("是空字符串");
        }
    }

    @Test
    public void test17() {
        String str = "";
        if(null != str && str.isEmpty()) {
            System.out.println("是空字符串");
        }
    }


}
