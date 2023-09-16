Feature: TagResource API
  This feature contains a list of functionalities related to tags

  Scenario: Create a new tag
    Given I have a new tag:
      """
      {
        "name": "NewTag",
        "description": "Tag description"
      }
      """
    When I send a POST request to "/api/tags" with the tag details
    Then the response status code should be 201
    And the response should contain the created tag details:
      """
      {
        "name": "NewTag",
        "description": "Tag description"
      }
      """

  Scenario: Update an existing tag
    Given I have an existing tag with the following details:
      | Name       | Description   |
      | ExistingTag| Existing desc |
    And I want to update the tag with the following details:
      | Name       | Description   |
      | UpdatedTag | Updated desc  |
    When I send a PUT request to "/api/tags/{tagId}" with the updated tag details
    Then the response status code should be 202
    And the response should contain the updated tag details:
      | Name       | Description   |
      | UpdatedTag | Updated desc  |


  Scenario: Get all tags
    Given there are existing tags in the system
    When I send a GET request to "/api/tags"
    Then the response status code should be 200
    And the response should contain a list of tags


  Scenario: Get a tag by ID
    Given there is an existing tag with ID {tagId}
    When I send a GET request to "/api/tags/{tagId}"
    Then the response status code should be 200
    And the response should contain the tag details


  Scenario: Delete a tag
    Given there is an existing tag with ID {tagId}
    When I send a DELETE request to "/api/tags/{tagId}"
    Then the response status code should be 204
    And the tag should be deleted from the system



  Scenario: Add multiple tags in a single request
    Given I have a list of tags with the following details:
      | Name       | Description   |
      | Tag1       | Tag1 desc     |
      | Tag2       | Tag2 desc     |
    When I send a POST request to "/api/tags/add-all" with the list of tag details
    Then the response status code should be 201
    And the response should contain a list of created tags
