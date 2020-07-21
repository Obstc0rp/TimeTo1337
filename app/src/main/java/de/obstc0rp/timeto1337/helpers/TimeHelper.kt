package de.obstc0rp.timeto1337.helpers

import java.time.LocalTime

fun getSecondsToNextMinute(): Long {
    val now = LocalTime.now();
    val secondsToNextMinute = 60 - now.second;
    return secondsToNextMinute.toLong();
}