#Author: Sai Krishna
Feature: multiplication

  Scenario: Multiplication of two number
    Given I have two variable "9" & "12"
    When I do multiplica  tion
    Then result should display in console

  Scenario: Multiplication with two numbers with
    Given I have two variables as below list
      |  8 |
      | 10 |
    When I do multiplication
    Then result should display in console
	
	Scenario: Addition of three numbers
		Given I have three variables "5" & "3" & "4"
		When I do sum
		Then print sum of three variables
	
	Scenario: Multiplication of four number with List
    Given I have Four variables as below Map
      | num1 | 80 |
      | num2 | 10 |
      | num3 | 11 |
      | num4 | 12 |
    When I do multiplication with multiple variable
    Then result should display in console