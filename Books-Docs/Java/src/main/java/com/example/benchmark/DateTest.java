package com.example.benchmark;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

public class DateTest {
	public static void main (String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println(today);

		LocalTime time = LocalTime.of(13,45,20); // 13:45:20
		int hour = time.getHour(); //13
		int minute = time.getMinute(); //45
		int second = time.getSecond(); //20

		LocalDate date = LocalDate.parse("2024-05-16");
		LocalTime time2 = LocalTime.parse("13:45:20");

		LocalDateTime dt1 = LocalDateTime.of(2024, Month.MAY, 16, 13,45,20);
		LocalDate date1 = dt1.toLocalDate();
		LocalTime time1 = dt1.toLocalTime();

		Instant now = Instant.now();
		System.out.println("now = " + now);

		//LocalDate date1 = LocalDate.of(2024,5,16);
		LocalDate date2 = date1.withYear(2025);
		LocalDate date3 = date1.withDayOfMonth(6);
		LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR,2);

		abc a = new abc() {
			@Override
			public Integer add (int a, int b) {
				return a+b;
			}
		};
		System.out.println(a.add(5,5));

	}
}
