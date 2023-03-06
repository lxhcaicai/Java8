package org.example.classload.demo2;

import org.junit.Test;

import java.lang.reflect.Modifier;

public class DoTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Person.class;
        System.out.println("clazz = " + clazz);

        Person person = new Person();
        Class<?> aClass = person.getClass();
        System.out.println("aClass = " + aClass);

        Class<?> aClass1 = Class.forName("org.example.classload.demo2.Person");
        System.out.println("aClass1 = "+ aClass1);

        Class<?> aClass2 = ClassLoader.getSystemClassLoader().loadClass("org.example.classload.demo2.Person");
        System.out.println("aClass = " + aClass2);
    }

    @Test
    public void test() {
        Class<?> clazz = Person.class;

        // 获取包信息
        Package aPackage = clazz.getPackage();
        String name = aPackage.getName();
        System.out.println("name = " + name);
    }

    // 获取修饰符（修饰符定义在 Modifier 类中，该类里面有很多常量值，每一个常量对应一种修饰符）
    @Test
    public void test1() {
        Class<?> clazz = Person.class;

        int modifiers = clazz.getModifiers();
        String s = Modifier.toString(modifiers);
        System.out.println("s = " + s);
    }

    //获取类名
    @Test
    public void test2() {
        Class<?> clazz = Person.class;

        //获取类命
        String name = clazz.getName();
        System.out.println("name = " + name);
        String simpleName = clazz.getSimpleName();
        System.out.println("simpleName = " + simpleName);
    }
}
