package com.alexanderbakhin.selenium.pages;

import com.alexanderbakhin.site.ISupportPage;
import com.alexanderbakhin.site.MyPageUrl;
import org.openqa.selenium.WebDriver;

public class SupportPage extends AbstractPage implements ISupportPage {

    public SupportPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSupportPage() {
        return isPage(MyPageUrl.SUPPORT_PAGE_URL.getPageUrl());
    }

    public void clickOnTestButton() {
        webElementsActions.clickOnElement(TEST_BUTTON);
    }

    public String getTestText() {
        return webElementsActions.getTextFromWebElement(TEST_TEXT);
    }
}