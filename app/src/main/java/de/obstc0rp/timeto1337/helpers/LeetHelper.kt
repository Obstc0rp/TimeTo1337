package de.obstc0rp.timeto1337.helpers

import java.time.LocalDateTime
import java.time.ZoneOffset

fun timeToLeet(): String {
    val now = LocalDateTime.now();
    val leet = getNextLeet();

    val difference = differenceBetween(now, leet);

    if (difference.isItLeet()) {
        return "It is 1337! \uD83C\uDF89"
    }
    return "${difference.hours} hours and ${difference.minutes} minutes to 1337!";
}

fun getNextLeet(): LocalDateTime {
    var leet = LocalDateTime.now();
    if (leet.hour > 13 || leet.hour == 13 && leet.minute > 37) {
        leet = leet.plusDays(1);
    }
    leet = leet.withHour(13).withMinute(37).withSecond(0);

    return leet;
}

fun differenceBetween(now: LocalDateTime, leet: LocalDateTime): DateTimeDifference {
    val differenceInSeconds = leet.toEpochSecond(ZoneOffset.UTC) - now.toEpochSecond(ZoneOffset.UTC);
    val difference = LocalDateTime.ofEpochSecond(differenceInSeconds, 0, ZoneOffset.UTC);
    val hours = difference.hour;
    val minutes = difference.minute;

    return DateTimeDifference(hours, minutes);
}

class DateTimeDifference(hours: Int, minutes: Int) {
    var hours: Int = hours;
    var minutes: Int = minutes;

    fun isItLeet(): Boolean {
        return hours == 13 && minutes == 37;
    }
}
