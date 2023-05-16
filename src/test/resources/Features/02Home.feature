@HomePageValidation
Feature: Home Page
		

@01homePageClickGetStarted/dropdownbox_WithoutSignin
  Scenario Outline: User is on Home page and click getstarted link/dropbox on  home page without sign in
  
  	When The user clicks on Get Started link on homepage "<option>" without login
    Then The user get warning message "You are not logged in"
    When The user select options from dropbox menu on homepage "<option>" without login
    Then The user get warning message "You are not logged in"
    
    Examples: 
      | option  |
      | Array |  
      