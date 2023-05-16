
@SignIn
Feature: SignIn
  
	
  @LoginWithInvalidUserDetails
  Scenario Outline: User entered invalid login details on Login Page
  	
  	Given User is on Home Page of DS Algo Portal
  	When User clicks on signIn link on Home page
  	Then User is navigated to Login Page title as "Login"
    When User entered login details from sheet "<SheetName>" and <RowNumber> 
    Then Error message is displayed

    Examples: 
    	| SheetName  | RowNumber |
      | SignIn |    0 |
      | SignIn |    1 |
      
  @LoginWithValidUserDetailsAndLogOut
  Scenario Outline: User entered valid login details on Login Page
  
    When User entered Username as "<username>" and Password as "<Password>"
    Then Success message is displayed
    And  User is navigated to Home page of DsAlgo Portal
    When User clicks on signOut link on Home page
    Then Message will be displayed as "Logged out successfully"

    Examples: 
      | username | Password | 
      | SDET108@numpy.com| abcd@1234|
      
 
      
   
     
      
  
     
      
