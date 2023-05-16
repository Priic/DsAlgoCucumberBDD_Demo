Feature: Stack


	@StackPage
	Scenario: User navigate to Stack Page for selected Topic 
		
	Given The User is on practice page of LinkedList 	
	When The user select "Stack"  from homepage dropDown menu
	Then User will be navigated to Stack page title as "Stack"
	
	@StackPagePythonCodeValidation
	Scenario Outline: User click on Try Here button and enter valid and invalid python code in tryEditor for Stack
	
	When User click "<option>" to select topics covered on Stack page
#	Then User is navigated to Stack selected topics page
	When User clicks Try Here button in the  Stack of selected topic page
	Then User should be redirected tryEditor page title as "Assessment" with a Run button to test Python code 
	When User Enter valid Python code in tryEditor from  "<ValidPythoncode>" for Stack topic and click Run button
  Then User should be presented with the Run output for valid Python code and Message for for Stack Page 
  When User Enter Invalid Python code in tryEditor from  "<InValidPythoncode>" for Stack topic and click Run button
  Then User should be presented with alert and no runOutput for Invalid Python code for Stack Page 
	And User navigate back to Stack page of selected topic	
		
			
   
   Examples: 
   |option |ValidPythoncode|InValidPythoncode|
   |Operations in|print 'Operations in Stack'|error  Operations in Stack|
   |Applications|print 'Applications in Stack'|error Applications in Stack|
   |Implementation|print 'Implementation in Stack'|error Implementation in Stack|
   
  @StackPagePracticePage	
	Scenario: User navigate back to selected Stack Topic Page and try Practice Question Page
  
  #	Given  User is on Data Structure page of selected topic  
			 
    When  User clicks Practice Questions Page on Stack Page
    Then User should be redirected to a Practice Questions Page of selected Stack Topic Page
    
   
   
   
  
   