Feature:Customer 

@regression
Scenario Outline: Add New Customer
    Given User launch chrome browser
    When User open url "https://admin-demo.nopcommerce.com/login"
    When User enter Email as "<email>" and password as "<password>"
    When User click on login button
    Then User can view Dashboard	
    When User click on customers menu
    And  User click on customers menu item
    And User click on Add new button
    Then User can view add new customer page
    When User enter customer info as "<newEmail>" and "<newpass>" and "<fname>" and "<lname>" and "<gender>" and "<comname>" and "<comment>"
    And User click on save button
    Then User can view confirmation msg "The new customer has been added successfull."   
    Then Close browser
    
   Examples: 
    
  |email|password|newEmail|newPass|fname|lname|gender|ComName|admincomment|
  |admin@yourstore.com|admin|raj12@gmail.com|1234|Kavya|Kotkar|Female|ABC|Test|
  |admin@yourstore.com |admin|radhlika13@gmail.com|4537|Gaurav|Kotkar|Male|XYZ|Test1|
  
  
  
  