package org.example.lambda;

import java.util.function.Consumer;

public class LambdaDemo12 {

    public static void getSum(int []arr) {
        int sum = 0;
        for(int i : arr) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }

    public static void main(String[] args) {
        int []arrs = {10, 11, -19, 9};
        printSum(LambdaDemo12::getSum,arrs);

        Consumer<int[]> consumer = LambdaDemo12::getSum;
        consumer.accept(arrs);
    }

    public static void printSum(Consumer<int[]> consumer, int []arr) {
        consumer.accept(arr);
    }
}
