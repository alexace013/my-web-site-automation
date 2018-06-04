@Rest
Feature: rest tests

  Scenario Outline: 0002 - REST navigates to page
    Then send request to <url> url
    Then status code is <statusCode>
    Examples:
      | url                                | statusCode |
      | http://alexanderbakhin.com         | 200        |
      | http://support.alexanderbakhin.com | 200        |