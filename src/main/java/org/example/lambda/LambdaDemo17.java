package org.example.lambda;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class LambdaDemo17 {
    public static void main(String[] args) {
        Supplier<Person> supplier = () -> {
            return new Person();
        };

        Person person = supplier.get();
        System.out.println("person = " + person);

        supplier = Person::new;
        person = supplier.get();
        System.out.println("Person = " + person);

        BiFunction<String, Integer, Person> function = (name, age) -> {
            return new Person(name, age);
        };

        person = function.apply("李四", 20);
        System.out.println("Person = " + person);

        function = Person::new;
        person = function.apply("张三", 25);
        System.out.println("Person = " + person);
    }
}

class Person {
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
