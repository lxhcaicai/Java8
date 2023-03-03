package org.example.string.demo1;

import org.junit.Test;

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
}
