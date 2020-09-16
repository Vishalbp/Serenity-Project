Feature: To test the Create Loan API features

  @Create_Loan
  Scenario Outline: To verify the admin is able create new loan
    Given A customer with "<userid>" and "<password>"
    When Verify the response code "<code>"
    Then Admin adds new loan "<addressLine1>", "<addressLine2>", "<borrowerName>", "<city>", "<zipcode>", "<legalDocuments>", "<loanType>", "<loanAmount>" and "<loanTerm>"
    And Verify Admin is able to successfully create the loan "<code>"

    Examples: 
      | userid | password | code | addressLine1 | addressLine2  | city    | zipcode | legalDocuments | loanType      | loanAmount | loanTerm |
      | test1  | pass123$ |  200 | Flat No 1    | George Street | Newyork |  700052 | Payslip        | Personal Loan |     250000 | 24 |

