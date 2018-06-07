package com.alexanderbakhin.pages;

import lombok.Getter;

@Getter
public enum MyPageUrl {

    MAIN_PAGE_URL("http://alexanderbakhin.com/"),
    SUPPORT_PAGE_URL("http://support.alexanderbakhin.com/");

    private String pageUrl;

    MyPageUrl(final String pageUrl) {
        this.pageUrl = pageUrl;
    }
}
