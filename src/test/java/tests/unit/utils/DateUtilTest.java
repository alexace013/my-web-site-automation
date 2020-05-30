package tests.unit.utils;

import static utils.DateUtil.getCurrentYear;
import static utils.DateUtil.NUMBER_0;
import static utils.DateUtil.NUMBER_4;

import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Log4j
public class DateUtilTest {

    @Test
    public void checkDateUtilGetCurrentYear() {
        final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        final Date date = new Date();
        final String nowDate = dateFormat.format(date);
        log.info(String.format("CURRENT DATE AND TIME: %s", nowDate));
        final int currentYear = Integer.parseInt(nowDate.substring(NUMBER_0, NUMBER_4));
        log.debug("current year: " + currentYear);
        Assert.assertEquals(currentYear, getCurrentYear());
    }
}