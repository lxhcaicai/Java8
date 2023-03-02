package org.example.stream;

import java.util.stream.Stream;

public class Stream4 {
    public static void main(String[] args) {
        // 目前使用的 Stream 流是串行的，就是在一个线程上执行
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        long count = stream.filter(s -> {
            System.out.println(Thread.currentThread().getName() + " ---- " + s);
            return true;
        }).count();

        System.out.println("count = " + count);
    }
}
