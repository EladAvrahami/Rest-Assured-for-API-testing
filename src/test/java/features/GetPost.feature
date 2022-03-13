Feature: GETPosts
  Verify different GET operations using REST-assured

  Scenario: Verify author of the post
    Given I perform GET operation for "/posts"
    #part 5
    #And I perform GET for the post number "1"
    Then I should see the author name as "typicode"

  Scenario: Verify collection of author in the post
    Given I perform GET operation for "/post"
    Then I should see the author names

  Scenario: Verify parameters of the Get
    Given I perform GET operation for "/post"
    Then I should see verify GET Parameter

  Scenario: Verify with Query parameters of the Get
    Given I perform GET operation for "/post"
    Then I should see verify by Query GET Parameter







