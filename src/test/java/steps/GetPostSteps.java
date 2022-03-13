package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.Is.is;//import חשוב מאוד עמ לקבל בפקודת is  מסוג סטרינג


public class GetPostSteps {

    //part 3
    @Given("I perform GET operation for {string}")
    public void iPerformGETOperationFor(String url) {
        //סןג התוכן שהפקודה מצפה לקבל מתצורת גייסון
        //given().contentType(ContentType.JSON);
    }
    //part 3
    @And("I perform GET for the post number {string}")
    public void iPerformGETForThePostNumber(String PostNum) {
        //סטרינג פורמט זה מעין פקודת printF
       // when().get(String.format("http://localhost:3000/posts/%s",PostNum)).
             //   then().body("author",is("typicode"));
        BDDStyledMethod.SimpleGETPOST(PostNum);
    }
    //part 3
    @Then("I should see the author name as {string}")
    public void iShouldSeeTheAuthorNameAs(String arg0) {

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
