package org.example.lambda;

public class LambdaDemo1 {

    public static void main(String[] args) {
        new Thread(new Runnable() {

            //使用匿名内部类存在的问题

            //匿名内部类做了哪些事情
            //①定义了一个没有名字的类
            //②这个类实现了Runnable接口
            //③创建了这个类的对象

            //其实我们最关注的是run方法和里面要执行的代码。
            //所以使用匿名内部类语法是很冗余的。

            @Override
            public void run() {
                System.out.println("线程执行啦!");
            }
        }).start();
    }
}
