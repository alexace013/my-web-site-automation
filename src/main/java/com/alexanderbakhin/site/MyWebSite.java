package com.alexanderbakhin.site;

import actions.WebElementsActions;
import com.alexanderbakhin.pages.AbstractPage;
import com.alexanderbakhin.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class MyWebSite {

    public WebElementsActions webElementsActions;
    public AbstractPage abstractPage;
    public MainPage mainPage;

    public MyWebSite(WebDriver driver) {
        abstractPage = new AbstractPage(driver);
        mainPage = new MainPage(driver);
        webElementsActions = new WebElementsActions(driver);
    }
}
