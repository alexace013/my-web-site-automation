package com.alexanderbakhin.site;

import controller.PropertyController;
import lombok.AllArgsConstructor;
import lombok.Getter;

public interface IHomePage {

    String HOME_PAGE_URL = PropertyController.loadProperty("home.page.url");
    String HREF_ATTRIBUTE = "href";
    String DOWNLOAD_RESUME_BUTTON_XPATH = ".//a[@title='google_drive_resume_link_en']";
    String SEND_BUTTON_XPATH = ".//button[text()='Send']";
    String MESSAGE_TEXT_AREA_XPATH = ".//input[@value='Message']/following-sibling::textarea";
    String INPUT_FIELDS_XPATH = ".//input[@value='%s']/following-sibling::input";
    String BOTTOM_LINKS_XPATH = ".//a[@title='%s']";
    String COPYRIGHT_FULL_TEXT_XPATH = ".//p[@class='wb-stl-footer']";
    String COPYRIGHT_LINK_XPATH = ".//p[@class='wb-stl-footer']/a";

    void inputDataIntoMessageTextArea(final String data);

    void inputDataIntoNameField(final String data);

    void inputDataIntoEmailField(final String data);

    void inputDataIntoCountryField(final String data);

    void inputDataIntoCityField(final String data);

    void inputDataIntoPhoneField(final String data);

    void clickOnSendButton();

    boolean isMessageTextEquals(final String text);

    void clickOnDownloadResumeButton();

    String getHrefFromBottomLink(final BottomLinks link);

    String getCopyrightText();

    String getCopyrightLink();

    int getCopyrightYear();

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