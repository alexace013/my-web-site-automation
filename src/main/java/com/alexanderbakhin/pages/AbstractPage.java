package com.alexanderbakhin.pages;

import actions.Actions;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;

@Log4j
public class AbstractPage {

    private String page;
    public WebDriver driver;
    public Actions webElementsActions;

    public AbstractPage(final WebDriver driver) {
        this.driver = driver;
        webElementsActions = new Actions(driver);
    }

    public AbstractPage(final WebDriver driver, final String page) {
        this.driver = driver;
        webElementsActions = new Actions(driver);
        this.page = page;
    }

}
