package com.alexanderbakhin.pages;

import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {

    private static final String DOWNLOAD_RESUME_BUTTON = ".//a[@title='google_drive_resume_link_en']";


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnDownloadResumeButton() {
        webElementsActions.clickOnElement(DOWNLOAD_RESUME_BUTTON);
    }

    public boolean isMainPage() {
        return isPage(MyPageUrl.MAIN_PAGE_URL.getPageUrl());
    }
}
