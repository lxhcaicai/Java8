package org.example.map;

import org.junit.Test;

import java.util.*;

public class DoTest {
    @Test
    public void test() {
        Map<String, Integer> map = new HashMap<>();

        map.put("张三", 18);
        map.put("李四", 28);
        map.put("王五", 45);

        Map<String,Integer> map2 = new HashMap<>();
        map2.put("赵六", 9);
        map2.put("田七", 30);

        System.out.println("map2 = " + map2); // map2 = {赵六=9, 田七=30}
        map.putAll(map2);

        System.out.println("map = " + map);

        Integer age = map.get("张三");
        System.out.println("age = " + age); // age = 18

        age = map.get("王八");
        System.out.println("age = " + age); // age = null


        System.out.println("map.isEmpty() = " + map.isEmpty());

        int size = map.size();
        System.out.println("size = " + size);

        System.out.println("map.equals(map2) = " + map.equals(map2));

        age = map.remove("张三");
        System.out.println("age = " + age);
        Set<String> keySet = map.keySet();
        System.out.println("keySet = " + keySet);

        Collection<Integer> values = map.values();
        System.out.println("values = " + values);
    }

    @Test
    public void test2() {
        Map<String, Integer> map = new HashMap<>();

        map.put("张三", 18);
        map.put("李四", 28);
        map.put("王五", 45);

        for(Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext();) {
            String key = iterator.next();
            Integer value = map.get(key);
            System.out.println("key: " + key + ", value:" + value);
        }
    }

    @Test
    public void test3() {
        Map<String,Integer> map = new HashMap<>();
        map.put("张三", 18);
        map.put("李四", 28);
        map.put("王五", 45);

        for(String key: map.keySet()) {
            Integer value = map.get(key);
            System.out.println("key: " + key + ", value = " + value);
        }
    }

    @Test
    public void test4() {
        Map<String, Integer> map = new HashMap<>();

        map.put("张三", 18);
        map.put("李四", 28);
        map.put("王五", 45);

        for(Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry<String,Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println("key：" + key + "，value：" + value);
        }
    }

    @Test
    public void test5() {
        Map<String, Integer> map = new HashMap<>();

        map.put("张三", 18);
        map.put("李四", 28);
        map.put("王五", 45);

        for(Map.Entry<String,Integer> entry: map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println("key：" + key + "，value：" + value);
        }
    }
}
