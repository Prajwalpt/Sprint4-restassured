@api
Feature: Customer Service API
  Background:
    Given Customer service is available

  Scenario: View customer list
    When I view customer list
    Then the response status should be 200
    And the response body should not be empty

  Scenario: View customer by known id
    When I view customer by id from "customerId1" in "known.json"
    Then the response status should be 200
    And the response body should not be empty

  Scenario: View customer by known mobile
    When I view customer by mobile from "mobile1" in "known.json"
    Then the response status should be 200
    And the response body should not be empty

  Scenario: Add a new customer with default data
    When I add a new customer with default data
    Then the response status should be 200
    And the response body should not be empty

  Scenario: Delete customer by known id
    When I delete customer by id from "customerId2" in "known.json"
    Then the response status should be 200
    And the response body should not be empty
