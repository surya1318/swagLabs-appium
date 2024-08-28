Feature: Login Functionality

  @Login
  Scenario Outline: Verify the Login functionality of swag labs application for valid username and password
    When user enters username as "<username>"
    When user enters password as "<password>"
    And I click on the login button
    Then Verify user should be able to land on to the "<title>" home page

    Examples: 
      | username      | password     | title    |
      | standard_user | secret_sauce | PRODUCTS |
      | problem_user  | secret_sauce | PRODUCTS |

  @Login
  Scenario Outline: Verify the Login functionality of swag labs application with lockedout username
    When user enters username as "<username>"
    When user enters password as "<password>"
    And I click on the login button
    Then I should get error message "<err>"

    Examples: 
      | username        | password     | err                                   |
      | locked_out_user | secret_sauce | Sorry, this user has been locked out. |

  