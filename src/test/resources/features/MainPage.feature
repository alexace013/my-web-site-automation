@MainPage
Feature: Main Page tests

  Scenario Outline: 0001 - navigates to main page
    Given user opens <main> page
    Then user is navigated to <main> page
    Examples:
| main                        |
| http://alexanderbakhin.com/ |