package com.alexanderbakhin.pages;

import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {

    private static final String DOWNLOAD_PDF_LINK = ".//div/a[@title='google_drive_resume_link']";


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnDownloadPdfLink() {
        webElementsActions.clickOnElement(DOWNLOAD_PDF_LINK);
    }

    public boolean isMainPage() {
        return isPage(MyPageUrl.MAIN_PAGE_URL.getPageUrl());
    }
}
