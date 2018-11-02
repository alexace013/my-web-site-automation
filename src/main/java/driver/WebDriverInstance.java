package driver;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import controller.OSController;
import controller.PropertyController;

import java.io.IOException;

@Log4j
public class WebDriverInstance {

    private static final String BROWSER_PATH_UNIX = PropertyController.loadProperty("chromedriver.path.unix");
    private static final String BROWSER_PATH_WINDOWS = PropertyController.loadProperty("chromedriver.path.windows");

    public static WebDriver driver;

    public WebDriverInstance() {
    }

    public static WebDriver initWebDriver(final boolean isWebDriverHeadless) {
        DesiredCapabilities desiredCapabilities;
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + getChromeDriverPath());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-sandbox");
        if (isWebDriverHeadless) {
            chromeOptions.addArguments("headless");
            chromeOptions.addArguments("window-size=1920x1080");
        }
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }

    private static String getChromeDriverPath() {
        if (OSController.isUnix()) {
            return BROWSER_PATH_UNIX;
        } else if (OSController.isWindows()) {
            return BROWSER_PATH_WINDOWS;
        } else {
            try {
                throw new IOException();
            } catch (IOException e) {
                log.debug("not found chrome driver for unix or windows");
                log.error(e);
            }
        }
        return "dev\\null";
    }
}
