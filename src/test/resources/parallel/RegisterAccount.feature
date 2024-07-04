Feature: Register new account
  Background:
    Given user is on home page

  Scenario Outline: Successful account registration
    When user navigate to register account page
    And user enter "<FirstName>" and "<Lastname>"
    And user enters "<Address>" "<City>" "<State>" and "<Zipcode>"
    And user enters "<PhoneNumber>" and "<SSN>"
    And user enters valid "<Username>" and "<Password>"
    And user confirm password as "<Password>"
    And user click on Register button
    Then user gets title of the page
    And page title should be "ParaBank | Customer Created"
    Examples:
      | FirstName | Lastname | Address | City | State | Zipcode | PhoneNumber | SSN | Username | Password |
      |TestUser   |001       |Munnekollal|Bangalore|Karnataka|560037|9687012345|009812|test01  |testUser@01|
      |TestUser   |002       |Tondiarpet |Chennai  |Tamilnadu|600081|9012345678|091234|test02  |testUser@02|
      |TestUser   |003       |Porur      |Chennai  |Tamilnadu|600087|8234567190|008123|test03  |testUser@03|

  Scenario: Successful Account Registration with random data
    When user navigate to register account page
    And user enter user details
    And user click on Register button
    Then user gets title of the page
    And page title should be "ParaBank | Customer Created"
