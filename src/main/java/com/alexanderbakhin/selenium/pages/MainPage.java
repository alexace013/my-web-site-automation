package com.alexanderbakhin.selenium.pages;

import com.alexanderbakhin.site.MyPageUrl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {

    public static final String DOWNLOAD_RESUME_BUTTON = ".//a[@title='google_drive_resume_link_en']";
    public static final String SEND_BUTTON = ".//button[text()='Send']";
    public static final String MESSAGE_TEXT_AREA = ".//input[@value='Message']/following-sibling::textarea";
    public static final String INPUT_FIELDS = ".//input[@value='%s']/following-sibling::input";
    public static final String BOTTOM_LINKS = ".//a[@title='%s']";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @AllArgsConstructor
    @Getter
    protected enum MessagePanel {
        NAME("Name"),
        E_MAIL("E-mail"),
        COUNTRY("Country"),
        CITY("City"),
        PHONE("Phone");
        private String field;
    }

    @AllArgsConstructor
    @Getter
    public enum BottomLinks {
        FACEBOOK("facebook-link"),
        LINKEDIN("linkedin-link"),
        INSTAGRAM("instagram-link"),
        YOUTUBE("youtube-link"),
        GOOGLE_PLUS("google-plus-link");
        // attribute title
        private String attrTitle;
    }

    public void inputDataIntoMessageTextarea(final String data) {
        webElementsActions.inputData(MESSAGE_TEXT_AREA, data);
    }

    public void inputDataIntoNameField(final String data) {
        inputDataIntoField(MessagePanel.NAME, data);
    }

    public void inputDataIntoEmailField(final String data) {
        inputDataIntoField(MessagePanel.E_MAIL, data);
    }

    public void inputDataIntoCountryField(final String data) {
        inputDataIntoField(MessagePanel.COUNTRY, data);
    }

    public void inputDataIntoCityField(final String data) {
        inputDataIntoField(MessagePanel.CITY, data);
    }

    public void inputDataIntoPhoneField(final String data) {
        inputDataIntoField(MessagePanel.PHONE, data);
    }

    public void clickOnSendButton() {
        webElementsActions.clickOnElement(SEND_BUTTON);
    }

    private void inputDataIntoField(final MessagePanel fieldValue, final String data) {
        webElementsActions.inputData(String.format(INPUT_FIELDS, fieldValue.getField()), data);
    }

    public boolean isMessageTextEquals(final String text) {
        return webElementsActions.waitAndGetAlertText().equals(text);
    }

    public void clickOnDownloadResumeButton() {
        webElementsActions.clickOnElement(DOWNLOAD_RESUME_BUTTON);
    }

    public boolean isMainPage() {
        return isPage(MyPageUrl.MAIN_PAGE_URL.getPageUrl());
    }

    public String getHrefFromBottomLink(final BottomLinks link) {
        return webElementsActions.getAttributeTitleFromElement(
                String.format(BOTTOM_LINKS, link.getAttrTitle()), "href");
    }
}
