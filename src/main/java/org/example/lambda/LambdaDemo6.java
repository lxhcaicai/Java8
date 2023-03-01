package org.example.lambda;

import java.util.Arrays;
import java.util.function.Supplier;

public class LambdaDemo6 {
    public static void main(String[] args) {
        printMax(() -> {
            int []arr = {22, 11, -2, 5};
            Arrays.sort(arr);
            return arr[arr.length - 1];
        });
    }


    //java.util.function.Supplier<T>接口，它意味着“供给”，对应的 Lambda 表达式需要对外提供一个符合泛型类型的对象数据。
    public static void printMax(Supplier<Integer> supplier) {
        Integer max = supplier.get();
        System.out.println("max = " + max);
    }
}
