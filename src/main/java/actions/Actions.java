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
    private static final String JS_WAIT_SCRIPT = "window.scrollBy(0,%d)";

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

    public void clickOnElement(final String xpathToElement) {
        scrollToElementBy(xpathToElement);
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathToElement))).click();
    }

    public void inputData(final String xpathToElement, final String data) {
        final WebElement inputElement = driverWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(xpathToElement)));
        scrollToElement(inputElement);
        log.debug(String.format("input data : [%s]", data));
        inputElement.sendKeys(data);
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
        driverWait.until(condition);
    }

    public void scrollToElementBy(final String elementLocator) {
        WebElement element = getWebElement(elementLocator);
        scrollToElement(element);
    }

    public void scrollToElement(final WebElement element) {
        int elementCoordinateY = element.getLocation().getY();
        log.info(String.format("scroll to element coordinate to Y: %d", elementCoordinateY));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript(String.format(JS_WAIT_SCRIPT, elementCoordinateY));
    }

    /**
     * This method is used to get text from pop-up windows
     *
     * @return alert text
     * @throws NoAlertPresentException If alert is not found on page
     */
    public String waitAndGetAlertText() {
        String alertText;
        try {
            driverWait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
            log.info(String.format("alert text < %s >", alertText));
            alert.accept();
            log.debug("alert closed");
        } catch (NoAlertPresentException e) {
            alertText = "alert is not found";
            log.error(String.format("< %s > . NoAlertPresentException < %s >", alertText, e.getMessage()));
            e.printStackTrace();
        }
        return alertText;
    }
}
