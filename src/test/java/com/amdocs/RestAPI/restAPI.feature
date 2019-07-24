Feature: rest calculator
	Scenario: invoking addition
		Given rest api "http://localhost:8080/addition?firstOperand=10&secondOperand=10"
		When i invoke the given rest api
		Then expected sum is 20
	
