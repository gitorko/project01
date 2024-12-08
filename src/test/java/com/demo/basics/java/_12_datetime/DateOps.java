package com.demo.basics.java._12_datetime;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *  https://www.journaldev.com/2800/java-8-date-localdate-localdatetime-instant
 */
public class DateOps {

    private static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        return Period.between(birthDate, currentDate).getYears();
    }

    @Test
    public void test_date_format() {
        var date = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("YYY-MM-dd"));
        System.out.println(date);
    }

    @Test
    public void test() {
        int calculateAge = calculateAge(LocalDate.of(1983, Month.OCTOBER, 4), LocalDate.now());
        Assertions.assertTrue(calculateAge > 37);
    }

    @Test
    public void test2() {
        long hours = 48; // 48 hours
        long minutes = TimeUnit.HOURS.toMinutes(hours); // Convert hours to minutes
        long seconds = TimeUnit.HOURS.toSeconds(hours); // Convert hours to seconds

        System.out.println(hours + " hours is equivalent to:");
        System.out.println(minutes + " minutes");
        System.out.println(seconds + " seconds");

        // Example with ChronoUnit
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime future = now.plus(3, ChronoUnit.DAYS).plus(5, ChronoUnit.HOURS);

        long daysBetween = ChronoUnit.DAYS.between(now, future);
        long hoursBetween = ChronoUnit.HOURS.between(now, future);

        System.out.println("\nCurrent time: " + now);
        System.out.println("Future time: " + future);
        System.out.println("Difference:");
        System.out.println(daysBetween + " days");
        System.out.println(hoursBetween + " hours");
    }

    @Test
    public void test_timezone() {
        ZoneId.getAvailableZoneIds()
                .forEach(System.out::println);
    }

    @SneakyThrows
    @Test
    public void test_timetaken() {
        var start = LocalDateTime.now();
        TimeUnit.SECONDS.sleep(2);
        var duration = ChronoUnit.SECONDS.between(start, LocalDateTime.now());
        System.out.println(duration);
    }

    @SneakyThrows
    @Test
    public void test_between() {
        var now = LocalDateTime.now();
        var jd = LocalDate.of(2021, Month.APRIL, 01);
        var day = ChronoUnit.DAYS.between(jd, now);
        System.out.println(day);
    }

}
