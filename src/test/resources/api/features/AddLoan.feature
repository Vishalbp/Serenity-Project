Feature: To test the Create Loan API features

  @Create_Loan
  Scenario Outline: To verify the admin is able create new loan
    Given A customer with "<userid>" and "<password>"
    When Verify the response code "<code>"
    Then Admin adds new loan "<legalDocuments>", "<loanType>", "<loanAmount>" and "<loanTerm>"
    And Verify Admin is able to successfully create the loan "<code>"

    Examples: 
      | userid | password | code | legalDocuments | loanType | loanAmount | loanTerm |
      | johnnyi  | Welcome |  200 | Payslip | Personal Loan | 250000 | 24 |

