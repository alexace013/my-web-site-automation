@HomePage

Feature: Home Page tests

  Background: open home page
    Given user opens http://alexanderbakhin.com/ page

  Scenario: 0001 - navigates to home page
    Then user is navigated to http://alexanderbakhin.com/ page
#    And recheck home page url

  Scenario Outline: 0004 - check 'download resume' button link
    When user clicks on DOWNLOAD RESUME button
    Then user is switched in new tab to <google drive resume url> url
    Examples:
      | google drive resume url                                                |
      | https://drive.google.com/file/d/1SZAIO2978XL0arryh19Wumsag7W0eD1_/view |
    
  Scenario Outline: 0005 - send test and generate message from home page
    When user inputs "<name>" data in name field
    And user inputs "<email>" data in e-mail field
    And user inputs "<country>" data in country field
    And user inputs "<city>" data in city field
    And user inputs "<phone>" data in phone field
    And user inputs "<message>" data in message textarea
    And user clicks on SEND button
    Then form was sent successfully with alert "Message was sent. Thanks!" text

    Examples:
      | name     | email         | country     | city     | phone             | message           |
      | TestName | test@mail.com | TestCountry | TestCity | +12(345)678-90-12 | Test Message Text |
      | generate | generate      | generate    | generate | generate          | generate          |

  Scenario: 0006 - check bottom links
    Then user checks urls from bottom links

  Scenario: 0007 - check copyright text and date
    Then user checks copyright text
    And copyright date is a current year
    And user checks copyright link