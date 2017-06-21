Feature:
  As a online cutomer
  I want to shop through my account

  Background:
    Given I have navigated to the online page
    And I login to my account

  @onlineShopping
  Scenario: Order a T-shirt online
    When I order a T-shirt
    Then I should see that my order is exist in orderhistory



