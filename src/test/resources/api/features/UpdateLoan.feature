Feature: To test the Update Loan API features

  @Update_Loan
  Scenario Outline: To verify the admin is able update existing loan
    Given A customer with "<userid>" and "<password>"
    When Verify the response code "<code>"
    Then Admin updates loan "<legalDocuments>", "<loanType>", "<loanAmount>", "<loanTerm>" and "<loanId>"
    And Verify Admin is able to successfully update the loan "<loanId>"

    Examples: 
      | userid | password | code | legalDocuments | loanType | loanAmount | loanTerm | loanId |
      | johnnyi  | Welcome |  200 | Payslip | Personal Loan | 250000 | 24 | 27396 |

