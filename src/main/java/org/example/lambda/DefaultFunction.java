package org.example.lambda;

public class DefaultFunction {
    public static void main(String[] args) {
        AA.show();
    }
}

interface AA {
    //● 直接使用接口名调用即可：接口名.静态方法名();
    //● 常用接口中的静态方法不能被继承，也不能被重写。

    static void show() {
        System.out.println("我是AA接口的静态方法");
    }
}

//默认方法的使用方式一：实现类可以直接使用
class BB implements AA {

}
