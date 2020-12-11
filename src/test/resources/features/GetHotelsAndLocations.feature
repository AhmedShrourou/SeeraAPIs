@get_hotels_and_locations
Feature: Verify Get Hotels and Location API.

  Scenario Outline: Verify Get Hotels And Locations API Response Code.
    Given From Hotels API, Set <query_value> For Query.
    When From Hotels API, Call Get Hotels API.
    Then Verify API 200 Status Code.
    Examples:
      |query_value|
      |Paris|

  Scenario Outline: Verify Get Hotels And Locations API Response Based On Query.
    Given From Hotels API, Set <query_value> For Query.
    When From Hotels API, Call Get Hotels API.
    Then Verify That <query_value> Returned Under Hotels List.
    Examples:
      |query_value|
      |Paris|

