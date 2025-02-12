package com.alexanderbakhin.site.selenium;

import actions.Actions;
import com.alexanderbakhin.selenium.pages.AbstractPage;
import com.alexanderbakhin.selenium.pages.HomePage;
import com.alexanderbakhin.selenium.pages.SupportPage;
import org.openqa.selenium.WebDriver;

public class MyWebSite {

    public Actions actions;
    public AbstractPage abstractPage;
    public HomePage homePage;
    public com.alexanderbakhin.selenide.pages.HomePage selenideHomePage;
    public SupportPage supportPage;

    public MyWebSite(WebDriver driver) {
        abstractPage = new AbstractPage(driver);
        homePage = new HomePage(driver);
        selenideHomePage = new com.alexanderbakhin.selenide.pages.HomePage();
        supportPage = new SupportPage(driver);
        actions = new Actions(driver);
    }
}
