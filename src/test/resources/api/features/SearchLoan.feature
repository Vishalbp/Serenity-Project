Feature: To test the Search Loan API features

  @Search_Loan
  Scenario Outline: To verify the admin is able create new loan
    Given A customer with "<userid>" and "<password>"
    When Verify the response code "<code>"
    Then Search loan "<borrowerFirstName>", "<borrowerLastName>", "<loanId>" and "<loanAmount>"
    And Verify user is able to successfully search the loan "<code>"

    Examples: 
      | userid | password | code | borrowerFirstName | borrowerLastName | loanId | loanAmount |
      | johnnyi | Welcome | 200 |  |  | 28122 | 45000 |

