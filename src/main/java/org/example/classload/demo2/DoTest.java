package org.example.classload.demo2;

import org.junit.Test;

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
}
