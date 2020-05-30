package com.alexanderbakhin.selenide.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import utils.WebDriverSelenideUtil;

import java.net.URL;

public abstract class AbstractPage {

    public AbstractPage() {
    }

    public void openPage(final String pageUrl) {
        Configuration.headless = true;
        Selenide.open(pageUrl);
    }

    public void openPage(final URL url) {
        Selenide.open(url);
    }

    public abstract boolean isPage();

    public String getCurrentUrl() {
        return WebDriverSelenideUtil.getWebDriver().getCurrentUrl();
    }
}