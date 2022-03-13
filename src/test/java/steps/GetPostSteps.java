package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

//import static org.hamcrest.MatcherAssert.assertThat;-add this line to get assertThat method


public class GetPostSteps {

    private  static ResponseOptions<Response> response;

    //part 5
    @Given("I perform GET operation for {string}")
    public void iPerformGETOperationFor(String url) throws Throwable{
        response= RestAssuredExtension.GetOperation(url);

    }
    /* //part 3
    @Given("I perform GET operation for {string}")
    public void iPerformGETOperationFor(String url) {
        //סןג התוכן שהפקודה מצפה לקבל מתצורת גייסון
        //given().contentType(ContentType.JSON);
    }*/
    //part 3
    /*@And("I perform GET for the post number {string}")
    public void iPerformGETForThePostNumber(String PostNum) {
        //סטרינג פורמט זה מעין פקודת printF
       // when().get(String.format("http://localhost:3000/posts/%s",PostNum)).
             //   then().body("author",is("typicode"));
        BDDStyledMethod.SimpleGETPOST(PostNum);
    }*/
    //part 3 + 5
    @Then("I should see the author name as {string}")
    public void iShouldSeeTheAuthorNameAs(String authorName ) throws Throwable{
        //i use the library that i written  (iShouldSeeTheAuthorNameAs)>that moves to test initialize>that initialize the arrange of data cuz its modified con i made
        assertThat(response.getBody().jsonPath().get("author"), hasItem("typicode")) ;
    }

    //part 3
    @Then("I should see the author names")
    public void iShouldSeeTheAuthorNames() {
        BDDStyledMethod.PerformContainsCollection();
    }

      /*
    //part 3
      //I start the testing like this but if i want to make it shorter use the one up^
      //רשמתי בתמציתיות את הפקודות במחלקה הסטטית BDDStyledMethod ומימשתי למעלה ***
      @Given("I perform GET operation for {string}")
    public void iPerformGETOperationFor(String url) {
        //סןג התוכן שהפקודה מצפה לקבל מתצורת גייסון
        given().contentType(ContentType.JSON);
    }

    @And("I perform GET for the post number {string}")
    public void iPerformGETForThePostNumber(String PostNum) {
        //סטרינג פורמט זה מעין פקודת printF
        when().get(String.format("http://localhost:3000/posts/%s",PostNum)).
                then().body("author",is("typicode"));
    }

    @Then("I should see the author name as {string}")
    public void iShouldSeeTheAuthorNameAs(String arg0) {

    }*/

    //part 4
    @Then("I should see verify GET Parameter")
    public void iShouldSeeVerifyGETParameter() throws Throwable {
        BDDStyledMethod.PerformPathParameter();
    }

    @Then("I should see verify by Query GET Parameter")
    public void iShouldSeeVerifyByQueryGETParameter() throws  Throwable{
        BDDStyledMethod.PerformQueryParameter();
    }




}
