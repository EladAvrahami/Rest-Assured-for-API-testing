package utilities;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * RestAssuredExtension contain reusable methods
 */
public class RestAssuredExtension {


    //Part 5 -conclusions -8:23
    public static RequestSpecification Request;

    //Part 5
    //Arrange
    //simple cons in order to create th rest of my methods
    public RestAssuredExtension() {
        //RequestSpecBuilder help me to Arrange the request data.
        RequestSpecBuilder builder=new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:3000");
        builder.setContentType(ContentType.JSON);
        var requestSpec= builder.build();
        //simply Request will be the uri that i set and its form will be as json
        Request= RestAssured.given().spec(requestSpec);
    }

    //Part 5
    public static void GetOpsWithPathParameters(String url, Map<String,String> pathParams) throws URISyntaxException {
        //ACT
        Request.pathParams(pathParams);
        try {
            Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    //Part 5
    //example without parameters
    public static ResponseOptions GetOperation(String url ) throws URISyntaxException {
        //ACT
        try {
           return Request.get(new URI(url));
        }catch (URISyntaxException e){
            e.printStackTrace();
        }
        return null;

    }
    /**
     * Part 6+7 make Scenario+method that will Post to our server
     * @param url
     * @param pathParams
     * @param body
     * @return
     * @throws URISyntaxException
     */
    //cuz returning response object i use "ResponseOptions"
    public static ResponseOptions <Response> PostOperationsWithBodyAndPathParams (String url, Map<String,String>pathParams , Map<String,String>body ) {
         Request.pathParams(pathParams);
         Request.body(body);
      return Request.post(url);

    }

    /* Request.pathParams(pathParams);
         Request.body(body);
       try {
           return Request.post(new URI(url));
       } catch (Exception e) {
           e.printStackTrace();
       }
       return null;
    }*/

    /*this is the methods that I will required to perform scenario 8 at the DELETEPost.feature */
    //Part 8
    public static ResponseOptions<Response> PostOperationWithBody (String url,Map<String ,String > body){
        Request.body(body);
        return Request.post(url);
    }
    //Part 8
    public static ResponseOptions<Response> DeleteOperationWithPathParams (String url,Map<String ,String > pathParams){
        Request.pathParams(pathParams);
        return Request.delete(url);
    }
    //Part 8
    public static ResponseOptions<Response> GetWithPathParams (String url,Map<String ,String > pathParams){
        Request.pathParams(pathParams);
        return Request.get(url);
    }











}
