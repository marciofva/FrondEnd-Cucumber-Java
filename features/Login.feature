#Author: Marcio Fernando Vieira de Almeida

#================================================================================================
#For running this application is necessary to pass 3 parameters in command line, such as, 
#(USERNAME, PASSWORD and BOWSER):
#
#-Dusername="tomsmith" 
#-Dpassword="SuperSecretPassword!" 
#-Dbrowser="chrome"
#
#------------------------------------------------------------------------------------------------ 
#FOR EXAMPLE: Passing the parameters by "VM arguments" in Eclipse IDE or "Command Line"
#
#-Dusername="tomsmith" -Dpassword="SuperSecretPassword!" -Dbrowser="chrome" 
#-Dusername="mary" -Dpassword="Abch97W" -Dbrowser="ie" 
#================================================================================================

Feature: Log into/out the Secure Area
	As an user
  I should be able to log into/out the Secure Area
  so I can manage my tasks safely

Scenario: Log into the system with VALID credentials
Given I access the login page
When I enter an username
	And I enter a password
	And I click on "Login" button
Then I should see the message "You logged into a secure area!" after login

Scenario: Logout of the system
Given I access the login page
When I enter an username
	And I enter a password
	And I click on "Login" button
	And I click on "Logout" button
Then I should see the message "You logged out of the secure area!" after logout