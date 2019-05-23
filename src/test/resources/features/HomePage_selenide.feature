@HomePage
@Debug
Feature: Home Page tests on Selenide

  Background: open home page
    Given user opens "http://alexanderbakhin.com/" page on Selenide

  Scenario: 0001 - navigates to home page
    Then user is navigated to "http://alexanderbakhin.com/" page on Selenide