package actions;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import controller.PropertyController;

import java.util.List;

@Log4j
public class Actions {

    private static final String WAIT_30_SEC = PropertyController.loadProperty("wait.timeout.30sec");

    private WebDriver driver;
    private WebDriverWait driverWait;

    public Actions(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, Integer.parseInt(WAIT_30_SEC));
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
        scrollToElementBy(xpath);
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    public String getCurrentUrl() {
        waitForPageLoaded();
        return driver.getCurrentUrl();
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> condition = driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState")
                .toString()
                .equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(WAIT_30_SEC));
        wait.until(condition);
    }

    public void scrollToElementBy(String elementLocator) {
        WebElement element = driver.findElement(By.xpath(elementLocator));
        int elementCoordinateY = element.getLocation().getY();
        log.info(String.format("scroll to element coordinate to Y: %s", elementCoordinateY));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0," + elementCoordinateY + ")", "");
    }
}
