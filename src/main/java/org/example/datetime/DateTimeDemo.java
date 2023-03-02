package org.example.datetime;

import org.junit.Test;

import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class DateTimeDemo {

    @Test
    public void testLocalDate() {
        LocalDate now = LocalDate.now();
        System.out.println("now = " + now);

        LocalDate date = LocalDate.of(2011, 11, 11);
        System.out.println("date = " + date);

        int year = now.getYear();
        System.out.println("year = " + year);
        int month = now.getMonth().getValue();
        System.out.println("month = " + month);
        int day = now.getDayOfMonth();
        System.out.println("day = " + day);
    }

    @Test
    public void testLocalTime() {
        LocalTime now = LocalTime.now();
        System.out.println("now = " + now);

        LocalTime time = LocalTime.of(15, 30, 11);
        System.out.println("time = " + time);

        int hour = now.getHour();
        System.out.println("hour = " + hour);
        int minute = now.getMinute();
        System.out.println("minute = " + minute);
        int second = now.getSecond();
        System.out.println("second = " + second);
        int nano = now.getNano();
        System.out.println("nano = " + nano);
    }

    @Test
    public void testLocalDateTime() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        LocalDateTime dateTime = LocalDateTime.of(2011, 11, 11, 11, 11, 11);
        System.out.println("datetime = " + dateTime);

        int year = now.getYear();
        System.out.println("year = " + year);
        int month = now.getMonthValue();
        System.out.println("month = " + month);
        int day = now.getDayOfMonth();
        System.out.println("day = " + day);
        int hour = now.getHour();
        System.out.println("hour = " + hour);
        int minute = now.getMinute();
        System.out.println("minute = " + minute);
        int second = now.getSecond();
        System.out.println("second = " + second);
        int nano = now.getNano();
        System.out.println("nano = " + nano);
    }

    /**
     * 修改时间
     */
    @Test
    public void testLocalDateTime2() {
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime localDateTime = now.withYear(2021).withMinute(5);
        System.out.println("now = " + now);
        System.out.println("localDateTime = " + localDateTime);

        LocalDateTime localDateTime1 = now.plusYears(1);
        System.out.println("localDateTime1 = " + localDateTime1);
    }

    /**
     * 比较时间
     */
    @Test
    public void testLocalDateTime3() {
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime localDateTime = LocalDateTime.now().plusYears(1);
        boolean before = now.isBefore(localDateTime);
        System.out.println("before = " + before);
    }

    @Test
    public void test4() {
        //Instance内部保存了秒和纳秒，一般不是给用户使用的，而是方便我们程序做一些统计
        Instant now = Instant.now();
        System.out.println("now = " +  now);

        Instant instant = now.plusSeconds(20);
        System.out.println("instant = " + instant);

        long epochSecond = now.getEpochSecond();
        System.out.println("epochSecond = " + epochSecond);
        int nano = now.getNano();
        System.out.println("nano = " + nano);
    }

    @Test
    public void test5() {
        //● Duration：用于计算 2 个时间（LocalTime，Instant等）的距离。
        //● Period：用于计算 2 个日期（LocalDate）的距离。
        Duration duration = Duration.between(LocalTime.now(), LocalTime.now().plusSeconds(60));

        System.out.println("相差天 = " + duration.toDays());
        System.out.println("相差小时 = " + duration.toHours());
        System.out.println("相差分钟 = " + duration.toMinutes());
        System.out.println("相差毫秒 = " + duration.toNanos());
        System.out.println("相差秒 = " + duration.getSeconds());

        Period period = Period.between(LocalDate.now(), LocalDate.now().plusDays(2).plusMonths(2));
        System.out.println("相差年 = " + period.getYears());
        System.out.println("相差月 = " + period.getMonths());
        System.out.println("相差日 = " + period.getDays());
    }

    /**
     * ● 有时我们可能需要获取例如：将日期调整到下一个月的第一天等操作。可以通过时间校正器来进行。
     * ● TemporalAdjuster：时间校正器。
     * ● TemporalAdjusters：该类通过静态方法提供了大量的常用 TemporalAdjuster 的实现。
     */
    @Test
    public void test6() {
        LocalDateTime now = LocalDateTime.now();
        //将日期和时间调整到"下一个月的第一天"
        LocalDateTime localDateTime = now.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("localDateTime = " + localDateTime);
    }

}
