package org.example.generic;

import com.sun.org.apache.bcel.internal.generic.PUSH;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DoTest {
    @Test
    public void test() {
        List<String> list = new ArrayList<>(); // 此时 <E> 就是 <String>
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        System.out.println("list = " + list);
    }

    /**
     * 我们要声明一个学生类，该学生包含姓名、成绩，而此时学生的成绩类型不确定，
     * 为什么呢，因为，语文老师希望成绩是“优秀”、“良好”、“及格”、“不及格”，
     * 数学老师希望成绩是 89.5 , 65.0，英语老师希望成绩是 'A' , 'B' , 'C' , 'D' , 'E' 。
     * 那么我们在设计这个学生类时，就可以使用泛型。
     */
    class Student<T> {
        private String name;
        private T score;
        public Student() {

        }

        public Student(String name, T score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public T getScore() {
            return score;
        }

        public void setScore(T score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

    /**
     * ●  在使用泛型类和泛型接口的时候，我们需要指定泛型变量的实际类型参数：
     * ●  ① 实际类型参数必须是引用数据类型，不能是基本数据类型。
     * ●  ② 在创建类的对象时指定类型变量对应的实际类型参数
     */
    @Test
    public void  test2()  {
        // 语文老师
        Student<String> stu1 = new Student<>("张三", "良好");
        System.out.println("stu1 = " + stu1);

        // 数学老师
        Student<Double> stu2 = new Student<>("李四", 80.0);
        System.out.println("stu2 = " + stu2);

        // 英语老师
        Student<Character> stu3 = new Student<>("王五", 'A');
        System.out.println("stu3 = " + stu3);
    }

    // 类型变量的上限

    /**
     * 声明一个两个数求和的工具类，要求两个加数必须是 Number 数字类型，并且实现 Comparable 接口
     */

    class SumTools<T extends Number & Comparable<T>> {
        private T t1;
        private T t2;

        public SumTools(T t1, T t2) {
            this.t1 = t1;
            this.t2 = t2;
        }

        public T getSum() {
            if(this.t1 instanceof BigInteger) {
                return (T)((BigInteger) this.t1).add((BigInteger) this.t2);
            } else if(this.t1 instanceof BigDecimal) {
                return (T)((BigDecimal) this.t1).add((BigDecimal) this.t2);
            } else if(this.t1 instanceof Integer) {
                return (T)(Integer.valueOf((Integer)this.t1 + (Integer)this.t2));
            } else if(this.t1 instanceof Long) {
                return (T)(Long.valueOf((Long)this.t1 + (Long)this.t2));
            } else if (this.t1 instanceof Float) {
                return (T)(Float.valueOf((Float)this.t1 + (Float)this.t2));
            } else if (this.t1 instanceof Double) {
                return (T)(Double.valueOf((Double)this.t1 + (Double)this.t2));
            }
            throw new UnsupportedOperationException("不支持该操作");
        }
    }

    @Test
    public void test3() {
        SumTools<Integer> sumTools = new SumTools<>(1, 2);
        Integer sum = sumTools.getSum();
        System.out.println("sum = " + sum);
    }

    /**
     * 泛型方法
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    @Test
    public void test4() {
        Integer[] arr = {8, 9, 5, 6, 3,5,2,1};
        sort(arr);
        for(int i : arr) {
            System.out.println(i);
        }
    }


    /**
     * 声明一个方法，形参是 Collection，但是元素类型不确定，怎么办？
     */
    public static void m1(Collection<Object> col) {
        for(Object o: col) {
            System.out.println("o = " + o);
        }
    }

    @Test
    public void test5() {
        m1(new ArrayList<Object>()); // 相当于 Collection<Object> col = new ArrayList<Object>();
        m1(new ArrayList<>()); // 相当于 Collection<Object> col = new ArrayList<>();
        m1(new ArrayList());// 相当于 Collection<Object> col = new ArrayList(); 会产生警告，因为 new ArrayList() 没有使用泛型，会产生泛型擦除现象
        // m1(new ArrayList<String>()); // 错误，相当于 Collection<Object> col = new ArrayList<String>(); 语法就不对

    }

    /**
     * 示例：方法形参声明为 Collection
     */

    public static void m2(Collection coll) {
        for(Object o: coll) {
            System.out.println("o = " + o);
        }
    }

    @Test
    public void test6() {
        // 编译看左边，左边泛型擦除，此时泛型按照 Object 处理，右边泛型指定也没有用
        m2(new ArrayList<Object>()); // 相当于 Collection coll = new ArrayList<Object>();
        m2(new ArrayList<>()); // 相当于 Collection coll = new ArrayList<>(); 和上面的是等价的
        m2(new ArrayList()); // 相当于 Collection coll = new ArrayList(); 泛型擦除
        m2(new ArrayList<String>()); // 相当于 Collection coll = new ArrayList<String>();
    }

    /**
     * 方法形参声明为 Collection<T>
     */
    public static<T> void m3(Collection<T> coll) {
        for(T o: coll) {
            System.out.println("o = " + o);
        }
    }

    @Test
    public void test7() {
        m3(new ArrayList<Object>()); // 相当于 Collection<Object> coll = new ArrayList<Object>();
        m3(new ArrayList<>()); // 相当于 Collection<Object> coll = new ArrayList<>(); 和上面的等价
        m3(new ArrayList()); // 相当于 Collection<Object> coll = new ArrayList(); // 有警告
        m3(new ArrayList<String>()); // 相当于 Collection<String> coll = new ArrayList<String>();
    }

    /**
     * 类型通配符
     * 当我们声明一个局部变量或形参的时候，这个局部变量或形参的类型是一个泛型类或泛型接口，例如：Comparator<T>，
     * 但是我们依然无法确认这个泛型类或泛型接口的变量 <T> 的具体类型，此时我们就需要考虑使用类型通配符 <?>
     */

    public static <T> void m4(Collection<?> coll) {
        for(Object o: coll) {
            System.out.println("o = " + o);
        }
    }

    @Test
    public void test8() {
        m4(new ArrayList<Object>()); // 相当于 Collection<?> coll = new ArrayList<Object>();
        m4(new ArrayList<>()); // 相当于 Collection<?> coll = new ArrayList<>();
        m4(new ArrayList()); // 相当于 Collection<?> coll = new ArrayList();
        m4(new ArrayList<String>()); // 相当于 Collection<?> coll = new ArrayList<String>();
    }


    /**
     * <?> 任意类型的使用
     */
    public static void read(List<?> list) {
        for(Object o: list) {
            System.out.println(o);
        }
    }

    @Test
    public void test9() {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("bb");
        read(list);
    }

    /**
     *  <? extends 类型> 类型通配符上限
     */

    public static Student<? extends Comparable> max(Student<? extends Comparable>[] arr) {
        Student<? extends Comparable> max = arr[0];
        for(int i = 0; i < arr.length; i ++) {
            if(arr[i].getScore().compareTo(max.getScore()) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    @Test
    public void test10() {
        Student<? extends Double>[] arr = new Student[3];
        arr[0] = new Student<>("张三", 90.5);
        arr[1] = new Student<>("李四", 80.5);
        arr[2] = new Student<>("王五", 94.5);

        Student<? extends Comparable> max = max(arr);
        System.out.println(max);
    }

    /**
     * <? super类型> 类型通配符下限
     */
//
//    public static <T> void sort(T[] arr,Comparable<? super T> c) {
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = 0; j < arr.length - i; j++) {
//                if (c.compare(arr[j], arr[j + 1]) > 0) {
//                    T temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//    }


    class A {

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public class B extends A {

    }

    public class C extends A {

    }

    @Test
    public void test11() {
        List<A> listA = new ArrayList<>();
        List<B> listB = new ArrayList<>();

        //listA = listB; // 错误，不可以
    }

    @Test
    public void test12() {
        List<A> listA = new ArrayList<>();
        List<B> listB = new ArrayList<>();

       // listB = listA; // 错误，不可以
    }

    @Test
    public void test13() {
        List<A> listA = new ArrayList<>();
        List<B> listB = new ArrayList<>();

        // listA 添加元素，可以添加 A、B、C 类型的元素
        listA.add(new A());
        listA.add(new B());
        listA.add(new C());

        // listB 添加元素，只能添加 B 类型的元素
        listB.add(new B());
        listB.add(new B());
        listB.add(new B());

    }

    /**
     * ? 代表任意类型，就是告诉调用者可以传递包含任意类型元素的集合。
     * 或许，你会疑惑，为什么在方法内部只能是遍历元素，而不能添加元素？
     * 需要牢记一点，泛型是编译期行为，其实就是我声明了 list 集合中的元素都是 Object 类型及其子类型。
     * 假设可以添加元素，并且我添加的是 String 类型的元素，那么当用户调用方法传递是是 List 集合，但是集合中的元素是自定义类型，岂不是冲突了~
     *
     * @param list
     */
    public static void method(List<?> list) {
        for(Object o:list) {
            System.out.println("o = " + o.getClass());
        }
    }

    @Test
    public void test14() {
        List<A> list = new ArrayList<>();
        list.add(new A());
        list.add(new A());
        list.add(new A());
        list.add(new A());

        method(list);

        List<B> listB = new ArrayList<>();
        listB.add(new B());
        listB.add(new B());
        listB.add(new B());
        listB.add(new B());
        method(listB);
    }

    //当然，也可以使用类型通配符的上限来处理：
    public static void method2(List<? extends A> list) {
        for (A o : list) {
            System.out.println("o = " + o.getValue()); // 调用的是 A 类的方法
        }
    }

    @Test
    public void test15() {
        List<A> list = new ArrayList<>();
        list.add(new A());
        list.add(new A());
        list.add(new A());
        list.add(new A());

        method2(list);

        List<B> listB = new ArrayList<>();
        listB.add(new B());
        listB.add(new B());
        listB.add(new B());
        listB.add(new B());

        method2(listB);

        List<String> strList = new ArrayList<>();
        strList.add("1");
        strList.add("2");
        strList.add("3");

       // method2(strList); // 错误
    }

    /**
     * ? super A 代表下限，就是告诉调用者可以传递包含任意 A 或 A 类型父类及父接口的集合。
     *
     * @param list
     */
    public  void method3(List<? super A> list) {
        // 遍历，之所以按照 Object 来处理，是因为 A 类型没有显示继承某个类，默认按照 Object 来处理
        for (Object o : list) {
            System.out.println("o = " + o);
        }

        list.add(new B());
        list.add(new A());
        list.add(new C());
    }

    @Test
    public void test16() {
        List<A> list = new ArrayList<>();
        list.add(new A());
        list.add(new A());
        list.add(new A());
        list.add(new A());

        method3(list);

        List<B> listB = new ArrayList<>();
        listB.add(new B());
        listB.add(new B());
        listB.add(new B());
        listB.add(new B());

         //method3(listB); //错误
    }

    /**
     * 问题 一
     * 如果将 泛型类<T> 指定为 泛型<?>，那么该泛型类中所有参数都是 T 类型的方法或成员将无法使用。参数类型不是 T 类型的方法照常使用。
     */
    @Test
    public void test17() {

        Collection<?> coll = new ArrayList<>();

        // coll.add(1); // 错误
        // coll.add("abc"); // 错误

        // 之所以错误，是因为 ? 表示任意类型，添加任何元素到集合中都是有风险的，并且 add(E t) 方法使用了泛型 E，所以错误
    }

    @Test
    public void test18() {
        // 取出元素的时候，是可以的
        List<?> nums = Arrays.asList(1, 3, 4);

        for(Object num: nums) {
            System.out.println("num = " + num);
        }
    }

    /**
     * 如果把 "泛型类<T> 指定为 泛型类<? extends 上限>：那么该泛型类中所有参数是 T 类型的方法或成员都无法正常使用。
     * 参数类型不是 T 类型的方法照常使用。
     */

    @Test
    public void test19() {
        List<? extends Number> list = new ArrayList<>();
        // list.add(1); //错误
        // list.add(1.0); //错误

        // 因为 ? 表示未知的类型，<? extends Number> 代表 Number 类型的一种，
        // 而 Number 类型有很多实现类，如：Integer、BigInteger，你如果添加成功了，那么怎么取出啊？

    }

    /**
     * 如果把 泛型类<T>指定为 泛型类<? super 下限>：那么该泛型类中所有参数是 T 类型的方法或成员都可以使用，但是有要求。
     * 参数类型不是 T 类型的方法照常使用。
     */
    @Test
    public void test20() {
        Collection<? super Number> coll = new ArrayList<>();
        coll.add(1);
        coll.add(1.0);
        // coll.add("hello"); //错误
    }
}
