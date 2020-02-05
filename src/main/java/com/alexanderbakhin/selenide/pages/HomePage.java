package com.alexanderbakhin.selenide.pages;

import static com.codeborne.selenide.Selenide.$x;

import com.alexanderbakhin.site.IHomePage;
import com.codeborne.selenide.Condition;
import utils.WebDriverSelenideUtil;

public class HomePage extends AbstractPage implements IHomePage {

    @Override
    public void clickOnDownloadResumeButton() {
        $x(DOWNLOAD_RESUME_BUTTON_XPATH).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickOnSendButton() {
        $x(SEND_BUTTON_XPATH).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickOnSupportButton() {
        $x(SUPPORT_BUTTON_XPATH).shouldBe(Condition.visible).click();
    }

    @Override
    public void inputDataIntoMessageTextArea(String data) {
        $x(MESSAGE_TEXT_AREA_XPATH).shouldBe(Condition.visible).data(data);
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

    @Override
    public void checkAlertMessageText(String text) {
        $x(ALERT_MESSAGE_XPATH).shouldBe(Condition.visible).shouldHave(Condition.text(text));
    }

    public boolean isPage() {
        return WebDriverSelenideUtil.getWebDriver().getCurrentUrl().equals(HOME_PAGE_URL);
    }

    private void inputDataIntoField(final String fieldName, final String data) {
        $x(String.format(INPUT_FIELDS_XPATH, fieldName)).shouldBe(Condition.visible).data(data);
    }

    @Override
    public String getHrefFromBottomLink(BottomLinks link) {
        return $x(String.format(BOTTOM_LINKS_XPATH, link.getAttrTitle())).getAttribute(HREF_ATTRIBUTE);
    }

    @Override
    public String getCopyrightText() {
        return $x(COPYRIGHT_FULL_TEXT_XPATH).getText();
    }

    @Override
    public String getCopyrightLink() {
        return $x(COPYRIGHT_LINK_XPATH).getText();
    }

    @Override
    public int getCopyrightYear() {
        return Integer.parseInt($x(COPYRIGHT_FULL_TEXT_XPATH).getText().substring(2, 6));
    }
}