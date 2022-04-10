
#Automation testing

Scripts
    
- src/test/java/TestFooGet: Validate different scenarios for GET endpoint.
- src/test/java/TestFooPost: Validate different scenarios for POST endpoint.

Framework

- main/java/framework/ApiBase: Class to manage general API execution
- main/java/framework/ApiResponse: Class to manage API response
- main/java/framework/Gets: Class to include all GET endpoints to be used in scripts
- main/java/framework/Posts: Class to include all POST endpoints to be used in scripts


###Bugs found during test execution

GET endpoint (TestFooGet failing on the last Scenario)
- The documentation doesn't explain which message should be returned when status code is 501 from GET.
- It isn´t allow double as input, if you introduce a double is managed like an integer.

POST endpoint (TestFooPost should be pass all scenarios)