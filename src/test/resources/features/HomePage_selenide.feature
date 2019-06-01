@SelenideHomePage
@Debug
Feature: Home Page tests on Selenide

  Background: open home page
    Given user opens "http://alexanderbakhin.com/" page on Selenide

  Scenario: 0001 - navigates to home page
    Then user is navigated to "http://alexanderbakhin.com/" page on Selenide

  Scenario Outline: 0002 - check 'download resume' button link on Selenide
    When user clicks on DOWNLOAD RESUME button on Selenide
    Then user is switched in new tab to <google drive resume url> url on Selenide

    Examples:
      | google drive resume url                                                |
      | https://drive.google.com/file/d/1SZAIO2978XL0arryh19Wumsag7W0eD1_/view |