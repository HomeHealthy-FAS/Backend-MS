Feature: collaborator feature

  Scenario: a collaborator creates an account
    Given the collaborator insert valid attributes
    When the collaborator clicks the create button
    Then a new account is created

  Scenario: A collaborator updates its information
    Given the collaborator already has an account created
    And and the collaborator wants to update its information
    When the collaborator inserts the new information
    Then the information of its account is updated

  Scenario: A collaborator wants to delete its account
    Given the collaborator already has an account created
    And and the collaborator wants to delete its account
    When the collaborator clicks the "delete account" button
    Then the account is set as "DELETED" on the database
