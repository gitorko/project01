package com.demo.basics.java._12_date;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *  https://www.journaldev.com/2800/java-8-date-localdate-localdatetime-instant
 */
public class DateOps {
    @Test
    public void test() {
        int calculateAge = new DateOps().calculateAge(LocalDate.of(1983, Month.OCTOBER, 4), LocalDate.now());
        Assertions.assertTrue(calculateAge > 37);
    }

    public int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        return Period.between(birthDate, currentDate).getYears();
    }

}
