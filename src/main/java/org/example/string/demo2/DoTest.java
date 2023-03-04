package org.example.string.demo2;

import org.junit.Test;

public class DoTest {
    @Test
    public void test() {
        StringBuilder sb = new StringBuilder("helloworld");
        sb.setLength(30);
        System.out.println("sb = " + sb);
    }

    @Test
    public void test2() {
        StringBuilder sb = new StringBuilder("helloworld");
        sb.reverse();
        System.out.println("sb = " + sb);
    }


    @Test
    public void test3() {
        StringBuilder sb = new StringBuilder("helloworld");
        sb.delete(1, 3);
        sb.deleteCharAt(4);
        System.out.println("sb = " + sb);
    }

    @Test
    public void test4() {
        StringBuilder sb = new StringBuilder("helloworld");
        sb.insert(5,"java");
        sb.insert(5,"小明");
        System.out.println("sb = " + sb);
    }

    @Test
    public void test5() {
        StringBuilder s = new StringBuilder();
        s.append("hello").append(true).append('a').append(12).append("lxhcaicai");
        System.out.println(s);
        System.out.println(s.length());
    }
}
