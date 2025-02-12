package com.alexanderbakhin.selenide.pages;

import com.alexanderbakhin.site.ISupportPage;
import com.codeborne.selenide.WebDriverRunner;

public class SupportPage extends AbstractPage implements ISupportPage {

    @Override
    public boolean isPage() {
        return WebDriverRunner.getWebDriver().getCurrentUrl().equals(SUPPORT_PAGE_URL);
    }
}