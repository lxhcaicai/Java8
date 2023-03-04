package org.example.string.demo1;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
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

    @Test
    public void  test18() {
        String str = "hello world";
        String s = str.toUpperCase();
        System.out.println("将字符串中的小写字母转换为大写字母 = " + s);

        String str2 = "Hello WorLD";
        String s1 = str2.toLowerCase();
        System.out.println("将字符串中的大写字母转换为小写字母 = " + s1);

        String str3 = "   hello world   ";
        String s3 = str3.trim();
        System.out.println("去掉字符串前后空白符 =" + s3);
    }

    @Test
    public void test19() {
        String str = "hello world";
        String str2 = "or";

        boolean contains = str.contains(str2);
        if (contains) {
            System.out.println(str + "中是否包含" + str2);
        }

        int index = str.indexOf(str2);
        System.out.println(str2 + "在" + str + "中从前往后查找的索引是：" + index);

        index = str.lastIndexOf(str2);
        System.out.println(str2 + "在" + str + "中从后往前的索引是：" + index);
    }

    @Test
    public void test20() {
        String str = "Java is a good computer language";
        System.out.println(str.substring(5));
        System.out.println(str.substring(5, 11));
    }

    @Test
    public void test21() {
        // 将首字母抓换为大写
        String str = "hello World";
        str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        System.out.println("str = " + str); // Hello World

        // 将字符串中的字符按照大小顺序排列
        String str2 = "helloworldjava";
        char[] chars = str2.toCharArray();
        Arrays.sort(chars);
        System.out.println("chars = " + Arrays.toString(chars));
    }

    @Test
    public void test22() {
        String str = "我爱中国";
        System.out.println(new String(str.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));
    }

    @Test
    public void test23() {
        String str = "我爱中国，我喜欢Java语言，但是我的英语不咋的";
        System.out.println(str.startsWith("我")); // true
        System.out.println(str.startsWith("我爱")); // true
        System.out.println(str.startsWith("我爱中国")); // true

        System.out.println(str.endsWith("不咋的")); // true
        System.out.println(str.endsWith("咋的")); // true
        System.out.println(str.endsWith("的")); // true
    }

    @Test
    public void test24() {
        String iphone = "13800138000";
        boolean matches = iphone.matches("^1[1-3]\\d{9}$");
        System.out.println("matches = " + matches);
    }

    @Test
    public void test25() {
        String str = "hello22world.java;234";
        // 将其中的非字母替换掉
        String s = str.replaceAll("[^a-zA-Z]","");
        System.out.println("s = " + s);
    }

    @Test
    public void test26() {
        String str = "张三.23|李四.24|王五.25";
        // 按照|拆分
        String regex = "\\|";
        String []split = str.split(regex);
        for(String s: split) {
            // 按照.进行拆分
            String []str2 = s.split("\\.");
            System.out.println(Arrays.toString(str2));
        }
    }

    /**
     * ● 在字符串中找出连续最长数字串，返回这个串的长度，并打印这个最长数字串。
     * ●  例如：abcd12345cd125se123456789，返回 9 ，打印出123456789。
     */
    @Test
    public void test27() {
        String str = "abcd12345cd125se123456789";
        String[] split = str.split("[a-zA-Z]+");
        String max = "";
        for(String s: split) {
            if(s.length() > max.length()) {
                max = s;
            }
        }
        System.out.println("最长的字符串是：" + max + ",它的长度是：" + max.length());
    }


    /**
     *  将字符串中指定部分进行反转。比如将 "abcdefgho" 反转为 "abfedcgho" 。
     */
    @Test
    public void test28() {
        String str = "abcdefgho";
        String reverse = reverse(str, 2, 5);
        System.out.println("reverse = " + reverse); // abfedcgho
    }

    public static String reverse(String str, int start, int end) {
        char[] chars = str.toCharArray();
        for(int i = start, j = end; i < j; i ++, j --) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }

    @Test
    public void test29() {
        String a = "dsabdnabdsnabeabiwpabekabd";
        String b = "ab";
        int times = times(a, b);
        System.out.println("times = " + times);
    }

    public int times(String str, String sub) {
        int count = 0;
        int index;
        while((index = str.indexOf(sub))!= -1) {
            count ++;
            str = str.substring(index + sub.length());
        }
        return count;
    }

}
