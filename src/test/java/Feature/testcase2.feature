Feature:
  As a online cutomer
  I want to edit my account details

  Background:
    Given I have navigated to the online shopping page
    And I login to my account to change my account details

  @onlineShopping1
  Scenario: Change forename
    Given I have navigated to the my profile page
    When I change my account forename
    Then the success message should to be appeared
    And I should  see that profile is updated

