

Feature: Login to application
  

 
  Scenario: Login to application
    Given Navigate to application    
    When User Click on sign in link
    And Enter email address as "testuser@gmail.com"
    And Enter password as "password"
    And Click on Login Button
    Then Login is successful
    

