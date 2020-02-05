package com.alexanderbakhin.selenium.pages;

import com.alexanderbakhin.site.IHomePage;
import com.alexanderbakhin.site.MyPageUrl;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;

public class HomePage extends AbstractPage implements IHomePage {

    private static final String GEN_CONST = "GEN_";
    private static final String INPUT_DATA_FORMAT = "%s%s";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void inputDataIntoMessageTextArea(final String data) {
        if (data.equals("generate")) {
            webElementsActions.inputData(MESSAGE_TEXT_AREA_XPATH,
                    String.format("%s%s", GEN_CONST, Faker.instance().crypto().sha512()));
        } else {
            webElementsActions.inputData(MESSAGE_TEXT_AREA_XPATH, data);
        }
    }

    @Override
    public void inputDataIntoNameField(final String data) {
        if (data.equals("generate")) {
            inputDataIntoField(MessagePanel.NAME, String.format(INPUT_DATA_FORMAT, GEN_CONST,
                    Faker.instance().name().firstName()));
        } else {
            inputDataIntoField(MessagePanel.NAME, data);
        }
    }

    @Override
    public void inputDataIntoEmailField(final String data) {
        if (data.equals("generate")) {
            inputDataIntoField(MessagePanel.E_MAIL, String.format(INPUT_DATA_FORMAT.concat("@mail.com"), GEN_CONST,
                    Faker.instance().name().title().toLowerCase().replace(" ", "_")));
        } else {
            inputDataIntoField(MessagePanel.E_MAIL, data);
        }
    }

    @Override
    public void inputDataIntoCountryField(final String data) {
        if (data.equals("generate")) {
            inputDataIntoField(MessagePanel.COUNTRY, String.format(INPUT_DATA_FORMAT, GEN_CONST,
                    Faker.instance().address().country()));
        } else {
            inputDataIntoField(MessagePanel.COUNTRY, data);
        }
    }

    @Override
    public void inputDataIntoCityField(final String data) {
        if (data.equals("generate")) {
            inputDataIntoField(MessagePanel.CITY, String.format(INPUT_DATA_FORMAT, GEN_CONST,
                    Faker.instance().address().city()));
        } else {
            inputDataIntoField(MessagePanel.CITY, data);
        }
    }

    @Override
    public void inputDataIntoPhoneField(final String data) {
        if (data.equals("generate")) {
            inputDataIntoField(MessagePanel.PHONE, String.format(INPUT_DATA_FORMAT, GEN_CONST,
                    Faker.instance().phoneNumber().phoneNumber()));
        } else {
            inputDataIntoField(MessagePanel.PHONE, data);
        }
    }

    @Override
    public void clickOnSendButton() {
        webElementsActions.clickOnElement(SEND_BUTTON_XPATH);
    }

    @Override
    public void clickOnSupportButton() {
        webElementsActions.clickOnElement(SUPPORT_BUTTON_XPATH);
    }

    private void inputDataIntoField(final MessagePanel fieldValue, final String data) {
        webElementsActions.inputData(String.format(INPUT_FIELDS_XPATH, fieldValue.getField()), data);
    }

    @Override
    public boolean isMessageTextEquals(final String text) {
        return webElementsActions.waitAndGetAlertText().equals(text);
    }

    @Override
    public void checkAlertMessageText(String text) {
        assert webElementsActions.getTextFromWebElement(ALERT_MESSAGE_XPATH).equals(text);
    }

    @Override
    public void clickOnDownloadResumeButton() {
        webElementsActions.clickOnElement(DOWNLOAD_RESUME_BUTTON_XPATH);
    }

    public boolean isHomePage() {
        return isPage(MyPageUrl.HOME_PAGE_URL.getPageUrl());
    }

    public int getCopyrightYear() {
        return Integer.parseInt(webElementsActions.getTextFromWebElement(COPYRIGHT_FULL_TEXT_XPATH).substring(2, 6));
    }

    @Override
    public String getCopyrightText() {
        return webElementsActions.getTextFromWebElement(COPYRIGHT_FULL_TEXT_XPATH);
    }

    @Override
    public String getCopyrightLink() {
        return webElementsActions.getAttributeTitleFromElement(COPYRIGHT_LINK_XPATH, HREF_ATTRIBUTE);
    }

    @Override
    public String getHrefFromBottomLink(final BottomLinks link) {
        return webElementsActions.getAttributeTitleFromElement(
                String.format(BOTTOM_LINKS_XPATH, link.getAttrTitle()), HREF_ATTRIBUTE);
    }
}
