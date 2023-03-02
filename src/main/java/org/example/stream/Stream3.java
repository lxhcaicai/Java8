package org.example.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream3 {
    // ● Collectors 的 joining 方法会根据指定的连接符，将所有元素连接成一个字符串。
    public static void main(String[] args) {
        Stream<Person> stream = Stream.of(
                new Person("赵丽颖", 52, 95),
                new Person("杨颖", 56, 86),
                new Person("迪丽热巴", 56, 99),
                new Person("黄晓明", 52, 77));

        String str = stream.map(Person::getName).collect(Collectors.joining("><", "(#^.^#)", "^_^"));

        System.out.println("str = " + str);

    }
}
