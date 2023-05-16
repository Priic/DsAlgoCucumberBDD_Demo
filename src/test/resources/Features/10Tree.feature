Feature: Tree

      
	@TreePagePythonCodeValidation
	Scenario: User navigate to Tree Page for selected Topic  and click on Try Here button
	
	Given The User is on practice page of Queue 		
	When The user select "Tree"  from homepage dropDown menu
	Then User will be navigated to Tree page title as "Tree"
	
	Scenario Outline: User click on Try Here button and enter valid and invalid python code in tryEditor for Tree
	
	When User click "<option>" to select topics covered on Tree page
#	Then User is navigated to Tree selected topics page
	When User clicks Try Here button in the Tree of selected topic page
	Then User should be redirected tryEditor page title as "Assessment" with a Run button to test Python code 
	When User Enter valid Python code in tryEditor from  "<ValidPythoncode>" for Tree topic and click Run button
  Then User should be presented with the Run output for valid Python code and Message for for Tree Page 
  When User Enter Invalid Python code in tryEditor from  "<InValidPythoncode>" for Tree topic and click Run button
  Then User should be presented with alert and no runOutput for Invalid Python code for Tree Page 
	And User navigate back to Tree page of selected topic	
		
			
   
   Examples: 
   |option|ValidPythoncode|InValidPythoncode|
   |Overview of Trees|print 'Overview of Trees'|error Overview of Trees|
   |Terminologies|print 'Terminologies'|error Terminologies|
   |Types of Trees|print 'Types of Trees'|error Types of Trees|
   |Tree Traversals|print 'Tree Traversals'|error Tree Traversals|
   |Traversals-Illustration|print 'Traversals-Illustration'|error Traversals-Illustration| 
   |Binary Trees|print 'Binary Trees'|error Binary Trees|
   |Types of Binary Trees|print 'Types of Binary Trees'|error Types of Binary Trees|
   |Implementation in Python|print 'Implementation in Python'|error Implementation in Python|
   |Binary Tree Traversals|print 'Binary Tree Traversals'|error Binary Tree Traversals|
   |Implementation of Binary Trees|print 'Implementation of Binary Trees'|error Implementation of Binary Trees|
   |Applications of Binary trees|print 'Applications of Binary trees'|error Applications of Binary trees|
   |Binary Search Trees|print 'Binary Search Trees'|error Binary Search Trees|
   |Implementation Of BST|print 'Implementation Of BST'|error Implementation Of BST|
   
  	
	Scenario: User navigate back to selected Tree Topic Page and try Practice Question Page
  
  #	Given  User is on Tree page of selected topic  
			 
    When  User clicks Practice Questions Page on Tree Page
    Then User should be redirected to a Practice Questions Page of selected Tree Topic Page
    
   
   
   
  
   