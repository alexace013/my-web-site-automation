package com.alexanderbakhin.site;

import actions.Actions;
import com.alexanderbakhin.pages.AbstractPage;
import com.alexanderbakhin.pages.MainPage;
import com.alexanderbakhin.pages.SupportPage;
import org.openqa.selenium.WebDriver;

public class MyWebSite {

    public Actions actions;
    public AbstractPage abstractPage;
    public MainPage mainPage;
    public SupportPage supportPage;

    public MyWebSite(WebDriver driver) {
        abstractPage = new AbstractPage(driver);
        mainPage = new MainPage(driver);
        supportPage = new SupportPage(driver);
        actions = new Actions(driver);
    }
}
