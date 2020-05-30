package com.alexanderbakhin.site;

import lombok.AllArgsConstructor;
import lombok.Getter;
import controller.PropertyController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public enum MyPageUrl {

    HOME_PAGE_URL(PropertyController.loadProperty("home.page.url")),
    SUPPORT_PAGE_URL(PropertyController.loadProperty("support.page.url")),
    FACEBOOK_LINK_URL(PropertyController.loadProperty("facebook.link.url")),
    LINKEDIN_LINK_URL(PropertyController.loadProperty("linkedin.link.url")),
    INSTAGRAM_LINK_URL(PropertyController.loadProperty("instagram.link.url")),
    YOUTUBE_LINK_URL(PropertyController.loadProperty("youtube.link.url")),
    GOOGLE_PLUS_LINK_URL(PropertyController.loadProperty("google.plus.link.url"));

    private String pageUrl;

    public static List<String> getUrls() {
        List<String> urlsList = new ArrayList<>();
        urlsList.add(MyPageUrl.FACEBOOK_LINK_URL.getPageUrl());
        urlsList.add(MyPageUrl.LINKEDIN_LINK_URL.getPageUrl());
        urlsList.add(MyPageUrl.INSTAGRAM_LINK_URL.getPageUrl());
        urlsList.add(MyPageUrl.YOUTUBE_LINK_URL.getPageUrl());
        urlsList.add(MyPageUrl.GOOGLE_PLUS_LINK_URL.getPageUrl());
        return urlsList;
    }
}
