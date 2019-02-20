package com.alexanderbakhin.selenium.pages;

import com.alexanderbakhin.site.MyPageUrl;
import org.openqa.selenium.WebDriver;

public class SupportPage extends AbstractPage {

    public SupportPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSupportPage() {
        return isPage(MyPageUrl.SUPPORT_PAGE_URL.getPageUrl());
    }
}