package com.alexanderbakhin.selenium.pages;

import com.alexanderbakhin.site.IHomePage;
import com.alexanderbakhin.site.MyPageUrl;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage implements IHomePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void inputDataIntoMessageTextArea(final String data) {
        webElementsActions.inputData(MESSAGE_TEXT_AREA, data);
    }

    @Override
    public void inputDataIntoNameField(final String data) {
        inputDataIntoField(MessagePanel.NAME, data);
    }

    @Override
    public void inputDataIntoEmailField(final String data) {
        inputDataIntoField(MessagePanel.E_MAIL, data);
    }

    @Override
    public void inputDataIntoCountryField(final String data) {
        inputDataIntoField(MessagePanel.COUNTRY, data);
    }

    @Override
    public void inputDataIntoCityField(final String data) {
        inputDataIntoField(MessagePanel.CITY, data);
    }

    @Override
    public void inputDataIntoPhoneField(final String data) {
        inputDataIntoField(MessagePanel.PHONE, data);
    }

    @Override
    public void clickOnSendButton() {
        webElementsActions.clickOnElement(SEND_BUTTON);
    }

    private void inputDataIntoField(final MessagePanel fieldValue, final String data) {
        webElementsActions.inputData(String.format(INPUT_FIELDS, fieldValue.getField()), data);
    }

    @Override
    public boolean isMessageTextEquals(final String text) {
        return webElementsActions.waitAndGetAlertText().equals(text);
    }

    @Override
    public void clickOnDownloadResumeButton() {
        webElementsActions.clickOnElement(DOWNLOAD_RESUME_BUTTON);
    }

    @Override
    public boolean isHomePage() {
        return isPage(MyPageUrl.HOME_PAGE_URL.getPageUrl());
    }

    // TODO #3 implement method on Selenium level
    @Override
    public void checkCopyrightText() {

    }

    public String getHrefFromBottomLink(final BottomLinks link) {
        return webElementsActions.getAttributeTitleFromElement(
                String.format(BOTTOM_LINKS, link.getAttrTitle()), "href");
    }
}
