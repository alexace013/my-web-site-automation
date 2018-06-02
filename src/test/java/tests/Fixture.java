package tests;

import com.alexanderbakhin.site.MyWebSite;
import driver.WebDriverInstance;
import lombok.extern.log4j.Log4j;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import utils.PropertyController;

import java.util.concurrent.TimeUnit;

@Log4j
public class Fixture {

    public static WebDriver driver;
    public static MyWebSite myWebSite;

    private static final String IMP_WAIT = PropertyController.loadProperty("wait.timeout.10sec");

    @BeforeClass
    public static void setUp() {
        driver = WebDriverInstance.initWebDriver();
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
