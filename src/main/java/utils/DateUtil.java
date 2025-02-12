package utils;

import lombok.extern.log4j.Log4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Log4j
public class DateUtil {

    public final static int NUMBER_0 = 0;
    public final static int NUMBER_4 = 4;

    public static int getCurrentYear() {
        final int year = Integer.parseInt(getFullCurrentDateAndTime().substring(NUMBER_0, NUMBER_4));
        log.debug(String.format("CURRENT YEAR: %d", year));
        return year;
    }

    private static String getFullCurrentDateAndTime() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        final String currentDateAndTime = dateFormat.format(now);
        log.debug(String.format("CURRENT DATE AND TIME: %s", currentDateAndTime));
        return currentDateAndTime;
    }
}