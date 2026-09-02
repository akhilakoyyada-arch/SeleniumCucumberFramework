
  @LoginOrangeHRM @Regression_OrangeHRM
  Feature: Login
    @LoginOrangeHRM
    Scenario Outline: Validating the Login page of OrangeHRM
      Given Launch and login to OrangeHrm application <testcaseID>

      Examples:
      | testcaseID        |
      | HRM_TC001_Login   |
