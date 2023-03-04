package org.example.date;

import com.sun.org.apache.bcel.internal.generic.PUSH;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class DoTest {
    /**
     * Date类 表示当前的日期对象，精确到毫秒值。
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

    /**
     * Calendar 类
     */
    @Test
    public void test2() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int milliSecond = calendar.get(Calendar.MILLISECOND);
        System.out.print(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second + ":" + milliSecond);
    }

    @Test
    public void test3() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2022);
        System.out.println("calendar = " + calendar.get(Calendar.YEAR));
    }

    @Test
    public void test4() {
        Calendar calendar = Calendar.getInstance();
        // 日历向后，偏移180天
        calendar.add(Calendar.DAY_OF_MONTH, 180);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int milliSecond = calendar.get(Calendar.MILLISECOND);
        System.out.print(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second + ":" + milliSecond);
    }
}
