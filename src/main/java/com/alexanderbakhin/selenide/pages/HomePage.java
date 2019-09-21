package com.alexanderbakhin.selenide.pages;

import static com.codeborne.selenide.Selenide.$x;

import com.alexanderbakhin.site.IHomePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import controller.PropertyController;

public class HomePage extends AbstractPage implements IHomePage {

    private static final String HOME_PAGE_URL = PropertyController.loadProperty("home.page.url");

    @Override
    public void clickOnDownloadResumeButton() {
        $x(DOWNLOAD_RESUME_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickOnSendButton() {
        $x(SEND_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void inputDataIntoMessageTextArea(String data) {
        $x(MESSAGE_TEXT_AREA).shouldBe(Condition.visible).data(data);
    }

    @Override
    public void inputDataIntoEmailField(String data) {
        inputDataIntoField(MessagePanel.E_MAIL.getField(), data);
    }

    @Override
    public void inputDataIntoNameField(String data) {
        inputDataIntoField(MessagePanel.NAME.getField(), data);
    }

    @Override
    public void inputDataIntoCountryField(String data) {
        inputDataIntoField(MessagePanel.COUNTRY.getField(), data);
    }

    @Override
    public void inputDataIntoCityField(String data) {
        inputDataIntoField(MessagePanel.CITY.getField(), data);
    }

    @Override
    public void inputDataIntoPhoneField(String data) {
        inputDataIntoField(MessagePanel.PHONE.getField(), data);
    }

    // TODO #1 need to implement method with Selenide
    @Override
    public boolean isMessageTextEquals(String text) {
        return false;
    }

    public boolean isPage() {
        return WebDriverRunner.getWebDriver().getCurrentUrl().equals(HOME_PAGE_URL);
    }

    private void inputDataIntoField(final String fieldName, final String data) {
        $x(String.format(INPUT_FIELDS, fieldName)).shouldBe(Condition.visible).data(data);
    }

    @Override
    public String getHrefFromBottomLink(BottomLinks link) {
        return $x(String.format(BOTTOM_LINKS, link.getAttrTitle())).getAttribute(HREF_ATTRIBUTE);
    }
}