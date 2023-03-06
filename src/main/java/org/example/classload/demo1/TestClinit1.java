package org.example.classload.demo1;

/**
 * ●  ① 运行主方法所在的类，要先完成类初始化，再执行 main 方法。
 * ●  ② 第一次使用某个类型，即 new 它的对象的时候，此时这个类还没有初始化的话，先完成类初始化再做实例初始化。
 * ●  ③ 调用某个类的静态成员（类变量和类方法），此时这个类没有初始化的话，先完成类初始化。
 * ●  ④ 子类初始化的时候，发现它的父类还没有初始化的话，那么先初始化父类。
 * ●  ⑤ 通过反射操作某个类的时候，如果这个类没有初始化，也会导致该类先初始化。
 */
class Father{
    static{
        System.out.println("main方法所在的类的父类(1)");//初始化子类时，会初始化父类
    }
}


public class TestClinit1 extends Father{
    static {
        System.out.println("main方法所在的类(2)"); // 主方法所在的类会初始化
    }

    public static void main(String[] args) throws ClassNotFoundException {
        new A(); //第一次使用A就是创建它的对象，会初始化A类
        B.test(); //直接使用B类的静态成员会初始化B类
        Class clazz = Class.forName("org.example.classload.demo1.C");
    }
}

class A{
    static {
        System.out.println("A类初始化");
    }
}

class B{
    static {
        System.out.println("B类初始化");
    }
    public static void test() {
        System.out.println("B类的静态方法");
    }
}

class C{
    static {
        System.out.println("C类初始化");
    }
}
