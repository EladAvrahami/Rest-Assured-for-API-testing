package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
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
        assertThat(response.getBody().jsonPath().get("author"), hasItem("elad avrahami")) ;
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


    //Part6
    @Given("I perform POST operation for {string}")
    public void iPerformPOSTOperationFor(String arg0) throws  Throwable{
        BDDStyledMethod.PerformPOSTWithBodyParameter();
    }

    //Part7 implementation part 2 +explanation
    @Given("I perform POST operation for {string} with body")
    public void iPerformPOSTOperationForWithBody(String url, DataTable table)throws  Throwable {
        // var data = table.raw(); instead this line i will writ the one down as i found on stackoverflow
        //https://stackoverflow.com/questions/55591569/cucumber-datatable-error-io-cucumber-datatable-undefineddatatabletypeexception
        List<List<String>> data = table.asLists(String.class);
        //set body
        HashMap<String,String> body=new HashMap<>();
        //"name" come from the data table that i wrote in the 7 scenario
        //put in there the first row with the zero column value (the position of the obj of table in scenario 7)
        body.put("name",data.get(1).get(0));
        //path params
        HashMap<String,String> pathParams=new HashMap<>();
        //"profileNum" should be like in the url {} in the Scenario 7
        //  profileNum is the key was specified in the URL Scenario 7
        pathParams.put("profileNum" ,data.get(1).get(1));
        //perform post operation
       response= RestAssuredExtension.PostOperationsWithBodyAndPathParams(url,pathParams,body);

//Part7 implementation part1
   /* @Given("I perform POST operation for {string} with body")
    public void iPerformPOSTOperationForWithBody(String url, DataTable table) throws  Throwable{

        // var data = table.raw(); instead this line i will writ
        //https://stackoverflow.com/questions/55591569/cucumber-datatable-error-io-cucumber-datatable-undefineddatatabletypeexception
        List<List<String>> data = table.asLists(String.class);
      //  String buildingName = data.get(1).get(1);
       // String reference = data.get(2).get(1);

       // var data = table.raw();

        //set body
        HashMap <String,String> body=new HashMap<>();
        body.put("name",data.get(1).get(0));

        //path params
        HashMap<String,String> pathParams=new HashMap<>();
        //"profileNum" should be like in the url {} in the Scenario 7
        pathParams.put("profileNum" ,data.get(1).get(1));

        //perform post operation
        response = RestAssuredExtension.PostOperationsWithBodyAndPathParams(url,pathParams,body);



    }*/
    }

    //Part 7
    @Then("I should see the body has name as {string}")
    public void iShouldSeeTheBodyHasNameAs(String name) throws  Throwable {
        /* assertThat()- The assertThat is one of the JUnit methods from the Assert object that can be used to
        check if a specific value match to an expected one. It primarily accepts 2 parameters.
        First one if the actual value and the second is a matcher object.
        */
        // equalTo()-compere the tow strings values (Name="Sam"- in scenario 7)
      assertThat(  response.getBody().jsonPath().get("name"), equalTo(name));
    }








}
