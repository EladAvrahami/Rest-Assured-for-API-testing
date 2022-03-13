package utilities;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssuredExtension {

    //2:22 conclusion
    //Part 5
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
            Request.get(new URI(url));
        }catch (URISyntaxException e){
            e.printStackTrace();
        }
        return null;

    }





}
