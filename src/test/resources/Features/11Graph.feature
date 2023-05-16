Feature: Graph


      
	@GraphPagePythonCodeValidation
	Scenario: User navigate to Graph Page for selected Topic and click on Try Here button
	
	Given The User is on practice page of Tree 	
	When The user select "Graph"  from homepage dropDown menu
	Then User will be navigated to Graph page title as "Graph"
	
	Scenario Outline: User click on Try Here button and enter valid and invalid python code in tryEditor for Graph
	
	When User click "<option>" to select topics covered on Graph page
#	Then User is navigated to Graph selected topics page
	When User clicks Try Here button in the  Graph of selected topic page
	Then User should be redirected tryEditor page title as "Assessment" with a Run button to test Python code 
	When User Enter valid Python code in tryEditor from  "<ValidPythoncode>" for Graph topic and click Run button
  Then User should be presented with the Run output for valid Python code and Message for for Graph Page 
  When User Enter Invalid Python code in tryEditor from  "<InValidPythoncode>" for Graph topic and click Run button
  Then User should be presented with alert and no runOutput for Invalid Python code for Graph Page 
	And User navigate back to Graph page of selected topic	
		
			
   
   Examples: 
   |option|ValidPythoncode|InValidPythoncode|
   |Graph|print 'Graph'|error Graph output|
   |GraphRepresentations|print 'Graph Representations'|error Graph Representations|
   
   
  	
	Scenario: User navigate back to selected Graph Topic Page and try Practice Question Page
  
  	Given  User is on graph page of selected topic  		
    When  User clicks Practice Questions Page on Graph Page
    Then User should be redirected to a Practice Questions Page of selected Graph Topic Page
    
   
   
   
  
   