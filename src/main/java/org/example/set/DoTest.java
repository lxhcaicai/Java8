package org.example.set;

import org.junit.Test;

import java.util.*;

public class DoTest {
    @Test
    public void test() {
        Set<String> set = new HashSet<>();

        set.add("aa");
        set.add("bb");
        set.add("cc");
        set.add("aa");

        System.out.println("set = " + set);
        System.out.println("--------------");

        for(String s: set) {
            System.out.println(s);
        }

        System.out.println("---------------");

        for(Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            System.out.println(next);
        }
    }

    class Person{
        /**
         * 姓名
         */
        private String name;
        /**
         * 年龄
         */
        private Integer age;

        public Person() {
        }

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) {
                return true;
            }
            if(obj == null || this.getClass()!=obj.getClass()) {
                return false;
            }
            Person person = (Person) obj;
            return Objects.equals(this.name, person.name) && Objects.equals(this.age, person.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.name, this.age);
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
    public void test2() {
        Set<Person> set = new HashSet<>();

        set.add(new Person("张三", 18));
        set.add(new Person("张三", 18));
        set.add(new Person("张三", 21));
        set.add(new Person("李四", 20));
        set.add(new Person("李四", 18));

        System.out.println("set = " + set);
    }

    /**
     * Set 的实现类之二：LinkedHashSet
     */
    @Test
    public void test3() {
        Set<String> set = new LinkedHashSet<>();


        set.add("aa");
        set.add("cc");
        set.add("bb");
        set.add("aa");

        System.out.println("set = " + set);
    }

    /**
     * 自然排序
     */
    @Test
    public void test4() {
        Set<String> set = new TreeSet<>();

        set.add("g");
        set.add("b");
        set.add("d");
        set.add("c");
        set.add("f");

        System.out.println("set = " + set); // set = [b, c, d, f, g]
    }


    class Student implements Comparable<Student>{
        private String name;

        private int age;

        public Student() {
        }

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public int compareTo(Student o) {
            return Integer.compare(this.getAge(), o.getAge());
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    /**
     * 自然排序
     */
    @Test
    public void test5() {
        Set<Student> set = new TreeSet<>();

        set.add(new Student("张三", 15));
        set.add(new Student("李四", 99));
        set.add(new Student("王五", 58));
        set.add(new Student("赵六", 9));
        set.add(new Student("田七", 1));
        set.add(new Student("王八", 44));

        System.out.println("set = " + set);
    }

    /**
     * 定制排序
     */
    @Test
    public void test6() {
        Set<Person> set = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });

        set.add(new Person("张三", 15));
        set.add(new Person("李四", 99));
        set.add(new Person("王五", 58));
        set.add(new Person("赵六", 9));
        set.add(new Person("田七", 1));
        set.add(new Person("王八", 44));

        System.out.println("set = " + set);
    }
}
