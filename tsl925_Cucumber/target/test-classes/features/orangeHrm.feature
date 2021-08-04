Feature: Login Function
	Scenario Outline: To do data driven Testing on Login Functionality
	Given Browser is Opened with Login Page
	When user enters "<username>", "<passWord>" & click on login button
	Then Login "<LoginType>" be happen
	
	Examples:
		|	username	|	passWord	| loginType	|
		|	admin			|	admin123	| should		|
		|	hr				|	hr123			| shouldNot	|
		|	demo			|	passWord	| shouldNot	|
		