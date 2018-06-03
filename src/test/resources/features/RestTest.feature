@Rest
Feature: rest tests

  @Test
  Scenario Outline: 0002 - REST navigates to main page
    Then send request to <url> url
    Then page status code is <statusCode>
    Examples:
      | url                        | statusCode |
      | http://alexanderbakhin.com | 200        |

  @Test
  Scenario Outline: 0002 - REST navigates to support page
    Then send request to <url> url
    Then page status code is <statusCode>
    Examples:
      | url                                | statusCode |
      | http://support.alexanderbakhin.com | 200        |