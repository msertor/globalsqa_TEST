Feature: Add a new customer

    Background: User must be logged in
      Given the user is logged in as Manager

    Scenario: Manager can add customer
      Given the manager is in the Add Customer section
      When the manager fills the form
      And the manager submits the form
      Then an alert saying that the customer has been successfully added pops up

    Scenario: Manager can see the added customer
      Given the manager adds a new customer
      When the manager goes to Customer tab
      Then the manager can see the new customer under Customer tab

      Scenario: Manager can delete customer
        Given the manager adds a new customer
        When the manager deletes the customer under Customer tab
        Then the new customer disappears
