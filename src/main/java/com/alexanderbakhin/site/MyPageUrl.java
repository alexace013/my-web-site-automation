package com.alexanderbakhin.site;

import lombok.AllArgsConstructor;
import lombok.Getter;
import controller.PropertyController;

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
}
