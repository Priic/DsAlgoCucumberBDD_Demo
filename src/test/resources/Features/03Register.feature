
	@RegisterPageValidation
	Feature: Register Page validation
	
	@NavigateToRegisterPage
	
		Scenario: User click register button on Home page
		
		Given User is on Home Page of DS Algo Portal
    When The user clicks the Register button on Home page 
    Then The User will be navigated to Register Page with title as "Registration"
	
	@Register_AllfieldsBlank
	Scenario: User click register button with all fields blank
	
	#	Given User is on Register page of dsAlgo Portal
    When The user clicks the Register button on register page with all fields value empty
    Then Error message is displayed "Please fill out this field. below Username textbox"
   
    
 	@Register_PasswordFieldsBlank
	Scenario: User click on register button with Password field blank 
		
	#	Given User is on Register page of dsAlgo Portal
    When The user clicks the Register button on register page with valid Username and Password fields value empty
    Then Error message is displayed "Please fill out this field. below Password textbox"
    
    
  @Register_ConfirmPasswordFieldsBlank
	Scenario Outline: User click on register button with valid Username & Password and confirm Password field as blank 
	
	#	Given User is on Register page of dsAlgo Portal
    When The user clicks the Register link on register page with Password as "<Password>" confirmPassword fields value empty
    Then Error message is displayed "Please fill out this field. below confirm Password textbox"
    
    Examples: 
      | Password  |
      | abcd@1234 |
	
  @RegisterPage_invalidUserData
  Scenario Outline: The user is on Register Page and entered invalid user Details
  
 #		Given User is on Register page of dsAlgo Portal
 		When User enter Invalid signUp details on register page from given sheetname "<SheetName>" and <RowNumber> 
    And The user clicks Register button 
    Then  Registration failed and error message is displayed  
    

    Examples: 
      | SheetName  | RowNumber |
      | RegisterPage |    0 |
      | RegisterPage |    1 |
      | RegisterPage |    2 |
      | RegisterPage |    3 |
      
     
      
    @RegisterPage_validUserData
  	Scenario Outline: The user opens Register Page and entered valid user Details
  
 	#	Given User is on Register page of dsAlgo Portal
 		When User enter Valid signUp details on register page UserName , Password as "<Password>" and ConfirmPassword as "<ConfirmPassword>"
    And The user clicks Register button 
    And  User will be navigated to Home page of DS Algo
    Then successMessage will be displayed "New Account Created. You are logged in as"
    
    
     Examples: 
      |Password| ConfirmPassword| 
      |abcd@124|abcd@124|
     
 	@LogoutAfterRegistration
		
		Scenario: User logout from application after registration
		
		When User clicks on signOut link on Home page
    Then Message will be displayed as "Logged out successfully"
