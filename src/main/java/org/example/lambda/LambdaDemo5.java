package org.example.lambda;

public class LambdaDemo5 {
    public static void main(String[] args) {
        test((a1, a2) -> {
            System.out.println(a1 + a2);
        });
    }

    public static void test(Operation operation) {
        operation.getSum(1, 2);
    }
}

interface Operation {
    void getSum(int a, int b);
}
