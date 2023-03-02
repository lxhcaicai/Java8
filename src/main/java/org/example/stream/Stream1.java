package org.example.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream1 {
    public static void main(String[] args) {
        Stream<Person> stream = Stream.of(
                new Person("赵丽颖", 52, 95, "女"),
                new Person("杨颖", 56, 86, "女"),
                new Person("迪丽热巴", 56, 99, "女"),
                new Person("黄晓明", 52, 77, "男")
        );
        Map<String, Map<Integer, List<Person>>> map = stream.collect(Collectors.groupingBy(Person::getSex,
                Collectors.groupingBy(Person::getAge)));

        map.forEach((sex, v1) -> {
            System.out.println("sex = " + sex);
            Map<Integer, List<Person>> map1 = v1;
            map1.forEach((age, v2) -> {
                System.out.println(age + "----->");
                System.out.println("personList = " + v2);
            });
        });
    }
}
