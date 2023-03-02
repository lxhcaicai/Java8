package org.example.option;

import org.example.stream.Person;
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

    /**
     * 判断Optional类中是否有值
     */
    @Test
    public void test() {
        Optional<Object> empty = Optional.empty();
        if(empty.isPresent()) {
            System.out.println("Optional类中有值");
        } else {
            System.out.println("Optional类中没有值");
        }
    }

    /**
     * 获取Optional类中的值
     */
    @Test
    public void test2() {
        Optional<String> optional = Optional.ofNullable("你好，世界");
        if(optional.isPresent()) {
            //get()方法，可以用来获取Optional类中的值，如果有值就返回具体值，否则就报错。
            //一般get()方法配置isPresent()方法使用
            String str = optional.get();
            System.out.println("str = " + str);
        }
    }

    /**
     * 获取Optional类中的值
     */
    @Test
    public void test3() {
        Optional<Object> optional = Optional.empty();
        //orElse：如果Optional中有值，就返回Optional中的值。否则返回orElse方法中参数指定的值
        Object obj = optional.orElse("如花");
        System.out.println("obj = " +  obj);
    }


    @Test
    public void test4() {
        Person person = null;
        person = new Person("hello world!", 18, 99);

        String name = getTraditionUpperName(person);
        System.out.println("name = " + name);

        name = getOptionalUpperName(person);
        System.out.println("name = " + name);

    }

    public String getOptionalUpperName(Person person) {
        return Optional.ofNullable(person).map(Person::getName).map(String::toUpperCase).orElse(null);
    }

    /**
     * 传统方式 实现需求
     *
     * @param person
     * @return
     */
    public String getTraditionUpperName(Person person) {
        if(null != person) {
            String name = person.getName();
            if(null != name) {
                return name.toUpperCase();
            }
        }
        return null;
    }

}
