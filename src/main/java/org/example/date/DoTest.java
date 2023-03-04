package org.example.date;

import org.junit.Test;

import java.util.Date;

public class DoTest {
    /**
     * Date类
     */
    @Test
    public void test() {
        Date date = new Date();
        System.out.println("date = " + date);
        Date date1 = new Date(1632638970000L);
        System.out.println("date1 = " + date1);

        long time = date.getTime();
        System.out.println("time = " + time);

        date.setTime(1632638970000L);
        System.out.println("date = " + date);
    }
}
