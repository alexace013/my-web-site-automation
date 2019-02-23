package com.alexanderbakhin.site;

import lombok.AllArgsConstructor;
import lombok.Getter;

public interface IHomePage {

    String DOWNLOAD_RESUME_BUTTON = ".//a[@title='google_drive_resume_link_en']";
    String SEND_BUTTON = ".//button[text()='Send']";
    String MESSAGE_TEXT_AREA = ".//input[@value='Message']/following-sibling::textarea";
    String INPUT_FIELDS = ".//input[@value='%s']/following-sibling::input";
    String BOTTOM_LINKS = ".//a[@title='%s']";

    void inputDataIntoMessageTextArea(final String data);

    void inputDataIntoNameField(final String data);

    void inputDataIntoEmailField(final String data);

    void inputDataIntoCountryField(final String data);

    void inputDataIntoCityField(final String data);

    void inputDataIntoPhoneField(final String data);

    void clickOnSendButton();

    boolean isMessageTextEquals(final String text);

    void clickOnDownloadResumeButton();

    boolean isMainPage();

    @AllArgsConstructor
    @Getter
    enum MessagePanel {
        NAME("Name"),
        E_MAIL("E-mail"),
        COUNTRY("Country"),
        CITY("City"),
        PHONE("Phone");
        private String field;
    }

    @AllArgsConstructor
    @Getter
    enum BottomLinks {
        FACEBOOK("facebook-link"),
        LINKEDIN("linkedin-link"),
        INSTAGRAM("instagram-link"),
        YOUTUBE("youtube-link"),
        GOOGLE_PLUS("google-plus-link");
        // attribute title
        private String attrTitle;
    }
}