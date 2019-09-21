package com.alexanderbakhin.site;

import controller.PropertyController;

public interface ISupportPage {

    String SUPPORT_PAGE_URL = PropertyController.loadProperty("support.page.url");
    String TEST_BUTTON_XPATH = ".//a[@title='test_button_url_404']";
    String TEST_TEXT_XPATH = ".//a[@name='test_text']/following-sibling::p";
}