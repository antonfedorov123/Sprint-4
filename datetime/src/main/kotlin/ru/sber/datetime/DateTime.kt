package ru.sber.datetime

import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters
import java.util.*

// 1.
fun getZonesWithNonDivisibleByHourOffset(): Set<String> = ZoneId
    .getAvailableZoneIds()
    .asSequence()
    .filter { ZonedDateTime.now(ZoneId.of(it)).minute != ZonedDateTime.now(ZoneId.of("UTC")).minute }
    .toSet()

// 2.
fun getLastInMonthDayWeekList(year: Int): List<String> = Month.values()
    .asSequence()
    .map { month ->
        LocalDateTime
            .of(year, month, 1, 0, 0)
            .with(TemporalAdjusters.lastDayOfMonth()).dayOfWeek.name
    }.toList()

// 3.
fun getNumberOfFridayThirteensInYear(year: Int): Int = Month.values()
    .asSequence()
    .count {
    LocalDateTime
        .of(year, it, 13, 0, 0)
        .dayOfWeek == DayOfWeek.FRIDAY
}

// 4.
fun getFormattedDateTime(dateTime: LocalDateTime): String = DateTimeFormatter
    .ofPattern("dd MMM yyyy, HH:mm", Locale.US)
    .format(dateTime)



