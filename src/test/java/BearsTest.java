import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.IsEqual.equalTo;

public class BearsTest {
    /*@BeforeClass
    public static void beforeAll() {
        RestAssured.requestSpecification = Bears.requestSpec; // определяет куда обращаться
    }*/
    @Test
    public void getAllBears() { //GET /bear - запрос всех медведей

       // ResponseBody gotAllBearsBody = get(EndPoints.allBears);
        //List<Bear> gotAllBears = Utils.responseToBears(gotAllBearsBody);

        ResponseBody gotAllBearsBody = given().
                spec(Bears.requestSpec).
                when().
                get(EndPoints.allBears).
                then()
                //.header("Content-Type", "application/json")
                .statusCode(200)
                .assertThat()
                .extract()
                .response().body();//"size()", is(0)

        /*Bear[] allBearsResponse = given().
                spec(Bears.requestSpec).
                when().
                get(EndPoints.allBears)
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath();
                .as(Utils.responseToBears(gotAllBearsBody));*/
        //assertThat(allBearsBody.length).isEqualTo(2);

        System.out.println("check Body: " + Utils.responseToBears(gotAllBearsBody));
        //List<Bear> allBears = Utils.responseToBears(gotAllBearsBody);

        //System.out.println("size: " + allBears.size());
    }
    @Test
    public void getABearBeforeCreating() { //GET /bear/{id} - запрос одного медведя. Когда ни одного не было создано
        given()
                .spec(Bears.requestSpec)
                .contentType(JSON)
                .pathParam("id", "1")
                .when()
                .get(EndPoints.specBear)
                .then()
                .spec(Bears.responseNotFound);
    }
    @Test
    public void createABear() { //POST /bear - создание медведя
        //Response createdBear =
        Bear oneDefaultBlackBear = new Bear();
        oneDefaultBlackBear.bear_name = "mikhail";
        oneDefaultBlackBear.bear_type = "BLACK";
        oneDefaultBlackBear.bear_age = 17.5;
        //создаем тело запроса из объекта
        Map<String, Object> oneDefaultBlackBearAsMap = new HashMap<>();
        oneDefaultBlackBearAsMap.put("bear_name", oneDefaultBlackBear.bear_name);
        oneDefaultBlackBearAsMap.put("bear_type", oneDefaultBlackBear.bear_type);
        oneDefaultBlackBearAsMap.put("bear_age", oneDefaultBlackBear.bear_age);

        given()
                .spec(Bears.requestSpec)
                .contentType(JSON)
                .body(oneDefaultBlackBearAsMap)
                .when().post(EndPoints.allBears)
                .then().
                        statusCode(201)
                        .body(containsString(oneDefaultBlackBear.bear_name))
                        .body(containsString(oneDefaultBlackBear.bear_type))
                        .body(contains(oneDefaultBlackBear.bear_age)); //не смогла понять, как вставить корректно тело ответа
    }
    @Test
    public void getABearAfterCreating() { //GET /bear/{id} - запрос одного медведя. Когда создан 1

        /*Bear oneDefaultBlackBear = new Bear();
        oneDefaultBlackBear.bear_name = "mikhail";
        oneDefaultBlackBear.bear_type = "BLACK";
        oneDefaultBlackBear.bear_age = 17.5;*/

        //ResponseBody oneBear =
        given()
                .spec(Bears.requestSpec)
                .contentType(JSON)
                .pathParam("id", "1")
                .when()
                .get(EndPoints.specBear)
                .then()
                .statusCode(200)
                .body("bear_id", equalTo(1))
                .body("bear_name", equalTo("mikhail"))
                .body("bear_type", equalTo("Black"))
                .body("bear_age", equalTo(17.5));

                /*
                .extract()
                .body().asString();

        Bear oneDefaultBlackBear_0 = Utils.responseToBear(oneBear);
        assertThat(oneDefaultBlackBear_0, equalTo(oneDefaultBlackBear));

                .body("bear_id", equalTo(1))
                .body("bear_name", equalTo("mikhail"))
                .body("bear_type", equalTo("Black"))
                .body("bear_age", equalTo(17.5))*/
    }

}