Feature: Linked List


      
	@LinkedListPagePythonCodeValidation
	Scenario: User navigate to Linked List Page for selected Topic 
	
	Given The User is on practice page of Array
	When The user select "Linked List"  from homepage dropDown menu
	Then User will be navigated to LinkedList page title as "Linked List"
	
	Scenario Outline: User click on Try Here button and enter valid and invalid python code in tryEditor for LinkedList
	
	When User click "<option>" to select topics covered on Link List page
#	Then User is navigated to Linked List selected topics page
	When User clicks Try Here button in the  Linked List of selected topic page
	Then User should be redirected tryEditor page title as "Assessment" with a Run button to test Python code 
	When User Enter valid Python code in tryEditor from  "<ValidPythoncode>" for for LinkedList topic and click Run button
  Then User should be presented with the Run output for valid Python code and Message for for LinkedList Page 
  When User Enter Invalid Python code in tryEditor from  "<InValidPythoncode>" for for LinkedList topic and click Run button
  Then User should be presented with alert and no runOutput for Invalid Python code for LinkedList Page 
	And User navigate back to LinkedList page of selected topic	
		
			
   
   Examples: 
   |option |ValidPythoncode|InValidPythoncode|
   |Introduction|print 'LinkedList Introduction'|error LinkedList Introduction|
   |Creating Linked LIst|print 'LinkedList createLinkedList'|error LinkedList createLinkedList|
   |type of |print 'Types of Linked List'|error Types of Linked List|
   |Implement Linked|print 'Linked List Implement Linked'|error Implement Linked|
   |Traversal|print 'Linked List Traversal'|error LinkedList Traversal|
   |Insertion|print 'Linked List Insertion'|error Insertion|
   |Deletion|print 'Linked List Deletion'|error LinkedList Deletion|	
   
   @LinkedListPracticePage
  	
	Scenario: User navigate back to selected LinkedList Topic Page and try Practice Question Page
  
  #	Given  User is on Data Structure page of selected topic  
			 
    When  User clicks Practice Questions Page on LinkedList Page
    Then User should be redirected to a Practice Questions Page of selected LinkedList Topic Page
    
   
   
   
  
   