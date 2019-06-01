package com.alexanderbakhin.site;

import controller.PropertyController;

public interface ISupportPage {

    String SUPPORT_PAGE_URL = PropertyController.loadProperty("support.page.url");
    String TEST_BUTTON = ".//a[@title='test_button_url_404']";
    String TEST_TEXT = ".//a[@name='test_text']/following-sibling::p";
}