@SelenideSupportPage
@Debug
Feature: Support Page tests on Selenide

  Background: open support page
    Given user opens "http://support.alexanderbakhin.com/" page on Selenide

  Scenario: 0016 - navigates to support page on Selenide
    Then user is navigated to "http://support.alexanderbakhin.com/" page on Selenide

  Scenario: 0017 - click on 'test button' on support page and navigates on broken page on Selenide
    When user clicks on TEST button on Selenide
    Then user is navigated to "https://drive.google.com/open?id=0B8WfFN21TEWubXlKQ1FEWGxWcGM" page on Selenide

  Scenario: 0018 - checks 'test' text on support page on Selenide
    Then user checks test text on support page on Selenide