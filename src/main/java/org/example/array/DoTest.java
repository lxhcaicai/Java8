package org.example.array;

import org.junit.Test;

import java.util.Arrays;

public class DoTest {
    // 数组的反转
    @Test
    public void test() {
        // 原来的数组
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        // 新的数组
        int[] newArr = new int[arr.length];

        for(int i = 0; i < newArr.length; i ++) {
            newArr[i] = arr[arr.length - 1 - i];
        }

        arr = newArr;

        System.out.println(Arrays.toString(arr));
    }

    // 数组反转
    @Test
    public void test2() {
        int[] arr = {1, 2, 3, 4 ,5 ,6, 7, 8};
        for(int i = 0, j = arr.length - 1; i < j ; i ++, j --) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        // 打印输出
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 基本查找法
     */
    @Test
    public void test3() {
        int[] arr = {1, 2, 3, 4, 5};
        int result = basicSearch(arr, 6);
        System.out.println("result = " + result);
    }

    public static int basicSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == key) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 二分查找法
     */
    @Test
    public void test4() {
        int[] arr = {1, 5, 8, 12, 15};
        int result = binarySearch(arr, 12);
        System.out.println(result);
    }

    public static int binarySearch(int []arr, int key) {
        int min = 0;
        int max = arr.length - 1;
        while(min <= max) {
            int mid = (min + max) /2;
            if(key == arr[mid]) {
                return mid;
            }
            if(key > arr[mid]) {
                min = mid + 1;
            }
            if(key < arr[mid]) {
                max = mid - 1;
            }
        }
        return - 1;
    }


    /**
     * 冒泡排序
     */
    @Test
    public void test5() {
        int[] arr = {3, 5, 2, 1, 4};
        System.out.println("排序之前：" + Arrays.toString(arr));
        sort(arr);
        System.out.println("排序之后：" + Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        for(int i = 0; i < arr.length; i ++) {
            for(int j = 0; j < arr.length - 1 - i; j ++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    /**
     * 递归求和
     */
    @Test
    public void test6() {
        int sum = sum(100);
        System.out.println("sum = " + sum);
    }

    public int sum(int n) {
        if(n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    @Test
    public void test7() {
        int factorial = factorial(5);
        System.out.println("factorial = "+ factorial);
    }

    public  int factorial(int n) {
        if(n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }


    /**
     * 数组的扩容
     */
    @Test
    public void test8() {
        // 原数组
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        // 扩容的数组
        int[] newArr = new int[arr.length * 2];
        // 将数组的数据拷贝到新数组中
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        // 如果还需要使用arr，可以让arr指向新数组
        arr = newArr;
        // 添加新数据到arr的最后
        arr = newArr;
        arr[8] = 10;
        System.out.println(Arrays.toString(arr));
    }

    /**
     *  数组元素的插入, 数组元素未满
     */
    @Test
    public void test9() {
        // 原数组
        String[] str = new String[5];
        str[0] = "张三";
        str[1] = "李四";
        str[2] = "王五";
        // 现在想在index为1的位置上插入一个元素赵六
        // 将index为1的位置以及后面的元素依次移动1位
        System.arraycopy(str,1,str, 2, 2);
        str[1] = "赵六";
        // 打印输出
        System.out.println(Arrays.toString(str));
    }

    /**
     * 数组元素的插入, 数组元素已满
     */
    @Test
    public void test10() {
        // 原数组
        String[] str = new String[3];
        str[0] = "张三";
        str[1] = "李四";
        str[2] = "王五";
        // 现在想在index为1的位置上插入一个元素赵六
        String[] dest = new String[4];
        str = dest;
        // 将index为1的位置以及后面的元素依次移动1位
        System.arraycopy(str, 1, str, 2, 2);
        // 在index为1的位置插入元素
        str[1] = "赵六";
        // 打印输出
        System.out.println(Arrays.toString(str));
    }

    @Test
    public void test11() {
        String[] arr = {"张三", "李四", "王五"};
        // 希望删除index为1的元素，但是不希望index为1上为空
        System.arraycopy(arr, 2, arr ,1 ,1);
        // 最后一个元素置空
        arr[2] = null;
        System.out.println(Arrays.toString(arr));
    }
}
