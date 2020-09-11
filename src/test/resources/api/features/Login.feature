@LoginFeature
Feature: To test the Login API features

  @UserLogin
  Scenario Outline: To verify the login functionality of a customer
    Given A customer with <userid> and <password>
    When User tries to login
    Then Verify the response code <code>
   
   Examples:
   
   | userid | password | code |
   | test1 | pass123$ | 200 |
   | test1 | password | 422 |
   | test2 | pass123$ | 422 |

  @AdminLogin
  Scenario Outline: To verify the login functionality of an admin user
    Given An admin user with <userid> and <password>
    When Admin tries to login
    Then Verify the response code <code>
   
   Examples:
   
   | userid | password | code |
   | Admin1 | Pass@123 | 200 |
   | Admin1 | password | 422 |
   | Admin2 | pass123$ | 422 |