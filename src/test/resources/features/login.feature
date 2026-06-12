Feature: Login Functionality

Background:
Given the user launches the SauceDemo Application

@Valid
Scenario Outline: Login using valid username and password
When User login into application with username "<username>" and password "<password>"
Then Check whether login is succeed

Examples:
	| username              | password      |
	|standard_user          |secret_sauce   |
    |problem_user           |secret_sauce   |
    |performance_glitch_user|secret_sauce   |
    |error_user             |secret_sauce   |
    |visual_user            |secret_sauce   |
    
    
@Invalid
Scenario:
Login fails with invalid credentials

When User login into application with username "invalid_user" and password "incorrect"
Then Error message should be displayed


@Invalid
Scenario Outline: Login using invalid username and password
When User login into application with username "<username>" and password "<password>"
Then Check whether login is not successful

Examples:
	| username               | password      |
	|standrd_user            |secret_sauce   |
    |locked_out_user         |secret_sauce   |
    |pr_oblem_user           |secret_sauce   |
    #|perfor2mance_glitch_user|secret_sauce   |
    #|error_user              |secret_s3auce  |
    #|visual_user             |secret_suce    |