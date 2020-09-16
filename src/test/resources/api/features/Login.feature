Feature: To test the Login API features

  @User
  Scenario Outline: To verify the login functionality of a customer
    Given A customer with "<userid>" and "<password>"
    When Verify the response code "<code>"
    Then Verify token is successfully created
    
     
   Examples:
   
   | userid | password | code |
   | test1 | pass123$ | 200 |
   
@Admin
  Scenario Outline: To verify the login functionality of a admin
    Given A customer with "<userid>" and "<password>"
    When Verify the response code "<code>"
    Then Verify token is successfully created
   
   Examples:
   
   | userid | password | code |
   | johnnyi | Welcome | 200 |