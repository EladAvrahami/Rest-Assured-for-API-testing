Feature: DeletePost
  Test the delete operation

  #Part8+9
  Scenario: Verify DELETE operation after POST
    Given I ensure to Perform POST operation "/posts" with body as
      |id |title       |   author       |
      |6  |API TESTING repo | eladAvrahami   |
    And I perform DELETE operation for "/posts/{postid}/"
      |postid|
      |6     |
    And I perform GET operation with path parameter for "/posts/{postsid}"
      |postid|
      |6     |
    Then I "should not" see the body with title as "API TESTING repo"