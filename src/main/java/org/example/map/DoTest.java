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

    /**
     * 和 LinkedHashSet 类似，LinkedHashMap 可以维护 Map 的迭代顺序：迭代顺序和 key - value 对的插入顺序一致。
     */

    @Test
    public void test6() {
        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("张三", 18);
        map.put("李四", 19);
        map.put("王五", 20);
        map.put("赵六", 21);

        for(Map.Entry<String,Integer> entry: map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println("key：" + key + "，value：" + value);
        }
    }

    @Test
    public void test7() {
        Map<String, Integer> map = new TreeMap<>();

        map.put("c", 25);
        map.put("h", 18);
        map.put("a", 21);
        map.put("b", 98);

        System.out.println("map = " + map);
    }

    class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
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
    public void test8() {
        Map<Person,String> map = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });


        map.put(new Person("张三", 18), "大一");
        map.put(new Person("李四", 20), "大一");
        map.put(new Person("王五", 19), "大二");
        map.put(new Person("赵六", 23), "大四");
        map.put(new Person("田七", 17), "大一");
        System.out.println("map = " + map);
    }

    /**
     * Map 的实现类之五：Properties
     */
    @Test
    public void test9() {
        Properties properties = new Properties();
        properties.setProperty("hello", "你好");
        properties.setProperty("world", "世界");

        String hello = properties.getProperty("hello");
        System.out.println("hello = " + hello);

        String world = properties.getProperty("world");
        System.out.println("world = " + world);

        Enumeration<?> enumeration = properties.propertyNames();
        while(enumeration.hasMoreElements()) {
            Object key = enumeration.nextElement();
            Object value = properties.get(key);
            System.out.println("key = " + key + "，value = " + value);
        }

        for(String name: properties.stringPropertyNames()) {
            String property = properties.getProperty(name);
            System.out.println("key = " + name + ", value = " + property);
        }
    }

}
