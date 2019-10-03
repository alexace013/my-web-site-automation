package utils;

import static java.lang.String.format;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavascriptExecutorUtil {

    private static final String WINDOW_SCROLL_JS_SCRIPT = "window.scrollBy(%d,%d)";
    private static final String DOCUMENT_READY_STATE = "return document.readyState";

    private static void scrollWindowOnPixels(final WebDriver driver,
                                             final int horizontalPixelScrollValue,
                                             final int verticalPixelScrollValue) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(format(WINDOW_SCROLL_JS_SCRIPT, horizontalPixelScrollValue, verticalPixelScrollValue));
    }

    public static void scrollWindowOnVerticalPixels(final WebDriver driver,
                                                    final int verticalPixelScrollValue) {
        scrollWindowOnPixels(driver, 0, verticalPixelScrollValue);
    }

    public static void scrollWindowOnHoriontalPixels(final WebDriver driver,
                                                     final int horizontalPixelScrollValue) {
        scrollWindowOnPixels(driver, horizontalPixelScrollValue, 0);
    }

    private static boolean isPageStatus(final WebDriver driver, final String expectedPageStatus) {
        return ((JavascriptExecutor) driver).executeScript(DOCUMENT_READY_STATE)
                .toString().equals(expectedPageStatus);
    }

    public static boolean isPageLoaded(final WebDriver driver) {
        String completeStatus = "complete";
        return isPageStatus(driver, completeStatus);
    }
}