package utils;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

@Log4j
public class UrlController {

    public static String getUrlFromNewTab(final WebDriver driver, final int tabNumber) {
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(!(tabNumber == 0) ?
                browserTabs.get(tabNumber - 1) : browserTabs.get(0));
        log.info(String.format("url from new tab: <%s>", driver.getCurrentUrl()));
        return driver.getCurrentUrl();
    }
}