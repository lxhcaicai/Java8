package org.example.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DoTest {
    /**
     * Iterator 接口
     */
    @Test
    public void test() {
        Collection<String> collection = new ArrayList<>();
        collection.add("aa");
        collection.add("bb");
        collection.add("cc");
        collection.add("dd");

        // 获取迭代器
        Iterator<String> iterator = collection.iterator();

        // 判断集合中是否有元素
        while(iterator.hasNext()) {
            // 取出集合中的元素
            String next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    public void test2() {
        Collection<String> collection = new ArrayList<>();
        collection.add("aa");
        collection.add("bb");
        collection.add("cc");
        collection.add("dd");

        for(Iterator<String> iterator = collection.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            System.out.println(next);
        }
    }

    /**
     *  使用 Iterator 迭代器删除元素
     */
    @Test
    public void test3() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);

        System.out.println("原来集合中的元素 = " + collection);
        for(Iterator<Integer> iterator = collection.iterator(); iterator.hasNext();) {
            Integer ele = iterator.next();
            if(ele % 2 == 0) {
                iterator.remove();
            }
        }

        System.out.println("后来集合中的元素 = " + collection);
    }

    /**
     * 并发修改异常（ ConcurrentModificationException ）
     */
    @Test
    public void test4() {
        Collection<String> collection = new ArrayList<>();
        collection.add("aa");
        collection.add("bb");
        collection.add("cc");
        collection.add("dd");

        for(Iterator<String> iterator = collection.iterator(); iterator.hasNext();) {
            String ele = iterator.next();
            System.out.println("ele = " + ele);
            collection.add("ee");
        }
    }

    class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    @Test
    public void test5() {
        Collection<Person> collection = new ArrayList<>();

        collection.add(new Person("张三", 11));
        collection.add(new Person("李四", 59));
        collection.add(new Person("王五", 19));
        collection.add(new Person("赵六", 42));
        collection.add(new Person("田七", 8));
        collection.add(new Person("王八", 2));

        for(Iterator<Person> iterator = collection.iterator(); iterator.hasNext();) {
            Person next = iterator.next();
            System.out.println(next);
        }
    }

    /**
     * 增强 for 循环
     */
    @Test
    public void test6() {
        int[] arr = {1, 2, 3, 4, 5};
        // 遍历数组
        for(int i : arr) {
            System.out.println("i = " + i);
        }
    }


    /**
     * 遍历集合（不要在遍历集合的时候对集合中的元素进行增加、删除、替换等操作）
     */
    @Test
    public void test7() {
        Collection<Integer> collection = new ArrayList<>();
        // 向集合中添加元素
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);

        // 遍历集合
        for(Integer i: collection) {
            System.out.println("i = " + i);
        }
    }
}
