import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

import static io.restassured.RestAssured.get;

//задаются основные параметры для доступа к API
public class Bears {
    public static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost") //хост = моя машина
            .setPort(6192) // порт задан при запуске контейнера (см. readme.md)
            .setAccept(ContentType.ANY) // заголовок принимаемого ответа. Думаю, нужно оставить JSON вместо ANY
            .setContentType(ContentType.JSON) // заголовок отправляемого запроса
            .log(LogDetail.ALL) // логирование
            .build();

    public static ResponseSpecification responseSuccess = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

    public static ResponseSpecification responseCreated = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .build();

    public static ResponseSpecification responseNoData = new ResponseSpecBuilder()
            .expectStatusCode(204)
            //.expectBody(null)
            .build();

    public static ResponseSpecification responseBadRec = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .build();

    public static ResponseSpecification responseNotFound = new ResponseSpecBuilder()
            .expectStatusCode(404)
            //.expectBody(null)
            .build();

    public static ResponseSpecification responseNotAllowed = new ResponseSpecBuilder()
            .expectStatusCode(405)
            //.expectBody(null)
            .build();

    public static void main(String[] args) {
        RestAssured.requestSpecification = requestSpec;
        //RestAssured.baseURI = "http://localhost:6192"; // rest assured preconfiguration
        //Response response = get("/bear");



    }

}

