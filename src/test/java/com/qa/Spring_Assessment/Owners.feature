Feature: Owner rest controller

Scenario: Testing the getAll owners method
Given an owner exists within the database
When the owner retrieves data about other owners
Then the page has been loaded

Scenario: Testing the Post method
Given a new owners needs to be added
When parameters have been added correctly
Then the new owner has been added

Scenario: Testing the get with parameters method
Given a owner exists with the last name "<lastName>"
When the owner retrieves the owner with the last = name "<lastName>"
Then the owner has been created

Scenario: Testing the delete method
Given an owner exists within the database
When the owner deletes a owner with a specified id
Then the owner has been deleted

Scenario: Testing the get owners method with parameters
Given an owner exists with the id
When the manager retrieves owner with the id
Then the owner with the id has been found

Scenario Outline: Testing the getAll owners method
Given an owner exists within the database
When when the owner retrieves data about other owners
Then all owners have been found

Examples:
    | lastName| id|
    | Estaban| 10|
    | Franklin| 1 |
    | Davis| 2|
    | Schroeder| 9 |