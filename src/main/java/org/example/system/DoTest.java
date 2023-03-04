package org.example.system;

import org.junit.Test;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Properties;

public class DoTest {
    @Test
    public void test() {
        long current = System.currentTimeMillis();
        System.out.println("current = " + current);

        int[] arr = {1,2,3,4,5,6};
        int[] target = new int[arr.length];
        System.arraycopy(arr, 0, target, 0, 2);
        System.out.println(Arrays.toString(target));

        // 获取所有系统属性
        Properties properties = System.getProperties();
        Enumeration<?> enumeration = properties.propertyNames();
        while(enumeration.hasMoreElements()) {
            Object o = enumeration.nextElement();
            System.out.println("o = " + o);
        }

        // 获取指定的系统属性
        String os = System.getProperty("os.name");
        System.out.println("os = " + os);
    }

    @Test
    public void test3() {
        Runtime runtime = Runtime.getRuntime();
        Runtime runtime1 = Runtime.getRuntime();
        System.out.println(runtime == runtime1);

        long totalMemory = runtime.totalMemory();
        System.out.println("totalMemory = " + totalMemory);
        long freeMemory = runtime.freeMemory();
        System.out.println("freeMemory = " + freeMemory);
    }
}
