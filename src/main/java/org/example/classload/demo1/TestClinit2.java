package org.example.classload.demo1;


/**
 * ● ① 使用某个类的静态常量（static final）。
 * ●  ② 通过子类调用父类的静态变量、静态方法，只会导致父类初始化，不会导致子类初始化，即只有声明静态成员的类才会初始化。
 * ●  ③ 用某个类型声明数组并创建数组对象时，不会导致这个类初始化
 */
public class TestClinit2 {
    public static void main(String[] args) {
        System.out.println(D.NUM);
        System.out.println(F.num);
        F.test();

        G[] arr = new G[5];
    }
}

class D{
    public static final int NUM = 10;
    static {
        System.out.println("D类的初始化");
    }
}

class E{
    static int num = 10;
    static {
        System.out.println("E父类的初始化");
    }
    public static void test() {
        System.out.println("父类的静态方法");
    }
}
class F extends E {
    static {
        System.out.println("F子类的初始化");
    }
}

class G{
    static {
        System.out.println("G类的初始化");
    }
}
