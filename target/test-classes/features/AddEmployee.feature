Feature: Adding Employees

  Background:
    And user is logged in with valid admin credentials
    When user clicks on PIM option
    And user clicks on add employee button

  @smoke
  Scenario: Adding employee from add employee page
    And user enters firstname middlename and lastname
    And user clicks on save button option
    Then employee is added successfully

    @smoke
  Scenario: Adding employee from add employee page via feature file
    And user enters first name "Iqra123" middle name "IDK" and last name "Iqra456"
    And user clicks on save button option
    Then employee is added successfully

      @example
      Scenario Outline: Adding employee from add employee page via feature file
        And user enters "<FirstName>" "<MiddleName>" and "<LastName>" in the application
        And user clicks on save button option
        Then employee is added successfully

        Examples:
        |FirstName|MiddleName|LastName|
        |Test0124 |MS        |Tester96|
        |Test4323 |MS        |Tester01|
        |C01      |A24       |J96     |


        @datatablewithheader
        Scenario: Adding multiple employees in a single execution
          When add multiple employees and verify they're added successfully
          |FirstName|MiddleName|LastName|
          |John0404 |MS        |US      |
          |Jack1234 |MS        |US123   |
          |Iqra1244 |IG        |testers |
          Then employee is added successfully

          @excel
          Scenario: Adding the employee from excel
            When user adds multiple employees from excel file from "newdata" sheet and verify they are added








