Feature: Queue


	@QueuePagePythonCodeValidation
	Scenario: User navigate to Queue Page for selected Topic and click on Try Here button
	
	Given The User is on practice page of Stack 		
	When The user select "Queue"  from homepage dropDown menu
	Then User will be navigated to Queue page title as "Queue"
	
	Scenario Outline: User click on Try Here button and enter valid and invalid python code in tryEditor for Queue
	
	When User click "<option>" to select topics covered on Queue page
#	Then User is navigated to Queue selected topics page
	When User clicks Try Here button in the Queue of selected topic page
	Then User should be redirected tryEditor page title as "Assessment" with a Run button to test Python code 
	When User Enter valid Python code in tryEditor from  "<ValidPythoncode>" for Queue topic and click Run button
  Then User should be presented with the Run output for valid Python code and Message for for Queue Page 
  When User Enter Invalid Python code in tryEditor from  "<InValidPythoncode>" for Queue topic and click Run button
  Then User should be presented with alert and no runOutput for Invalid Python code for Queue Page 
	And User navigate back to Queue page of selected topic	
		
			
   
   Examples: 
   |option|ValidPythoncode|InValidPythoncode|
   |Implementation of Queue in|print 'Queue Implementation'|error Queue Implementation|
   |Implementation using collections.deque|print 'Implemenation using collections.deque'|error Implemenation using collections.deque|
   |Implementation using array|print 'Implemenation using Array'|error Implemenation using Array|
   |Queue Operations|print 'Queue Operations'|error Queue Operations|
   
   
  	
	Scenario: User navigate back to selected Queue Topic Page and try Practice Question Page
  
  #	Given  User is on Data Structure page of selected topic  
			 
    When  User clicks Practice Questions Page on Queue Page
    Then User should be redirected to a Practice Questions Page of selected Queue Topic Page
    
   
   
   
  
   