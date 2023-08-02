Feature: This is a feature file for Creating an user

  @Smoke @functional
  Scenario Outline: TCS1
    #To give a email id to create a user

    Given The user is in Home Page
    When The user clicks on  Signup / Login in Home Page
    Then The user should be navigated to Signup / Login Page
    When The user enters the <Name> and <Email Address> in Signup / Login Page
    And  The user clicks on Signup in Signup / Login Page
    Then The user should be navigated to Signup Page
    When The user enters the following <Account Information> in Signup Page
      | Title | Name          | Email           | Password       | Date of Birth | Sign up for our newsletter! | Receive special offers from our partners! |
      | Mrs   | Lakshmi Mohan | Lakshmi4@abc.com | myPassword@123 | 04/25/1988    | true                        | false                                     |
      | Mr    | Srinath Mohan | Srinath4@abc.com | myPassword@123 | 05/25/1988    | false                       | true                                      |
    And The user enters the following <Address Information> in Signup Page
      | First name | Last name | Address | Address 2    | Country       | State   | City  | Zipcode | Mobile Number |
      | Lakshmi    | Mohan     | 9811    | Fan Palm Way | United States | Florida | Tampa | 33610   | 7026052830    |
      | Srinath    | Mohan     | 9811    | Fan Palm Way | United States | Florida | Tampa | 33610   |  7026052830    |
    And The user clicks on Create Account in Signup Page
    Then The user should be navigated to Account Created Page
    And  ACCOUNT CREATED! should be visible in Account Created Page
    When The user clicks on Continue in Account Created Page
    Then The user should be navigated to Home Page
    And Logged in as <Name> should be visible in Home Page
    When The user clicks on  Delete Account in Home Page
    Then  ACCOUNT DELETED! should be visible in Account Created Page

    Examples:
      | Name          | Email Address   | Account Information | Address Information |
      | Lakshmi Mohan | Lakshmi4@abc.com | 1                   | 1                   |
      | Srinath Mohan | Srinath4@abc.com | 2                   | 2                   |