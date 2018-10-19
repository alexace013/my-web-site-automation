@MainPage
Feature: Main Page tests

  Background: open main page
    Given user opens http://alexanderbakhin.com/ page

  Scenario: 0001 - navigates to main page
    Then user is navigated to http://alexanderbakhin.com/ page
    And Recheck main page url

  Scenario Outline: 0004 - check 'download resume' button link
    When user clicks on DOWNLOAD RESUME button
    Then user is switched in new tab to <google drive resume url> url
    Examples:
      | google drive resume url                                                |
      | https://drive.google.com/file/d/1SZAIO2978XL0arryh19Wumsag7W0eD1_/view |

  @ignore
  Scenario: 0005 - check message fields with validation
    When user input into field <field> next text <text>
    And user clicks on SEND button
    Then form was send successful <status>
      | field   |
      | name    |
      | email   |
      | country |
      | city    |
      | phone   |
      | message |