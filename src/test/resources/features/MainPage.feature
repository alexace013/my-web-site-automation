@MainPage
Feature: Main Page tests

  @Test
  Scenario Outline: 0001 - navigates to main page
    Given user opens browser
    When user navigates to <main> page
    Then user is navigated to <main> page
    And page status code is <statusCode>
  Examples:
  | main                        | statusCode |
  | http://alexanderbakhin.com/ | 200        |
