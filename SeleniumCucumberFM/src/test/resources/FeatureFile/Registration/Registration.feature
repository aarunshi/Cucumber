
Feature: Registration
@before (order=1
  @sanity @regression
  Scenario Outline: Register user
   Given Navigate to application
    When User Click on sign in link
    And Enter Registration email id
    And Click on open account 
    Then Registration form open
    And Select Mr radio button
    And Enter first Name "<firstName>"
    And Enter last Name "<lastName>"
    And Enter password "<password>"
    And Select a Day "<day>"
    And Select a month "<month>"
    And Select a year "<year>"
    And Enter your address first Name "<addressFirstName>"
    And Enter your address last Name "<addressLastName>"
    And Enter your company Name "<companyName>"
    And Enter Address "<address>"
    And Select city "<city>"
    And Select state "<state>"
    And Select country "<country>"
    And Enter Zipcode "<zipcode>"
    And Enter mobile phone number "<mobilePhoneNumber>"
    And Select Address alias "<addressAlias>"
    And Click on registration button
    Then Verify Registration successfull message

    Examples: 
      | firstName | lastName |password | day | month| year| addressFirstName| addressLastName | companyName | address  | city  | state   | country | zipcode | mobilePhoneNumber | addressAlias |
    | aarunshi  | takkar   | success  |   4 | March | 2001 | aarunshi         | takkar    | BS          | antriksh | noida | Arizona | india   |  200101 |        9999999999 | home         |
      | aarunshi  | malhotra | success  |   4 | March | 2001 | aarunshi         | takkar          | BS          | antriksh | noida | Arizona | india   |  200101 |        9999999999 | home         |
