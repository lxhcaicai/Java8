package org.example.option;

import org.junit.Test;

import java.util.Optional;

public class OptionalDemo {
    /**
     * 创建Optional实例
     * Optional.of(T value)：不能传null，否则报错
     */
    @Test
    public void testCreateOptional1() {
        Optional<String> optional = Optional.of("凤姐");
        System.out.println("optional.get() = " +  optional.get());
    }

    /**
     * 创建Optional实例
     * Optional.empty() 创建一个空的Optional
     */
    @Test
    public void testCreateOptional2() {
        Optional<Object> empty = Optional.empty();
        System.out.println("empty = " + empty);
    }

    /**
     * 创建Optional实例
     * Optional.ofNullable(T value)：如果value是null，则返回Optional.empty()；如果value有值，则返回Optional.of(T value)
     */
    @Test
    public void testCreateOptional3() {
        Optional<Object> optional = Optional.ofNullable(null);
        System.out.println("optional = " + optional);
        optional = Optional.ofNullable("你好啊！");
        System.out.println("optional = " + optional);
    }
}
