package org.example.datetime;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
}
