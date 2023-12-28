Feature:Admin

  @smoke
  Scenario: Login with your valid credential
    Given User launch chrome browser
    When User open url "https://admin-demo.nopcommerce.com/login"
    When User enter Email as "admin@yourstore.com" and password as "admin"
    When User click on login button
    Then User verify page title should be "Dashboard / nopCommerce administration"
    Then Close browser
  
   Scenario: Login with your invalid credential
    Given User launch chrome browser
    When User open url "https://admin-demo.nopcommerce.com/login"
    When User enter Email as "admin123@yourstore.com" and password as "admin123"
    When User click on login button
    Then User verify page title should be "Dashboard / nopCommerce administration"
    Then Close browser
    
  @sanity
   Scenario Outline: Login data driven 
    Given User launch chrome browser
    When User open url "https://admin-demo.nopcommerce.com/login"
    When User enter Email as "<email>" and password as "<password>"
    When User click on login button
    Then User verify page title should be "Dashboard / nopCommerce administration"
    Then Close browser
    
   Examples:
    
  |email                  |password|
  |admin@yourstore.com    |admin  |
  |admin123@yourstore.com |admin123| 