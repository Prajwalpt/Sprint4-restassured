@api
Feature: Authentication for OnlineVegStore APIs
  Scenario: Obtain bearer token
    Given I request an access token
    Then I should receive a valid bearer token
