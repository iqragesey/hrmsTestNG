Feature: Dashboard tabs functionality

  @dashboardtabs
  Scenario: Dashboard Tab verification
    When user enters valid admin username and password
    And user clicks on login button
    Then admin user is successfully logged in
    Then verify the following tabs on dashboard
    |Admin|PIM|Leave|Time|Recruitment|Performance|Dashboard|Directory|

