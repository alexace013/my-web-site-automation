package com.alexanderbakhin.pages;

import lombok.Getter;
import controller.PropertyController;

@Getter
public enum MyPageUrl {

    MAIN_PAGE_URL(PropertyController.loadProperty("main.page.url")),
    SUPPORT_PAGE_URL(PropertyController.loadProperty("support.page.url"));

    private String pageUrl;

    MyPageUrl(final String pageUrl) {
        this.pageUrl = pageUrl;
    }
}
