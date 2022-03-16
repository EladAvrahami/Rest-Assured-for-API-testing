Feature: GETPosts
  Verify different GET operations using REST-assured

  #befor starting any scenario you should type "json-server .\db.json" at your local cmd and put
  #some values in the json local file that will be created .
  #U can take a demo db file from the one i posted on my gitHub page or chake how to create ur own here:https://github.com/typicode/json-server

  Scenario: Verify author of the post
    Given I perform GET operation for "/posts"
    #part 5
    #And I perform GET for the post number "1"
    Then I should see the author name as "elad avrahami"

  Scenario: Verify collection of author in the post
    Given I perform GET operation for "/post"
    Then I should see the author names

  Scenario: Verify parameters of the Get
    Given I perform GET operation for "/post"
    Then I should see verify GET Parameter

  Scenario: Verify with Query parameters of the Get
    Given I perform GET operation for "/post"
    Then I should see verify by Query GET Parameter

  #part6
  #PAY ATTENTION!!!  in order to create post operation i needed to add to
  # the pomXML file- Jackson library
  Scenario: Verify Post operation
    Given I perform POST operation for "/posts"



    #Part 7
  #perform a POST operation with path&body parameters
  Scenario: Verify Post operation for Profile
    Given I perform POST operation for "/posts/{profileNum}/profile" with body
      | name | profile  |
      | Sam | 2        |
    Then I should see the body has name as "Sam"



