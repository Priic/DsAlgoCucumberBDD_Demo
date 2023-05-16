Feature: Array Page

@ArrayPage
    Scenario Outline: User validate dropbox
    
    Given The User is on practice page of data Structure
    When The user select "<option>"  from dropbox menu 
    When user is navigate to "Array" Page
    Examples:
     | option  |
     | Array |  
    @ArrayPagePythonCodeValidation
     Scenario Outline: User validate ArrayPage

      Then User click "<topiclist>" link on Array page
      And  User clicks Try Here button of selected topic
      When User Enter valid Python code in tryEditor from  "<ValidPythoncode>" for topics in Array and click Run button
      Then User should be presented with the Run output for valid Python code and massege for Array Page 
      When User Enter Invalid Python code in tryEditor from  "<InValidPythoncode>" for topics in Array and click Run button
      Then User should be presented with alert and no runOutput for Invalid Python code for Array Page 
    	And User navigate back to Array topic list
  
   
    Examples: 
   |topiclist        |ValidPythoncode|InValidPythoncode|
   |Arrays in Python |print 'Arrays in Python'|print Arrays in Python|
   |Arrays Using List|print 'Arrays Using List'|error Arrays Using List|
   |Basic Operations in Lists|print 'Basic Operations in Lists'|error Basic Operations in Lists|
   |Applications of Array|print 'Applications of Array'|error Applications of Array|
   
  @ArrayPagePracticePage	 
    Scenario:  PracticeQuestion Page
    When user click on practice Question
    Then User will be navigated to Practice Question  Array page  as "Practice Questions" 
 
    Scenario Outline: User validate PracticeQuestion Array Page
     Then User click "<Links>" on practice question Array page
     Then User should clear textcode in tryEditor
     When User entered valid Python code in tryEditor  "<SheetName>" and <RowNumber> and click Run button
     Then User should be presented with the Run output for valid Python code and massege for Array Page 
     And User navigate back to Array topic list
    	
    	Examples:
    	|Links| SheetName  |RowNumber|
      |Search the array | PythonCode |0|
      |Max Consecutive Ones| PythonCode |1|                  
      |Find Numbers with Even Number of Digits| PythonCode |2|
      |Search the array  Squares of  a Sorted Array| PythonCode |3|

    
   
   