
@tag
Feature: Home Page
Background:
Given: The user opens DS Algo portal link 

  @homePageClickGetStartedWithoutSignin
  Scenario Outline: User is on Home page and click getstarted link on  home page without sign in
   	Given: User is on Home page of DsAlgo portal
    When The user clicks on Get Started link on homepage "<option>" without login
    Then The user get warning message "You are not logged in"

    Examples: 
      | option  |
      | Data Structures-Introduction | 
      
       
  
  Scenario Outline: User is on Home page and select from dropbox menu on home page without sign in
  
   	Given: User is on Home page of DsAlgo portal
    When The user select options from dropbox menu on homepage "<option>" without login
    Then The user get warning message "You are not logged in"

    Examples: 
      | option  |
      | Array |  
     
