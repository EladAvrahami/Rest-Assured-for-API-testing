Feature: PUTPost

  #Part 10
  Scenario: Verify PUT operation after POST
    Given I ensure to Perform POST operation "/posts" with body as
      |id |title       |   author       |
      |6  |API TESTING repo | eladAvrahami   |
    And I perform PUT operation for "/posts/{postid}/"
      |id    |title           |author       |
      |6     |ELAD API TESTING|eladAvrahami |
    And I perform GET operation with path parameter for "/posts/{postsid}"
      |postid|
      |6     |
    Then I "should" see the body with title as "ELAD API TESTING"