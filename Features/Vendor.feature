Feature: Vendor

  @regression
  Scenario: Login with your valid credential
    Given User launch chrome browser
    When User open url "https://admin-demo.nopcommerce.com/login"
    When User enter Email as "admin@yourstore.com" and password as "admin"
    When User click on login button
    Then User verify page title should be "Dashboard / nopCommerce administration"
    Then Close browser.