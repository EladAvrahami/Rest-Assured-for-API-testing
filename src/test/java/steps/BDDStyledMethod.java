package steps;

import io.restassured.http.ContentType;
import org.hamcrest.core.Is;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

public class BDDStyledMethod {

    //part 3
    public static void SimpleGETPOST(String PostNum){
        //סןג התוכן שהפקודה מצפה לקבל מתצורת גייסון
        given().contentType(ContentType.JSON).
                when().get(String.format("http://localhost:3000/posts/%s",PostNum)).
                then().body("author",is("typicode"));
    }
    //part 3
    public static void PerformContainsCollection() {
                given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/posts/")
                .then()
                .body("author", containsInAnyOrder("typicode", "elad avrahami",null)).statusCode(200);
                //המפתח יהיה המירה "מחבר" והערכים שיכולים להיות לפי איזה סדר של הכנסה שאני רוצה הם ה"ערכים"
                //יש לשים לב שבבדיקה גם הסטטוס קוד שמתקבל גם אם בטווח 200 כלומר התקבל תקין הוא צריך להיות שווה לסטטוס קוד שמצפים לקבל במתודה שרושמים למשל אם נרשום בסטטוס קוד 204 במקום 200 שמצופה להתקבל מהשרת (ניתן לראות בcmd ) תתקבל שגיאה בהרצת התסריט בדיקה
    }


    //part4
    //הכנסת פרמטרים בתוך נתיב כתובת
    //בודק האם באידיי מס 2  שמתקבל בכתובת מסויימת שהמפתח שלו הוא "מחבר" והערך שלו הוא "אלעד"
    public  static void PerformPathParameter(){
        given()
                .contentType(ContentType.JSON).
        with()
                .pathParams("post",2).
        when()
                .get("http://localhost:3000/posts/{post}").
        then()
                .body("author",containsString("elad avrahami")) ;

    }

    //Part4

    /**
     * check with queryParam if there is author "hasItem" typicode that its id is 1 .
     */
    public  static void PerformQueryParameter(){
        //
        given()
                .contentType(ContentType.JSON)
                .queryParam("id",1).
                when()
                .get("http://localhost:3000/posts/").
                then()
                .body("author", hasItem( "typicode")) ;

    }

    //Part6
    /** RUN A POST OPERATION WITH BODY PARAMETERS */
    public static void PerformPOSTWithBodyParameter(){
        //create mew hash map called "postContent" with key value contents
        HashMap<String,String> postContent=new HashMap<>();
        postContent.put("id","5");
        postContent.put("title","elad course");
        postContent.put("author","eladA");
        //given content in json model>with the hash map content>when post specific url>then check key&value
        given()
                .contentType(ContentType.JSON).
        with()
                .body(postContent).
        when()
                .post("http://localhost:3000/posts").
        then()
                .body("author", Is.is("eladA"));

    }

}
