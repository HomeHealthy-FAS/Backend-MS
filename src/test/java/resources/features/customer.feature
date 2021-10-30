Feature: customer feature

  Scenario: a customer creates an account
    Given the customer insert valid attributes
    When the customer clicks the create button
    Then a new account is created

  Scenario: A customer updates its information
    Given the customer already has an account created
    And and the customer wants to update its information
    When the customer inserts the new information
    Then the information of its account is updated

  Scenario: A customer wants to delete its account
    Given the customer already has an account created
    And and the customer wants to delete its account
    When the customer clicks the "delete account" button
    Then the account is set as "DELETED" on the database

