@GetStartedPage
Feature: GetStart Page

Scenario: User launch Start page of an dsalgo project
  
  	
  	Given The User launches the Chrome browser
    When The user opens DS Algo portal link 
    And The user clicks the Get Started button 
    Then The user should be redirected to homepage with page title as "NumpyNinja"
