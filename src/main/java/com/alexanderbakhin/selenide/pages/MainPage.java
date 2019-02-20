package com.alexanderbakhin.selenide.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    @FindBy(xpath = com.alexanderbakhin.selenium.pages.MainPage.DOWNLOAD_RESUME_BUTTON)
    private SelenideElement downloadResumeButton;
    @FindBy(xpath = com.alexanderbakhin.selenium.pages.MainPage.SEND_BUTTON)
    private SelenideElement sendButton;
    @FindBy(xpath = com.alexanderbakhin.selenium.pages.MainPage.MESSAGE_TEXT_AREA)
    private SelenideElement messageTextarea;
    // TODO need to refactoring -> see com.alexanderbakhin.selenium.pages.MainPage.MessagePanel
    @FindBy(xpath = com.alexanderbakhin.selenium.pages.MainPage.INPUT_FIELDS)
    private SelenideElement inputFields;
    @FindBy(xpath = com.alexanderbakhin.selenium.pages.MainPage.BOTTOM_LINKS)
    private SelenideElement bottomLinks;

    public void clickOnDownloadResumeButton() {
        downloadResumeButton.shouldBe(Condition.visible).click();
    }

    public void clickOnSendButton() {
        downloadResumeButton.shouldBe(Condition.visible).click();
    }
}