@book_apartment
Feature: Verify Book Apartment API.

  Scenario: Verify Book Apartment API Response Code.
    Given From Booking API, Set API Body.
    When From Booking API, Call Book Rooms API.
    Then Verify API 200 Status Code.

  Scenario: Verify Book Apartment API Response Body.
    Given From Booking API, Set API Body.
    When From Booking API, Call Book Rooms API.
    Then Verify Book Apartment API Response Body.
