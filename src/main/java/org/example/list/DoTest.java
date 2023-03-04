package org.example.list;

import com.sun.org.apache.bcel.internal.generic.PUSH;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class DoTest {
    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        // 向集合的尾部添加
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("list = " + list);

        list.add(1, 10);
        System.out.println("list = " +list);
    }

    @Test
    public void test2() {
        List<String> list = new ArrayList<>();

        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");

        System.out.println("list = " + list);

        List<String> list2 = new ArrayList<>();
        list2.add("ee");
        list2.add("ff");

        list.addAll(1, list2);
        System.out.println("list = " + list);
    }

    /**
     * 获取元素
     */
    @Test
    public void test3() {
        List<String> list = new ArrayList<>();

        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");

        String s = list.get(1);
        System.out.println("s = " + s);
    }

    @Test
    public void test4() {
        List<String> list = new ArrayList<>();

        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");

        System.out.println("list = " + list);
        List<String> list1 = list.subList(1, 3);
        System.out.println("list1 = " + list1);
    }

    @Test
    public void test5() {
        List<String> list = new ArrayList<>();

        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");

        for(int i = 0; i < list.size(); i ++) {
            System.out.println(list.get(i));
        }
    }

    /**
     *  获取元素索引
     */
    @Test
    public void test6() {
        List<String> list = new ArrayList<>();

        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        list.add("aa");

        int index = list.indexOf("aa");
        System.out.println("index = " + index);

        int index1 = list.indexOf("ee");
        System.out.println("index1 = " + index1);
    }

    @Test
    public void test7() {
        List<String> list = new ArrayList<>();

        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        list.add("aa");

        int index = list.lastIndexOf("aa");
        System.out.println("index = " + index);

        int index1 = list.lastIndexOf("ff");
        System.out.println("index1 = " + index1);
    }

    @Test
    public void test8() {
        List<String> list = new ArrayList<>();

        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        list.add("aa");

        System.out.println("list = " + list);
        String remove = list.remove(2);

        System.out.println("remove = " + remove);

        System.out.println("list = " + list);
    }

    /**
     * 替换元素
     */

    @Test
    public void test9() {
        List<String> list = new ArrayList<>();

        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        list.add("aa");

        System.out.println("list =" +list);
        list.set(4, "java");

        System.out.println("list = " + list);
    }


    /**
     *  List 特有的迭代器 ListIterator（了解）
     */
    @Test
    public void test10() {
        List<String> list = new ArrayList<>();

        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        list.add("aa");

        for(ListIterator<String> iterator = list.listIterator(list.size()); iterator.hasPrevious();) {
            String previous = iterator.previous();
            System.out.println(previous);
        }
    }

    @Test
    public void test11() {
        LinkedList<String> linkedList = new LinkedList<>();


        linkedList.add("aa");
        linkedList.add("bb");
        linkedList.add("cc");
        linkedList.add("dd");

        System.out.println("linkedList = " + linkedList);
        linkedList.addFirst("你好啊");
        linkedList.add("你好呢");
        System.out.println("linkedList = " + linkedList);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        linkedList.removeFirst();

        System.out.println("linkedList = " + linkedList);

        linkedList.removeLast();

        System.out.println("linkedList = " + linkedList);
    }



}
