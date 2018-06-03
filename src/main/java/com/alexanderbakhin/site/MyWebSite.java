package com.alexanderbakhin.site;

import actions.Actions;
import com.alexanderbakhin.pages.AbstractPage;
import com.alexanderbakhin.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class MyWebSite {

    public Actions actions;
    public AbstractPage abstractPage;
    public MainPage mainPage;

    public MyWebSite(WebDriver driver) {
        abstractPage = new AbstractPage(driver);
        mainPage = new MainPage(driver);
        actions = new Actions(driver);
    }
}
