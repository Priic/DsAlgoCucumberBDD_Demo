Feature: Data Structure Intro


@Login
  	Scenario Outline: User entered valid login details on Login Page and logged in
  	
  	Given User is on Home Page of DS Algo Portal
  	When User clicks on signIn link on Home page
  	And User entered Username as "<username>" and Password as "<Password>"
    Then  User is navigated to Home page of DsAlgo Portal
   

    Examples: 
      | username | Password | 
      | SDET108@numpy.com| abcd@1234|
      
	@NavToDataStructures
	Scenario: User navigate to Data Structure Page for selected Topic and click on Try Here button
		
	When The user clicks on DataStructure GetStarted button on homepage "Data Structures-Introduction" 
	Then User will be navigated to Data Structures-Introduction page title as "Data Structures-Introduction"
	When User clicks on Time Complexity link
	Then User will be navigated to time-complexity page title as "Time Complexity"
	When User clicks Try Here button in the datastructure page 
	Then User should be redirected tryEditor page title as "Assessment" with a Run button to test Python code
	
	@DataStructurePagePythonCodeValidation
	Scenario Outline: User enter valid and invalid python code in tryEditor 
	
  When User Enter Python code in tryEditor from  "<Pythoncode>" for DataStructures topic and click Run button
  Then User should be presented with the Run output for valid Python code and Message for DataStructure Page 
	
			
   Examples: 
  	|Pythoncode|
    |print 'Data Structures-Introduction'|
    |print Data Structures-Introduction|
    
    
	Scenario Outline: User navigate to Data Structure from dropdown and try Practice Question Page
  
  #	Given  User is on Data Structure page of selected topic  
		Given User navigate back to dataStructure page of selected topic		 
    When  User clicks Practice Questions Page on DataStructure Page
    Then User should be redirected to a Practice Questions Page of selected DataStructure Topic Page
    
   
   
   
  
    