
#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
 
Feature: Login to Facebook
Keywords Summary: This test is testing login related scenraion on facebook

Scenario: Login with valid credentials
Given User navigate to Facbook.com
When User enter username as "USER" and password as "Password" 

And user click on login button
Then Login should be successful

Scenario: Login with invalid credentials
Given User navigate to Facbook.com
When User enter username as "USER1" and password as "Password1" 

And user click on login button
Then Login should not be successful
 