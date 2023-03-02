package org.example.annotation;

import java.util.Arrays;

public class RepeatableAnnotationDemo {
    public static void main(String[] args) {
        MyTest []myTests = Person.class.getAnnotationsByType(MyTest.class);
        Arrays.stream(myTests).map(MyTest::value).forEach(System.out::println);
    }
}
