@SupportPage
Feature: Support Page tests

  Scenario Outline: 0003 - navigates to support page page
    Given user opens <support> page
    Then user is navigated to <support> page
    Examples:
      | support                             |
      | http://support.alexanderbakhin.com/ |