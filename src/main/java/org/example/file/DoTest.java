package org.example.file;

import org.junit.Test;

import java.io.File;

public class DoTest {
    @Test
    public void test() {
        // 通过将给定的路径名称字符串转换为抽象路径名为创建新的File实例
        File file = new File("D:\\gitpace\\Java8\\src\\main\\java\\org\\example\\file\\DoTest.java");
        System.out.println("file = " + file);
    }
}
