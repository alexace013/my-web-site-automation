package com.alexanderbakhin.pages;

import lombok.Getter;

@Getter
public enum MyPageUrl {

    MAIN_PAGE("http://alexanderbakhin.com/"),
    SUPPORT_PAGE("http://support.alexanderbakhin.com/");

    private String page;

    MyPageUrl(final String page) {
        this.page = page;
    }

}
