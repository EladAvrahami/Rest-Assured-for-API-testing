package steps;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
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

}
