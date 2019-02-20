package com.alexanderbakhin.site;

import actions.Actions;
import com.alexanderbakhin.selenium.pages.AbstractPage;
import com.alexanderbakhin.selenium.pages.MainPage;
import com.alexanderbakhin.selenium.pages.SupportPage;
import org.openqa.selenium.WebDriver;

public class MyWebSite {

    public Actions actions;
    public AbstractPage abstractPage;
    public MainPage mainPage;
    public com.alexanderbakhin.selenide.pages.MainPage selenideMainPage;
    public SupportPage supportPage;

    public MyWebSite(WebDriver driver) {
        abstractPage = new AbstractPage(driver);
        mainPage = new MainPage(driver);
        selenideMainPage = new com.alexanderbakhin.selenide.pages.MainPage();
        supportPage = new SupportPage(driver);
        actions = new Actions(driver);
    }
}
