package org.example.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class DoTest {

    /**
     * 增加元素
     */
    @Test
    public void test() {
        Collection<String> collection = new ArrayList<>();
        collection.add("hello");
        collection.add("world");
        System.out.println("collection = " + collection);
    }

    @Test
    public void test2() {
        Collection<String> c1 = new ArrayList<>();
        c1.add("aa");
        c1.add("bb");
        c1.add("cc");

        Collection<String> c2 = new ArrayList<>();
        c1.add("ee");
        c2.add("ff");
        c1.addAll(c2);

        System.out.println("c1 = " + c1);
    }

    @Test
    public void test3() {
        Collection<Object> c1 = new ArrayList<>();
        c1.add("aa");
        c1.add("bb");
        c1.add("cc");

        Collection<Object> c2 = new ArrayList<>();
        c2.add("ee");
        c2.add("ff");

        c1.add(c2);

        System.out.println("c1 = " + c1);
    }


    /**
     * 2 删除元素
     */
    @Test
    public void test4() {
        Collection<String> c1 = new ArrayList<>();
        c1.add("aa");
        c1.add("bb");
        c1.add("cc");

        System.out.println("c1 = " + c1);
        c1.remove("aa");

        System.out.println("c1 = " + c1);
    }

    @Test
    public void test5() {
        Collection<Object> c1 = new ArrayList<>();
        c1.add("aa");
        c1.add("bb");
        c1.add("cc");

        Collection<Object> c2 = new ArrayList<>();
        c2.add("ee");
        c2.add("ff");

        c1.add(c2);

        System.out.println("c1 = " + c1);
        c1.remove(c2);

        System.out.println("c1 = " + c1);
    }

    @Test
    public void test6() {
        Collection<String> c1 = new ArrayList<>();
        c1.add("aa");
        c1.add("bb");
        c1.add("cc");

        Collection<String> c2 = new ArrayList<>();
        c2.add("ee");
        c2.add("ff");

        c1.addAll(c2);

        System.out.println("c1 = " + c1);

        c1.removeAll(c2);

        System.out.println("c1 = " + c1);
    }


    @Test
    public void test7() {
        /**
         * 删除满足指定条件的此集合中的所有元素
         */
        Collection<Integer> col = new ArrayList<>();

        col.add(1);
        col.add(2);
        col.add(3);
        col.add(4);

        // 删除 > 2 的元素
        col.removeIf((i) -> i > 2);

        System.out.println("col = " + col); // col = [1, 2]
    }


    /**
     * 判断
     */
    @Test
    public void test8() {
        Collection<String> c1 = new ArrayList<>();
        c1.add("aa");
        c1.add("bb");
        c1.add("cc");
        c1.add("dd");

        System.out.println("c1 = " + c1.isEmpty()); // c1 = false

        c1.clear();

        System.out.println("c1 = " + c1.isEmpty());  // c1 = true
    }

    @Test
    public void test9() {
        Collection<String> c1 = new ArrayList<>();
        c1.add("aa");
        c1.add("bb");
        c1.add("cc");
        c1.add("dd");

        System.out.println("c1 = " + c1.contains("aa"));
        System.out.println("c1 = " + c1.contains("aaa"));
    }

    @Test
    public void test10() {
        Collection<String> c1 = new ArrayList<>();
        c1.add("aa");
        c1.add("bb");
        c1.add("cc");
        c1.add("dd");

        Collection<String> c2 = new ArrayList<>();
        c2.add("aa");
        c2.add("bb");
        c2.add("ee");

        System.out.println("c1.containsAll(c2) = " + c1.containsAll(c2));

        Collection<String> c3 = new ArrayList<>();
        c3.add("aa");
        c3.add("bb");

        System.out.println("c1.containsAll(c3) = " + c1.containsAll(c3));
    }


    /**
     * 获取集合中元素的个数
     */
    @Test
    public void test11() {
        Collection<String> c1 = new ArrayList<>();
        c1.add("aa");
        c1.add("bb");
        c1.add("cc");
        c1.add("dd");

        System.out.println("c1.size() = " + c1.size());

        c1.clear();

        System.out.println("c1.size() = " + c1.size());
    }

    /**
     *  交集
     */
    @Test
    public void test12() {
        Collection<String> c1 = new ArrayList<>();
        c1.add("aa");
        c1.add("bb");
        c1.add("cc");
        c1.add("dd");

        Collection<String> c2 = new ArrayList<>();
        c2.add("bb");

        c1.retainAll(c2);
        System.out.println("c1 = " + c1);
    }

    /**
     *  转数组
     */
    @Test
    public void test13() {
        Collection<String> c = new ArrayList<>();
        c.add("aa");
        c.add("bb");
        c.add("cc");
        c.add("dd");

        Object[] objects = c.toArray();
        System.out.println("objects = " + Arrays.toString(objects));

        String[] strings = c.toArray(new String[c.size()]);
        System.out.println("strings = " + Arrays.toString(strings));
    }

    @Test
    public void test14() {

    }

    @Test
    public void test15() {

    }
}
