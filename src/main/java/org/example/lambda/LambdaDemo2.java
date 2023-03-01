package org.example.lambda;

public class LambdaDemo2 {
    public static void main(String[] args) {
        new Thread(() -> {
            //Lambda体现的是函数式编程思想，只需要将要执行的代码放到函数中（函数就是类中的方法）
            //Lambda就是一个匿名函数，我们只需要将要执行的代码放到Lambda表达式中即可
            //Lambda表达式的好处：可以简化匿名内部类，让代码更加精简。
            System.out.println("lambda 线程执行啦！");
        }).start();
    }
}
