Feature:
  As a online cutomer
  I want to shop through my account

  Background:
    Given I have navigated to the online page
    And I login to my account

  @onlineShopping
  Scenario: Order a shirt online
    When I order a shirt
    Then I should see that my order is exist in orderhistory



