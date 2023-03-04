package org.example.date;

import com.sun.org.apache.bcel.internal.generic.PUSH;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

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

    @Test
    public void test5() {
        TimeZone aDefault =TimeZone.getDefault();
        System.out.println("aDefault = " + aDefault.getID());
        String [] availableIDs = TimeZone.getAvailableIDs();
        System.out.println("availableIDs = " + Arrays.toString(availableIDs));
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
        System.out.println("timeZone = "+ timeZone);
    }

    /**
     * SimpleDateFormat
     * @throws ParseException
     */
    @Test
    public void test6() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String format = sdf.format(date);
        System.out.println("format = " + format);
        Date parse = sdf.parse(format);
        System.out.println("parse = " + parse);
    }


    @Test
    public void test7() {
        LocalDate now = LocalDate.now();
        System.out.println("now = " + now);
        LocalTime now1 = LocalTime.now();
        System.out.println("now1 = " + now1);
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println("now2 = " + now2);
    }

    @Test
    public void test8() {
        Instant now = Instant.now();
        System.out.println("now = " + now);
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println("now1 = " + now);
    }

    @Test
    public void test9() {
        LocalDateTime  of = LocalDateTime.of(2023, 3, 4, 11,11,11);
        System.out.println("of = " + of);
    }

    @Test
    public void test10() {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        System.out.println("获取年份：" + year);
        int monthValue = now.getMonthValue();
        System.out.println("获取月份：" + monthValue);
        int dayOfMonth = now.getDayOfMonth();
        System.out.println("获取天数:" + dayOfMonth);
        int dayOfYea = now.getDayOfYear();
        System.out.println("获取一年中的第" + dayOfYea + "天");
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        System.out.println("获取星期" + dayOfWeek.getValue());
        int hour = now.getHour();
        System.out.println("获取小时:" + hour);
        int miniute = now.getMinute();
        System.out.println("获取分钟:" + miniute);
        int second = now.getSecond();
        System.out.println("获取秒:" + second);
        int nano = now.getNano();
        System.out.println("获取纳秒:" + nano);
    }

    @Test
    public void test11() {
        LocalDateTime now = LocalDateTime.now();
        LocalDate localDate = now.toLocalDate();
        System.out.println("localDate = " + localDate);
        // 转化成LocalTime
        LocalTime localTime = now.toLocalTime();
        System.out.println("localTime = " + localTime);
    }

    /**
     * 修改日期
     */

    @Test
    public void test12() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        LocalDateTime localDateTime = now.withYear(2022);
        System.out.println("修改年 = " + localDateTime);
        LocalDateTime localDateTime1 = now.withMonth(10);
        System.out.println("修改月份 = " + localDateTime1);
        LocalDateTime localDateTime2 = now.withDayOfMonth(28);
        System.out.println("修改日期（一个月中的第几天） = " + localDateTime2);
        LocalDateTime localDateTime3 = now.withDayOfYear(15);
        System.out.println("修改日期（一年中的第几天） = " + localDateTime3);
        LocalDateTime localDateTime4 = now.withHour(10);
        System.out.println("修改小时 = " + localDateTime4);
        LocalDateTime localDateTime5 = now.withMinute(15);
        System.out.println("修改分钟 = " + localDateTime5);
        LocalDateTime localDateTime6 = now.withSecond(10);
        System.out.println("修改秒 = " + localDateTime6);
    }

    @Test
    public void test13() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        LocalDateTime localDateTime = now.plusYears(1);
        System.out.println("localDateTime = " + localDateTime);
        LocalDateTime localDateTime1 = now.plusYears(-1);
        System.out.println("localDateTime1 = " + localDateTime1);
        LocalDateTime localDateTime2 = now.plusMonths(1);
        System.out.println("localDateTime2 = " + localDateTime2);
        LocalDateTime localDateTime3 = now.plusDays(1);
        System.out.println("localDateTime3 = " + localDateTime3);
        LocalDateTime localDateTime4 = now.plusHours(1);
        System.out.println("localDateTime4 = " + localDateTime4);
        LocalDateTime localDateTime5 = now.plusMinutes(1);
        System.out.println("localDateTime5 = " + localDateTime5);
        LocalDateTime localDateTime6 = now.plusSeconds(1);
        System.out.println("localDateTime6 = " + localDateTime6);
        LocalDateTime localDateTime7 = now.plusWeeks(1);
        System.out.println("localDateTime7 = " + localDateTime7);

    }

    @Test
    public void test14() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        LocalDateTime localDateTime = now.minusYears(1);
        System.out.println("localDateTime = " + localDateTime);
        LocalDateTime localDateTime1 = now.minusMonths(1);
        System.out.println("localDateTime1 = " + localDateTime1);
        LocalDateTime localDateTime2 = now.minusDays(1);
        System.out.println("localDateTime2 = " + localDateTime2);
        LocalDateTime localDateTime3 = now.minusHours(1);
        System.out.println("localDateTime3 = " + localDateTime3);
        LocalDateTime localDateTime4 = now.minusMinutes(1);
        System.out.println("localDateTime4 = " + localDateTime4);
        LocalDateTime localDateTime5 = now.minusSeconds(1);
        System.out.println("localDateTime5 = " + localDateTime5);
        LocalDateTime localDateTime6 = now.minusWeeks(1);
        System.out.println("localDateTime6 = " + localDateTime6);
    }

    @Test
    public void test15() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = LocalDateTime.now().plusHours(1);
        System.out.println(now.isBefore(localDateTime));
        System.out.println(now.isAfter(localDateTime));
        System.out.println(now.isEqual(localDateTime));
    }

    /**
     *  指定时区日期时间 ZonedDateTime
     */
    @Test
    public void test16() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("now = " + now);
        ZonedDateTime now1 = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("now1 = " + now1);
    }
}
