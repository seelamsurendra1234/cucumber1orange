@tag
Feature: check admin able to register employee or not

@tag1
Scenario: admin create employee data
Given i open a browse with url "http:orangehrm.qedgetech.com"
Then i should see login page
When i enter user name as  "Admin"
And i enter password as  "Qedge123!@#"
And i click login button
When i click on PIM
And i click on Addemployee
And i enter first name as  "sur"
And i enter last name as  "redy"
And click on save button
Then i should see employee list
And click on logout
Then i should see login page
When i close the browser
 