@SupportPage
Feature: Support Page tests

  Background: navigates on support page
    Given user opens http://support.alexanderbakhin.com/ page

  Scenario: 0003 - checks that is support page
    Then user is navigated to http://support.alexanderbakhin.com/ page
#    And recheck support page url

  Scenario: 0008 - click on 'test button' on support page and navigates on broken page
    When user clicks on TEST button
    Then user is navigated to "https://drive.google.com/open?id=0B8WfFN21TEWubXlKQ1FEWGxWcGM" page

  Scenario: 0009 - checks 'test' text on support page
    Then user checks test text on support page