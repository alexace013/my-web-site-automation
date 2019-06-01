@SupportPage
@Debug
Feature: Support Page tests on Selenide

  Background: open support page
    Given user opens "http://support.alexanderbakhin.com/" page on Selenide

  Scenario: 0001 - navigates to support page
    Then user is navigated to "http://support.alexanderbakhin.com/" page on Selenide