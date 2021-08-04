Feature: Search Page
	Scenario: Verification of Search page Title
		Given Browser is opened
		When User navigates to url as "http://google.com"
		Then title should be as "Google"
