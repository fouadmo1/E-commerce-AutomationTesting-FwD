@smoke
Feature: users could Login with registered account

  Scenario: user could login with valid email and password
  Given user go to login page
  When user login with valid email "fouadmohamed8@gmail.com" and password "123456"
  And  user press on login button
  Then  user login to the system successfully

