Feature: create and recover user data

  Background:
    * url baseUrl
    * def userdata = read('userdata.json')

Scenario: Create user
		Given path 'user'
		Given request userdata
    When method post
    Then status 200
    
Scenario: Get user
		Given path 'user/testUser963852'
		When method get
    Then status 200
    