package org.example.file;

import org.junit.Test;

import java.io.File;
import java.net.URI;

public class DoTest {
    @Test
    public void test() {
        // 通过将给定的路径名称字符串转换为抽象路径名为创建新的File实例
        File file = new File("D:\\gitpace\\Java8\\src\\main\\java\\org\\example\\file\\DoTest.java");
        System.out.println("file = " + file);
    }

    // // 通过父路径名字符串和子路径名字符串创建新的File实例
    @Test
    public void test2() {
        File file = new File("D:\\gitpace\\Java8\\src\\main\\java\\org\\example\\file", "DoTest.java");
        System.out.println("file = " + file);
    }


    @Test
    public void test3() {
        File parent = new File("D:\\gitpace\\Java8\\src\\main\\java\\org\\example\\file");
        String child = "DoTest.java";
        File file = new File(parent, child);
        System.out.println("file = " + file);
    }

    @Test
    public void test4() {
        URI uri = URI.create("file:///D:/gitpace/Java8/src/main/java/org/example/file/DoTest.java");
        File file = new File(uri);
        System.out.println("file = " + file);
    }

}
