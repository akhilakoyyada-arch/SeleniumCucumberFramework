
@API_test @BookingID
Feature: Booking ID
  @API_test
  Scenario Outline: Validating the Booking ID of Restful Booker API
    Given Launch and login to Restful Booker API <testcaseID>

    Examples:
      | testcaseID        |
      | API_TC001_BookingID |