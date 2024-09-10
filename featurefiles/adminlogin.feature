@tag
Feature: admin login
              i want to use this feature file to check admin login
              
      @tag1
      Scenario: check admin login with valid credentials
      Given i open browser with a url "http://orangehrm.qedgetech.com"
      Then i should see login page
      When i enter username as  "Admin"
      And i enter password as  "Qedge123!@#"
      And i click on login button
      Then i should see admin module
      When i click on logout
      Then i should see login page
      When i close browser
      
      @tag2
      Scenario Outline: check admin login with invalid credentials
       Given   i open browser with a url "http://orangehrm.qedgetech.com"
      Then i should see login page
      When i enter username as  "<username>"
      And i enter password as   "<password>"
      And i click on login button
      Then i should see appropriate error message
      When i close browser
      
      Examples: 
      |username|password|
      |Admin|xyz123|
      |abc|xyz|
      |||