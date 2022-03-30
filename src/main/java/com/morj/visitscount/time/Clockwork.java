package com.morj.visitscount.time;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Clockwork {
    public static String getTime() {
        LocalDateTime currentTime = LocalDateTime.now(Clock.systemUTC());
        return currentTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
