@Rest
Feature: rest tests

  Scenario Outline: 0002 - REST navigates to page
    Then send request to <url> url for my web site
    Then status code is <statusCode>
    Examples:
      | url                                              | statusCode |
      | http://alexanderbakhin.com                       | 200        |
      | http://support.alexanderbakhin.com               | 200        |
      | http://alexanderbakhincom.s46.yourdomain.com.ua/ | 200        |

  Scenario Outline: 0010 - REST navigates to page
    Then send request to <url> url
    Then status code is <statusCode>
    Examples:
      | url                                                                    | statusCode |
      | https://drive.google.com/file/d/1SZAIO2978XL0arryh19Wumsag7W0eD1_/view | 200        |
      | https://drive.google.com/open?id=0B8WfFN21TEWubXlKQ1FEWGxWcGM          | 404        |