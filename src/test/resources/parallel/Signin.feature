Feature: Signin feature
  Background:
    Given user is on home page

  Scenario Outline: Successful user login
    When user enter "<UserName>" and "<Password>" to signin
    And user click on Login button
    Then user gets title of the page
    And page title should be "ParaBank | Accounts Overview"
    Examples:
      | UserName | Password |
      |test01    |testUser@01|
      |test02    |testUser@02|