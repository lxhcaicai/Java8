package org.example.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream2 {
    // Collectors 的 partitioningBy 方法会根据值是否为 true，把流中的数据分为两个部分，一个是 true 的部分，一个是 false 的部分。
    public static void main(String[] args) {
        Stream<Person> stream = Stream.of(
                new Person("赵丽颖", 52, 95, "女"),
                new Person("杨颖", 56, 86, "女"),
                new Person("迪丽热巴", 56, 99, "女"),
                new Person("黄晓明", 52, 77, "男")
        );
        Map<Boolean, List<Person>> map = stream.collect(Collectors.partitioningBy(p -> p.getScore() > 90));
        map.forEach((k, v) -> {
            System.out.println("k = " + k);
            System.out.println("v = " + v);
        });
    }
}
