package tests;

import com.alexanderbakhin.site.MyWebSite;
import driver.WebDriverInstance;
import lombok.extern.log4j.Log4j;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import controller.PropertyController;

import java.util.concurrent.TimeUnit;

@Log4j
public class Fixture {

    public static WebDriver driver;
    public static MyWebSite myWebSite;

    private static final String IMP_WAIT = PropertyController.loadProperty("wait.timeout.30sec");
    private static final String WEB_DRIVER_HEADLESS_STATUS = PropertyController.loadProperty("chromedriver.headless");
    private static final String BROWSER_NAME = PropertyController.loadProperty("browser.name");

    @BeforeClass
    public static void setUp() {
        log.info(String.format("WEB_DRIVER <%s> is HEADLESS: <%b>",
                BROWSER_NAME, Boolean.parseBoolean(WEB_DRIVER_HEADLESS_STATUS)));
        driver = WebDriverInstance.initWebDriver(Boolean.parseBoolean(WEB_DRIVER_HEADLESS_STATUS));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(IMP_WAIT), TimeUnit.SECONDS);
        myWebSite = new MyWebSite(driver);
        log.info("Start Test Suite execution");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
        log.info("Tests Suite execution completed.");
    }
}
