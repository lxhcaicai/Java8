package org.example.classload.demo2;

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
}
