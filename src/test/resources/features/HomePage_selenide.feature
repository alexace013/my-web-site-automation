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

  Scenario Outline: 0003 - send test and generate message from home page on Selenide
    When user inputs "<name>" data in name field on Selenide
    And user inputs "<email>" data in e-mail field on Selenide
    And user inputs "<country>" data in country field on Selenide
    And user inputs "<city>" data in city field on Selenide
    And user inputs "<phone>" data in phone field on Selenide
    And user inputs "<message>" data in message textarea on Selenide
    And user clicks on SEND button on Selenide
#    Then form was sent successfully with alert "Message was sent. Thanks!" text on Selenide

    Examples:
      | name     | email         | country     | city     | phone             | message           |
      | TestName | test@mail.com | TestCountry | TestCity | +12(345)678-90-12 | Test Message Text |
#      | generate | generate      | generate    | generate | generate          | generate          |