package org.example.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Stream5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Stream<String> parallelStream = list.parallelStream();
        //串行流转成并行流
        Stream<String> parallel = list.stream().parallel();
    }
}
