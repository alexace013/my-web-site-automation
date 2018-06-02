package actions;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyController;

import java.util.List;

@Log4j
public class WebElementsActions {

    private static final String WAIT_20_SEC = "wait.timeout.20sec";

    private WebDriver driver;
    private WebDriverWait driverWait;

    public WebElementsActions(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, Integer.parseInt(
                PropertyController.loadProperty(WAIT_20_SEC)));
    }

    public void openPage(final String url) {
        log.info(String.format("browser open <%s> page", url));
        driver.get(url);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void navigateToPage(final String url) {
        log.info(String.format("browser navigate to <%s> page", url));
        driver.navigate().to(url);
    }

    public WebElement getWebElement(final String xpathToElement) throws TimeoutException {
        return driver.findElement(By.xpath(xpathToElement));
    }

    public List<WebElement> getWebElements(final String xpathToElement) {
        return driver.findElements(By.xpath(xpathToElement));
    }

    public void clickOnElement(final String xpath) {
        getWebElement(xpath).click();
    }
}
