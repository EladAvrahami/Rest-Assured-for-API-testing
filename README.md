# Rest-Assured-for-API-testing
Rest Assured+ cucumber+API+uploud local json-server in 15 sec using cmd</br>
🚧🚧🚧work in progress🚧🚧🚧</br></br>
###Rest-Assured is a simple java liberary for testing and validating REST services (just like Roby&Groovy).###</br>
pattern behavior-driven development (BDD) is an agile software development process that encourages collaboration among developers, quality assurance testers, and customer representatives in a software project
</br>
</br>

#1 </br>
Testing Features:</br>
Scenario ,Given, And , Then . 
</br>
</br>

#2 </br>
GET operation with params:</br>
given() , .with(), .when(), .then(), .queryParam() ,hasSize(num), hasItem() .
</br></br>

#3</br>
   1 - Arrange /Act/Assert pattren :</br>
requestSpecBuilder class , setBaseUri() ,builder</br>
   2 - RestAssuredExtantion:</br>
   RequestSpecification class -is a important class becouse it has a lot of staff like cookies parameters query parameters and a lot more ... 
   </br></br>
   
   #4 </br>
POST with body parameter:</br>
Use json serializer as pom dependency called Jackson-make the haseMap that puted as key value in the BDDStyleMethod to availible to create a new server json objects.</br>
Creat scanerio for POST with body and path params + step definition implementation. </br>
<-- PAY ATTENTION!!! TO DELETE THE DEFULD <SCOP> THAT COMES WITH THAT OR THERE WILL BE
  DIFFICULT TO IMPORT JAVA's OTHER CLASSES !!!! (according to :https://stackoverflow.com/questions/58515714/the-import-io-restassured-restassured-cannot-be-resolved )  -->
      
</br>

#5</br>
perform a POST operation with path&body parameters- Scenario 7</br>
assertThat()- The assertThat is one of the JUnit methods from the Assert object that can be used to
        check if a specific value match to an expected one. It primarily accepts 2 parameters.
        First one if the actual value and the second is a matcher object. I use it to compere between the name valuse that i supposed to get to the one i got . </br>
DataTable and new way to use it :  //https://stackoverflow.com/questions/55591569/cucumber-datatable-error-io-cucumber-datatable-undefineddatatabletypeexception .
</br>
</br>

#6</br>
perform a DELET operation with RESTassured - Scenario 8</br>
just follow the scenario (: + I biuld methods at the RestAssuredExtension java class that I will be required to perform scenario 8 at the DELETEPost.feature
</br>
Scnerio Part 8 start process of POST obj >DELETE him>and chack if found with Get operation
</br>
</br>
#7</br>
implement DELETEPost Scenario+ debuge it by using live json server +debug+postman
        
   


</br>
</br>
helpful links: </br>
1.https://github.com/typicode/json-server</br>
2.https://rest-assured.io/


