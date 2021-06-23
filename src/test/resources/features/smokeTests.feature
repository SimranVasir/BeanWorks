@smokeTests
Feature: BeanWorks smoke tests

  Scenario:  user registration new username
    Given the user goes to Parabank website
    And the user clicks register button on main page
    And the user fills in registration form with randomUser
    And the user submits registration form
    Then user should see successful registration message on next page
    And the user logs out

  Scenario Outline:  user registration old username
    Given the user goes to Parabank website
    And the user clicks register button on main page
    And the user fills in registration form with <existingUsername>
    And the user submits registration form
    Then the user should see a user already exists registration error
    Examples:
      | existingUsername |
      | simranv          |

  Scenario:  user registration empty username
    Given the user goes to Parabank website
    And the user clicks register button on main page
    And the user fills in registration form with emptyUser
    And the user submits registration form
    Then the user should see a username required error message

  Scenario Outline:  user logs in
    Given the user goes to Parabank website
    And the user logs in with username <username> and password <password> and clicks login
    Then the user should arrive on Accounts page
    Examples:
      | username | password |
      | simranv  | test1234 |

