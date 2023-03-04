package org.example.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E>{

    /**
     * 底层存储的数据的容器
     */
    private Object[] all = new Object[5];

    /**
     * 记录实际存储元素的个数
     */
    private int total;

    /**
     * 插入元素
     * @param e
     * @return
     */
    public boolean add(E e) {
        // 判断是否要扩容
        if (total >= all.length) {
            all = Arrays.copyOf(all, all.length + (all.length >> 1));
        }
        all[total++] = e;
        return true;
    }

    /**
     * 插入指定位置的元素
     * @param index
     * @param e
     * @return
     */
    public boolean add(int index, E e) {
        // 校验index, 合理的范围是 [0, total]
        if(index < 0 || index > total) {
            throw new IndexOutOfBoundsException(index + "越界" + "，合理的范围是 [0," + total + "]");
        }

        if(total >= all.length) {
            all = Arrays.copyOf(all, all.length + (all.length >> 1));
        }
        System.arraycopy(all, index, all, index + 1, total - index);
        all[index] = e;
        total ++;
        return true;
    }

    public boolean remove(int index) {
        // 校验 index ,合理的范围是 [0,total-1]
        if (index < 0 || index >= total) {
            throw new IndexOutOfBoundsException(index + "越界" + "，合理的范围是 [0," + (total - 1) + "]");
        }
        System.arraycopy(all, index + 1, all, index, total - index - 1);
        all[total - 1] = null;
        total --;
        return true;
    }

    @Test
    public void test() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");

        for(String s: list) {
            System.out.println("s = " + s);
        }

        list.remove(1);
        for(String ss: list) {
            System.out.println(" ss = " + ss);
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new Intr<>();
    }

    private class Intr<E> implements Iterator<E>{

        private int cursor; // 默认指向第一个元素

        @Override
        public boolean hasNext() {
            return cursor < total;
        }

        @Override
        public E next() {
            return (E) all[cursor++];
        }
    }
}
