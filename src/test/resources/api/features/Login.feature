Feature: To test the Login API features

  @User
  Scenario Outline: To verify the login functionality of a user
    Given A customer with "<userid>" and "<password>"
    When Verify the response code "<code>"

    Examples: 
      | userid   | password | code |
      | abinayar | Welcome  |  200 |

  @UserNegTestCase
  Scenario Outline: To verify the login functionality of a user fails with invalid credentials
    Given A customer with "<userid>" and "<password>"
    When Verify the response code "<code>"

    Examples: 
      | userid   | password | code |
      | abinayar | Test     |  401 |

  @Admin
  Scenario Outline: To verify the login functionality of a admin
    Given A customer with "<userid>" and "<password>"
    When Verify the response code "<code>"
    Then Verify token is successfully created

    Examples: 
      | userid  | password | code |
      | johnnyi | Welcome  |  200 |

  @AdminNegTestCase
  Scenario Outline: To verify the login functionality of a admin fails with invalid credentials
    Given A customer with "<userid>" and "<password>"
    When Verify the response code "<code>"

    Examples: 
      | userid | password | code |
      | test   | Welcome  |  401 |
