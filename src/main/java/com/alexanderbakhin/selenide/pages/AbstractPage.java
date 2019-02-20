package com.alexanderbakhin.selenide.pages;

import com.codeborne.selenide.Selenide;

import java.net.URL;

public abstract class AbstractPage {

    private URL pageUrl;

    public AbstractPage() {
    }

    public AbstractPage(final URL pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void openPage() {
        Selenide.open(pageUrl);
    }

    public void openPage(final String pageUrl) {
        Selenide.open(pageUrl);
    }

    public void openPage(final URL url) {
        Selenide.open(url);
    }

}